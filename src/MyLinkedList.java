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
// ********************************************************************
// Linked List 구현
// ********************************************************************
public class MyLinkedList<T extends Comparable<T>>{
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
	
	public boolean isEmpty(){
		return (size==0);
	}
	public int size(){
		return size;
	}
	public LLNode<T> get(int idx){
		return null;// index의 값을 가져오는 함수. 첫 item만 가져오면 돼서 구현 안함
	}
	
	public LLNode<T> getFirst(){
		return head.getNext();
	}
	public void removeAll(){
		head = null;
		size = 0;
	}
	
	public void add(int index, T obj){
		//T obj를  index에 넣는 함수. 구현에 필요하지 않아 대신 리스트 가장 뒤에 집어넣는 insertBack을 구현했다.
	}
	
	public void remove(T obj){
		//T obj를 가진 node를 없애는 함수. 구현에 필요하지 않아 대신 리스트 가장 첫 원소를 없애는 deleteFirst를 구현했다.
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
	
	

}
