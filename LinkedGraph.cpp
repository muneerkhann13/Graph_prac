#include<bits/stdc++.h>

using namespace std;

struct adjNode{
  int des;
  struct adjNode * next;
};
struct adjList{
  struct adjNode *head;
};

struct graph{
  int size;
  struct adjList *nodes;
};

struct adjNode *newadjNode(int des){
  adjNode *node = (struct adjNode*)malloc(sizeof(struct adjNode*));
  node->des=des;
  node->next=NULL;
  return node;
};
struct graph * newGraph(int size){
  graph *newGraph = (graph *)malloc(sizeof(graph*));
  newGraph->nodes=(adjList *)malloc(size*sizeof(adjList*));
  newGraph->size=size;

  for(int i=0;i<size;i++)
    newGraph->nodes[i].head=NULL;
  return newGraph;
}

void addEdge(graph *g,int src,int des){
  adjNode *newNode=newadjNode(des);
  newNode->next=g->nodes[src].head;
  g->nodes[src].head=newNode;
}

void printList(graph *g){
  for(int i=0;i<g->size;i++){
    adjNode *list=g->nodes[i].head;
    while(list){
      cout<<list->des<<" ";
      list=list->next;
    }
    cout<<endl;
  }
}
int main()
{
    // create the graph given in above fugure
    int V = 5;
    struct graph* g = newGraph(V);
    addEdge(g, 0, 1);
    addEdge(g, 0, 4);
    addEdge(g, 1, 2);
    addEdge(g, 1, 3);
    addEdge(g, 1, 4);
    addEdge(g, 2, 3);
    addEdge(g, 3, 4);

    // print the adjacency list representation of the above graph
    printList(g);

    return 0;
}
