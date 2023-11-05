package Matrix;


// 稀疏矩阵类使用三元组表示法
public class SparseMatrix {
    private final int rows;
    private final int cols;
    private final Triplet[] elements;
    private int count;
    public SparseMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new Triplet[rows * cols];
        this.count = 0;
    }

    public static void main(String[] args) {
        // 创建一个4x4的稀疏矩阵
        SparseMatrix matrix = new SparseMatrix(4, 4);

        // 设置一些元素的值
        matrix.set(0, 0, 1);
        matrix.set(1, 1, 2);
        matrix.set(2, 2, 3);
        matrix.set(3, 3, 4);

        // 打印矩阵
        matrix.print();
    }

    public void set(int row, int col, int value) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        if (value != 0) {
            elements[count] = new Triplet(row, col, value);
            count++;
        }
    }

    public int get(int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        for (int i = 0; i < count; i++) {
            if (elements[i].row == row && elements[i].col == col) {
                return elements[i].value;
            }
        }
        return 0;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(get(i, j) + " ");
            }
            System.out.println();
        }
    }

    // 三元组类表示稀疏矩阵中的非零元素
    public static class Triplet {
        int row;
        int col;
        int value;

        public Triplet(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
