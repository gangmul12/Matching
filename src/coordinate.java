
class coordinate implements Comparable<coordinate>{
	private int line;
	private int index;
	
	public coordinate(int nthline, int nthindex){
		this.line = nthline;
		this.index = nthindex;
	}
	public coordinate(coordinate other){
		this.line = other.getLine();
		this.index = other.getIndex();
	}
	
	public int getLine(){
		return line;
	}
	
	public int getIndex(){
		return index;
	}
	
	@Override
	public int compareTo(coordinate other){
		if(this.line>other.line)
			return 1;
		else if(this.line<other.line)
			return -1;
		else{
			if(this.index>other.index)
				return 1;
			else if(this.index<other.index)
				return -1;
			else
				return 0;
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + line;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		coordinate other = (coordinate) obj;
		if (index != other.index)
			return false;
		if (line != other.line)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		String result = "("+line+", "+index+")";
		return result;
	}
	
	
	
	

}
