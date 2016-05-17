package help;
/**
 * 
 */


import java.util.List;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/**
 * @author harinder
 *
 */
public class Pos {
	public static List<TaggedWord> getPosTags(String sentence) throws Exception {
	    MaxentTagger tagger = new MaxentTagger("models/english-left3words-distsim.tagger");
	    
	    List<HasWord> sent = Sentence.toWordList(sentence);
	    List<TaggedWord> taggedSent = tagger.tagSentence(sent);
	    return taggedSent;
	  }
}
