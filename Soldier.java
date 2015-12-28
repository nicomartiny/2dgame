import java.applet.Applet;
import java.awt.*;


public class Soldier extends AnimatedSprite
{
   Rect boundary;

   public Soldier(int x, int y, Applet applet)
   {
      super("g", x, y, 5, 5, applet);

      boundary = new Rect(x, y, 20, 50);

   }

   public boolean contains(int mx, int my)
   {
      boundary.x = x;
      boundary.y = y;

      return boundary.contains(mx, my);
   }

/*
   public void draw(Graphics g)
   {
      super.draw(g);

      boundary.draw(g);
   }
*/
}
