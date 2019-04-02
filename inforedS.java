package cs351_informed_search_class;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class inforedS {
	
	
	

	//h scores is the stright-line distance from the current city to Bucharest
    public static void main(String[] args){
            
    	        // create the map of Romenia
            Map map=new Map();
            // get the source node: Arad
            Node start=map.getStart();
            
            // get the destination node: bucharest
            Node goal=map.getGoal();
            
            
            
            GreedyBS(start,goal);

            List<Node> path = printPath(goal);

    		System.out.println("Path: " + path);
    		
    		



    }
    public static List<Node> printPath(Node target){
		List<Node> path = new ArrayList<Node>();
        
        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }

        Collections.reverse(path);

        return path;
	}

public static void GreedyBS(Node source, Node goal){
		
		source.pathCost = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(20, 
			new Comparator<Node>(){

				//override compare method
				public int compare(Node i, Node j){
					if(i.pathCost > j.pathCost){
						return 1;
					}

					else if (i.pathCost < j.pathCost){
						return -1;
					}

					else{
						return 0;
					}
				}
			}

		);
		
		queue.add(source);
		Set<Node> explored = new HashSet<Node>();
		boolean found = false;

		do{

			Node current = queue.poll();
			explored.add(current);
			

			if(current.value.equals(goal.value)){
				found = true;

				
			}

			


			for(Edge e: current.adjacencies){
				Node child = e.target;
				double cost = e.cost;
				

			
				if(!explored.contains(child) && !queue.contains(child)){
					child.pathCost = current.pathCost + cost;
					child.parent = current;
					queue.add(child);
						
				}
					

				


			}

			
		}while(!queue.isEmpty()&& (found==false));

	}



			

   
				


		

	}
	


                            
  

    
