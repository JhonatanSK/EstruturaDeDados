package model;

public class BinaryTree {
	private Node root;
	private int size;
	
	
	public BinaryTree () {
		this.root = null;
		this.size = 0;
	}
	
	public void insertNode(int value) {
		Node node = new Node(value, null, null);
		
		if(isEmpty()) root = node;
		else insertLeaf(root, node);
		size++;
	}
	
	public void insertLeaf(Node root, Node child) {
		Node aux;
		if(child.getElement() < root.getElement()) {
			aux = root.getLeft();
			if(aux != null) insertLeaf(aux, child);
			else root.setLeft(child);
		}
		else {
			aux = root.getRight();
			if(aux != null) insertLeaf(aux, child);
			else root.setRight(child);
		}
	}
	
	public	Node deleteNode(int value, Node node) {
		Node aux, ndRet = null;
				
		if(node != null) {
			if(node.getElement() == value) {
				if(node.getLeft() == node.getRight())	ndRet = null;
				else {
					if(node.getLeft() == null)	ndRet = node.getRight();
					else {
						if(node.getRight() == null)	 ndRet = node.getLeft();
						else {
							aux = node.getRight();
							while(aux.getLeft() != null)	aux = aux.getLeft();
							aux.setLeft(node.getLeft());
							ndRet =	node.getRight();
						}
					}
				}				
			}
			else {
				if(node.getElement() < value) node.setRight(deleteNode(value,node.getRight()));
				else node.setLeft(deleteNode(value,node.getLeft()));
				ndRet = node;
			}
		}
		return	ndRet;
	}

			
	public	int	 showNode(int value) {	
		return	hasInTree(value, root);
	}
	
	public	int	 hasInTree(int value, Node node) {
		if(node != null) {
			if(value == node.getElement())	return value;
			else {
				if(value < node.getElement()) {
					if(hasInTree(value, node.getLeft()) == value)	return value;
				}
				else {
					if(hasInTree(value, node.getRight()) == value)	return value;
				}
			}
		}
		return -1;
	}
	
	
	public	String	getTree() {
		return	getLevel(0, root);
	}
	
	public	String	getLevel(int level, Node node) {
		String	output = "";
		if(node != null) {
			output += getLevel(level+1, node.getLeft());
			for(int i = 0; i < level; i++)	output += "          ";
			output += node.getElement() + "\n";
			output += getLevel(level+1, node.getRight());
		}	
		return	output;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty()
	{
		boolean value = false;
		if(size() == 0)		value = true;
		return	value;
	}

		
}
