import java.util.*;

public class ArrayStack implements Stack {

	protected int top = -1;
	protected Object[] arr = new Object[10];

	public void push(Object obj){
		arr[++top] = obj;
	}

	public Object pop(){
		if(empty()){
			throw new EmptyStackException();
		}
		return arr[top--];
	}

	public boolean empty() {
		if(arr[top] == null) {
			return true;
		}
		return false;
	}

	public Object peek(){
		return arr[top];
	}
}