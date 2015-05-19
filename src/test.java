
public class test {
	
	
	public static void  main(String arg[]){
		
		MyAVLTree a = new MyAVLTree();
		inputQuery A = new inputQuery("bage", new coordinate(3,4));
		inputQuery B = new inputQuery("aage", new coordinate(3,4));
		inputQuery C = new inputQuery("cage", new coordinate(3,4));
		inputQuery D = new inputQuery("age", new coordinate(3,4));
		inputQuery E = new inputQuery("Fage", new coordinate(3,4));
		a.insert(A);
		a.insert(B);
		a.insert(C);
		a.insert(D);
		a.insert(E);
		a.insert(D);
		a.preorder(a.getRoot());
		
		System.out.println(a.getRoot().leftHeight);
		
		System.out.println(a.getRoot().rightHeight);
	}

}
