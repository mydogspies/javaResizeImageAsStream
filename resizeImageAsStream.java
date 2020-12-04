import ij.ImagePlus;
import ij.process.ImageProcessor;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResizeImageAsStream {

  public InputStream resizedImage (InputStream is, int width) throws IOException {

          // settings for the gaussian blur and interpolation within ImageJ
          double sigmaFactor = 0.3;
          int interpolationMethod = ImageProcessor.NONE;

          BufferedImage img = ImageIO.read(is);
          ImagePlus imp = new ImagePlus("image", img);

          double scaleFactor = width/(double) imp.getWidth();

          ImageProcessor ip = imp.getProcessor();
          ip.blurGaussian(sigmaFactor / scaleFactor);
          ip.setInterpolationMethod(interpolationMethod);
          ImageProcessor outputProcessor = ip.resize((int)(ip.getWidth() * scaleFactor), (int)(ip.getHeight()*scaleFactor));
          BufferedImage newBuffImage = outputProcessor.getBufferedImage();

          final ByteArrayOutputStream output = new ByteArrayOutputStream() {
              @Override
              public synchronized byte[] toByteArray() {
                  return this.buf;
              }
          };
          ImageIO.write(newBuffImage, "jpeg", output);
          return new ByteArrayInputStream(output.toByteArray(), 0, output.size());
      }
}
