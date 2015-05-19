
public class inputQuery {
	private coordinate coord;
	private String substr;
	
	public inputQuery(String str, int line, int index){
		coord = new coordinate(line, index);
		substr = str;
	}
	
	public inputQuery(String str, coordinate q){
		coord = q;
		substr = str;
	}
	
	public coordinate getCoord(){
		return coord;
	}
	
	public String getStr(){
		return substr;
	}

}
