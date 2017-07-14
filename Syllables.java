import java.util.*;

public class Syllables {
  
  public static String vowels = "aeiouy";
  public static Scanner sc = new Scanner(System.in);
  
  //while the program runs, keep reading in from stdin
  //calculate the words syllables and print them out as they are recieved.
  public static void main(String[] args) {
    while(sc.hasNextLine()){
      countSyllables(sc.nextLine());
    }
  }
  
  public static void countSyllables(String word){
    word = word.toLowerCase();
    boolean lastCharVowel = false;
    boolean foundVowel = false;
    int syllableCount = 0;
    //'the' and 'me' are exceptions to this rule.
    if(word.charAt(word.length()-1) == 'e' && (!word.equals("the")) && (!word.equals("me"))){
      if(word.charAt(word.length()-2) != 'l'){
        //removing the 'e' from the word
        word = word.substring(0, word.length()-1);
      }
    }
    
    //finding the syllables.
    for(int i = 0; i < word.length(); i++){
      for (int j = 0; j < vowels.length(); j++) {
        if(word.charAt(i) == vowels.charAt(j)) {
          foundVowel = true;
        }
      }
      //if we found a vowel and the last char checked was not a vowel;
      //increment the count and reset 'foundVowel' to false.
      if(foundVowel){
        if(!lastCharVowel){
          syllableCount++;
        }
        lastCharVowel = true;
      } else {
        lastCharVowel = false;
      }
      foundVowel = false;
    }
    System.out.println(syllableCount);
  }
  
}
