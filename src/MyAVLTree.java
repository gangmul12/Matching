
class AVLNode implements Comparable<AVLNode>{
	
	
	private String str;
	private MyLinkedList<coordinate> list;
	private AVLNode rChild;
	private AVLNode lChild;
	public int leftHeight;
	public int rightHeight;
	
	public AVLNode(String obj){
		str = obj;
		list = new MyLinkedList<coordinate>();
		rChild=lChild=null;
		leftHeight=rightHeight=0;
	}
	
	
	public String getStr(){
		return str;
	}
	public MyLinkedList<coordinate> getList(){
		return list;
	}
	

	
	public AVLNode getLeft(){
		return lChild;
	}
	public AVLNode getRight(){
		return rChild;
	}
	public AVLNode get(int direction){
		if (direction%2 ==0)
			return getLeft();
		else
			return getRight();
	}
	public void setLeft(AVLNode obj){
		lChild = obj;
		if(obj==null){
			leftHeight = 0;
			return;
		}
		leftHeight = (obj.leftHeight>obj.rightHeight)? obj.leftHeight+1:obj.rightHeight+1;
	}
	public void setRight(AVLNode obj){
		rChild = obj;
		if(obj==null){
			rightHeight = 0;
			return;
		}
		rightHeight = (obj.leftHeight>obj.rightHeight)? obj.leftHeight+1:obj.rightHeight+1;
	}
	public void set(int dir, AVLNode obj){
		if(dir%2==0)
			setLeft(obj);
		else
			setRight(obj);
	}
	public int heightOf(int dir){
		if(dir%2==0)
			return leftHeight;
		else
			return rightHeight;
	}
	
	
	@Override
	public int compareTo(AVLNode obj){
		return this.str.compareTo(obj.str);
	}
	
	public int compareTo(inputQuery obj){
		return this.str.compareTo(obj.getStr());
		
	}
		
}


public class MyAVLTree{
	final int LEFT = 0;
	final int RIGHT = 1;
	
	
	private AVLNode root;
	
	public AVLNode getRoot(){
		return root;
	}
	
	public MyAVLTree(){
		root = null;
	}
	public void insert(inputQuery obj){
		MyLinkedList<Integer> record = new MyLinkedList<Integer>(-1);
		boolean efInsert = (retrieve(obj.getStr())==null);
		root = insertItem(obj, root, record);
		if(efInsert){
			//fixHeight(record);
			rebalance(record.getFirst());
		}
		
		
	}

	private AVLNode insertItem(inputQuery obj, AVLNode aNode, MyLinkedList<Integer> record){
		if(aNode==null){
			aNode = new AVLNode(obj.getStr());
			aNode.getList().add(obj.getCoord());
		}
		else if(aNode.getStr()==obj.getStr()){
			aNode.getList().add(obj.getCoord());
		}
		else if(aNode.compareTo(obj)>0){
			record.insertBack(LEFT);
			aNode.setLeft(insertItem(obj, aNode.getLeft(), record));
		}
		else{
			record.insertBack(RIGHT);
			aNode.setRight(insertItem(obj, aNode.getRight(), record));
		}
		return aNode;
		
	}
	

	
	private void rebalance(LLNode<Integer> dirNode){
		root = balance(root, dirNode);
	}
	
	private AVLNode balance(AVLNode aNode, LLNode<Integer> dirNode){
		if(dirNode.getItem()==-1) return aNode;
		else{
			int dir = dirNode.getItem();
			if(!needBalance(aNode)){
				aNode.set(dir, balance(aNode.get(dir), dirNode.getNext()));
			}
		
			else{
				
				if(needBalance(aNode.get(dir))){
					aNode.set(dir, balance(aNode.get(dir), dirNode.getNext()));
				}
				else{
					aNode = fixRotation(aNode, dirNode);
				}	
			}
		}
		return aNode;
		
	}
	
	private AVLNode fixRotation(AVLNode aNode, LLNode<Integer> dirNode){
		int dir = dirNode.getItem();
		
		if(needDbRotation(aNode, dir)){
			aNode.set(dir, rotation(aNode.get(dir), dir));
		}
		return rotation(aNode, dir+1);
		
	}
	

	private boolean needDbRotation(AVLNode aNode2, int dir){
		AVLNode rootNode = aNode2.get(dir);
		if(rootNode.heightOf(dir)<rootNode.heightOf(dir+1))
			return true;
		return false;
		
	}
	private boolean needBalance(AVLNode aNode){
		if(aNode==null)
			return false;
		return ((aNode.leftHeight-aNode.rightHeight)==2||(aNode.rightHeight-aNode.leftHeight)==2);
	}
	
	private AVLNode rotation(AVLNode aNode, int dir){
		AVLNode newRoot;
		newRoot = aNode.get(dir+1);
		AVLNode temp = newRoot.get(dir);
		aNode.set(dir+1, temp);
		newRoot.set(dir,aNode);
		
		return newRoot;		
	}
	
	public AVLNode retrieve(String key){
		return retrieveItem(key, root);
	}
	
	private AVLNode retrieveItem(String key, AVLNode aNode){
		if(aNode==null) return null;
		else{
			if(key==aNode.getStr()) return aNode;
			else if(key.compareTo(aNode.getStr())>0)
				return retrieveItem(key, aNode.getRight());
			else
				return retrieveItem(key, aNode.getLeft());
		}
	}
	
	/*
	private void fixH8(){
		root.leftHeight = fixH8recur(root.getLeft());
		root.rightHeight = fixH8recur(root.getRight());
	}
	private int fixH8recur(AVLNode aNode){
		if(aNode==null)
			return 0;
		aNode.leftHeight = fixH8recur(aNode.getLeft())+1;
		aNode.rightHeight = fixH8recur(aNode.getRight())+1;
		return (aNode.leftHeight>aNode.rightHeight)? aNode.leftHeight:aNode.rightHeight;
	}
	
	private void fixHeight(){
		
		
		
		
		/*AVLNode currentNode = root;
		LLNode<Integer> currentLLNode = record.getHead().getNext();
		for(int i = 0 ; i < record.size(); i++){
			if(currentLLNode.getItem()==LEFT){
				if(record.size()-i>currentNode.leftHeight){
					currentNode.leftHeight=record.size()-i;
				}
			}
			else{
				if(record.size()-i>currentNode.rightHeight){
					currentNode.rightHeight=record.size()-i;
				}
			}
			
			currentNode = (currentLLNode.getItem()==LEFT)?currentNode.getLeft() : currentNode.getRight();
			currentLLNode=currentLLNode.getNext();
			
		}
	}*/
	
	public void delete(){
		
	}
	
	public void preorder(AVLNode aNode){
		if(aNode!=null){
			System.out.println(aNode.getStr());
			preorder(aNode.getLeft());
			preorder(aNode.getRight());
	
		}
	}
	
	

}
