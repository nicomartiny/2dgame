import java.applet.Applet;
import java.awt.*;


public class Soldier3D extends AnimatedSprite3D
{
   Rect boundary;

   public Soldier3D(int x, int y, int z, int w, int h, Applet applet)
   {
      super("g", x, y, z, w, h, 5, 5, applet);

      boundary = new Rect(x, y, 20, 50);

   }

   public boolean contains(int mx, int my)
   {
      boundary.x = x;
      boundary.y = y;

      return boundary.contains(mx, my);
   }

}
