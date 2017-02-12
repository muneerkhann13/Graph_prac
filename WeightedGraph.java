import java.util.*;

class Node{
  int des;
  int weight;
  public Node(int des,int weight){
    this.des=des;
    this.weight=weight;
  }
  public int getDes(){
    return des;
  }
  public int getWeight(){
    return weight;
  }
}
class WeightedGraph{
  private int v;
  private LinkedList<Node> []nodes;
  public WeightedGraph(int v){
      this.v=v;
      nodes=new LinkedList[v];
      for(int i=0;i<v;i++)
        nodes[i]=new LinkedList<Node>();
  }
  public void addEdge(int src,int des,int weight){
    nodes[src].add(new Node(des,weight));
  }
  // public void DFS(int src){
  //   boolean visited[]=new boolean[v];
  //
  //   for(int i=0;i<v;i++)
  //     visited[i]=false;
  //
  //   DFSUtil(src,visited);
  // }
  // public void DFSUtil(int src,boolean visited[]){
  //   visited[src]=true;
  //   System.out.println(" "+src);
  // }
  public static void main(String [] args){
    WeightedGraph g =new WeightedGraph(6);
    g.addEdge(0,1,10);
    g.addEdge(1,2,12);
    g.addEdge(2,3,14);
    g.addEdge(3,4,16);
    g.addEdge(4,5,18);
    g.print();


  }
}
