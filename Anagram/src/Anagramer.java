import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** Anagramer
 * Allows to search for anagrams
 * The only public method is Collection collectAnagrams(String[] dictionary, String searchAnagramsFor);
 * @author valeri.solovey
 * 
 * ...
 * ...
 * ...
 * But if you DO need the FASTEST possible implementation, and your domain is some language corpus (which is rather stable dataset) 
 * then you do not want use this function directly every time.  
 * You should rather apply this function to all of the corpus and build some kind of anagram dictionary, for example, HashMap<String, List<String>>.
 * Then you call "getOrDefault(searchAnagramsFor, null)" method of this hashmap and voila - you have instant answer.  
 * Because function is not calculation, it is just a mapping.
 * 
 * collectAnagrams result:
 * антиквар
 * травинка
 * Травкина
 * 77 ms
 * 
 * 
 * getOrDefault result:
 * антиквар
 * травинка
 * Травкина
 * 0 ms
 */

public class Anagramer {
	
	public Anagramer() {
		return;
	}
	
	public Collection collectAnagrams(String[] dictionary, String searchAnagramsFor) {
	    
		List<Integer> example = toInts(searchAnagramsFor);
		
		int exampleLength = example.size();
		
		return Arrays
	    .stream(dictionary)
	    .parallel()
	    .filter(el -> el.length() == example.size())
	    .filter(el -> toInts(el).equals(example))
	    .collect(Collectors.toList());
	}

			
	private List<Integer> toInts(String s){
		return s
			.toLowerCase()
			.chars()
			.sorted()
			.boxed()
			.collect(Collectors.toList());
	}
	
}
