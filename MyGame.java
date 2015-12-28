import java.awt.*;
import java.awt.event.*;

public class MyGame extends GameApplet
{

   Tank tank1 = new Tank(200, 300);
   Tank tank2 = new Tank(700, 500);

   FLight light = new FLight(200, 200);
//   FLight light2 = new FLight(200, 200);

   Soldier3D[] sd;

   Soldier3D my_sd = null;

   int mx = 0;
   int my = 0;



   Rect r1 = new Rect(100, 100, 2, 2);
   Rect r2 = new Rect(300, 100, 20, 50);


   ImageLayer mountains;
   ImageLayer houses;
   ImageLayer trees;


   public void init()
   {
      super.init();


      mountains = new ImageLayer("mountains.gif", 10, this);
      houses = new ImageLayer("houses.gif", 3, this);
      trees = new ImageLayer("trees.gif", 1, this);


      sd = new Soldier3D[10];

      for(int i = 0; i < sd.length; i++)
      {

         sd[i]= new Soldier3D(50, 0, 1000 - 10 * i, 20, 50, this);

      }
      my_sd = sd[0];
   }




   public void InGameLoop()
   {

      while(my_sd == null);
   
      if (upPressed)  light.moveBy(0, -5);
      if (dnPressed)  light.moveBy(0, 5);
      if (ltPressed)  light.moveBy(-5, 0);
      if (rtPressed)  light.moveBy(5, 0);
   //
/*
      if (upPressed)  my_sd.moveUp(1);
      if (dnPressed)  my_sd.moveDown(1);
      if (ltPressed)  my_sd.moveLeft(1);
      if (rtPressed)  my_sd.moveRight(1);
//*/
/*
      for (int i = 0; i < sd.length; i++)
      {

         if (upPressed)  sd[i].moveForward(4);
         if (dnPressed)  sd[i].moveBackward(4);
         if (ltPressed)  sd[i].moveLeft(4);
         if (rtPressed)  sd[i].moveRight(4);

         if (sd[i].contains(mx, my))   my_sd = sd[i];

         if(r1.hasCollidedWith(sd[i].boundary))
         {
            sd[i].die();
         }
      }
*/


         if (ltPressed)  Camera.moveLeft(4);
         if (rtPressed)  Camera.moveRight(4);

   }


   public void mousePressed(MouseEvent e)
   {
      mx = e.getX();
      my = e.getY();

   }

   public void mousereleased(MouseEvent e)
   {

   }


   public void paint(Graphics g)
   {

      for(int i = 0; i < sd.length; i++)
      {
         //sd[i].draw(g);
      }
        
//      light2.draw(g);
      light.draw(g);
      mountains.draw(g);
      houses.draw(g);
      trees.draw(g);
      //r1.draw(g);
      //r2.draw(g);
   }



}
