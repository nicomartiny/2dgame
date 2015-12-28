import java.applet.Applet;
import java.awt.*;


public class AnimatedSprite3D extends Sprite3D
{
   Animation[] animation;

   public AnimatedSprite3D
   (
      String filename,
      int x, int y, int z,
      int w, int h,
      int anim_count,
      int img_count,
      Applet applet
   )
   {
      super(x, y, z, w, h);

      animation = new Animation[anim_count];


      String[] movement = movements();

      for(int i = 0; i < anim_count; i++)
         animation[i] = new Animation(filename + movement[i], img_count, applet);
   }



   public void draw(Graphics g)
   {
     if (z > 0)
     {
        if (dying && (! dead))
        {
           moving = true;

           if (animation[action].current == 4)  dead = true;
        }

        int d = 100;
        int x_origin = 512;
        int y_origin = 550;

        int xp = d * x / z;
        int yp = d * y / z;

        int wp = d * w / z;
        int hp = d * h / z;

        int xd = (xp - wp / 2) + x_origin;
        int yd = (yp - hp) + y_origin;

         if (moving)
            g.drawImage(animation[action].currentImage(), xd, yd, wp, hp, null);
         else
            g.drawImage(animation[action].stillImage(), xd, yd, wp, hp, null);


         clearMoving();
     }
   }
}
