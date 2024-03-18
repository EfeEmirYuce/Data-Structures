package Graph;

import java.awt.*;
import java.util.ArrayList;

public class Graph<T extends Comparable> {
    Vertex<T> head;

    public Vertex<T> findVertex(T id){
        Vertex<T> iterator=head;
        while(iterator!=null){
            if(iterator.id.compareTo(id)==0){
                return iterator;
            }
            iterator=iterator.nextVertex;
        }
        return null;

    }
    public void addVertex(T id){
        if(findVertex(id)!=null) {
            System.out.println("IT ALREADY EXISTS");
            return;
        }
        Vertex<T> newVertex= new Vertex<>(id);
        if (head==null)
            head=newVertex;
        else{
            Vertex<T> iterator=head;
            while(iterator.nextVertex!=null)
                iterator=iterator.nextVertex;
            iterator.nextVertex=newVertex;
        }
    }
    public boolean checkIfTwoEdgesExistBetween(T startId, T endId){
        Vertex<T> startVertex = findVertex(startId);
        Vertex<T> endVertex = findVertex(endId);
        if(startVertex.edgeLink.nextEdge != null && startVertex.edgeLink.nextEdge.vertexId.compareTo(endVertex.id) == 0){
            return true;
        }else{
            return false;
        }
    }
    public void addEdge(T startingId, T endId, int w){
        Vertex<T> current=findVertex(startingId);
        Edge<T> newEdge=new Edge<>(endId, w);
        Edge<T> iteratorEdge=current.edgeLink;
        if(iteratorEdge==null)
            current.edgeLink=newEdge;
        else{
            while(iteratorEdge.nextEdge!=null)
                iteratorEdge=iteratorEdge.nextEdge;
            iteratorEdge.nextEdge=newEdge;
        }
    }
    public int outDegree(T id){
        Vertex<T> current=findVertex(id);
        int count=0;
        Edge<T> iteratorEdge=current.edgeLink;
        while(iteratorEdge!=null)
        {
            iteratorEdge=iteratorEdge.nextEdge;
            count++;

        }
        return count;
    }
    public void display(){
        Vertex<T> current = head;
        while (current != null){
            System.out.print(current.id + "-->");
            Edge<T> iteratorEdge = current.edgeLink;
            if(iteratorEdge == null){
                System.out.print("/");
            }
            while (iteratorEdge != null){
                if(iteratorEdge.nextEdge == null){
                    System.out.println(iteratorEdge.vertexId + "/");
                }else{
                    System.out.print(iteratorEdge.vertexId + "--");
                }
                iteratorEdge = iteratorEdge.nextEdge;
            }
            current = current.nextVertex;
            System.out.println();
        }
    }
    public void display2() {
        Vertex<T> iteratorVertex = head;
        while (iteratorVertex != null) {
            System.out.print(iteratorVertex.id + "->");
            Edge<T> iteratorEdge = iteratorVertex.edgeLink;
            while (iteratorEdge != null) {
                System.out.print(iteratorEdge.vertexId + " ");
                iteratorEdge = iteratorEdge.nextEdge;
            }
            System.out.println();
            iteratorVertex = iteratorVertex.nextVertex;
        }
    }
    public int inDegree(T id){
        int count = 0;
        Vertex<T> iterator = head;
        while(iterator.nextVertex != null){
            Edge<T> iteratorEdge=iterator.edgeLink;
            while(iteratorEdge!=null)
            {
                if(iteratorEdge.vertexId == id){
                    count++;
                }
                iteratorEdge=iteratorEdge.nextEdge;
            }
            iterator = iterator.nextVertex;
        }
        return count;
    }

    public int totalWeight(){
        Vertex<T> iterator = head;
        int count = 0;
        while(iterator != null){
            Edge<T> iteratorEdge = iterator.edgeLink;
            while(iteratorEdge != null){
                count = count + iteratorEdge.weight;
                iteratorEdge = iteratorEdge.nextEdge;
            }iterator = iterator.nextVertex;
        }return count;
    }
    public ArrayList<T> topologicalOrderStartingPoint(){
        Vertex<T> iterator = head;
        ArrayList<T> list = new ArrayList<>();
        while(iterator.nextVertex != null){
            if(inDegree(iterator.id) == 0) {
                list.add(iterator.id);
            }
            iterator = iterator.nextVertex;
        }
        return list;
    }
}