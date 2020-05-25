package model;

public class NoDuplamenteEncadeado {
	private	int	element;
	private	NoDuplamenteEncadeado	previous;
	private	NoDuplamenteEncadeado	next;

	public	NoDuplamenteEncadeado()	{
		element=0;
		previous=null;
		next=null;
	}
	
	public	NoDuplamenteEncadeado(int element, NoDuplamenteEncadeado prev, NoDuplamenteEncadeado next)	{
		this.element=element;
		this.previous=prev;
		this.next=next;
	}
	
	void setPrevious(NoDuplamenteEncadeado	prev)	{
		this.previous=prev;
	}

	void setNext(NoDuplamenteEncadeado	next)	{
		this.next=next;
	}
	
	int	getElement()	{
		return	element;
	}
	
	NoDuplamenteEncadeado getPrevious() {
		return	previous;
	}

	NoDuplamenteEncadeado getNext()	{
		return	next;
	}
}
