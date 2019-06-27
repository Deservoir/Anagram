import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String filename = args[1];
		
		Scanner sc = new Scanner(new File(filename));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
		  lines.add(sc.nextLine());
		}

		String[] arr = lines.toArray(new String[0]);
		
		sc.close();
		Anagramer anagramer = new Anagramer();
		
	    
	    
	    

	    
		//Collection collectedAnagrams = anagramer.collectAnagrams(arr, args[1]);
		
	    long start = System.currentTimeMillis();;
	    Collection collectedAnagrams = anagramer.collectAnagrams(arr, "антиквар");
		long end = System.currentTimeMillis();;
		
		collectedAnagrams.forEach(i -> System.out.println(i));
		System.out.println((end - start) + " ms");
		
		
		System.out.println("----");
		
		//Map<String, List<String>> index = new HashMap<String, List<String>>();
			
		
		 Map<String, List<String>> index = null;
	      try
	      {
	         FileInputStream fis = new FileInputStream("hashmap.ser");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         index = (HashMap) ois.readObject();
	         ois.close();
	         fis.close();
	      }catch(IOException ioe)
	      {
	         ioe.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return;
	      }
		
	    
	      
		    start = System.currentTimeMillis();;
		    List<String> res = index.getOrDefault("антиквар", null);
			end = System.currentTimeMillis();;
			
			res.forEach(i -> System.out.println(i));
			System.out.println((end - start) + " ms");
	      
	      
		/*	
		for (int i=0; i < arr.length-1; i++) {
			index.put(arr[i], (List<String>)anagramer.collectAnagrams(arr, arr[i]));
			if (i%(arr.length/500) == 0) {
				System.out.println(i);	
			}
			
		}
		
		
		try
        {
               FileOutputStream fos =
                  new FileOutputStream("hashmap.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(index);
               oos.close();
               fos.close();
               System.out.printf("Serialized HashMap data is saved in hashmap.ser");
        }catch(IOException ioe)
         {
               ioe.printStackTrace();
         }
		*/
		
	}

	
	
}
