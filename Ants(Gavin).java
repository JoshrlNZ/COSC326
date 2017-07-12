import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Ants {
  
  private static String[][] scenarioDNA = new String[1][3];
  private static List<Integer> scenarioTurns = new ArrayList<Integer>();
  private static HashMap<String, String> plane = new HashMap<String, String>();
  
  public static void main(String[] args) {
    // Receive input
    Scanner scan = new Scanner(System.in);
    // Input loop
    while (scan.hasNextLine()) {
      String line = scan.nextLine();
      //check if line is a comment, start loop again imediatly if line is a comment 
      if(line.charAt(0) != '#'){ 
        String[] lineArray = line.split(" ");
        switch (lineArray.length) {
          //if the array has three elements then increase the array if required
          //copy exsisting elements to the new array
          //add the new elements to the new array
          case 3: if(scenarioDNA.length >= scenarioTurns.size()){
            String[][] scenarioDNAincrease = new String[(scenarioDNA.length)+1][3];
            for (int i = 0; i < scenarioDNA.length; i++) {
              for (int j = 0; j < 3; j++) {
                scenarioDNAincrease[i][j] = scenarioDNA[i][j];
              }
            }
          }
          for(int i = 0; i < 3; i++){
            scenarioDNA[scenarioDNA.length][i] = lineArray[1];
          }
          break;
          //if the scanned line only has one element present
          //add that number to the turns array
          case 1: scenarioTurns.add(Integer.parseInt(line));
          break;
        }
      }
    }
    // Check line input for line of DNA or number of turns for scenario
    // Remember to ignore lines starting with hashes
    // Input line into scenarioDNA or scenarioTurns
    // If blank line, exit input loop
    
    int currentScenario = 0;
    // While currentScenario is less than number of scenarios (length of scenarioDNA)
    int antX = 0;
    int antY = 0;
    String defaultType = scenarioDNA[0][0];
    // Initialize plane with default value 
    int turnsPassed = 0;
    char lastAntDirection = 'N';
    char nextAntDirection = 'N';
    String currentType;
    // While number of turns passed is less than turns for scenario
    // Change current tile based on current state of tile
    // Change ant position based on last ant direction
    // End while loop for number of turns
    while(turnsPassed < scenarioTurns.get(currentScenario)){
      //if the tile the ant is occuping does not exsist yet, create it
      if(!plane.containsKey(antX+","+antY)){
        plane.put(antX+","+antY, defaultType);
      }
      currentType = plane.get(antX+","+antY);
      //find the next direction and tile change based on the current type the ant is occupying
      for(int i = 0; i < scenarioDNA.length; i++){
        if(currentType == scenarioDNA[i][0]){
          if(lastAntDirection == 'N'){
            nextAntDirection = scenarioDNA[i][1].charAt(0);
            plane.put(antX+","+antY, scenarioDNA[i][2].charAt(0));
          }
          if(lastAntDirection == 'E'){
            nextAntDirection = scenarioDNA[i][1].charAt(1);
            plane.put(antX+","+antY, scenarioDNA[i][2].charAt(1));
          }
          if(lastAntDirection == 'S'){
            nextAntDirection = scenarioDNA[i][1].charAt(2);
            plane.put(antX+","+antY, scenarioDNA[i][2].charAt(2));
          }
          if(lastAntDirection == 'W'){
            nextAntDirection = scenarioDNA[i][1].charAt(3);
            plane.put(antX+","+antY, scenarioDNA[i][2].charAt(3));
          }
        }
      }
      //change the current position of the ant
      if(nextAntDirection == 'N'){
        antY++;
      }
      if(nextAntDirection == 'E'){
        antX++;
      }
      if(nextAntDirection == 'S'){
        antY--;
      }
      if(nextAntDirection == 'W'){
        antX--;
      }
        
    }
    currentScenario++;
    
    // Loop through scenario DNA and print it out
    // Print out scenario turn
    // Print out final ant position
    
    // End currentScenario loop
  }

}
