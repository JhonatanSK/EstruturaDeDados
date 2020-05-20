package estruturaDeDadosEx28;

public class Student {
	private String nome;
	private long ra;
	private Student previous;
	private Student next;
	
	public Student() {
		nome = null;
		ra = 0;
		previous = null;
		next = null;
	}

	public Student(String nome, long ra, Student previous, Student next) {
		this.nome = nome;
		this.ra = ra;
		this.previous = previous;
		this.next = next;
	}
	
	void setNext(Student	next) {
		this.next = next;
	}

	void setPrevious(Student previous) {
		this.previous = previous;
	}
		
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getRa() {
		return ra;
	}

	public void setRa(long ra) {
		this.ra = ra;
	}

	Student	getNext() {
		return	next;
	}
	
	Student	getPrevious() {
		return	previous;
	}

	@Override
	public String toString() {
		return "Estudante ( nome: " + nome + ", ra: " + ra+" )";
	}
	
	
	
}
