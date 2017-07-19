import java.util.*;

public class Syllables {
  
  public static String vowels = "aeiouy";
  public static String hardLets = "aeiouypkb";
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
    boolean eFound = false;
    ArrayList<Character> vowelArray = new ArrayList<Character>();
    for(int i = 0; i < vowels.length(); i++){
      vowelArray.add(vowels.charAt(i));
    }
    ArrayList<Character> hardLetters = new ArrayList<Character>();
    for(int i = 0; i < hardLets.length(); i++) {
        hardLetters.add(hardLets.charAt(i));
    }

   /* 
    // swapped vowel-consonant-e
    for (int i = 0; i < word.length()-2; i++) {
      if (vowelArray.contains(word.charAt(i)) && !vowelArray.contains(word.charAt(i+1))&& word.charAt(i+2) == 'e') {
        word = changeCharacter(word, i+2, word.charAt(i+1));
        word = changeCharacter(word, i+1, word.charAt(i));
        word = changeCharacter(word, i, 'e');
        //System.out.println(word);
      }
    }
  */
    if (word.substring(word.length()-2, word.length()).equals("ed")) {
      //System.out.println("changed to " + word.substring(0, word.length()-2));
      eFound = true;
      word = word.substring(0, word.length()-2);
    } else {
      if(word.charAt(word.length()-1) == 'e'){
        if (word.charAt(word.length()-2) != 'l') {
          //removing the 'e' from the word
          word = word.substring(0, word.length()-1);
          eFound = true;
          //System.out.println("e removed");
        } else {
            if (vowelArray.contains(word.charAt(word.length()-3))) {
                word = word.substring(0, word.length()-2);
                eFound = true;
            }
        }
      }
    }
    /*
    for (int i = 0; i < word.length()-3; i++) {
        if (vowelArray.contains(word.charAt(i)) && 
            vowelArray.contains(word.charAt(i+1)) && 
            (word.charAt(i+2) == 'l' || word.charAt(i+2) == 't')) {
            syllableCount++;
        }
    }
*/
    if (word.length() >= 5 &&
        word.substring(word.length()-5, word.length()).equals("ement")) {
        syllableCount--;
    }

    if (word.length() >= 4 &&
        word.substring(word.length()-3, word.length()).equals("ing") &&
        vowelArray.contains(word.charAt(word.length()-4))) {
        syllableCount++;
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

    if (eFound && syllableCount == 0) {
      syllableCount++;
      //System.out.println("added syllable as e was the only vowel but removed");
    }
    
    System.out.println(syllableCount);
  }
  
  public static String changeCharacter (String word, int index, char character) {
    char[] wordChars = word.toCharArray();
    wordChars[index] = character;
    return String.valueOf(wordChars);
  }
}
