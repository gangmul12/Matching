
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
	public void setLeft(AVLNode obj){
		lChild = obj;
	}
	public void setRight(AVLNode obj){
		rChild = obj;
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
	private AVLNode root;
	
	public AVLNode getRoot(){
		return root;
	}
	
	public MyAVLTree(){
		root = null;
	}
	public void insert(inputQuery obj){
		MyLinkedList<Integer> record = new MyLinkedList<Integer>();
		root = insertItem(obj, root, record);
		if(retrieve(obj.getStr())==null){
			fixHeight(record);
		}
		
		rotation();
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
			record.insert(0);
			aNode.setLeft(insertItem(obj, aNode.getLeft(), record));
		}
		else{
			record.insert(1);
			aNode.setRight(insertItem(obj, aNode.getRight(), record));
		}
		return aNode;
		
	}
	
	private void rotation(){
		
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
			if(currentLLNode.getItem()==0){
				if(record.size()-i>currentNode.leftHeight){
					currentNode.leftHeight=record.size()-i;
				}
			}
			else{
				if(record.size()-i>currentNode.rightHeight){
					currentNode.rightHeight=record.size()-i;
				}
			}
			
			currentNode = (currentLLNode.getItem()==0)?currentNode.getLeft() : currentNode.getRight();
			currentLLNode.getNext();
			
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
