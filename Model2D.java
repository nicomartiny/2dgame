import java.awt.*;


public abstract class Model2D
{
   int[][] xm = getXPoints();

   int[][] ym = getYPoints();


   int x = 0;
   int y = 0;

   int angle = 0;


   public Model2D(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   public abstract int[][] getXPoints();
   public abstract int[][] getYPoints();

   public void moveForwardBy(int dist)
   {
      x += dist * Math.cos(angle * Math.PI / 180);

      y += dist * Math.sin(angle * Math.PI / 180);
   }


   public void moveBy(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

   public void rotateBy(int dangle)
   {
      angle += dangle;
   }


   public void draw(Graphics g)
   {
      int[] xr = new int[4];
      int[] yr = new int[4];

      int[] xp = new int[4];
      int[] yp = new int[4];

      double cosA = Math.cos(angle * Math.PI / 180);
      double sinA = Math.sin(angle * Math.PI / 180);

      for(int poly = 0; poly < xm.length; poly++)
      {
         for(int i = 0; i < xm[poly].length; i++)
         {
            xr[i] = (int)(xm[poly][i]*cosA - ym[poly][i]*sinA);
            yr[i] = (int)(xm[poly][i]*sinA + ym[poly][i]*cosA);

            xp[i] = xr[i] + x;
            yp[i] = yr[i] + y;
         }

         g.drawPolygon(xp,  yp,  xm[poly].length);
      }

   }

}