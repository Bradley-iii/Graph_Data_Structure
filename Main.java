import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
            MyGraph<String> graph = new MyGraph<>();
            
            /*
            graph.addVertex(new MyGraphVertex<String>("u"));
            graph.addVertex(new MyGraphVertex<String>("v"));
        
            graph.addEdge(new MyGraphEdge("e"), graph.get("u"), graph.get("v"));
            graph.addEdge(new MyGraphEdge("g"), graph.get("u"), graph.get("w"));
            graph.addEdge(new MyGraphEdge("f"), graph.get("v"), graph.get("w"));
            graph.addEdge(new MyGraphEdge("h"), graph.get("w"), graph.get("z"));
            */
        

            graph.addVertex(new MyGraphVertex<String>("A"));
            graph.addVertex(new MyGraphVertex<String>("B"));
            graph.addVertex(new MyGraphVertex<String>("C"));
            graph.addVertex(new MyGraphVertex<String>("D"));
            graph.addVertex(new MyGraphVertex<String>("E"));
            graph.addVertex(new MyGraphVertex<String>("F"));
            graph.addVertex(new MyGraphVertex<String>("G"));
            graph.addVertex(new MyGraphVertex<String>("H"));
            graph.addVertex(new MyGraphVertex<String>("I"));
            graph.addVertex(new MyGraphVertex<String>("J"));
            graph.addVertex(new MyGraphVertex<String>("K"));
            graph.addVertex(new MyGraphVertex<String>("L")); // 12

            MyGraphEdge a = new MyGraphEdge("a");
            graph.addEdge(a, graph.get("A"), graph.get("B"));

            graph.addEdge(new MyGraphEdge("b"), graph.get("A"), graph.get("F"));
            graph.addEdge(new MyGraphEdge("c"), graph.get("B"), graph.get("C"));
            graph.addEdge(new MyGraphEdge("d"), graph.get("C"), graph.get("G"));
            graph.addEdge(new MyGraphEdge("e"), graph.get("C"), graph.get("H"));
            graph.addEdge(new MyGraphEdge("f"), graph.get("D"), graph.get("H"));
            graph.addEdge(new MyGraphEdge("h"), graph.get("E"), graph.get("F"));
            graph.addEdge(new MyGraphEdge("g"), graph.get("F"), graph.get("I"));
            graph.addEdge(new MyGraphEdge("l"), graph.get("F"), graph.get("L"));
            graph.addEdge(new MyGraphEdge("i"), graph.get("I"), graph.get("J"));
            graph.addEdge(new MyGraphEdge("j"), graph.get("J"), graph.get("K"));
            graph.addEdge(new MyGraphEdge("k"), graph.get("K"), graph.get("L")); // 11 


            /*
            System.out.println(graph);
            System.out.println("-=-=-==-= LOL -=-=-=-=-");
            System.out.println("numVertices: " + graph.numVertices());
            System.out.println("Vertices: " + graph.vertices());
            System.out.println("Edges: " + graph.edges());
            System.out.println("getEdge(u, v): " + graph.getEdge(graph.get("A"), graph.get("B")));
            System.out.println("endVertices: " + graph.endVertices(graph.getEdge("a"))); // getEdge returns the edge from a given string, makes it easier, not essential
            System.out.println("opposite: " + graph.opposite(graph.get("A"), graph.getEdge("a")));
            System.out.println("outDegree: " + graph.outDegree(graph.get("A")));    
            */ 
            ArrayList<MyGraphEdge> arr = graph.pathToVertex(graph.get("I"), graph.get("D"));
            for(MyGraphEdge edges: arr) { 
                System.out.println(edges);
            }
    }
}

