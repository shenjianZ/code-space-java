package Matrix;

public class SymmetricMatrix {
    private int size;
    private int[] element;

    public SymmetricMatrix(int size) {
        this.size = size;
        // 只存储上半部分或下半部分
        this.element = new int[size * (size + 1) / 2];
    }

    // 其他操作可以根据需要添加，例如矩阵相加等
    public static void main(String[] args) {
        int size = 3; // 设置矩阵大小
        SymmetricMatrix symmetricMatrix = new SymmetricMatrix(size);

        // 设置矩阵元素
        symmetricMatrix.set(0, 0, 1);
        symmetricMatrix.set(1, 1, 2);
        symmetricMatrix.set(2, 2, 3);
        symmetricMatrix.set(0, 1, 4);
        symmetricMatrix.set(1, 2, 5);

        // 打印矩阵
        symmetricMatrix.print();
    }

    public void set(int row, int col, int value) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid row or column index");
        }

        if (row >= col) {
            // 存储上半部分或对角线上的元素
            element[row * (row + 1) / 2 + col] = value;
        } else {
            // 存储下半部分
            element[col * (col + 1) / 2 + row] = value;
        }
    }

    public int get(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid row or column index");
        }

        if (row >= col) {
            // 上半部分或对角线上的元素
            return element[row * (row + 1) / 2 + col];
        } else {
            // 下半部分
            return element[col * (col + 1) / 2 + row];
        }
    }

    public int getSize() {
        return size;
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
