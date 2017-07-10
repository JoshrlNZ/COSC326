import java.util.Scanner;

public class Ants {
  public enum Direction {
    NORTH, EAST, SOUTH, WEST
  }
  
  private String[][] scenarioDNA;
  private String[] scenarioTurns;
  
  public static void main(String[] args) {
    // Receive input
    Scanner scan = new Scanner(System.in);
    // Input loop
    String line = scan.nextLine(); 
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
    Direction lastAntDirection = NORTH;
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
