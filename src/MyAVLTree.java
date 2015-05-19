
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
		root = insertItem(obj, root, (retrieve(obj.getStr())==null));
		rotation();
	}
	private AVLNode insertItem(inputQuery obj, AVLNode aNode, boolean efInsert){
		if(aNode==null){
			aNode = new AVLNode(obj.getStr());
			aNode.getList().add(obj.getCoord());
		}
		else if(aNode.getStr()==obj.getStr()){
			aNode.getList().add(obj.getCoord());
		}
		else if(aNode.compareTo(obj)>0){
			if(efInsert==true)
				aNode.leftHeight+=1;
			
			aNode.setLeft(insertItem(obj, aNode.getLeft(), efInsert));
		}
		else{
			if(efInsert==true)
				aNode.rightHeight+=1;
			aNode.setRight(insertItem(obj, aNode.getRight(), efInsert));
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
