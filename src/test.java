
public class test {
	
	
	public static void  main(String arg[]){
		
		MyAVLTree a = new MyAVLTree();
		
		inputQuery[] b = new inputQuery[20];
		for(int i = 0 ; i <20; i ++){
			rand()
			
			inputQuery[i] = new
		}
		
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
	/*private void rebalance(MyLinkedList<Integer> record){
		AVLNode curNode = root;
		LLNode<Integer> curLLNode = record.getHead().getNext();
		boolean needTrack = false;  //do we need to rebalance?
		for(int i = 0 ; i < record.size(); i++){
			if(needBalance(curNode)){
				needTrack = true;
				break;
			}
			curNode = curNode.get(curLLNode.getItem());
			curLLNode = curLLNode.getNext();
		}
		
		if(needTrack == false) // if we don't need to rebalance
			return;
		//if we need to rotate root
		if(curNode==root&&!needBalance(curNode.get(curLLNode.getItem()))&&needBalance(root)){
			if(needDbRotation(root, curLLNode.getItem()))
				root.set(curLLNode.getItem(), rotation(root.get(curLLNode.getItem()), curLLNode.getItem()));
			root = rotation(root, curLLNode.getItem()+1);
			return;
		}
		//else
		while(true){
			int dir = curLLNode.getItem();
			int nextDir = curLLNode.getNext().getItem();
			if(needBalance(curNode.get(dir).get(nextDir))){
				curNode = curNode.get(dir);
				curLLNode = curLLNode.getNext();
				continue;
			}
			else{
				if(needDbRotation(curNode.get(dir), nextDir))
					curNode.get(dir).set(nextDir, rotation(curNode.get(dir).get(nextDir), nextDir));
				curNode.set(dir, rotation(curNode.get(dir), dir));
				break;
			}			
		}
	}*/

}
