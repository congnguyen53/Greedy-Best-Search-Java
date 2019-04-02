package cs351_informed_search_class;

public class Edge{
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal){
            target = targetNode;
            cost = costVal;
    }
}
