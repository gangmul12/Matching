
public class MyHashTable {
	public final int TABLE_SIZE = 100;
	private MyAVLTree[] table;
	
	
	public MyHashTable(){
		table = new MyAVLTree[TABLE_SIZE];
		
	}
	
	private int indexCalculator(String input){
		int result = 0;
		for(int i = 0 ; i < input.length(); i++){
			result += input.charAt(i);
		}
		return result % TABLE_SIZE;
	}
	
	public void add(inputQuery input){
		int idx = indexCalculator(input.getStr());
		if(table[idx]==null){
			table[idx] = new MyAVLTree();
		}
		table[indexCalculator(input.getStr())].insert(input);
		
	}
	
	public void print(int idx){
		if(table[idx]==null){
			System.out.println("EMPTY");
			return;
		}
		table[idx].preorderPrint();
	}
	

}
