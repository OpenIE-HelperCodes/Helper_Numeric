package help;
/**
 * 
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

/**
 * @author harinder
 *
 */
public class Util_Numerical {

	private static Pattern numberPat, yearPat;
	private static StanfordCoreNLP pipeline;
	private static Properties prop;
	
	/*private static boolean isSentenceWithMultipleNumbers(List<String> list_tokenStr) { //TODO
		for (String string : list_tokenStr) {
			if(isNumber(token))
		}
	}*/
	
	private static java.lang.String removeTrailingZeros(java.lang.String str) {
		if (str == null) {
			return null;
		}
		char[] chars = str.toCharArray();
		int length, index;
		length = str.length();
		index = length - 1;
		for (; index >= 0; index--) {
			if (chars[index] != '0') {
				break;
			}
		}
		return (index == length - 1) ? str : str.substring(0, index + 1);
	}
	
	public static Integer removeTrailingZeros(Integer i) {
		String s = String.valueOf(i);
		return Integer.valueOf(removeTrailingZeros(s));
	}

	public static boolean isNumber(String token) {
		return numberPat.matcher(token.toString()).find();
	}
	
	private static boolean isNumberAtEOS(String line) {
		return line.matches("^.+?\\d.?$");
		//TODO: this will reject the line even if it has some apt number in the middle of sentence
	}

	private static boolean isYear(String token) {
		return yearPat.matcher(token).find();
	}

	private static boolean isDate(String token, Map<String, String> nerTagMap) {
		String nerTag = nerTagMap.get(token);

		if (nerTag == null) {
			System.out.println("this shall be rare..returning true");
			return false;
		}
		if (nerTag.equals("DATE") || nerTag.equals("TIME") || nerTag.equals("DURATION"))
			return true;

		return false;
	}

	public static void init() {
		numberPat = Pattern.compile("^[\\+-]?\\d+([,\\.]\\d+)*([eE]-?\\d+)?$");
		yearPat = Pattern.compile("^19[56789]\\d|20[01]\\d$");
		prop = new Properties();
		prop.put("annotators", "tokenize, ssplit");
		pipeline = new StanfordCoreNLP(prop);
	}
	
	private static List<String> getListOfTokenStrings(String str) throws Exception {
		List<String> list_tokenStr = new ArrayList<String>();
		
		Annotation doc = new Annotation(str);
		pipeline.annotate(doc);
		List<CoreMap> sentences = doc.get(SentencesAnnotation.class);
		for (CoreMap sentence : sentences) {
			for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
				String tokenStr = token.get(TextAnnotation.class);
				list_tokenStr.add(tokenStr);
			}
		}
				
		return list_tokenStr;
	}
	
	private static boolean isInvalidWord(List<String> list_tokenStr, int index) throws Exception {
		if(index == list_tokenStr.size()-1) return true; //no last word - thus invalid
		if(Constants.INVALID_NEXT_WORDS.contains(list_tokenStr.get(index+1))) return true; //contains an invalid word
		return false;
	}

	//This is the wrapper function. use this function to check whether a string is a required number
	//return true if the string:
	// a. is a number
	// b. is not a date
	// c. is not a configured invalid word
	// d. has units according to Danroth's quantifier
	public static boolean isReqNumber(String str) throws Exception {
		//if(isNumberAtEOS(str)) return false; //------- number can not be at the EOS
		
		List<String> list_tokenStr = getListOfTokenStrings(str);
		
		// -------check that the number shall have a unit
		
		// ------- it shall contain a number and that shall not be a date or duration
		Map<String, String> nerMap = Ner.getNerTags(str);
		for (int index=0; index<list_tokenStr.size(); index++) {
			// if (isNumber(tokenStr) && !isYear(tokenStr)) {
			String tokenStr = list_tokenStr.get(index);
			
			if(!isNumber(tokenStr)) continue;
			if(isDate(tokenStr, nerMap)) continue;
			if(isInvalidWord(list_tokenStr, index)) continue;
			if(!Quantifier_Danroth.hasUnits(str, Str2Double(tokenStr))) continue;
			
			return true; // --- passes all the filters
			
			//if (isNumber(tokenStr) && !isDate(tokenStr, nerMap) && !isInvalidWord(list_tokenStr, index)) {
				// System.out.println(tokenStr + "- Yes");
				//return true;
			//}
		}
		
		return false;
	}
	
	private static Double Str2Double(String str) throws ParseException {
		NumberFormat format = NumberFormat.getInstance(Locale.US);
	    Number number = format.parse(str);
	    return number.doubleValue();
	}

	public static boolean isContainsMentionedEntities(String str)
			throws Exception {
		// Looking for keyword in the text
		boolean foundKeyword = false;
		for (String keyword : Constants.KEYWORDS) {
			if (str.contains(keyword)) {
				foundKeyword = true;
				break;
			}
		}
		if (!foundKeyword)
			return false;

		// Looking for country in the text
		boolean foundCountry = false;
		for (String country : Constants.COUNTRIES) {
			if (str.contains(country)) {
				foundCountry = true;
				break;
			}
		}
		if (!foundCountry)
			return false;

		return true;
	}

	public static String[] sentenceSplitter(String sentenceToSplit) {
		SentenceDetector sentenceDetector = null;
		InputStream modelIn = null;

		try {
			modelIn = new FileInputStream("/home/harinder/Documents/IITD_MTP/Open_nre/HelperCodes/Helper_Numeric/models/en-sent.bin");
			final SentenceModel sentenceModel = new SentenceModel(modelIn);
			modelIn.close();
			sentenceDetector = new SentenceDetectorME(sentenceModel);
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (final IOException e) {
				}
			}
		}
		String sentences[] = (sentenceDetector.sentDetect(sentenceToSplit));
		/*
		 * for(int i=0; i<sentences.length;i++) {
		 * System.out.println(sentences[i]); }
		 */
		return sentences;
	}
}
