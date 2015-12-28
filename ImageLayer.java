import java.awt.*;
import java.applet.*;

public class ImageLayer
{
   Image image;

   int depth;

   public ImageLayer(String filename, int depth, Applet applet)
   {
      image = applet.getImage(applet.getCodeBase(), filename);

      this.depth = depth;
   }


   public void draw(Graphics g)
   {
      int width = image.getWidth(null);


      for(int i = 0 ; i < 10; i++)
         g.drawImage(image, i * width - Camera.x/depth, 0, null);
   }

}
