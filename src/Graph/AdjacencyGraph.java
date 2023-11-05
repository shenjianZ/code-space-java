package Graph;

public class AdjacencyGraph<E> {

    int MaxVertex;
    int vertexCount;
    int edgeCount;
    HeadNode<E>[] vertex;
    public AdjacencyGraph() {
        this.MaxVertex = 6;
        this.vertexCount = 0;
        this.edgeCount = 0;
        this.vertex = new HeadNode[MaxVertex];
    }

    public static void main(String[] args) {
        AdjacencyGraph<Character> graph = new AdjacencyGraph<>();
        for (int c = 'A'; c <= 'D'; c++) {
            graph.addVertex((char) c);
        }
        graph.addEdge(0, 1);   //A -> B
        graph.addEdge(1, 2);   //B -> C
        graph.addEdge(2, 3);   //C -> D
        graph.addEdge(3, 0);   //D -> A
        graph.addEdge(2, 0);   //C -> A
        graph.printGraph();
    }

    public void addVertex(E element) {
        if (vertexCount >= MaxVertex)
            return;
        vertex[vertexCount] = new HeadNode<>();
        vertex[vertexCount].element = element;
        vertex[vertexCount].next = null;
        this.vertexCount++;
    }

    public void addEdge(int x, int y) {
        Node<E> node = this.vertex[x].next;
        Node<E> newNode = new Node<>();
        newNode.next = null;
        newNode.nextVertex = y;
        if (node == null)
            vertex[x].next = newNode;
        else {
            while (true) {
                if (node.nextVertex == y)
                    // 如果已经连接了对应的顶点，那么直接返回
                    return;
                if (node.next != null)
                    // 否则继续向后遍历
                    node = node.next;
                else
                    // 如果没有下一个了，那就找到最后一个结点了，直接结束
                    break;
            }
            node.next = newNode;
        }
        this.edgeCount++;
    }

    public void printGraph() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + " | " + vertex[i].element);
            Node<E> node = vertex[i].next;
            while (node != null) {
                System.out.print(" -> " + node.nextVertex);
                node = node.next;
            }
            System.out.println();
        }
    }

    public static class Node<E> {
        int nextVertex;
        Node<E> next;


    }

    public static class HeadNode<E> {
        E element;
        Node<E> next;
    }

}
