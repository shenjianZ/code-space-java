package Matrix;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] element;

    // 构造方法，添加对rows和columns的判断
    public Matrix(int rows, int columns) {
        if (rows < 0 || columns < 0) {
            throw new IllegalArgumentException("Rows and columns must be greater than or equal to 0.");
        }

        this.rows = rows;
        this.columns = columns;
        this.element = new int[rows][columns];
    }

    // 主方法用于测试
    public static void main(String[] args) {
        try {
            // 尝试创建一个 3x3 的矩阵并初始化
            Matrix matrix = new Matrix(3, 3);
            matrix.set(0, 0, 1);
            matrix.set(0, 1, 2);
            matrix.set(0, 2, 3);
            matrix.set(1, 0, 4);
            matrix.set(1, 1, 5);
            matrix.set(1, 2, 6);
            matrix.set(2, 0, 7);
            matrix.set(2, 1, 8);
            matrix.set(2, 2, 9);

            // 打印矩阵
            System.out.println("Matrix:");
            matrix.printMatrix();
            // 使用 toString 方法打印矩阵
            System.out.println("Matrix:\n" + matrix);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // 尝试创建一个 0x3 的矩阵，应该抛出异常
        try {
            Matrix invalidMatrix = new Matrix(0, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage()); // 应该打印异常信息
        }
    }

    // 获取矩阵行数
    public int getRows() {
        return rows;
    }

    // 获取矩阵列数
    public int getColumns() {
        return columns;
    }

    // 获取矩阵中指定位置的元素
    public int get(int row, int column) {
        return element[row][column];
    }

    // 设置矩阵中指定位置的元素
    public void set(int row, int column, int value) {
        element[row][column] = value;
    }

    // 打印矩阵
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(element[i][j] + " ");
            }
            System.out.println();
        }
    }

    //重写toString方法
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.append(element[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
