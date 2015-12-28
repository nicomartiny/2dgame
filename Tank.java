import java.awt.*;

public class Tank extends Model2D
{

   public Tank(int x, int y)
   {
      super(x, y);
   }


   public int[][] getXPoints()
   {
      int[][] xm =
      {
         {100, 100, -100, -100},
         { 90,  90,  -90,  -90},
         { 90,  90,  -90,  -90},
         {90, 90, 20, 20},
      };

      return xm;
   }

   public int[][] getYPoints()
   {
      int[][] ym =
      {
         {-50, 50, 50, -50},
         { 50, 60, 60, 50},
         {-50, -60, -60, -50},
         {-5, 5, 5, -5},
      };

      return ym;
   }



   public void draw(Graphics g)
   {
      super.draw(g);

      g.drawOval(x-20, y-20, 40, 40);
   }


}