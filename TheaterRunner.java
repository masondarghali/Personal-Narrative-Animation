// TheaterRunner.java
import org.code.theater.*;
import org.code.media.*;

/*
 * Main runner for the program.
 * Sets up all the data and plays the scenes.
 */
public class TheaterRunner {

  /*
   * main method
   * Creates arrays, scenes, and plays them.
   *
   * Pre: image files exist in the project
   * Post: scenes are shown in order
   */
  public static void main(String[] args) {

    // Conferences and divisions
    String[][] divisions = {
      {"NFC West", "NFC North", "NFC East", "NFC South"},
      {"AFC West", "AFC North", "AFC East", "AFC South"}
    };

    // Teams by division
    String[][] teamsByDivision = {
      {"49ers", "Rams", "Seahawks", "Cardinals"},
      {"Packers", "Vikings", "Bears", "Lions"},
      {"Cowboys", "Eagles", "Giants", "Commanders"},
      {"Saints", "Buccaneers", "Falcons", "Panthers"},
      {"Chiefs", "Raiders", "Chargers", "Broncos"},
      {"Ravens", "Bengals", "Browns", "Steelers"},
      {"Bills", "Dolphins", "Patriots", "Jets"},
      {"Texans", "Colts", "Jaguars", "Titans"}
    };

    // 49ers players
    String[][] playersByTeam = {
      {"Brock Purdy", "Christian McCaffrey", "George Kittle", "Fred Warner", "Nick Bosa", null}
    };

    // Logos
    ImageFilter[][] logos = {
      { new ImageFilter("nfl.png"), new ImageFilter("nfc.png"), new ImageFilter("afc.png"), new ImageFilter("football.png") },
      { new ImageFilter("49ers.png"), new ImageFilter("rams.png"), new ImageFilter("seahawks.png"), new ImageFilter("cardinals.png") }
    };

    
    // Create scenes
    FactionScene factionScene = new FactionScene(logos);
    ClassScene classScene = new ClassScene(divisions, teamsByDivision);
    SubScene subScene = new SubScene(playersByTeam);

    // Draw scenes
    factionScene.drawScene();
    classScene.drawScene();
    subScene.drawScene();

    // Play scenes
    Theater.playScenes(factionScene, classScene, subScene);
  }
}
