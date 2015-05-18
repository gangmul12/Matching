
public class inputQuery {
	private coordinate coord;
	private String substr;
	
	public inputQuery(int line, int index, String str){
		coord = new coordinate(line, index);
		substr = str;
	}
	
	public coordinate getCoord(){
		return coord;
	}
	
	public String getStr(){
		return substr;
	}

}
