import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Draw extends Applet implements Runnable, KeyListener
{

   Tank tank = new Tank(100, 400);

   StealthFighter fighter = new StealthFighter(500, 200);

   Thread thread;


   boolean upPressed = false;
   boolean dnPressed = false;
   boolean ltPressed = false;
   boolean rtPressed = false;


   int x = 0;
   int y = 0;

   public void init()
   {
      requestFocus();

      addKeyListener(this);

      thread = new Thread(this);

      thread.start();
   }



   public void paint(Graphics g)
   {

       tank.draw(g);

       fighter.draw(g);

   }


   public void run()
   {
      while(true)
      {

         if(dnPressed)    fighter.moveForwardBy(10);

         if(rtPressed)    fighter.rotateBy(-3);

         if(ltPressed)    fighter.rotateBy(3);

         if(upPressed)    fighter.moveForwardBy(10);





         try
         {
            thread.sleep(16);
         }
         catch(Exception x){}

         repaint();
      }
   }


   public void keyPressed(KeyEvent e)
   {
      if(e.getKeyCode() == e.VK_UP)     upPressed = true;
      if(e.getKeyCode() == e.VK_DOWN)   dnPressed = true;
      if(e.getKeyCode() == e.VK_LEFT)   ltPressed = true;
      if(e.getKeyCode() == e.VK_RIGHT)  rtPressed = true;
   }

   public void keyReleased(KeyEvent e)
   {
      if(e.getKeyCode() == e.VK_UP)     upPressed = false;
      if(e.getKeyCode() == e.VK_DOWN)   dnPressed = false;
      if(e.getKeyCode() == e.VK_LEFT)   ltPressed = false;
      if(e.getKeyCode() == e.VK_RIGHT)  rtPressed = false;
   }

   public void keyTyped(KeyEvent e)
   {

   }


   public void drawPoly(int[] xPoints, int[] yPoints, Graphics g)
   {
      int len = xPoints.length;

      for(int i = 0; i <= len; i++)
      {
         drawLine
         (
            xPoints[i],
            yPoints[i],
            xPoints[(i+1) % len],
            yPoints[(i+1) % len],
            g
         );
       }

   }



   public void drawLine(int x1, int y1, int x2, int y2, Graphics g)
   {
      if(y1 == y2)  drawHLine(x1, x2, y1, g);
      else
      if(x1 == x2)  drawVLine(x1, y1, y2, g);
      else
      {



         float m = (y2 - y1) / (float)(x2 - x1);

         if(Math.abs(m) < 1)
         {
            if(x1 > x2)
            {
               int temp = x1;
               x1 = x2;
               x2 = temp;

               temp = y1;
               y1 = y2;
               y2 = temp;
            }


            float y = y1;

            for(int x = x1; x <= x2; x++)
            {
               plotPoint(x, (int)y, g);

               y += m;
            }
         }
         else
         {
            float r = 1 / m;

            if(y1 > y2)
            {
               int temp = x1;
               x1 = x2;
               x2 = temp;

               temp = y1;
               y1 = y2;
               y2 = temp;
            }


            float x = x1;

            for(int y = y1; y <= y2; y++)
            {
               plotPoint((int)x, y, g);

               x += r;
            }
         }

      }

   }


   public void plotPoint(int x, int y, Graphics g)
   {
      g.drawLine(x, y, x, y);
   }


   public void drawVLine(int x, int y1, int y2, Graphics g)
   {
      if(y1 < y2)
      {
         for(int y = y1; y <= y2; y++)
            plotPoint(x, y, g);
      }
      else
      {
         for(int y = y2; y <= y1; y++)
            plotPoint(x, y, g);
      }
   }

   public void drawHLine(int x1, int x2, int y, Graphics g)
   {
      if(x1 < x2)
      {
         for(int x = x1; x <= x2; x++)
            plotPoint(x, y, g);
      }
      else
      {
         for(int x = x2; x <= x1; x++)
            plotPoint(x, y, g);
      }
   }

}