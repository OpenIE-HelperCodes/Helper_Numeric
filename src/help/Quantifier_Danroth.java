package help;
/**
 * 
 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.illinois.cs.cogcomp.quant.driver.QuantSpan;
import edu.illinois.cs.cogcomp.quant.driver.Quantifier;
import edu.illinois.cs.cogcomp.quant.standardize.Quantity;

/**
 * @author harinder
 *
 */
public class Quantifier_Danroth {
	
	private static List<QuantSpan> getQuantitiesDanroth(String text) {
		Quantifier quantifier = new Quantifier();
		List<QuantSpan> quantSpans;
		
		quantSpans = quantifier.getSpans(text, true);

		/*for(QuantSpan qs : quantSpans) {
	        System.out.println("Quantity : " + qs.toString());		  
	    }*/
	    
	    return quantSpans;
	}
	
	public static void main(String args[]) {
		String sentence = "four people, Stalin was responsible for the death of 4.4 million people within the borders of the Soviet Union.";
		//getQuantitiesDanroth(sentence);
		//getQuantifiersMap(sentence);
		System.out.println(hasUnits(sentence, 4.4));
	}
	
	private static Map<Double, String> getQuantifiersMap(String text) {
		Map<Double, String> map_quantifiers = new HashMap<Double, String>();
		
		List<QuantSpan> quantSpans = getQuantitiesDanroth(text);
		
		for (QuantSpan quantSpan : quantSpans) {
			if(!(quantSpan.object instanceof Quantity)) continue;
			map_quantifiers.put(getQuantityValue(quantSpan), getQuantityUnits(quantSpan));
		}
		
		return map_quantifiers;
	}
	
	private static Map<Double, String> getPhraseMap(String text) {
		Map<Double, String> map_quantifiers_phrase = new HashMap<Double, String>();
		
		List<QuantSpan> quantSpans = getQuantitiesDanroth(text);
		
		for (QuantSpan quantSpan : quantSpans) {
			if(!(quantSpan.object instanceof Quantity)) continue;
			map_quantifiers_phrase.put(getQuantityValue(quantSpan), getQuantityPhrase(quantSpan));
		}
		
		return map_quantifiers_phrase;
	}
	
	private static String getQuantityPhrase(QuantSpan quantSpan) {
		String phrase = ((Quantity)(quantSpan.object)).phrase;
		return phrase;
	}

	private static Double getQuantityValue(QuantSpan quantSpan) {
		//String valueStr = getQuantityPhrase(quantSpan).split(" ")[0];
		String phraseSplit[] = getQuantityPhrase(quantSpan).split(" ");
		Double value = 0.0;;
		/*try {
			value = Double.valueOf(valueStr);
		} catch(Exception e){
			value = 0.0;
		}*/
		
		for(int i=0; i<phraseSplit.length; i++) {
			String valueStr = phraseSplit[i];
			
			try {
				value = Double.valueOf(valueStr);
			} catch(Exception e){
				value = 0.0;
			}
			
			if(value!=0.0) break;
		}
		
		return value;
	}
	
	private static String getQuantityUnits(QuantSpan quantSpan) {
		return ((Quantity)(quantSpan.object)).units.trim();
	}
	
	public static boolean hasUnits(String sentence, double number) {
		Map<Double, String> map_quantifiers = getQuantifiersMap(sentence);
		Map<Double, String> map_quantifiers_phrase = getPhraseMap(sentence);

		String unit = map_quantifiers.get(((Double)number));
		String phrase = map_quantifiers_phrase.get(((Double)number));
		
		if(phrase.split(" ").length > 1) return true;
		if(unit==null || unit.isEmpty()) return false;
		return true;
	}
	
}
