package help;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

public class Ner {
	
	String serializedClassifier = "/home/harinder/Documents/IITD_MTP/Open_nre/HelperCodes/Helper_Numeric/classifiers/english.muc.7class.distsim.crf.ser.gz";
	AbstractSequenceClassifier<CoreLabel> classifier;

	public Ner() throws ClassCastException, ClassNotFoundException, IOException{
		classifier = CRFClassifier.getClassifier(serializedClassifier);
	}

  public Map<String, String> getNerTags(String str) throws Exception {

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