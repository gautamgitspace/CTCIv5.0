/**
 * Created by Gautam on 7/9/16.
 */
public class CTCI1_6
{
    public static void rotate(int[][] matrix, int n)
    {
        for (int layer = 0; layer < n / 2; ++layer)
        {
            System.out.println("LAYER: " + layer);
            int first = layer;
            System.out.println("FIRST: " + first);
            int last = n - 1 - layer;
            System.out.println("LAST: " + last);
            for(int i = first; i < last; ++i)
            {

                int offset = i - first;
                System.out.println("OFFSET: " + offset);
                // save top
                int top = matrix[first][i];

                // left -> top
                System.out.println("Moving " + "[" + (last-offset) + "]" + "[" + first + "]" + " to " + "[" + first+ "]" + "[" + i + "]");
                matrix[first][i] = matrix[last-offset][first];


                // bottom -> left
                System.out.println("Moving " + "[" + last + "]" + "[" + (last - offset) + "]" + " to " + "[" + (last-offset) + "]" + "[" + first + "]" );
                matrix[last-offset][first] = matrix[last][last - offset];


                // right -> bottom
                System.out.println("Moving " + "[" + i + "]" + "[" + last + "]" + " to " +  "[" + last + "]" + "[" + (last - offset) + "]" );
                matrix[last][last - offset] = matrix[i][last];


                // top -> right
                System.out.println("Moving " + "[" + first + "]" + "[" + i + "]" + " to " + "[" + i + "]" + "[" + last + "]");
                matrix[i][last] = top; // right <- saved top

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

    public static void main(String[] args)
    {
        int[][] matrix = randomMatrix(4, 4, 0, 3);
        printMatrix(matrix);
        rotate(matrix, 4);
        System.out.println();
        printMatrix(matrix);
    }
}
