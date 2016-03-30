package helpers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageHelper {
  
  /**
   * This method transforms an Image into a BufferedImage and colors it (tint)
   * @param img The source image
   * @param color The target color
   * @return The wanted BufferedImage colored
   */
  public static BufferedImage toColoredBufferedImage(Image img, Color color) {
    BufferedImage tempBufferedImage = toBufferedImage(img);
    return colorImage(tempBufferedImage, color);
  }
  
  /**
   * This method transforms an Image to a BufferedImage
   * @param img The source Image
   * @return The Image transformed into a BufferedImage
   */
  public static BufferedImage toBufferedImage(Image img) {
    if (img instanceof BufferedImage)
    {
        return (BufferedImage) img;
    }

    // Create a buffered image with transparency
    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = bimage.createGraphics();
    bGr.setBackground(Color.GREEN);
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    // Return the buffered image
    return bimage;
  }
  
  /**
   * This method colors a BufferedImage
   * @param img The source BufferedImage
   * @param color The wanted color
   * @return The BufferedImage with the RGB values changed to the target color
   */
  public static BufferedImage colorImage(BufferedImage img, Color color) {
    int rgbValues = color.getRGB();
    for (int x = 0; x < img.getWidth(); x++) {
      for (int y = 0; y < img.getHeight(); y++) {

          // Change the RGB values of the image
          img.setRGB(x, y, rgbValues);
      }
    }
    return img;
  }
}
