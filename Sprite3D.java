import java.awt.*;

public abstract class Sprite3D
{
   int x;
   int y;
   int z;

   int w;
   int h;


   boolean moving = false;
   boolean dying  = false;
   boolean dead   = false;

   final int FORWARD    = 0;
   final int BACKWARD   = 1;
   final int LEFT  = 2;
   final int RIGHT = 3;
   final int DIE   = 4;
   final int JUMP  = 5;

   int action = FORWARD;


   public Sprite3D(int x, int y, int z, int w, int h)
   {
      this.x = x;
      this.y = y;
      this.z = z;

      this.w = w;
      this.h = h;
   }

   public String[] movements()
   {
      String[] movement =
      {
         "_up_",
         "_dn_",
         "_lt_",
         "_rt_",
         "_di_",
      };

      return movement;
   }



   public void moveLeft(int dx)
   {
      x -= dx;

      moving = true;

      action  = LEFT;
   }


   public void moveRight(int dx)
   {
      x += dx;

      moving = true;

      action = RIGHT;
   }

   public void moveBackward(int dz)
   {
      z -= dz;

      moving = true;

      action = BACKWARD;
   }

   public void moveForward(int dz)
   {
      z += dz;

      moving = true;

      action = FORWARD;
   }

   public void die()
   {
      dying = true;

      action = DIE;
   }

   public void jump()
   {
      moving = true;

      action = JUMP;
   }

   public void clearMoving()
   {
      moving = false;
   }

   public abstract void draw(Graphics g);


}