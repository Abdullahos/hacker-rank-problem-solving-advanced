/*challenge link:
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=
interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        int pairCounts = 0;
        //charachters of the string
        List<Character>uniqCharacters = new ArrayList<Character>();
        //adding characters to list
        int noOfUniqueChars = 0;
        for(int i = 0 ; i <s.length(); i++){
            if(! uniqCharacters.contains(s.charAt(i))){
                uniqCharacters.add(s.charAt(i));
                noOfUniqueChars++;
            }
        }
        //to hold the substrings info
        HashMap<String,HashMap<Character,Integer>> m = new  HashMap<String,HashMap<Character,Integer>>();
        int noOfSubs=0;
        for(int i=0 ; i<s.length(); i++){
            for(int j = i+1; j<=s.length(); j++){
                String sub = s.substring(i,j);
                noOfSubs++;
                //iterating over substring:
                HashMap<Character,Integer> temp= new  HashMap<Character,Integer>();
                //searching for letters in that sub
                for(int z = 0; z<noOfUniqueChars; z++){
                    //pick in order one of unique characters
                    //searching for specific letter in sub
                    char ch = uniqCharacters.get(z);
                    //search for that character(ch) in sub
                    int freq =0;
                    for(int k = 0 ; k<sub.length(); k++){
                        if(sub.charAt(k) == (ch)){
                        //if not checked before
                            if(!temp.containsKey(ch))    {
                                //System.out.println("test");
                                freq = 1;
                                temp.put(ch,freq); //edited(added)
                            }
                            else{
                                freq = temp.get(ch);
                                freq++;
                                temp.put(ch,freq);
                            } 
                        }
                    }
                    temp.put(ch,freq);
                }
                //set substring info
                if(m.containsKey(sub))          m.put(String.valueOf(j)+i,temp);
                else                            m.put(sub,temp);    //!!!!
            }
        }
        
        //array saye3
        int i = 0;
        String arr[] = new String[noOfSubs];
        for(String sub : m.keySet()){
            String freqsAsWord ="";
            HashMap<Character,Integer>temp = m.get(sub);
            for(Character c : temp.keySet()){
                freqsAsWord = freqsAsWord+temp.get(c).toString();
            }
           // System.out.println(freqsAsWord);
            arr[i] = freqsAsWord;
            i++;
        }
        //iterating over arr el saye3

        for( i = 0 ; i < arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i].equals(arr[j]))   pairCounts++;
            }
        }
        return pairCounts;
            
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
