package Graph;

public class WeightedMatrixGraph<E> {
    int MaxVertex;   //最大顶点数
    int vertexCount; //顶点数
    int edgeCount;   //边数
    int[][] matrix;  //邻接矩阵 for weights
    E[] data;       //顶点对应的数据

    /**
     *
     */
    public WeightedMatrixGraph() {
        this.MaxVertex = 6;
        this.vertexCount = 0;
        this.edgeCount = 0;
        this.data = (E[]) new Object[MaxVertex];
        matrix = new int[MaxVertex][MaxVertex];
        for (int i = 0; i < MaxVertex; i++) {
            for (int j = 0; j < MaxVertex; j++) {
                matrix[i][j] = 0; // Initialize weights to 0
            }
        }
    }

    public static void main(String[] args) {
        WeightedMatrixGraph<Character> graph = new WeightedMatrixGraph<Character>();
        for (int c = 'A'; c <= 'D'; ++c)
            graph.addVertex((char) c);
        graph.addEdge(0, 1, 2);   //A -> B with weight 2
        graph.addEdge(1, 2, 3);   //B -> C with weight 3
        graph.addEdge(2, 3, 4);   //C -> D with weight 4
        graph.addEdge(3, 0, 1);   //D -> A with weight 1
        graph.addEdge(2, 0, 5);   //C -> A with weight 5
        graph.printGraph();
    }

    /**
     * @param element 顶点的值
     */
    public void addVertex(E element) {
        if (this.vertexCount > this.MaxVertex)
            return;
        this.data[this.vertexCount++] = element;
    }

    /**
     * @param x      起始顶点
     * @param y      终止顶点
     * @param weight 边的权值
     */
    public void addEdge(int x, int y, int weight) {
        if (this.matrix[x][y] == 0) {
            this.matrix[x][y] = weight;
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