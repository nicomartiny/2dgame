import java.awt.*;

public abstract class Sprite
{
   int x;
   int y;

   boolean moving = false;
   boolean dying  = false;
   boolean dead   = false;

   final int UP    = 0;
   final int DOWN  = 1;
   final int LEFT  = 2;
   final int RIGHT = 3;
   final int DIE   = 4;
   final int JUMP  = 5;

   int action = UP;


   public Sprite(int x, int y)
   {
      this.x = x;
      this.y = y;
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


   public void moveBy(int dx, int dy)
   {
      x += dx;
      y += dy;

      moving = true;
   }


   public void moveUp(int dy)
   {
      y -= dy;

      moving = true;

      action = UP;
   }

   public void moveDown(int dy)
   {
      y += dy;

      moving = true;

      action = DOWN;
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