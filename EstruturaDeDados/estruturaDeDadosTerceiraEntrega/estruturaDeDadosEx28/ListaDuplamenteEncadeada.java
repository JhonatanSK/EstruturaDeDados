package estruturaDeDadosEx28;

public class ListaDuplamenteEncadeada {
	private	Student	head;
	private	Student	next;
	private	Student	previous;
	
	public	ListaDuplamenteEncadeada()	{
		head=null;
		next=null;
		previous=null;
	}
	
	public	void	startList()	{
		next=head;
		previous=null;
	}

	public	Student	nextNode()	{
		Student	student = new Student();
		
		if(next == null)  return  null;
		
		student.setNome(next.getNome());
		student.setRa(next.getRa());
		previous = next;
		next = next.getNext();
		
		return	student;
	}

	public	Student	previousNode()	{
		Student	student = new	Student();
		
		if(previous==null)	return	null;
		
		student.setNome(previous.getNome());
		student.setRa(previous.getRa());
		next = previous;
		previous = previous.getPrevious();
		
		return	student;
	}

	public	boolean	insertList(String name, long ra) {
		Student	newStudent = new Student(name, ra, null, null);
		
		if(head==null) {
			newStudent.setNext(null);
			newStudent.setPrevious(null);
			next=newStudent;
			previous=null;
			head=newStudent;
		}
		else {
			if(next!=null) {
				if(next==head) {
					newStudent.setNext(next);
					newStudent.setPrevious(null);
					next.setPrevious(newStudent);
					next=newStudent;
					previous=null;
					head=newStudent;
				}
				else {
					newStudent.setNext(next);
					newStudent.setPrevious(previous);
					next.setPrevious(newStudent);
					previous.setNext(newStudent);
					next=newStudent;
				}
			}								
			else {
				newStudent.setNext(null);
				newStudent.setPrevious(previous);
				previous.setNext(newStudent);
				next=newStudent;
			}
		}
		return	true;
	}

	public	Student	removeLast() {
		Student	student = new Student();
		Student	prevStudent;

		if(previous == null)  return	null;
		else
		{
			prevStudent = previous.getPrevious();
			if(prevStudent == null)	{
				if(next != null)	next.setPrevious(null);
				head = next;
			}
			else {
				prevStudent.setNext(next);
				if(next != null) next.setPrevious(prevStudent);
			}
			
			student.setNome(previous.getNome());
			student.setRa(previous.getRa());
			previous.setNext(null);
			previous.setPrevious(null);
			previous = prevStudent;
			return	student;
		}
	}
	
	public	boolean	isEmpty() {
		if(head == null)  return	true;
		else  return	false;
	}

	public	boolean	isFirst() {
		if(previous == null)  return	true;
		else	return	false;
	}
		
	public	boolean	isLast() {
		if(next == null)  return	true;
		else	return	false;
	}
}
