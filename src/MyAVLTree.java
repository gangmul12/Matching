
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
	}
	public void setRight(AVLNode obj){
		rChild = obj;
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
		MyLinkedList<Integer> record = new MyLinkedList<Integer>();
		boolean efInsert = (retrieve(obj.getStr())==null);
		root = insertItem(obj, root, record);
		if(efInsert){
			fixHeight(record);
			rebalance(record);
		}
		
		
	}
	
	private void rebalance(MyLinkedList<Integer> record){
		AVLNode curNode = root;
		LLNode<Integer> curLLNode = record.getHead().getNext();
		boolean needTrack = false;  //do we need to rebalance?
		for(int i = 0 ; i < record.size(); i++){
			if(needBalance(curNode)){
				needTrack = true;
				break;
			}
			curNode = curNode.get(curLLNode.getItem());
			curLLNode = curLLNode.getNext();
		}
		
		if(needTrack == false) // if we don't need to rebalance
			return;
		//if we need to rotate root
		if(curNode==root&&!needBalance(curNode.get(curLLNode.getItem()))&&needBalance(root)){
			if(needDbRotation(root, curLLNode.getItem()))
				root.set(curLLNode.getItem(), rotation(root.get(curLLNode.getItem()), curLLNode.getItem()));
			root = rotation(root, curLLNode.getItem()+1);
			return;
		}
		//else
		while(true){
			int dir = curLLNode.getItem();
			int nextDir = curLLNode.getNext().getItem();
			if(needBalance(curNode.get(dir).get(nextDir))){
				curNode = curNode.get(dir);
				curLLNode = curLLNode.getNext();
				continue;
			}
			else{
				if(needDbRotation(curNode.get(dir), nextDir))
					curNode.get(dir).set(nextDir, rotation(curNode.get(dir).get(nextDir), nextDir));
				curNode.set(dir, rotation(curNode.get(dir), dir));
			}			
		}
	}
	
	
	
	private boolean needDbRotation(AVLNode aNode2, int dir){
		AVLNode rootNode = aNode2.get(dir);
		if(rootNode.heightOf(dir)<rootNode.heightOf(dir+1))
			return true;
		return false;
		
	}
	private boolean needBalance(AVLNode aNode){
		return ((aNode.leftHeight-aNode.rightHeight)==2||(aNode.rightHeight-aNode.leftHeight)==2);
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
	
	private AVLNode rotation(AVLNode aNode, int dir){
		AVLNode newRoot;
		newRoot = aNode.get(dir+1);
		AVLNode temp = newRoot.get(dir);
		newRoot.set(dir,aNode);
		aNode.set(dir+1, temp);
		
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
	
	private void fixHeight(MyLinkedList<Integer> record){
		AVLNode currentNode = root;
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
	}
	
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
