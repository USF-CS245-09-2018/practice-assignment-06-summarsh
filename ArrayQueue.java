import java.util.*;

public class ArrayQueue implements Queue {

	protected int head;
	protected int tail;
	protected Object[] arr;
	protected int size;

	public ArrayQueue() {
		head = 0;
		tail = -1;
		arr = new Object[10];
		size = 0;
	}

	public void enqueue(Object obj) {
		if(tail >= arr.length) {
			grow_array();
		}
		++tail;
		arr[tail%arr.length]=obj;
		size++;
	}

	public void grow_array() {
		Object[] newArr = new Object[arr.length*2];
		for(int i=head; i<arr.length; i++){
			newArr[i-head] = arr[i%arr.length];
		}
		head = 0;
		tail = size-1;
		arr = newArr;
	}

	public Object dequeue(){
		if(empty()){
			throw new IllegalStateException("Empty Queue.");
		}
		Object obj = arr[head % arr.length];
		head++;
		size--;
		return obj;
	}

	public boolean empty() {
		return size==0;
	}
}