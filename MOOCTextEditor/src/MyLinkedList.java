
import java.util.AbstractList;



/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size=0;
		this.head=tail.prev;
		this.tail=head.next;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )  throws NullPointerException
	{
		// TODO: Implement this method
		try{
			if(element!=null){
				if(size==0){
					LLNode<E> temp = null;
					temp.data=element;
					tail.prev=temp;
					temp.prev=head;
					
					size++;
				}
				else if(size>0){
					LLNode<E> temp = null;
					temp.data=element;
					tail.prev=temp;
					temp.prev=tail.prev.prev;
					
					size++;
				}
			}
		}
		catch(Exception e){
			e.getMessage();
		}
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	@SuppressWarnings("unchecked")
	public E get(int index) throws IndexOutOfBoundsException
	{
		if(index<size){
			int j=0;
			// TODO: Implement this method.
			for(LLNode<E> i=head;i!=tail;i=i.next){
				if(j==index){
					return i.data;
				}
				j++;
			}
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index<size){
			int j=0;
			// TODO: Implement this method.
			LLNode<E> temp = null;
			for(LLNode<E> i=head;i!=tail;i=i.next){
				if(j==index){
					i.next=temp;
					temp.prev=i;
					temp.data=element;
				}
				j++;
			}
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		int j=0;
		LLNode<E> i;
		for(i=head;i!=tail;i=i.next){
			if(j==index){
				i.prev.next=i.next;
				i.next.prev=i.prev;
				break;
			}
			j++;
		}
		return i.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		int j=0;
		LLNode<E> i;
		E tmp = null;
		for(i=head;i!=tail;i=i.next){
			if(j==index){
				tmp = i.data;
				i.data = element;
				break;
			}
			j++;
		}
		return tmp;
	} 
	
	public static void main(String args[]){
		MyLinkedList<String> shortList;
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("b");
		System.out.println(shortList.size);
		System.out.println(shortList.get(0));
		
		
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	

}
