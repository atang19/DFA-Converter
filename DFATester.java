import java.util.*;

public class DFATester{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		DFAMap myMap = new DFAMap();
		myMap.addState();
		myMap.addState();
		myMap.addEdge(0,1,"a");
		myMap.addEdge(0,1,"b");
		myMap.addEdge(0,1,"c");
		myMap.addEdge(0,1,"d");		
		myMap.stateList.get(0).printRelations();
		myMap.stateList.get(1).printRelations();
		myMap.stateList.get(0).overlapToOr();
		myMap.stateList.get(1).overlapToOr();	
		myMap.stateList.get(0).printRelations();
		myMap.stateList.get(1).printRelations();			
	}
}