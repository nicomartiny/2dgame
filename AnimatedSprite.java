import java.applet.Applet;
import java.awt.*;


public class AnimatedSprite extends Sprite
{
   Animation[] animation;

   public AnimatedSprite
   (
      String filename,
      int x, int y,
      int anim_count,
      int img_count,
      Applet applet
   )
   {
      super(x, y);

      animation = new Animation[anim_count];


      String[] movement = movements();

      for(int i = 0; i < anim_count; i++)
         animation[i] = new Animation(filename + movement[i], img_count, applet);
   }




   public void draw(Graphics g)
   {
     if (dying && (! dead))
     {
        moving = true;

        if (animation[action].current == 4)  dead = true;
     }

      if (moving)    g.drawImage(animation[action].currentImage(), x, y, null);
      else           g.drawImage(animation[action].stillImage(),   x, y, null);

      clearMoving();
   }
}
