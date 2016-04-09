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

	private static Double getQuantityValue(QuantSpan quantSpan) {
		String phrase = ((Quantity)(quantSpan.object)).phrase.split(" ")[0];
		Double value = 0.0;;
		try {
			value = Double.valueOf(phrase);
		} catch(Exception e){
			value = 0.0;
		}
		
		return value;
		
	}
	
	private static String getQuantityUnits(QuantSpan quantSpan) {
		return ((Quantity)(quantSpan.object)).units.trim();
	}
	
	public static boolean hasUnits(String sentence, double number) {
		Map<Double, String> map_quantifiers = getQuantifiersMap(sentence);
		String unit = map_quantifiers.get(((Double)number));
		if(unit==null || unit.isEmpty()) return false;
		return true;
	}
	
}
