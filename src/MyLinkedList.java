class LLNode<T>{
	final T item;
	private LLNode<T> next;
	
	public LLNode(T obj){
		this.item = obj;
		this.next = null;
	}
	
	public LLNode(T obj, LLNode<T> next){
		this.item = obj;
		this.next = next;
	}
	
	public void setNext(LLNode<T> obj){
		this.next = obj;
	}
	
	public T getItem(){
		return item;
	}
	
	public LLNode<T> getNext(){
		return next;
	}
	
}

//TODO implement ordered LinkedList with dummy head node
public class MyLinkedList<T extends Comparable<T>> {
	private int size;
	private LLNode<T> head;
	
	public MyLinkedList(){
		size = 0;
		head = new LLNode<T>(null);
	}
	public boolean isEmpty(){
		return (size==0);
	}
	public void add(T obj){
		
	}
	public void delete(T obj){
		
	}
	public int size(){
		return size;
	}

}
