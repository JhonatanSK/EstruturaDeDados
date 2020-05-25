package model;

public class ListaDuplamenteEncadeada{

	private NoDuplamenteEncadeado first;
	private NoDuplamenteEncadeado last;
	private NoDuplamenteEncadeado pointer;
	private int size;

	public	ListaDuplamenteEncadeada() {
		first = null;
		last = null;
		pointer = null;
		size = 0;
	}
	
	public NoDuplamenteEncadeado getHead() {
		return first;
	}

	public boolean insertEnd(int value) {
		NoDuplamenteEncadeado node = new NoDuplamenteEncadeado(value, null, null);
		if (size == 0) {
			first = node;
			last = node;
			pointer = node;
		} else {
			last.setNext(node);
			node.setPrevious(last);
			last = node;
			pointer = first;
		}
		size++;
		return true;
	}

	public int removeEnd() {
		int value;

		value = last.getElement();
		if (size == 1) {
			first = null;
			last = null;
			pointer = null;
			size--;
			return value;
		} else {
			last = last.getPrevious();
			last.setNext(null);
			pointer = first;
			size--;
			return value;
		}
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	public boolean isFirst() {
		if (pointer.getPrevious() == null)
			return true;
		else
			return false;
	}

	public boolean isLast() {
		if (pointer.getNext() == null)
			return true;
		else
			return false;
	}

	public int showCurrent() {
		return pointer.getElement();
	}

	public int showNext() {
		pointer = pointer.getNext();
		return pointer.getElement();
	}

	public int showBefore() {
		pointer = pointer.getPrevious();
		return pointer.getElement();
	}
	
	public int searchElement(NoDuplamenteEncadeado next, int value){
		if(next != null){
			if(next.getElement() == value) return value;
			else return searchElement(next.getNext(), value);
		}
		return -1;
	}
	
	public String listElements(NoDuplamenteEncadeado next, String valores){
		if(next != null){
			valores += next.getElement() + ",";
			return listElements(next.getNext(), valores);
		}
		return valores;
	}

}
