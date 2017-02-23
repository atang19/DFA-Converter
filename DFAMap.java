import java.util.*;

public class DFAMap{

	public int numStates;
	public ArrayList<DFAState> stateList;
	public ArrayList<DFAState> finalStates;
	public int startingState;

	public DFAMap() {
		int numStates = 0;
		stateList = new ArrayList<DFAState>();
		finalStates = new ArrayList<DFAState>(); 
		startingState = 0;
	}

	public void addState(){
		stateList.add(new DFAState(numStates, false));
		numStates += 1;
	}

	public void addFinalState(){
		stateList.add(new DFAState(numStates, true));
		finalStates.add(stateList.get(numStates));
		numStates += 1;
	}

	public void addEdge(int origin, int dest, String symbols){
		stateList.get(origin).addEdgeOut(dest, symbols);
		stateList.get(dest).addEdgeIn(origin, symbols);
	}

	public void StringTraverse(String s){
		boolean dead = false;
		int l = s.length();
		int currentState = startingState;
		for(int i=0; i<l; i++){
			String input = Character.toString(s.charAt(i));
			if(stateList.get(currentState).edgesOut.containsKey(input) == false){
				System.out.println("You've encountered a dead state or characters in this string are not in the alphabet.");
				dead = true;
				break;
			}
			else{
				currentState = stateList.get(currentState).edgesOut.get(input);
			}
		}
		if(dead == false){
			if(stateList.get(currentState).isFinal){
				System.out.println("The string is accepted in the language.");
			}
			else{
				System.out.println("The string terminates in a non-final state.");
			}
		}
	}


	public void printStates(){
		for(int i=0; i<stateList.size(); i++){
			System.out.println(stateList.get(i).stateID + ". Is final: " + stateList.get(i).isFinal);
		}
	}

	public void printAllRelations(){
		for(int i=0; i<stateList.size(); i++){
			System.out.println("For state " + i + ":");
			stateList.get(i).printRelations();
		}
	}
}