import java.util.*;

public class DFATester{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		DFAMap myMap = new DFAMap();
		myMap.addFinalState();
		myMap.addState();
		myMap.addState();
		myMap.addState();
		myMap.addEdge(0,1,"0");
		myMap.addEdge(0,3,"1");
		myMap.addEdge(1,0,"0");
		myMap.addEdge(1,2,"1");
		myMap.addEdge(2,1,"1");
		myMap.addEdge(2,3,"0");
		myMap.addEdge(3,0,"1");
		myMap.addEdge(3,2,"0");

		while(in.next() != "a"){
			myMap.StringTraverse(in.next());
		}
	}
}