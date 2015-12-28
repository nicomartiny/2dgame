import java.awt.*;

public class Rect extends Sprite
{
   int w;
   int h;

   public Rect(int x, int y, int w, int h)
   {
      super(x, y);
      this.w = w;
      this.h = h;
   }


   public boolean contains(int mx, int my)
   {
      return
      (
         (mx > x)      &&
         (mx < x + w)  &&
         (my > y)      &&
         (my < y + h)
      );

   }

   public boolean hasCollidedWith(Rect r)
   {
      return
      (
         (r.y <= y   + h)    &&
         (r.x <= x   + w)    &&
         (y   <= r.y + r.h)  &&
         (x   <= r.x + r.w)
      );
   }


   public void draw(Graphics g)
   {
      g.drawRect(x, y, w, h);
   }



}