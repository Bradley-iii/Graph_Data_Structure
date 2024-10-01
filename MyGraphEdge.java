
public class MyGraphEdge {
    private float weight; 
    private String name; 

    public MyGraphEdge(String name) { 
        this.name = name;
    }

    public MyGraphEdge(String name, float weight) { 
        this.name = name;
        this.weight = weight; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public float getWeight() { 
        return weight;
    }

    public void setWeight(float weight) { 
        this.weight = weight; 
    }

    @Override
    public String toString() {
        return "{" +
            " weight='" + getWeight() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

    
}
