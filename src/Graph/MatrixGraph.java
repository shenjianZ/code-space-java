package Graph;

public class MatrixGraph<E> {
    int MaxVertex;   //最大顶点数
    int vertexCount; //顶点数
    int edgeCount;   //边数
    int[][] matrix;  //邻接矩阵
    E[] data;       //顶点对应的数据

    /**
     *
     */
    public MatrixGraph() {
        this.MaxVertex = 6;
        this.vertexCount = 0;
        this.edgeCount = 0;
        this.data = (E[]) new Object[MaxVertex];
        matrix = new int[MaxVertex][MaxVertex];
        for (int i = 0; i < MaxVertex; i++) {
            for (int j = 0; j < MaxVertex; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        MatrixGraph<Character> graph = new MatrixGraph<>();
        for (int c = 'A'; c <= 'D'; ++c)
            graph.addVertex((char) c);
        graph.addEdge(0, 1);   //A -> B
        graph.addEdge(1, 2);   //B -> C
        graph.addEdge(2, 3);   //C -> D
        graph.addEdge(3, 0);   //D -> A
        graph.addEdge(2, 0);   //C -> A
        graph.printGraph();
    }

    /**
     * @param element
     */
    public void addVertex(E element) {
        if (this.vertexCount > this.MaxVertex)
            return;
        this.data[this.vertexCount++] = element;
    }

    /**
     * @param x
     * @param y
     */
    public void addEdge(int x, int y) {
        if (this.matrix[x][y] == 0) {
            this.matrix[x][y] = 1;
            this.edgeCount++;
        }
    }

    /**
     *
     */
    public void printGraph() {
        for (int i = -1; i < this.vertexCount; i++) {
            for (int j = -1; j < this.vertexCount; j++) {
                if (j == -1)
                    System.out.printf("%c", 'A' + i);
                else if (i == -1)
                    System.out.printf("%3c", 'A' + j);
                else
                    System.out.printf("%3d", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

}
