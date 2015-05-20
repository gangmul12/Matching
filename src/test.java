import java.util.Random;
public class test {
	
	
	public static void  main(String arg[]){
		
		MyAVLTree a = new MyAVLTree();
		/*
		inputQuery[] b = new inputQuery[20];
		Random rand = new Random();
		for(int i = 0 ; i <20; i ++){
			String num = Integer.toString(rand.nextInt(20));
			if(num.length()==1)
				num = "0"+num;
			b[i] = new inputQuery(num, new coordinate(0,0));
			System.out.print(num + " ");
			a.insert(b[i]);
		}*/
		
		inputQuery A1 = new inputQuery("17", new coordinate(0,0));
		inputQuery A2 = new inputQuery("07", new coordinate(0,0));
		inputQuery A3 = new inputQuery("13", new coordinate(0,0));
		inputQuery A4 = new inputQuery("18", new coordinate(0,0));
		inputQuery A5 = new inputQuery("06", new coordinate(0,0));
		inputQuery A6 = new inputQuery("12", new coordinate(0,0));
		inputQuery A7 = new inputQuery("01", new coordinate(0,0));
		inputQuery A8 = new inputQuery("05", new coordinate(0,0));
		inputQuery A9 = new inputQuery("00", new coordinate(0,0));
		inputQuery A10 = new inputQuery("04", new coordinate(0,0));
		inputQuery A11 = new inputQuery("19", new coordinate(0,0));
		inputQuery A12 = new inputQuery("03", new coordinate(0,0));
		inputQuery A13 = new inputQuery("09", new coordinate(0,0));
		
		a.insert(A1);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A2);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A3);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A4);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A5);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A6);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A7);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A8);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A9);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A10);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A11);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A12);
		a.preorder(a.getRoot());
		System.out.println();
		a.insert(A13);
		a.preorder(a.getRoot());
		System.out.println();
		
		
		
		
		
		System.out.println();
		
		System.out.println();
		System.out.println(a.getRoot().leftHeight);
		System.out.println();
		System.out.println(a.getRoot().rightHeight);
		System.out.println("Done");
	}
}
