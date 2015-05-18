//TODO AVLItem을 AVLNode와 합치고 AVLNode 를 Comparable로 만들라





class AVLItem implements Comparable<AVLItem>{
	private String item;
	private MyLinkedList<coordinate> list;
	
	public AVLItem(String substr){
		item = substr;
		list = new MyLinkedList<coordinate>();
		
	}
	
	public String getItem(){
		return item;
	}
	public MyLinkedList<coordinate> getList(){
		return list;
	}
	
	@Override
	public int compareTo(AVLItem obj){
		return this.item.compareTo(obj.item);
	}
	
	
}

class AVLNode{
	AVLItem item;
	private AVLNode rChild;
	private AVLNode lChild;
	public int leftHeight;
	public int rightHeight;
	
	public AVLNode(AVLItem obj){
		item = obj;
		rChild=lChild=null;
		leftHeight=rightHeight=0;
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
public class MyAVLTree{
	private AVLNode root;
	
	public MyAVLTree(){
		root = null;
	}
	public void insert(inputQuery obj){
		root = insertItem(obj, root);
	}
	public AVLNode insertItem(inputQuery obj, AVLNode aNode){
		if(aNode==null){
			aNode = new AVLNode(new AVLItem(obj.getStr()));
			aNode.item.getList().add(obj.getCoord());
		}
		if(aNode.item)
	}
	
	public void delete(){
		
	}

}
