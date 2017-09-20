import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class TextsReader {

    private static final int TOP_WORDS = 10;
   
    public static void main(String[] args) throws java.io.FileNotFoundException {
    	 Scanner sc = null;
 	    String way="";
 	    System.out.println("Enter the way in the format(DISK:\\folder\\name of text file");
 	    Scanner w=new Scanner(System.in);
 	    way=w.nextLine();
 	try {
 	    sc = new Scanner(new File(way));//D:\\1\\text.txt
 	} catch (FileNotFoundException e) {
 	   System.out.println("File not found");
 		//e.printStackTrace();
 	}
        String word;
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        int count, current;
        
        count = 0;
        while ( sc.hasNext() ) {
            word = sc.next();
            ++count;
            words.put(word, ( words.containsKey(word) ) ? ( words.get(word) + 1 ) : 1 );
        }
        
        sc.close();
        
        ValueComparator cmp = new ValueComparator(words);
        TreeMap<String, Integer> ordered = new TreeMap<String, Integer>(cmp);
        ordered.putAll(words);
        
        System.out.println(count + " words found.");
        System.out.println("Top " + TOP_WORDS + " frequently meeting words:");
        current = 0;
        for ( String key : ordered.keySet() ) {
            if ( ++current > TOP_WORDS )
                break;
            int val = words.get(key);
            System.out.println(key + ": " + val + " (" + ((double)val * 100.0 / count) + "%)" );
        }
        
    }
}

