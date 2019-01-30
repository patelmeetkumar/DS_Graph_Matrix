/*
 * Name: Meetkumar Patel
 * CS 2400 Fall 2018 Project 5
 */

public interface GraphAdjacencyMatrixInterface <E>
{
	public E getLabel(int vertex);
	
	public boolean isEdge(int source, int target);
	
	public void addEdge(int source, int target);
	
	public int[] neighbors(int vertex);
	
	public void removeEdge(int source, int target);
	
	public void setLabel(int vertex, E newLabel);
	
	public int size();
	
	void BFS();
	
	public void DFS();
	
	
	
} // end GraphAdjacencyMatrixInterface
