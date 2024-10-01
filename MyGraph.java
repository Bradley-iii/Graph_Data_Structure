import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import javax.xml.transform.Source;



public class MyGraph<T> {
    HashSet<MyGraphVertex<T>> vertices; 

    public MyGraph() {
        vertices = new HashSet<>();
    }

    public void addVertex(MyGraphVertex<T> v) { 
        vertices.add(v);
    }

    @Override
    public String toString() { 
        String output = "";
        for(MyGraphVertex<T> v: vertices) { 
            output += v.getName() + " -> ";
            HashMap<MyGraphVertex<T>, MyGraphEdge> map = v.getMap();
            Set<MyGraphVertex<T>> keyset = map.keySet();
            for(MyGraphVertex<T> currentVertex: keyset) { 
                output += currentVertex.getName();
                output += "( " + map.get(currentVertex) + "), ";
            }
            output += "\n";
        }
        return output; 
    }

    public void addEdge(MyGraphEdge e, MyGraphVertex<T> v1, MyGraphVertex<T> v2) {
        v1.addVertexEdgePair(v2, e); 
        v2.addVertexEdgePair(v1, e);
    }

    // return a vertex given a vertex name
    public MyGraphVertex<T> get(String v) { 
        Iterator<MyGraphVertex<T>> iter = vertices.iterator();
        while(iter.hasNext()) { 
            MyGraphVertex<T> current = iter.next();
            if(current.getName().equals(v)) { 
                // if it equals param
                return current;
            }
        }
        return null;
    }

    public int numVertices() { 
        Iterator<MyGraphVertex<T>> iter = vertices.iterator();
        int c = 0; 
        while(iter.hasNext()) { 
            c++;
            iter.next();
        }
        return c; 
    }

    public String vertices() {
        Iterator<MyGraphVertex<T>> iter = vertices.iterator();
        String c = ""; 
        while(iter.hasNext()) { 
            MyGraphVertex<T> current = iter.next();
            c += current.getName() + " ";
        }
        return c; 
    }

    public String edges() { 
        ArrayList<MyGraphEdge> arr = new ArrayList<>();
        Iterator<MyGraphVertex<T>> iter = vertices.iterator();
        String c = ""; 
        while(iter.hasNext()) { 
            MyGraphVertex<T> current = iter.next();
            HashMap<MyGraphVertex<T>, MyGraphEdge> map = current.getMap(); // gives me the hashmap of the vertice
            for(MyGraphEdge edge: map.values()) {
                if(!arr.contains(edge)) {
                    c += edge.getName() + " ";
                    arr.add(edge);
                }
            }
        }
        return c; 
    }

    public MyGraphEdge getEdge(MyGraphVertex<T> u, MyGraphVertex<T> v) { 
        if(u != null && v != null) { 
            HashMap<MyGraphVertex<T>, MyGraphEdge> mapOfU = u.getMap();
            return mapOfU.get(v);
        }
        return null;
    }

    

    public ArrayList<MyGraphVertex<T>> endVertices(MyGraphEdge e) { 
        ArrayList<MyGraphVertex<T>> arr = new ArrayList<>();
        for(MyGraphVertex<T> v: vertices) {
            if(v.getMap().values().contains(e)) {
                arr.add(v);
            }
        }
        return arr; 
    } 


    public MyGraphEdge getEdge(String a) { 
        Iterator<MyGraphVertex<T>> iter = vertices.iterator(); 
        while(iter.hasNext()) { 
            MyGraphVertex<T> current = iter.next();
            for(MyGraphEdge val: current.getMap().values()) {
                if(val.getName().equals(a)) {
                    return val;
                }
            }
        }
        return null;
    }

    public MyGraphVertex<T> opposite(MyGraphVertex<T> v, MyGraphEdge e) { 
        Iterator<MyGraphVertex<T>> iter = vertices.iterator(); 
        while(iter.hasNext()) { 
            MyGraphVertex<T> current = iter.next();
            if(current.getMap().get(v) != null) { 
                return current;
            }
        }
        return null;
    }

    public int outDegree(MyGraphVertex<T> v) { 
        return v.getMap().size();
    }

    public int inDegree(MyGraphVertex<T> v) {
        return outDegree(v);
    }

    public String outgoingEdges(MyGraphVertex<T> v) { 
        String str = "";
        for(MyGraphEdge edge: v.getMap().values()) {
            str += edge + " ";
        }
        return str;
    }

    public String incomingEdges(MyGraphVertex<T> v) { 
        return outgoingEdges(v);
    }

    public void removeVertex(MyGraphVertex<T> v) {
        v.getMap().clear();
        Iterator<MyGraphVertex<T>> iter = vertices.iterator();
        while(iter.hasNext()) {
            MyGraphVertex<T> curr = iter.next();
            if(curr.getMap().get(v) != null) {
                curr.getMap().remove(v);
            }
        }
        vertices.remove(v);
        v = null;
    }

    public void removeEdge(MyGraphEdge e) { 
        Iterator<MyGraphVertex<T>> iter = vertices.iterator();
        while(iter.hasNext()) {
            MyGraphVertex<T> curr = iter.next();
            if(curr.getMap().values().contains(e)) {
                Set<MyGraphVertex<T>> set = curr.getMap().keySet();
                Iterator<MyGraphVertex<T>> setIter = set.iterator();
                while(setIter.hasNext()) {
                    MyGraphVertex<T> setCurr = setIter.next();
                    if(curr.getMap().get(setCurr).equals(e)) {
                        setIter.remove();
                    }
                }

            }
        }
    }
             
            

    

    public ArrayList<MyGraphEdge> pathToVertex(MyGraphVertex<T> begin, MyGraphVertex<T> end) { 

        for(MyGraphVertex<T> temp: DepthFirstSearch(begin, end)) {
            System.out.println(temp.getName());
        }
        return null;
        
    }

    private ArrayList<MyGraphVertex<T>> DepthFirstSearch(MyGraphVertex<T> begin, MyGraphVertex<T> end) {
        Stack<MyGraphVertex<T>> myStack = new Stack<>();
        ArrayList<MyGraphVertex<T>> visitedList = new ArrayList<>();
        for(MyGraphVertex<T> vertexesAroundMe: begin.getAllConnectedVertices()) { 
            myStack.add(vertexesAroundMe);
        }
        MyGraphVertex<T> curr = begin; 
        visitedList.add(begin);
        // the begin and stack are now done, now to work on traversing 
        while(myStack.size() != 0) {
            if(curr.equals(end)) {
                break;
            }
            // the stack has the shit around us, while we have shit to go to. 
            curr = myStack.peek();
            myStack.pop();      
            visitedList.add(curr); 
            for(MyGraphVertex<T> vertexesAroundMe: curr.getMap().keySet()) { 
                if(!myStack.contains(vertexesAroundMe) && !visitedList.contains(vertexesAroundMe)){
                    myStack.add(vertexesAroundMe);
                }
            }
        }
        return visitedList; 
    }



    
}
