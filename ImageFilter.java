// ImageFilter.java
import org.code.theater.*;
import org.code.media.*;

/*
 * ImageFilter
 * Extends ImagePlus and adds custom image filter methods that modify the pixel colors.
 * These filters are used in the animation for visual effects.
 */
public class ImageFilter extends ImagePlus {

  /*
   * ImageFilter constructor
   * Purpose: Calls the ImagePlus constructor to load the image.
   *
   * Preconditions:
   * - fileName exists in the JavaLab project files
   *
   * Postconditions:
   * - Image is loaded and pixel data is available for filtering
   */
  public ImageFilter(String fileName) {
    super(fileName);
  }

  /*
   * keepColor(String color)
   * Purpose: Keeps only one primary color channel (red/green/blue) and removes the others.
   *
   * Preconditions:
   * - color should be "red", "green", or "blue"
   *
   * Postconditions:
   * - Pixels are modified so only the chosen color channel remains
   */
  public void keepColor(String color) {
    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        // Turn off the channels we don't want
        if (color.equals("red")) {
          currentPixel.setBlue(0);
          currentPixel.setGreen(0);
        } else if (color.equals("blue")) {
          currentPixel.setRed(0);
          currentPixel.setGreen(0);
        } else if (color.equals("green")) {
          currentPixel.setRed(0);
          currentPixel.setBlue(0);
        }
      }
    }
  }

  /*
   * pixelate(int gridSize)
   * Purpose: Pixelates the image by averaging colors inside gridSize x gridSize blocks.
   *
   * Preconditions:
   * - gridSize must be > 0
   *
   * Postconditions:
   * - The image looks blocky because each grid area is set to the same average color
   */
  public void pixelate(int gridSize) {
    Pixel[][] pixels = getImagePixels();

    // Step through the image by grid blocks instead of one pixel at a time
    for (int row = 0; row < pixels.length; row += gridSize) {
      for (int col = 0; col < pixels[0].length; col += gridSize) {
        int endRow = Math.min(row + gridSize, pixels.length);
        int endCol = Math.min(col + gridSize, pixels[0].length);

        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;

        // Add up all colors inside the block
        for (int r = row; r < endRow; r++) {
          for (int c = col; c < endCol; c++) {
            totalRed += pixels[r][c].getRed();
            totalGreen += pixels[r][c].getGreen();
            totalBlue += pixels[r][c].getBlue();
          }
        }

        int count = (endRow - row) * (endCol - col);
        int avgRed = totalRed / count;
        int avgGreen = totalGreen / count;
        int avgBlue = totalBlue / count;

        // Set every pixel in that block to the average color
        for (int r = row; r < endRow; r++) {
          for (int c = col; c < endCol; c++) {
            pixels[r][c].setRed(avgRed);
            pixels[r][c].setGreen(avgGreen);
            pixels[r][c].setBlue(avgBlue);
          }
        }
      }
    }
  }

  /*
   * motionBlur(int length, String direction)
   * Purpose: Creates a blur by averaging a line of pixels in a direction.
   *
   * Preconditions:
   * - length should be > 0
   * - direction should be "horizontal", "vertical", or "diagonal"
   *
   * Postconditions:
   * - Each pixel is changed to the average color of nearby pixels in the chosen direction
   */
  public void motionBlur(int length, String direction) {
    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;

        int x = col;
        int y = row;
        int count = 0;

        // Walk forward length pixels (or until we hit the edge)
        while (count < length && x < pixels[0].length && y < pixels.length) {
          Pixel p = pixels[y][x];
          totalRed += p.getRed();
          totalGreen += p.getGreen();
          totalBlue += p.getBlue();
          count++;

          // Move based on direction
          if (direction.equals("horizontal")) {
            x++;
          } else if (direction.equals("vertical")) {
            y++;
          } else if (direction.equals("diagonal")) {
            x++;
            y++;
          }
        }

        // Average the collected pixels
        int avgRed = totalRed / count;
        int avgGreen = totalGreen / count;
        int avgBlue = totalBlue / count;

        // Set the current pixel to the averaged color
        Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(avgRed);
        currentPixel.setGreen(avgGreen);
        currentPixel.setBlue(avgBlue);
      }
    }
  }
}
