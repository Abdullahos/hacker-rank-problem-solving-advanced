
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HashTableRansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String,Integer> original = new HashMap<String,Integer>();
        HashMap<String,Integer> magazn = new HashMap<String,Integer>();
        boolean miss = false;
        //filling note hashmap
        for(String w : note){
            if(original.containsKey(w)) {
                int occ = original.get(w);
                original.put(w,occ+1);
            }
            else    original.put(w,1);
        }
      //filling magazn hashmap
        for(String w : magazine){
            if(magazn.containsKey(w)) {
                int occ = magazn.get(w);
                magazn.put(w,occ+1);
            }
            else    magazn.put(w,1); 
        }
        //checking that all words with its no of occs of orig r in mag 
        for(String word : original.keySet()){
            if(magazn.get(word) < original.get(word)){
                miss = true;
                break;
            }
        }
        if(miss)    System.out.println("No");
        else        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
