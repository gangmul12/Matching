import java.io.*;
public class Commander {
	
	private char command;
	private String cmdData;
	
	public Commander(String input) {
		cmdData = input.substring(2);
		command = input.charAt(0);
		
		
	}
	
	public MyHashTable work(MyHashTable ht) throws IOException{
		switch(command){
		case '<':
			
			ht=fileIn();
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
		return ht;
	}
	
	private MyHashTable fileIn(){
		MyHashTable htb = new MyHashTable();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(cmdData));
			String s = null;
			int i = 1;
			
			while((s=br.readLine())!=null){
				for(int j = 1; j<=s.length()-5;j++){
					htb.add(new inputQuery(s.substring(j-1, j+5), i, j));
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
		return htb;
		
	}
	
	private void findStr(MyHashTable ht){
		int numOfDisjointStr = cmdData.length()/6;
		int numOfJointStr = cmdData.length()%6;
		int totNum = numOfDisjointStr+numOfJointStr;
		String[] strSet = new String[totNum];
		for(int i = 0 ; i<numOfDisjointStr ; i++){
			strSet[i] = cmdData.substring(6*i, 6*i+6);
		}
		for(int i = 1; i<=numOfJointStr;i++){
			strSet[i+numOfDisjointStr-1] = cmdData.substring(6*(numOfDisjointStr-1)+i, 6*(numOfDisjointStr)+i);
		}
		if(ht.getValue(strSet[0])==null||ht.getValue(strSet[0]).retrieve(strSet[0])==null||ht.getValue(strSet[0]).retrieve(strSet[0]).getList().size()==0){
			System.out.println("(0, 0)");
			return;
		}
		int numOfCand = ht.getValue(strSet[0]).retrieve(strSet[0]).getList().size();	
		coordinate[] cordSet = new coordinate[numOfCand];
		boolean [] boolSet = new boolean[numOfCand];
		
		
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
