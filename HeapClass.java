public class Heap {
	
	ArrayList<Integer> heap;
	
	Heap(){
		heap = new ArrayList<>();
	}
	
	
	int getMin() throws HeapEmptyException{
		if(heap.size() == 0) throw new HeapEmptyException();
		
		return heap.get(0);
	}
	
	int removeMin() throws HeapEmptyException{
		
		if(heap.size() == 0) throw new HeapEmptyException();
		
		int temp = heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		downHeapify();
		
		return temp;
	}
	
	void insert(int data){
		heap.add(data);
		upHeapify();
	}
	
	
	private int getParentIndex(int index){
		return (index-1)/2;
	}
	
	private int getLeftChildIndex(int index){
		return 2*index + 1;
	}
	
	private int getRightChildIndex(int index){
		return 2*index + 2;
	}
	
	private void downHeapify() {
		// TODO Auto-generated method stub
		if(heap.size() == 0) return;
		//iterate till index > heap.size() || index value is greater that either left or right child
		
		int index = 0;
		
		while(index < heap.size()){
			int leftChildIndex = getLeftChildIndex(index);
			int rightChildIndex = getRightChildIndex(index);
			
			//compare
			if(leftChildIndex < heap.size() && rightChildIndex < heap.size()){
				if(heap.get(leftChildIndex) < heap.get(rightChildIndex)){
					if(heap.get(leftChildIndex) < heap.get(index)){
						swap(index, leftChildIndex);
						index = leftChildIndex;
					}else break;
				}else{
					if(heap.get(rightChildIndex) < heap.get(index)){
						swap(index, rightChildIndex);
						index = rightChildIndex;
					}else break;
				}
			}else if(leftChildIndex < heap.size()){
				if(heap.get(leftChildIndex) < heap.get(index)) swap(index, leftChildIndex);
				break;
			}else{
				break;
			}
			
		}
		
	}

	private void upHeapify() {
		// TODO Auto-generated method stub
		//iterate till root or value is greater than parentIndex

    int index = heap.size()-1;
		
		while(index != 0 && heap.get(index) < heap.get(getParentIndex(index))){
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}

	private void swap(int index, int parentIndex) {
		
		int temp = heap.get(parentIndex);
		heap.set(parentIndex, heap.get(index));
		heap.set(index, temp);
		
	}
}
