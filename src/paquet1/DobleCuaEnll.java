package paquet1;

public class DobleCuaEnll<E> implements DobleCua<E>{

	private Node leftEnd;
	private Node rightEnd ;
	

	
	private class Node{
		
		private Node left;
		private Node right;
		private E e;
		
		Node(Node left,E e){
			this.e=e;
			this.left=left;
			this.right=null;
		}
		Node(E e,Node right){
			this.e=e;
			this.right=right;
			this.left=null;
		}
		
	}
	
	@Override
	public boolean addToRight(E e) {
		if(rightEnd==null){
			rightEnd=new Node(leftEnd,e);
			leftEnd=rightEnd;
		}
		else {
			if(leftEnd==rightEnd){	
				leftEnd=rightEnd;
				rightEnd=new Node(leftEnd,e);
				leftEnd.right=rightEnd;
			}
			else{
				rightEnd.right=new Node(rightEnd,e); 
				rightEnd=rightEnd.right;
			}
		}
		return true;
	}

	@Override
	public boolean addToLeft(E e) {
		if(leftEnd==null){
			leftEnd=new Node(e,rightEnd);
			rightEnd=leftEnd;
		}
		else {
			if(rightEnd==leftEnd){	
				rightEnd=leftEnd;
				leftEnd=new Node(e,rightEnd);
				rightEnd.left=leftEnd;
			}
			else{
				leftEnd.left=new Node(e,leftEnd);
				leftEnd=leftEnd.left;
			}
		}
		return true;
	}

	@Override
	public boolean removeFromRight() { 
		if(leftEnd==rightEnd){ 
			leftEnd=null;
			rightEnd=null;
			return true;
		}
		if(rightEnd.left==leftEnd){
			rightEnd=leftEnd;
			return true;
		}
		rightEnd=rightEnd.left;
		rightEnd.right=null;
		return true;
	}

	@Override
	public boolean removeFromLeft() {
		if(leftEnd==rightEnd){ 
			leftEnd=null;
			rightEnd=null;
			return true;
		}
		if(leftEnd.right==rightEnd){
			leftEnd=rightEnd;
			return true;
		}
		leftEnd=leftEnd.right;
		leftEnd.left=null;
		return true;
	}

	@Override
	public E getRight() {
		return rightEnd.e;
	}

	@Override
	public E getLeft() {
		return leftEnd.e;
	}

	@Override
	public boolean isEmpty() {
		return leftEnd==null;
	}

	@Override
	public void clear() {
	
			leftEnd=leftEnd.right;
			while(leftEnd!=null){
				leftEnd.left=null;
			}
			rightEnd=null;
			leftEnd=null;
	}

	@Override
	public String toString(){
		if(leftEnd==null) return ""; 
		
		String output="";
		Node aux=leftEnd;
		while(aux!=null){
			output+=aux.e.toString();
			aux=aux.right;
		}
		return output;
	}
	
	@Override
	public int length() {

		if(this.leftEnd==null) return 0;
			return 1 + length(leftEnd.right);
			
		}
	private int length(Node element){
	if(element==null) return 0;
	else return 1 + length(element.right);
	}
	
	public boolean equals(Object o){
		if(!(o instanceof DobleCuaEnll)) return false;
		
		boolean iguals=true;
		
		Node aux=this.leftEnd;
		Node alt=((DobleCuaEnll<E>)o).leftEnd;
		
		while(aux!=null && iguals!=false){
			if(alt==null) iguals=false;
			else{
				if(!(aux.e.equals(alt.e))) iguals=false;
				aux=aux.right;
				alt=alt.right;
			}
		}
		
		if(iguals) return true;
		
		aux=this.rightEnd;
		alt=((DobleCuaEnll<E>)o).rightEnd;
		
		while(aux!=null){
			if(alt==null) return false;
			else{
				if(!(aux.e.equals(alt.e))) return false;
				aux=aux.left;
				alt=alt.left;
			}
		}
		return true;
	}
	

}
