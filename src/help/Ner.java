package help;


import java.util.HashMap;
import java.util.Map;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

public class Ner {

  public static Map<String, String> getNerTags(String str) throws Exception {

    String serializedClassifier = "/home/harinder/Documents/IITD_MTP/Open_nre/HelperCodes/Helper_Numeric/classifiers/english.muc.7class.distsim.crf.ser.gz";

    AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(serializedClassifier);

    String nerTagged = classifier.classifyToString(str, "slashTags", false);
    String[] nerTaggedArr = nerTagged.split(" ");
    
    Map<String, String> nerMap = new HashMap<String, String>();
    
    for(String word : nerTaggedArr) {
    	String[] tagSplit = word.split("/");
    	if(tagSplit.length<2) continue;
    	nerMap.put(tagSplit[0], tagSplit[1]);
    }
    
    return nerMap;
  }
}