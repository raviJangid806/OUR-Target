import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphTraversal {
    public void graphDFS(GraphNode root){
        List<GraphNode> visited = new ArrayList<>();
        DfsTraversal(root,visited);
    }  
    private void DfsTraversal(GraphNode root, List<GraphNode> visited){
        
        visited.add(root);
        for(GraphNode child : root.neighbors){
            if(!visited.contains(child)){
                DfsTraversal(child, visited);
            }
        }
    }      
}
