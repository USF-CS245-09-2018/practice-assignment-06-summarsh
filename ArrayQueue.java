import java.util.*;

public class ArrayQueue implements Queue {

	protected int head;
	protected int tail;
	protected Object[] arr;

	public void enqueue(Object obj) {
		if((tail+1) % arr.length == head) {
			grow_array();
		}
		arr[tail++]=obj;
		if(tail>=arr.length){
			tail=0;
		}
	}

	public void grow_array() {
		Object[] newArr = new Object[arr.length*2];
		tail=0;
		for(int i=head; i<arr.length+head; i++){
			newArr[tail++] = arr[i%arr.length];
		}
		head = 0;
		arr = newArr;
	}

	public Object dequeue(){
		if(empty()){
			throw new EmptyStackException();
		}
		Object obj = arr[head];
		++head;
		head = head%arr.length;
		return obj;
	}

	public boolean empty() {
		if(head==tail){
			return true;
		}
		return false;
	}
}