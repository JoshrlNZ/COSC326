import java.util.*;

public class Scenario {
  public enum Direction {
    N, E, S, W
  }

  private HashMap<Character, String[]> tableDNA = new HashMap<Character, String[]>();
  private int noTurns;
  private Character defaultType;
  
  public void addDNA(Character tile, String direction, String newTile) {
    String[] valueDNA = {direction, newTile};
    tableDNA.put(tile, valueDNA);
    if (defaultType == null) {
        defaultType = tile;
    }
  }
  
  public void setNoTurns(int noTurns) {
    this.noTurns = noTurns;
  }
  
  public String simulate() {
    int antX = 0;
    int antY = 0;
    int turnsPassed = 0;
    Direction lastDirection = Direction.N;
    HashMap<List<Integer>, Character> plane = new HashMap<List<Integer>, Character>();
    while (turnsPassed < noTurns) {
        List<Integer> antPos = Arrays.asList(antX, antY);
        if (!plane.containsKey(antPos)) {
            plane.put(antPos, defaultType);
        }
        Character currentTile = plane.get(antPos);
        String[] tileDNA = tableDNA.get(currentTile);
        plane.put(antPos, tileDNA[1].charAt(lastDirection.ordinal()));
        lastDirection = Direction.valueOf(Character.toString(tileDNA[0].charAt(lastDirection.ordinal())));
        antX += lastDirection == Direction.E ? 1 : lastDirection == Direction.W ? -1 : 0;
        antY += lastDirection == Direction.N ? 1 : lastDirection == Direction.S ? -1 : 0;
        turnsPassed++;    
    }
    return "# " + antX + " " + antY;
  }
}
