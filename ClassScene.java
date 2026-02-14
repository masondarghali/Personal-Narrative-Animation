// ClassScene.java
import org.code.theater.*;
import org.code.media.*;

/*
 * Shows divisions and teams.
 */
public class ClassScene extends Scene {

  private String[][] divisions;
  private String[][] teamsByDivision;

  /*
   * Constructor
   * Stores division and team data.
   *
   * Pre: arrays exist
   * Post: data saved for scene
   */
  public ClassScene(String[][] divisions, String[][] teamsByDivision) {
    this.divisions = divisions;
    this.teamsByDivision = teamsByDivision;
  }

  /*
   * Main scene method.
   * Shows division and team selection.
   */
  public void drawScene() {
    drawDivisionScene();
    drawTeamScene();
  }

  /*
   * Shows NFC divisions.
   *
   * Pre: divisions[0] exists
   * Post: all NFC divisions shown
   */
  public void drawDivisionScene() {
    clear("black");

    setTextHeight(28);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("Pick a Division (NFC)", 40, 60);

    setTextHeight(22);
    int y = 120;

    for (int i = 0; i < divisions[0].length; i++) {
      drawText(divisions[0][i], 70, y);
      y += 45;
      pause(0.3);
    }

    drawText("Selected: NFC West", 90, 330);
    pause(1.0);
  }

  /*
   * Shows NFC West teams.
   *
   * Pre: teamsByDivision[0] exists
   * Post: team names are shown
   */
  public void drawTeamScene() {
    clear("white");

    setTextHeight(28);
    setTextColor("black");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("Pick a Team (NFC West)", 35, 60);

    String[] nfcWestTeams = teamsByDivision[0];

    setTextHeight(22);
    int y = 120;
    for (int i = 0; i < nfcWestTeams.length; i++) {
      drawText(nfcWestTeams[i], 120, y);
      y += 45;
      pause(0.3);
    }

    drawText("Selected: 49ers", 135, 330);
    pause(1.0);
  }
}
