
public class StealthFighter extends Model2D
{
   public StealthFighter(int x, int y)
   {
       super(x, y);
   }

   public int[][] getXPoints()
   {
      int[][] xm ={{0, 100, -100}};

      return xm;
   }

   public int[][] getYPoints()
   {
      int[][] ym ={{100, -50, -50}};

      return ym;
   }




}