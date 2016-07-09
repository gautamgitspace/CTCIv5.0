/**
 * Created by Gautam on 7/9/16.
 */
public class CTCI1_7
{
    public void zeroify(int[][] matrix)
    {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
    }

    public static void main(String args)
    {

    }

    public void nullifyRow(int[][] matrix, int row)
    {

    }
    public void nullifyCol(int[][] matrix, int col)
    {
        
    }

}
