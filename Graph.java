import java.util.*;

class Graph{
  private int v;
  private LinkedList<Integer> []nodes;

  public Graph(int v){
    this.v=v;
    nodes = new LinkedList[v];

    for(int i=0;i<v;i++){
      nodes[i]=new LinkedList<Integer>();
    }
  }
  public void addEdge(int src,int des){
    nodes[src].add(des);
  }
  public void BFS(int src){
    LinkedList<Integer> q = new LinkedList<Integer>();
    boolean []visited = new boolean[v];

    for(int i=0;i<v;i++)
      visited[i]=false;

    visited[src]=true;

    q.add(src);
    while(q.size()!=0){
      src=q.poll();
      System.out.println(src+" ");


      Iterator<Integer> it =nodes[src].listIterator();
      while(it.hasNext()){
        int n=it.next();
        if(visited[n]==false){
          visited[n]=true;
          q.add(n);
        }
      }
    }
  }
  public void DFSUtil(int src,boolean visited[]){
    visited[src]=true;
    System.out.println(src+" ");
    Iterator<Integer> it=nodes[src].listIterator();
    while(it.hasNext()){
      int n=it.next();
      if(visited[n]==false){
        visited[n]=true;
        DFSUtil(n,visited);
      }
    }
  }
  public void DFS(int src){
    boolean []visited = new boolean[v];
    for(int i=0;i<v;i++)
      visited[i]=false;
    DFSUtil(src,visited);

  }
  public void motherVertex(){
    boolean []visited = new boolean[v];
    int n=0;
    for(int i=0;i<v;i++)
      visited[i]=false;

    for(int i=0;i<v;i++)
        if(!visited[i]){

          DFSUtil(i,visited);
          n=i;
    }
    for(int i=0;i<v;i++)
      visited[i]=false;
    DFSUtil(n,visited);
    for(int i=0;i<v;i++){
        if(!visited[i])
          System.out.println(-1);
          return;
    }
    System.out.println("---"+n);

  }
  public void topologicalSortUtil(int src,boolean visited[],Stack<Integer> s){
    visited[src]=true;
    int n;
    Iterator<Integer> it = nodes[src].listIterator();
    while(it.hasNext()){
      n=it.next();
      if(visited[n]==false)
        topologicalSortUtil(n,visited,s);
    }
    s.push(src);
  }
  public void topologicalSort(){
    boolean visited[] = new boolean[v];
    Stack<Integer> s = new Stack<Integer>();
    for(int i=0;i<v;i++)
      visited[i]=false;
    for(int i=0;i<v;i++){
      if(visited[i]==false)
        topologicalSortUtil(i,visited,s);
    }
    while(!s.empty()){
      System.out.println(s.pop()+" ");
    }
  }
  // public longestDistance(int src){
  //   boolean visited[] = new boolean[v];
  //   Stack<Integer> s = new Stack<Integer>();
  //   for(int i=0;i<v;i++)
  //     visited[i]=false;
  //   for(int i=0;i<v;i++){
  //     if(visited[i]==false)
  //       topologicalSortUtil(i,visited,s);
  //   }
  //   int dis[] = new int[v];
  //   for(int i=0;i<v;i++)
  //     dis[i]=-1;
  //   dis[src]=0;
  //   while(!s.empty()){
  //     int u = s.pop();
  //
  //     if(dis[u]!=-1){
  //       Iterator<Integer> it= nodes[u].listIterator();
  //       if(dis[it] < dis[u]+)
  //     }
  //   }
  // }

  public static void main(String args[]){
   Graph g = new Graph(7);
   g.addEdge(0, 1);
g.addEdge(0, 2);
g.addEdge(1, 3);
g.addEdge(4, 1);
g.addEdge(6, 4);
g.addEdge(5, 6);
g.addEdge(5, 2);
g.addEdge(6, 0);

        g.motherVertex();

  }
}
