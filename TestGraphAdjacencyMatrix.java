/*
 * Name: Meetkumar Patel
 * CS 2400 Fall 2018 Project 5
 */

public class TestGraphAdjacencyMatrix 
{
	public static void main(String[] args)
	{
		System.out.println("CS 2400 Fall 2018 Java Project 5 \n");
		
		GraphAdjacencyMatrixInterface<String> gam = new GraphAdjacencyMatrix<String>(9);
		
		gam.addEdge(0,1); // edges["A"]["B"] = true; edges[0][1] = true;
		gam.addEdge(0,3); // edges["A"]["D"] = true; edges[0][3] = true;
		gam.addEdge(0,4); // edges["A"]["E"] = true; edges[0][4] = true;
		gam.addEdge(1,4); // edges["B"]["E"] = true; edges[1][4] = true;
		gam.addEdge(2,1); // edges["C"]["B"] = true; edges[2][1] = true;
		gam.addEdge(3,6); // edges["D"]["G"] = true; edges[3][6] = true;
		gam.addEdge(4,5); // edges["E"]["F"] = true; edges[4][5] = true;
		gam.addEdge(4,7); // edges["E"]["H"] = true; edges[4][7] = true;
		gam.addEdge(5,2); // edges["F"]["C"] = true; edges[5][2] = true;
		gam.addEdge(5,7); // edges["F"]["H"] = true; edges[5][7] = true;
		gam.addEdge(6,7); // edges["G"]["H"] = true; edges[6][7] = true;
		gam.addEdge(7,8); // edges["H"]["I"] = true; edges[7][8] = true;
		gam.addEdge(8,5); // edges["I"]["F"] = true; edges[8][5] = true;
		
//		System.out.println("A = 0, B = 1, C = 2, D = 3, E = 4, F = 5, G = 6, H = 7, I = 8");
		gam.setLabel(0, "A");
		gam.setLabel(1, "B");
		gam.setLabel(2, "C");
		gam.setLabel(3, "D");
		gam.setLabel(4, "E");
		gam.setLabel(5, "F");
		gam.setLabel(6, "G");
		gam.setLabel(7, "H");
		gam.setLabel(8, "I");
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
		gam.BFS(); // Perform a BFS from A
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
		gam.DFS(); // Perform a DFS from A
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Task accomplished - End of project!");
		
	} // end main

} // end TestGraphAdjacencyMatrix
