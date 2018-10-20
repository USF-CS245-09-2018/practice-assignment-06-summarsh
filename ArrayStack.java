import java.util.*;

public class ArrayStack implements Stack {

	protected int top;
	protected Object[] arr;

	public ArrayStack() {
		top = -1;
		arr = new Object[10];
	}

	public void push(Object obj){
		if(top == arr.length-1) {
			grow_array();
		}
		++top;
		arr[top] = obj;
	}

	public Object pop(){
		if(empty()){
			throw new IllegalStateException("Empty stack.");
		}
		return arr[top--];
	}

	public void grow_array() {
		Object[] newArr = new Object[arr.length*2];
		for(int i=0; i<arr.length; i++){
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	public boolean empty() {
		return top == -1;
	}

	public Object peek(){
		if(empty()){
			throw new IllegalStateException("Empty stack.");
		}
		return arr[top];
	}
}