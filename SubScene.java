// SubScene.java
import org.code.theater.*;
import org.code.media.*;

/*
 * Shows players for the selected team.
 */
public class SubScene extends Scene {

  private String[][] playersByTeam;

  /*
   * Constructor
   * Stores player data.
   *
   * Pre: array exists
   * Post: data saved for scene
   */
  public SubScene(String[][] playersByTeam) {
    this.playersByTeam = playersByTeam;
  }

  /*
   * Main scene method.
   */
  public void drawScene() {
    drawPlayersScene();
  }

  /*
   * Shows the 49ers players.
   *
   * Pre: playersByTeam[0] exists
   * Post: player list displayed
   */
  public void drawPlayersScene() {
    clear("black");

    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("San Francisco 49ers", 20, 60);

    setTextHeight(22);
    drawText("Players:", 30, 110);

    int y = 150;

    for (String player : playersByTeam[0]) {
      if (player != null) {
        drawText("- " + player, 30, y);
        y += 35;
        pause(0.4);
      }
    }

    pause(1.5);
  }
}
