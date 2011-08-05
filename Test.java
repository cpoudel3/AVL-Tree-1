import java.util.Random;


class Test {
	
	/**
	 * Test method to perform a series of 100 unique insertions into 
	 * a blank AVL Tree, and returns the tree.
	 * 
	 * TODO: this code would be better served in another Test class.
	 * 
	 * 
	 * @return Tree with insertions
	 */
	public static void performInsertions(AvlTree<Integer> t){
		Random r = new Random();
		int range = 500;
		int count = 100;
		Integer x;				
		
		// Delete any old nodes from the tree
		t.makeEmpty();
		
		// Clear the counts
		t.countInsertions = 0;
		t.countSingleRotations = 0;
		t.countDoubleRotations = 0;
		
		// Generate and insert 100 random numbers
		for (int i = 0; i < count; i++){
			// Prevent insertion of duplicates
			//
			//  Note: must take care in selecting parameters,
			//        to avoid an infinite loop. If count > max - min,
			//        then we have a problem.
			do {
				x = new Integer (r.nextInt(range) + 1);
			} while (!t.insert (x));
		}
	}
	
	public static void main (String []args){
		AvlTree<Integer> t = new AvlTree<Integer>();
		int testCases = 10;
		int insertionCount = 0;
		int singleRotationCount = 0;
		int doubleRotationCount = 0;
		
		System.out.println ("Perfoming a series of " + testCases + " test cases.");
		System.out.println ("\nSR\tDR\n");
		
		for (int i=0; i < testCases; i++) {
			Test.performInsertions(t);
			insertionCount      += t.countInsertions;
			singleRotationCount += t.countSingleRotations;
			doubleRotationCount += t.countDoubleRotations;
			
			System.out.println (t.countSingleRotations + "\t" + t.countDoubleRotations);
		}
		
		System.out.println ("Total Insertions:       " + insertionCount);
		System.out.println ("Total Single Rotations: " + singleRotationCount);
		System.out.println ("Total Double Rotations: " + doubleRotationCount);
		
		t.makeEmpty();
		
		t.insert (new Integer(2));
		t.insert (new Integer(1));
		t.insert (new Integer(4));
		t.insert (new Integer(5));
		t.insert (new Integer(9));
		t.insert (new Integer(3));
		t.insert (new Integer(6));
		t.insert (new Integer(7));
		
		System.out.println ("Infix Traversal:");
		System.out.println (t.serializeInfix());
		
		System.out.println ("Prefix Traversal:");
		System.out.println (t.serializePrefix());
  
	    // Ensure only the numbers above are found in the tree 
	    for (int i = 1; i < 8; i++){ 
	      assert (t.find(i)) : i + " is not found";
	    }
	    assert (t.find(9)) : "9 is not found";
	
	    for (int i = 10; i < 18; i++){ 
	      assert (!t.find(i)) : i + " is found";
	    }

	    assert (!t.insert(new Integer(9))) : "Duplicate 9 was inserted";

		  t.makeEmpty();		
  		t.insert (new Integer(2));
      t.remove (2);
      assert (t.isEmpty()) : "2 was not removed from tree";

		  t.makeEmpty();		
  		t.insert (new Integer(11));
  		t.insert (new Integer(22));
      t.remove (11);
		System.out.println ("Prefix Traversal:");
		System.out.println (t.serializePrefix());      
      assert (!t.find(11)) : "11 was not removed from tree";

		  t.makeEmpty();		
  		t.insert (new Integer(11));
  		t.insert (new Integer(22));
      t.remove (22);
		System.out.println ("Prefix Traversal:");
		System.out.println (t.serializePrefix());      
      assert (!t.find(22)) : "22 was not removed from tree";
	}
}
