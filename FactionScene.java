// FactionScene.java
import org.code.theater.*;
import org.code.media.*;

/*
 * Intro scene.
 * Shows NFL and lets the program pick NFC.
 */
public class FactionScene extends Scene {

  private ImageFilter[][] logos;

  /*
   * Constructor
   * Stores the logos for this scene.
   *
   * Pre: logos array is not null
   * Post: logos saved for drawing
   */
  public FactionScene(ImageFilter[][] logos) {
    this.logos = logos;
  }

  /*
   * Main scene method.
   * Calls the intro and conference screens.
   *
   * Pre: logos exist
   * Post: both screens are shown
   */
  public void drawScene() {
    drawIntroScene();
    drawConferenceScene();
  }

  /*
   * Shows the NFL intro and blur effect.
   *
   * Pre: nfl logo exists
   * Post: intro text and blurred logo shown
   */
  public void drawIntroScene() {
    clear("black");
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawText("Intro to NFL", 120, 70);

    drawImage(logos[0][0], 120, 110, 160);
    pause(1.0);

    logos[0][0].motionBlur(30, "horizontal");
    drawImage(logos[0][0], 120, 110, 160);
    pause(1.0);
  }

  /*
   * Shows NFC vs AFC selection screen.
   *
   * Pre: nfc and afc logos exist
   * Post: NFC is highlighted
   */
  public void drawConferenceScene() {
    clear("white");

    setFillColor("blue");
    drawRectangle(0, 0, 200, 400);

    setFillColor("red");
    drawRectangle(200, 0, 200, 400);

    setTextHeight(26);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("Choose Conference", 40, 50);

    drawImage(logos[0][1], 45, 120, 110);
    drawText("NFC", 70, 270);

    drawImage(logos[0][2], 245, 120, 110);
    drawText("AFC", 270, 270);

    pause(0.8);
    logos[0][1].keepColor("red");
    drawImage(logos[0][1], 45, 120, 110);
    pause(1.0);
 
 
    
  }
}
