package paquet1;

public interface DobleCua<E>{
	
	// Basic functionality
	
	boolean addToRight(E e);
	
	boolean addToLeft(E e);
	
	boolean removeFromRight();
	
	boolean removeFromLeft();
	
	E getRight();
	
	E getLeft();
	
	boolean isEmpty();
	
	void clear();

	// Additional
	
	String toString();
	
	int length();
}
