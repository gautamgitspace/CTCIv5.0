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

    public static int randomInt(int n)
    {
        return (int) (Math.random() * n);
    }
    public static int randomIntInRange(int min, int max)
    {
        return randomInt(max + 1 - min) + min;
    }
    public static int[][] randomMatrix(int M, int N, int min, int max)
    {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] < 10 && matrix[i][j] > -10)
                {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100)
                {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0)
                {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
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
