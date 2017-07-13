import java.util.Scanner;
import java.util.ArrayList;

public class AntsApp {
  public static void main(String[] args) {
    // Receive input
    Scanner scan = new Scanner(System.in);
    ArrayList<Scenario> scenarioList = new ArrayList<Scenario>();
    // Input loop
    int currentScenario = 0;
    while (scan.hasNextLine()) { 
      String line = scan.nextLine();
      if (line.length() > 0) {
        if (line.charAt(0) != '#') {
            if (currentScenario >= scenarioList.size()) {
                if (scenarioList.size() > 0) {
                    System.out.println();
                }
                scenarioList.add(new Scenario());
            }
            System.out.println(line);
            String[] lineArray = line.split(" ");
            switch (lineArray.length) {
            case 3:
                scenarioList.get(currentScenario).addDNA(lineArray[0].charAt(0), lineArray[1], lineArray[2]);
                break;
            case 1:
                scenarioList.get(currentScenario).setNoTurns(Integer.parseInt(lineArray[0]));
                System.out.println(scenarioList.get(currentScenario).simulate());
                break;
            }
        }
      } else {
        currentScenario++;
      }
    }
  }
}
