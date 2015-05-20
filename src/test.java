import java.util.Random;
public class test {
	
	
	public static void  main(String arg[]){
		
		MyAVLTree a = new MyAVLTree();
		
		inputQuery[] b = new inputQuery[20];
		Random rand = new Random();
		for(int i = 0 ; i <20; i ++){
			String num = Integer.toString(rand.nextInt(20));
			b[i] = new inputQuery(num, new coordinate(0,0));
			System.out.print(num + " ");
			a.insert(b[i]);
		}
		
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
