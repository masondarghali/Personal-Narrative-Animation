// ImagePlus.java
import org.code.theater.*;
import org.code.media.*;

/*
 * ImagePlus
 * Represents an image that can be modified with filters and effects.
 * This class stores the Pixel[][] so filters can edit pixels directly.
 */
public class ImagePlus extends Image {

  // Cached 2D array of pixels from the image
  private Pixel[][] pixels;

  /*
   * ImagePlus constructor
   * Purpose: Loads an image file and stores its pixels into a 2D array.
   *
   * Preconditions:
   * - filename exists in the JavaLab project files
   *
   * Postconditions:
   * - Image is loaded
   * - pixels field is filled with Pixel objects from the image
   */
  public ImagePlus(String filename) {
    super(filename);
    pixels = getPixelsFromImage();
  }

  /*
   * getImagePixels()
   * Purpose: Returns the Pixel[][] for this image (used by filter methods).
   *
   * Preconditions:
   * - pixels has been initialized in the constructor
   *
   * Postconditions:
   * - Returns the same Pixel[][] reference stored in this object
   */
  public Pixel[][] getImagePixels() {
    return pixels;
  }

  /*
   * getPixelsFromImage()
   * Purpose: Builds a 2D Pixel array from the image by reading each pixel location.
   *
   * Preconditions:
   * - The image has a valid width/height and is fully loaded
   *
   * Postconditions:
   * - Returns a Pixel[][] sized [height][width] that matches the image
   */
  public Pixel[][] getPixelsFromImage() {
    Pixel[][] tempPixels = new Pixel[getHeight()][getWidth()];

    // Copy each pixel from the image into the 2D array
    for (int row = 0; row < tempPixels.length; row++) {
      for (int col = 0; col < tempPixels[0].length; col++) {
        tempPixels[row][col] = getPixel(col, row);
      }
    }

    return tempPixels;
  }
}
