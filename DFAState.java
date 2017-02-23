import java.util.*;

public class DFAState{

	public boolean isFinal;
	public int stateID;
	public Map<String, Integer> edgesOut;
	public ArrayList<Integer> edgesOutList;
	public Map<String, Integer> edgesIn;
	public ArrayList<Integer> edgesInList;


	public DFAState(int id, boolean iF){
		stateID = id;
		isFinal = iF;
		edgesOut = new HashMap<String, Integer>();
		edgesOutList = new ArrayList<Integer>();
		edgesIn = new HashMap<String, Integer>();
		edgesInList = new ArrayList<Integer>();
	}
	
	public void addEdgeOut(int targetID, String symbols){
		edgesOut.put(symbols, targetID);
		edgesOutList.add(targetID);
	}

	public void addEdgeIn(int targetID, String symbols){
		edgesIn.put(symbols, targetID);
		edgesInList.add(targetID);
	}

	public void overlapToOr(){
		Map<Integer, String> dupCheck = new HashMap<Integer, String>();
		Map<String, Integer> newEdgesOut = new HashMap<String, Integer>();
		Map<String, Integer> newEdgesIn = new HashMap<String, Integer>();		
		for(String key: edgesIn.keySet()){
			String inIDSymbol = key;
			int inID = edgesIn.get(key);
			if(dupCheck.containsKey(inID)){
				String s1 = dupCheck.get(inID);
				String concat = s1 + "|" + inIDSymbol;
				dupCheck.remove(inID);
				dupCheck.put(inID, concat);				
			}
			else{
				dupCheck.put(inID, inIDSymbol);
			}
		}
		for(int inID : dupCheck.keySet()){
			String inIDSymbol = dupCheck.get(inID);
			newEdgesIn.put(inIDSymbol, inID);
		}
		dupCheck.clear();		
		for(String key: edgesOut.keySet()){
			String outIDSymbol = key;
			int outID = edgesOut.get(key);
			if(dupCheck.containsKey(outID)){
				String s1 = dupCheck.get(outID);
				String concat = s1 + "|" + outIDSymbol;
				dupCheck.remove(outID);
				dupCheck.put(outID, concat);
			}
			else{
				dupCheck.put(outID, outIDSymbol);
			}
		}
		for(int outID : dupCheck.keySet()){
			String outIDSymbol = dupCheck.get(outID);
			newEdgesOut.put(outIDSymbol, outID);
		}
		edgesOut = newEdgesOut;
		edgesIn = newEdgesIn;
	}

	//debugging functions

	public void printRelations(){
		System.out.println("The state " + stateID + " has the following outward edges:");
		for ( String key : edgesOut.keySet() ) {
			String outIDSymbol = key;
			int outID = edgesOut.get(key);
			System.out.println("State : " + outID + ", via symbols: " + outIDSymbol);

		}
			/*
			int outID = edgesOutList.get(i);
			String outIDSymbol = edgesOut.get(outID);
			*/
		System.out.println("The state " + stateID + " has the following inward edges:");
		for(String key : edgesIn.keySet()){
			String inIDSymbol = key;
			int inID = edgesIn.get(key);
			System.out.println("State : " + inID + ", via symbols: " + inIDSymbol);
		}		
	}


}