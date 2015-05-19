
public class test {
	
	
	public static void  main(String arg[]){
		
		MyAVLTree a = new MyAVLTree();
		inputQuery A = new inputQuery("1", new coordinate(3,4));
		inputQuery B = new inputQuery("2", new coordinate(3,4));
		inputQuery C = new inputQuery("3", new coordinate(3,4));
		inputQuery D = new inputQuery("4", new coordinate(3,4));
		inputQuery E = new inputQuery("5", new coordinate(3,4));
		inputQuery F = new inputQuery("6", new coordinate(3,4));
		inputQuery G = new inputQuery("7", new coordinate(3,4));
		inputQuery H = new inputQuery("8", new coordinate(3,4));
		inputQuery I = new inputQuery("9", new coordinate(3,4));
		inputQuery J = new inputQuery("0", new coordinate(3,4));
		
		a.insert(G);
		a.insert(J);
		a.insert(C);
		a.insert(A);
		a.insert(E);
		a.insert(D);
		a.insert(B);
		a.insert(F);
		a.insert(I);
		a.insert(H);
		a.preorder(a.getRoot());
		System.out.println();
		System.out.println(a.getRoot().leftHeight);
		System.out.println();
		System.out.println(a.getRoot().rightHeight);
		System.out.println("Done");
	}

}
