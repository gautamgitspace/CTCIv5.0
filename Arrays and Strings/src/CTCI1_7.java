/**
 * Created by Gautam on 7/9/16.
 */
public class CTCI1_7
{
    public static void zeroify(int[][] matrix)
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
        //call to nullify rows
        for(int i=0;i<row.length;i++)
        {
            if(row[i])
                nullifyRow(matrix,i);
        }
        //call to nullify columns
        for(int j=0;j<col.length;j++)
        {
            if(col[j])
                nullifyCol(matrix,j);
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



    public static void nullifyRow(int[][] matrix, int row)
    {
        for(int j=0;j<matrix[0].length;j++)
        {
            matrix[row][j]=0;
        }
    }
    public static void nullifyCol(int[][] matrix, int col)
    {
        for(int i=0;i<matrix.length;i++)
        {
            matrix[i][col]=0;
        }
    }
    public static void main(String args[])
    {
        int[][] matrix1 = randomMatrix(10, 15, 0, 100);
        printMatrix(matrix1);
        System.out.println();
        zeroify(matrix1);
        printMatrix(matrix1);

    }

}
