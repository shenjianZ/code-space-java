package Graph;

import java.util.LinkedList;
import java.util.Queue;

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
        System.out.println("dfs：");
        int[] arr1 = new int[graph.vertexCount];
        graph.dfs(0, 5, arr1);
        System.out.println("\nbfs:");
        Queue<Integer> queue = new LinkedList<>();
        int[] arr2 = new int[graph.vertexCount];
        graph.bfs(0, 4, arr2, queue);
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

    /*    public void dfs(){
            for (int i = 0; i < vertexCount; i++) {
                Node<E> node = vertex[i].next;
                while (node != null) {
                    System.out.print(node.nextVertex + " ");
                    node = node.next;
                }
                System.out.println();
            }
        }*/
    public void dfs(int startVertex, int targetVertex, int[] visited) {
        visited[startVertex] = 1;
        System.out.print(vertex[startVertex].element + " -> "); // 打印当前顶点值
        Node<E> node = vertex[startVertex].next; // 遍历当前顶点所有的分支
        while (node != null) {
            if (visited[node.nextVertex] == 0 && node.nextVertex != targetVertex)
                // 如果尚未访问过这个顶点，那么继续深度优先搜索
                dfs(node.nextVertex, targetVertex, visited);
            else if (visited[node.nextVertex] == 1 && node.nextVertex == targetVertex) {
                System.out.println("Target found!");
                return;
            }
            node = node.next;
        }
    }

    public void bfs(int startVertex, int targetVertex, int[] visited, Queue<Integer> queue) {
        queue.add(startVertex);  // 把起始位置顶点丢进去
        visited[startVertex] = 1; // 起始位置设置为已走过
        while (!queue.isEmpty()) {
            int next = queue.poll();
            System.out.print(vertex[next].element + " -> "); // 从队列中取出下一个顶点，打印
            Node<E> node = this.vertex[next].next; // 遍历当前顶点所有的分支
            while (node != null) {
                if (visited[node.nextVertex] == 0) {
                    // 如果没有走过，那么就直接入队
                    queue.add(node.nextVertex);
                    visited[node.nextVertex] = 1;
                }
                node = node.next;
            }
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
