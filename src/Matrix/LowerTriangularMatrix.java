package Matrix;

public class LowerTriangularMatrix {
    private int size;
    private int[] elements;

    public LowerTriangularMatrix(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Matrix size must be a positive integer");
        }
        this.size = size;
        // 计算下三角矩阵需要的元素个数
        int numElements = size * (size + 1) / 2;
        this.elements = new int[numElements];
    }

    public static void main(String[] args) {
        // 创建一个3x3的下三角矩阵
        LowerTriangularMatrix matrix = new LowerTriangularMatrix(3);

        // 设置一些元素的值
        matrix.set(0, 0, 1);
        matrix.set(1, 1, 2);
        matrix.set(2, 2, 3);
        matrix.set(1, 0, 4);

        // 打印矩阵
        matrix.print();
    }

    public void set(int row, int col, int value) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        if (row >= col) {
            // 在下三角部分设置元素
            elements[row * (row + 1) / 2 + col] = value;
        } else {
            // 上三角部分的元素应为零
            throw new IllegalArgumentException("Invalid element for lower triangular matrix");
        }
    }

    public int get(int row, int col) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        if (row >= col) {
            // 获取下三角部分的元素
            return elements[row * (row + 1) / 2 + col];
        } else {
            // 上三角部分的元素应为零
            return 0;
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
