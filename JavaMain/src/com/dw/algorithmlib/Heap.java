package com.dw.algorithmlib;

public class Heap {

	private int op_array[];
	private int heapSize;
	public Heap(int op_array[]) {
		this.op_array = op_array;
		this.heapSize = op_array.length;
	}
	
	public int HeapSize() {
		return heapSize;
	}
	
	public int Parent(int i) {
		if (i==0)
			return 0;
		
		return (i+1)/2 - 1;
	}
	
	int Left(int i) {
		return 2*(i+1) - 1;
	}
	
	int Right(int i) {
		return 2*(i+1);
	}
	
	void MaxHeapify(int i)
	{
		int l = Left(i);
		int r = Right(i);

		int largest=i;

		if(l<HeapSize() && op_array[l]>op_array[i])
			largest = l;

		if(r<HeapSize()&& op_array[r]>op_array[largest])
			largest = r;

		if(largest!=i)
		{
			// exchange(&op_array[i],&op_array[largest]);
			int temp = op_array[i];
			op_array[i] = op_array[largest];
			op_array[largest] = temp;
			
			MaxHeapify(largest);
		}
	}
	
	void Build_Max_Heap()
	{
		int i=0;
		for(i=op_array.length/2-1;i>=0;i--)
			MaxHeapify(i);
	}
	
	void MaxHeapSort() {
		Build_Max_Heap();
		
		for(int i=op_array.length-1;i>=1;i--)
		{
			int temp = op_array[0];
			op_array[0] = op_array[i];
			op_array[i] = temp;
			heapSize--;
			MaxHeapify(0);
		}
		
		printArray();
	}
	
	void printArray() {
		for(int i=0;i<op_array.length;i++)
			System.out.printf("%d\t",op_array[i]);
		System.out.println();
	}
	
	public static void main(String[] args) {

		int op_array[] = {3,5,7,1,3,12,56,8,7,16};
		int i;
		Heap h = new Heap(op_array);
		System.out.printf("Heap Tree Test\n");
		System.out.printf("Heap Size %d\n",h.HeapSize());

		h.MaxHeapSort();		
	}

}
