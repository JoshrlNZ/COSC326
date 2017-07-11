import java.util.Scanner;

public class Ants {
  public enum Direction {
    NORTH, EAST, SOUTH, WEST
  }
  
  private String[][] scenarioDNA = new String[1][3];
  private List<String> scenarioTurns = new ArrayList<String>();
  
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
          case 3: if(scenarioDNA.length() >= scenarioTurns.size()){
            String[][] scenarioDNAincrease = new String[scenarioDNA.length()+1][3];
            for (int i = 0; i < scenarioDNA.length; i++) {
              for (int j = 0; j < 3; j++) {
                scenarioDNAincrease[i][j] = scenarioDNA[i][j];
              }
            }
          }
          for(int i = 0; i < 3 i++){
            scenarioDNA[scenarioDNA.length()][i] = lineArray[1];
          }
          break;
          //if the scanned line only has one element present
          //add that string to the array
          case 1: scenarioTurns.add(line);
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
    int topLeftX = 0;
    int topLeftY = 0;
    int antX = 0;
    int antY = 0;
    char[][] plane;
    char defaultChar; // Initialize to default value
    // Initialize plane with default value
    int turnsPassed = 0;
    Direction lastAntDirection = Direction.NORTH;
    // While number of turns passed is less than turns for scenario
    // Change current tile based on current state of tile
    // Change ant position based on last ant direction
    // Expand plane if ant exceeds current plane (make sure to default value on expansion to default value)
    // End while loop for number of turns
    currentScenario++;
    
    // Loop through scenario DNA and print it out
    // Print out scenario turn
    // Print out final ant position
    
    // End currentScenario loop
  }
}
