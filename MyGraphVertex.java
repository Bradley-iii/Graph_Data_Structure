import java.util.HashMap;
import java.util.Set;

public class MyGraphVertex<T> {
    private T data; 
    private String name; 
    private HashMap<MyGraphVertex<T>, MyGraphEdge> map; 


    public MyGraphVertex(String name) {
        this.name = name;
        map = new HashMap<>();
    }
    

    public MyGraphVertex(T data, String name) {
        this.data = data;
        this.name = name;
        map = new HashMap<>();
    }

    public void addVertexEdgePair(MyGraphVertex<T> v, MyGraphEdge e) { 
        map.putIfAbsent(v, e);
    }


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<MyGraphVertex<T>, MyGraphEdge> getMap() {
        return map;
    }

    public void setMap(HashMap<MyGraphVertex<T>,MyGraphEdge> map) {
        this.map = map;
    }


    public Set<MyGraphVertex<T>> getAllConnectedVertices() { 
        return map.keySet();
    }

    public boolean connectedTo(MyGraphVertex<T> v) { 
        Set<MyGraphVertex<T>> vertices = getAllConnectedVertices();
        for(MyGraphVertex<T> tempV: vertices) { 
            if(tempV == v) { 
                return true;
            }
        }

        return false; 
    }
    
}
