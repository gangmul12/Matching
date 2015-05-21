import java.util.Iterator;

class LLNode<T>{
	final T item;
	private LLNode<T> next;
	private LLNode<T> prev;
	
	public LLNode(T obj){
		this.item = obj;
		this.next = this.prev = null;
	}
	
	public LLNode(T obj, LLNode<T> prev, LLNode<T> next){
		this.item = obj;
		this.next = next;
		this.prev = prev;
	}
	
	public void setNext(LLNode<T> obj){
		this.next = obj;
	}
	public void setPrev(LLNode<T> obj){
		this.prev = obj;
	}
	
	public T getItem(){
		return item;
	}
	
	public LLNode<T> getNext(){
		return next;
	}
	public LLNode<T> getPrev(){
		return prev;
	}
}

//TODO implement ordered LinkedList with dummy head node
public class MyLinkedList<T extends Comparable<T>> implements Iterable<T>{
	private int size;
	private LLNode<T> head;
	
	
	public MyLinkedList(T obj){
		size = 0;
		head = new LLNode<T>(obj);
		head.setNext(head);
		head.setPrev(head);
	}
	public MyLinkedList(){
		size = 0;
		head = new LLNode<T>(null);
		head.setNext(head);
		head.setPrev(head);
	}
	public Iterator<T> iterator() {
		
		return new MyLinkedListIterator<T>(this);
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public LLNode<T> getHead(){
		return head;
	}
	public LLNode<T> getFirst(){
		return head.getNext();
	}
	public void add(T obj){
		
	}
	public void deleteFirst(){
		LLNode<T> newFirst = head.getNext().getNext();
		head.setNext(newFirst);
		newFirst.setPrev(head);
		size--;
		
	}
	public void insertBack(T obj){
		LLNode<T> cur = head.getPrev();
		cur.setNext(new LLNode<T>(obj, cur, head));
		head.setPrev(cur.getNext());
		size++;
		
	}
	
	public LLNode<T> search(T obj){
		LLNode<T> curNode = this.getFirst();
		for(int i = 0 ; i < this.size; i++){
			if(curNode.getItem().equals(obj))
				return curNode;
			curNode = curNode.getNext();
		}
		return null;
		
	}
	
	public int size(){
		return size;
	}

}
