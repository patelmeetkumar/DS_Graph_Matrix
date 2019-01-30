/*
 * Name: Meetkumar Patel
 * CS 2400 Fall 2018 Project 5
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjacencyMatrix<E> implements GraphAdjacencyMatrixInterface<E>
{
	private int N; // number of vertices in the graph
	private boolean[][] edges; // edges[i][j] is true if there is a vertex from i to j
	private E[] labels; // labels[i] contains the label for vertex i
	Queue<Integer> traversalOrderBFS = new LinkedList<Integer>();
	Queue<Integer> traversalOrderDFS = new LinkedList<Integer>();
	
	@SuppressWarnings("unchecked")
	public GraphAdjacencyMatrix(int n) 
	{
		N = n;
		edges = new boolean[n][n]; // All values initially false
		labels = (E[]) new Object[n]; // All values initially null
	} // end constructor

	// Accessor method to get the label of a vertex of this Graph
	public E getLabel(int vertex) 
	{
		return labels[vertex];
	} // end getLabel

	// Test whether an edge exists
	public boolean isEdge(int source, int target) 
	{
		return edges[source][target];
	} // end isEdge

	// Add an edge
	public void addEdge(int source, int target) 
	{
		edges[source][target] = true;
	} // end addEdge

	// Obtain a list of neighbors of a specified vertex of this Graph
	public int[] neighbors(int vertex) 
	{
		int i;
		int count = 0;
		int[] answer;

		for (i = 0; i < labels.length; i++) 
		{
			if (edges[vertex][i]) 
			{
				count++;
			} // end if
		} // end for
		answer = new int[count];
		count = 0;

		for (i = 0; i < labels.length; i++) 
		{
			if (edges[vertex][i]) 
			{
				answer[count++] = i;
			} // end if
		} // end for
		return answer;
	} // end neighbors

	// Remove an edge
	public void removeEdge(int source, int target) 
	{
		edges[source][target] = false;
	} // end removeEdge

	// Change the label of a vertex of this Graph
	public void setLabel(int vertex, E newLabel) 
	{
		labels[vertex] = newLabel;
	} // end setLabel

	// Accessor method to determine the number of vertices in this Graph
	public int size() 
	{
		return labels.length;
	} // end size
	
	// perform a BFS on the graph G
	public void BFS() 
	{
		boolean[] visited = new boolean[N]; // a visited array to mark which vertices have been visited while doing the BFS

		// do the BFS from each node not already visited
		for (int i = 0; i < N; ++i) 
		{	
			if (!visited[i]) 
			{
				System.out.printf("Performing a BFS starting at node %s%n", getLabel(i));
				System.out.println("");
				
				BFS(i, visited);
			} // end if
		} // end for
		
		System.out.println();
		System.out.println("Successfully completed BFS.");
		
		System.out.print("The traversal order is: ");
		for (int i = 0; i < N; ++i) 
		{
			System.out.print("" + getLabel(traversalOrderBFS.poll()) + "");
		} // end for
		
	} // end BFS

	// perform a BFS starting at node start
	public void BFS(int start, boolean[] visited) 
	{
		Queue<Integer> vertexQueue = new LinkedList<Integer>(); // A queue to process nodes

		// start with only the start node in the queue and mark it as visited
		vertexQueue.offer(start);
		visited[start] = true;

		// continue searching the graph while still nodes in the queue
		while (!vertexQueue.isEmpty()) 
		{
			int at = vertexQueue.poll(); // get the head of the queue
			System.out.printf("At node %s in the BFS%n", getLabel(at));
			traversalOrderBFS.offer(at);

			// add any unseen nodes to the queue to process, then mark them as visited so
			// they don't get re-added
			for (int i = 0; i < N; ++i)
			{	
				if (edges[at][i] && !visited[i]) // if edge exists between at and i, & not visited i
				{
					vertexQueue.offer(i);
					visited[i] = true;
					System.out.printf("Adding node %s to the queue in the BFS%n", getLabel(i));
				} // end if
			} // end for
			System.out.printf("Done processing node %s%n", getLabel(at));
		} // end while

		System.out.printf("\nFinished with the BFS from start node %s%n", getLabel(start));
	} // end BFS

	// perform a DFS starting from 0 index (works iteratively)
	public void DFS() 
	{
		Stack<Integer> stack = new Stack<>();
		int[] visited = new int[N]; // a visited array to mark which vertices have been visited while doing the DFS
		int source = 0; // begin DFS at 0. ie: A
		int element = source;
		int i = source;
		
		System.out.printf("Performing a DFS starting at node %s%n", getLabel(source));
		System.out.println("");
		stack.push(source);
		visited[source] = 1; // mark 0th index (A) as visited
		System.out.printf("At node %s in the DFS%n", getLabel(source));
		traversalOrderDFS.offer(source);
		
		while (!stack.isEmpty()) // while the stack is not empty
		{
			element = stack.peek(); // peek the top element
			i = element;
			
			while (i < N) // To go down, get neighbor, then it's neighbor, and continue till no unvisited neighbor
			{
				if (edges[element][i] && visited[i] == 0) // if edge exists (element and i) & not visited i
				{
					stack.push(i); // add to stack
					System.out.printf("Going to node %s...", getLabel(i));
					visited[i] = 1; // mark as visited
					element = i;
					i = 1;
					System.out.printf("At node %s in the DFS%n", getLabel(element));
					traversalOrderDFS.offer(element);
					continue;
				} // end if
				i++; // increment to go to neighbor's neighbor
			} // end inner while
			stack.pop();
			System.out.printf("Done processing node %s%n", getLabel(element));
		} // end outer while
		
		System.out.printf("\nFinished with the DFS from start node %s%n", getLabel(source));
		System.out.println();
		System.out.println("Successfully completed DFS.");
		System.out.print("The traversal order is: ");
		for (int j = 0; j < N; ++j) 
		{
			System.out.print("" + getLabel(traversalOrderDFS.poll()) + "");
		} // end for
		
	} // end DFS
	
	
	
} // end GraphAdjacencyMatrix
