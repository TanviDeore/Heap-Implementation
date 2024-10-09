package prac;

public class HeapImplementation {
	 public static void printElements(int[] array) {
		 for(int i=0;i< array.length;i++) {
				System.out.print(""+array[i]+" ");
			}
	}
	 public static int[] swap(int[]array,int index,int current) {
		 int temp = array[index];
		 array[index] = array[current];
		 array[current] = temp;
		 return array;
	 }
	 
	 public static int[] percolateDown(int[] array, int current) {
		 int LCH= current*2;
		 int RCH = current*2+1;
		 int index = current;
		 int length = array[0];
		 if(LCH<=length && RCH<=length) {
			 if(array[LCH]<array[RCH]) 
			 {index = LCH;}
			 else {index =RCH;}
		 }
		 //for last sorting (Comparing array[1] with array[2])
		 else if(LCH<=length) {
			 index = LCH;
		 }
		 if(array[index]<array[current]) {
			 array = swap(array,index,current);
			 array = percolateDown(array, index);
		 }
			return array;
	 }
	
	
	 public static int[] buildMinHeap(int array[]) {
	int lastParent = (int) Math.ceil((array.length-1)/2);
		for(int i=lastParent;i>=1;i--) {
			array = percolateDown(array, i);
		}
		return array;
		
	}
	 
	public static int[] sortHeap(int array[]) {
		while(array[0]!=0) {
			array = swap(array,1,array[0]);
			array[0]= array[0]-1;
			array = percolateDown(array, 1);
		}
		
		return array;
	}
	
	public static void main(String args[]) {
		int array[] = {27, 14, 33, 5, 19, 45, 8, 29, 11, 35, 22, 30, 41, 13, 9};
		
		int arrayBeforeHeap[] = new int[array.length+1];
		arrayBeforeHeap[0] = -1;
		
		for(int i=0;i< array.length;i++) {
			arrayBeforeHeap[i+1] = array[i];
		}
		System.out.println("Array Before heap");
		printElements(arrayBeforeHeap);
		
		arrayBeforeHeap[0] = arrayBeforeHeap.length-1;
		int[] arrayHeap = buildMinHeap(arrayBeforeHeap);
		
		System.out.println("\nArray After converting to Minheap");
		printElements(arrayHeap);
		
		System.out.println("\nSorted heap in descending order");
		sortHeap(arrayHeap);
		printElements(arrayHeap);	
		
		
	}
}
