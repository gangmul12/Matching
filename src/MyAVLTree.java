class AVLNode{
	String item;
	private AVLNode rChild;
	private AVLNode lChild;
	
	public AVLNode(String obj){
		item = obj;
		rChild=lChild=null;
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
}
public class MyAVLTree {

}
