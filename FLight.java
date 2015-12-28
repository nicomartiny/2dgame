import java.awt.*;
import java.awt.geom.*;


public class FLight extends Model2D
{

   public FLight(int x, int y)
   {
      super(x, y);
   }


   public int[][] getXPoints()
   {
      int[][] xm =
      {
//         {450, 450, 0, 0},
//         { 90,  90,  -90,  -90},
//         { 90,  90,  -90,  -90},
//         {90, 90, 20, 20},
      };

      return xm;
   }

   public int[][] getYPoints()
   {
      int[][] ym =
      {
//         {0, 300, 300, 0},
//         { 50, 60, 60, 50},
//         {-50, -60, -60, -50},
//         {-5, 5, 5, -5},
      };

      return ym;
   }

   public void draw(Graphics g)
   {
      
      int iFront = 1; 
      g.setColor(new Color(0, 0, 0, 235));//shadows color and intencity 
      g.fillRect(x + (500 * (iFront - 1)), y - 1000, 1000, 1000);//top front
      g.fillRect(x + (500 * (iFront - 1)), y + 60, 1000, 1000);//bottom front
      g.fillRect(x - (500 * (iFront + 1)), y - 1000, 1000, 2000);//all behind
//      g.fillPolygon(new int [] {x, y + 30} , new int [] {x,  y}, new int [] {x + 400, y});//triangle top       

//      g.setBackground(new Color(0, 0, 0, 64)); 
//      g.setComposite(1);
      super.draw(g);

    
   }
}
