package estruturaDeDadosEx30;

public class Node {
	private	int	element;
	private	Node left;
	private	Node right;

	public	Node()	{
		element = 0;
		left = null;
		right = null;
	}
	
	public	Node(int element, Node left, Node right)	{
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	void setLeft(Node	prev)	{
		this.left = prev;
	}

	void setRight(Node	right)	{
		this.right = right;
	}
	
	int	getElement()	{
		return	element;
	}
	
	Node getLeft() {
		return	left;
	}

	Node getRight()	{
		return	right;
	}
}
