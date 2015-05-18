
public class MyHashTable {
	public final int TABLE_SIZE = 100;
	private MyAVLTree[] table;
	private int size;
	
	public MyHashTable(){
		table = new MyAVLTree[TABLE_SIZE];
		size=0;
	}
	
	private int indexCalculator(String input){
		int result = 0;
		for(int i = 0 ; i < input.length(); i++){
			result += input.charAt(i);
		}
		return result % TABLE_SIZE;
	}
	
	public void add(inputQuery input){
		table[indexCalculator(input.getStr())].insert(input);
	}

}
