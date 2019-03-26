package com.dw.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MST {
	public int V = 5;
	
    int minKey(int key[], Boolean mstSet[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) 
            { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    
    int primMST(int graph[][]) 
    { 
        int parent[] = new int[V]; 
  
        int key[] = new int [V]; 
  
        Boolean mstSet[] = new Boolean[V]; 
  
        for (int i = 0; i < V; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
        key[0] = 0;     // Make key 0 so that this vertex is 
                        // picked as first vertex 
        parent[0] = -1; // First node is always root of MST 
  
        for (int count = 0; count < V-1; count++) 
        { 
            int u = minKey(key, mstSet); 
  
            mstSet[u] = true; 
  
            for (int v = 0; v < V; v++) 
  
                if (graph[u][v]!=0 && mstSet[v] == false && 
                    graph[u][v] < key[v]) 
                { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
  
        return sumMST(parent, V, graph); 
    } 
    
    int sumMST(int parent[], int n, int graph[][]) 
    { 
    	int total = 0;
        for (int i = 1; i < V; i++) {
        	int value = graph[i][parent[i]];
        	
        	if(value > 1) {
        		total += value;
        	}
        }
        return total;
    } 
	
	int getMinimumCostToRepair(int numTotalAvailableCities, 
            int numTotalAvailableRoads, 
            List<List<Integer>> roadsAvailable, 
            int numRoadsToBeRepaired, 
            List<List<Integer>> costRoadsToBeRepaired)
	{
	// WRITE YOUR CODE HERE
	
		int result = 0;
		V = numTotalAvailableCities;
		
		int graph[][] = new int[numTotalAvailableCities][numTotalAvailableCities];
		
		HashMap<List<Integer>, Integer> hashMap = new HashMap<List<Integer>, Integer>();
		
		for(int i = 0; i< numTotalAvailableRoads; i++) {
			List<Integer> pair = roadsAvailable.get(i);
			int start = pair.get(0);
			int end = pair.get(1);
			
			graph[start-1][end-1] = 1;
			graph[end-1][start-1] = 1;
		}
		
		for(int i=0; i<numRoadsToBeRepaired; i++) {
			List<Integer> pair = costRoadsToBeRepaired.get(i);
			int start = pair.get(0);
			int end = pair.get(1);
			
			graph[start-1][end-1] = pair.get(2);
			graph[end-1][start-1] = pair.get(2);
		}
		
		MST t = new MST();
		result = t.primMST(graph);
		
		return result;
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numTotalAvailableCities = 5;
		int numTotalAvailableRoads = 5;
		int[][] roadsAvailable = {{1,2}, {2,3}, {3,4}, {4,5}, {1,5}};
		int numRoadsToBeRepaired = 3;
		int[][] costRoadsToBeRepaired = {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
		
		List<List<Integer>> roadsAvailableList = new ArrayList<List<Integer>>();
		for(int i=0;i<numTotalAvailableRoads;i++) { 
			List<Integer> t = new ArrayList<Integer>();
			t.add(roadsAvailable[i][0]);
			t.add(roadsAvailable[i][1]);
			
			roadsAvailableList.add(t);
		}
		
		List<List<Integer>> costRoadsToBeRepairedList = new ArrayList<List<Integer>>();
		for(int i=0;i<numRoadsToBeRepaired;i++) { 
			List<Integer> t = new ArrayList<Integer>();
			t.add(costRoadsToBeRepaired[i][0]);
			t.add(costRoadsToBeRepaired[i][1]);
			t.add(costRoadsToBeRepaired[i][2]);
			
			costRoadsToBeRepairedList.add(t);
		}
		
		MST mst = new MST();
		
		int result = mst.getMinimumCostToRepair(numTotalAvailableCities, numTotalAvailableRoads,
				roadsAvailableList, numRoadsToBeRepaired, costRoadsToBeRepairedList);
		
		System.out.println(result);
	}

}
