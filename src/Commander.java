import java.io.*;
public class Commander {
	
	private char command;
	private String cmdData;
	
	public Commander(String input) {
		cmdData = input.substring(2);
		command = input.charAt(0);
		
		
	}
	
	public void work(MyHashTable ht) throws IOException{
		switch(command){
		case '<':
			fileIn(ht);
			break;
		case '@':
			print(ht);
			break;
		case '?':
			findStr(ht);
			break;
		default:
			throw new IOException();
		}
		
	}
	
	private void fileIn(MyHashTable ht){
		try {
			BufferedReader br = new BufferedReader(new FileReader(cmdData));
			String s = null;
			int i = 1;
			while((s=br.readLine())!=null){
				for(int j = 1; j<=s.length()-5;j++){
					ht.add(new inputQuery(s.substring(j-1, j+5), i, j));
				}
				i++;
			}
			if(br!=null) br.close();
		} catch (FileNotFoundException e) {
			System.out.println("There is not such file");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void findStr(MyHashTable ht){
		
	}
	private void print(MyHashTable ht) throws IOException{
		int idx = stringToInt(cmdData);
		if(idx<0||idx>=100)
			throw new IOException();
		ht.print(idx);
		
	}
	private int stringToInt(String input){
		int result=0;
		int digit = 1;
		for(int i = input.length()-1 ; i >=0; i--){
			result += digit*Character.getNumericValue(input.charAt(i));
			digit *=10;
		}
		return result;
	}

}
