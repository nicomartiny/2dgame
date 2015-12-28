import java.awt.*;
import java.applet.Applet;

public class Animation
{
   Image[] image;

   int current = 1;

   int delay = 0;

   public Animation(String filename, int count, Applet applet)
   {
      image = new Image[count];

      for(int i = 0; i < count; i++)
         image[i] = applet.getImage(applet.getCodeBase(), filename + i + ".gif");
   }


   public Image currentImage()
   {
      if( delay == 10)
      {
         current++;

         if (current >= image.length) current = 1;

         delay = -1;
      }

      delay++;

      return image[current];
   }

   public Image stillImage()
   {
      return image[0];
   }

}