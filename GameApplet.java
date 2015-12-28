import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public abstract class GameApplet extends Applet
       implements Runnable, KeyListener, MouseListener
{

   Image    offscr_image;
   Graphics offscr_g;

   Graphics g;


   Thread thread;


   boolean upPressed = false;
   boolean dnPressed = false;
   boolean ltPressed = false;
   boolean rtPressed = false;
   boolean u_Pressed = false;
   boolean d_Pressed = false;



   public void init()
   {
      offscr_image = createImage(1024, 768);

      offscr_g     = offscr_image.getGraphics();

      g = getGraphics();


      requestFocus();

      addKeyListener(this);

      addMouseListener(this);

      thread = new Thread(this);

      thread.start();
   }

   public void update(Graphics g)
   {
      offscr_g.clearRect(0, 0, 1024, 800);

      paint(offscr_g);

      g.drawImage(offscr_image, 0, 0, null);
   }


   public void repaint()
   {
      //Graphics g = getGraphics();

      update(g);

      //g.dispose();
   }






   public void run()
   {
      while(true)
      {
         InGameLoop();

         try
         {
            thread.sleep(16);
         }
         catch(Exception x){}

         repaint();
      }
   }


   public abstract void InGameLoop();


   public void keyPressed(int code)
   {
      if(code == _UP)  upPressed = true;
      if(code == _DN)  dnPressed = true;
      if(code == _LT)  ltPressed = true;
      if(code == _RT)  rtPressed = true;
      if(code == _U)   u_Pressed = true;
      if(code == _D)   d_Pressed = true;
   }


   public void keyReleased(int code)
   {
      if(code == _UP)  upPressed = false;
      if(code == _DN)  dnPressed = false;
      if(code == _LT)  ltPressed = false;
      if(code == _RT)  rtPressed = false;
      if(code == _U)   u_Pressed = false;
      if(code == _D)   d_Pressed = false;
   }



   final int _UP = KeyEvent.VK_UP;
   final int _DN = KeyEvent.VK_DOWN;
   final int _LT = KeyEvent.VK_LEFT;
   final int _RT = KeyEvent.VK_RIGHT;
   final int _A = KeyEvent.VK_A;
   final int _B = KeyEvent.VK_B;
   final int _C = KeyEvent.VK_C;
   final int _D = KeyEvent.VK_D;
   final int _E = KeyEvent.VK_E;
   final int _F = KeyEvent.VK_F;
   final int _G = KeyEvent.VK_G;
   final int _H = KeyEvent.VK_H;
   final int _I = KeyEvent.VK_I;
   final int _J = KeyEvent.VK_J;
   final int _K = KeyEvent.VK_K;
   final int _L = KeyEvent.VK_L;
   final int _U = KeyEvent.VK_U;
   final int _0 = KeyEvent.VK_0;
   final int _1 = KeyEvent.VK_1;
   final int _2 = KeyEvent.VK_2;
   final int _3 = KeyEvent.VK_3;
   final int _4 = KeyEvent.VK_4;
   final int _5 = KeyEvent.VK_5;
   final int _6 = KeyEvent.VK_6;
   final int _7 = KeyEvent.VK_7;


   public void mousePressed(MouseEvent e)
   {

   }

   public void mouseReleased(MouseEvent e)
   {

   }

   public void mouseClicked(MouseEvent e)
   {

   }

   public void mouseEntered(MouseEvent e)
   {

   }

   public void mouseExited(MouseEvent e)
   {

   }


   public final void keyPressed(KeyEvent e)
   {
      keyPressed(e.getKeyCode());
   }


   public final void keyReleased(KeyEvent e)
   {
      keyReleased(e.getKeyCode());
   }

   public final void keyTyped(KeyEvent e) {   }


}