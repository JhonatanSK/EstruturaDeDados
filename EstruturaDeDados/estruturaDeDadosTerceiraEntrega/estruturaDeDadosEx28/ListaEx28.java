package estruturaDeDadosEx28;

import javax.swing.JOptionPane;


public class ListaEx28 {
public	static	ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
	
	public  static String name =  "Listas Duplamente Encadeadas";
	public  static String title = "Estrutura de Dados";
	public static String[] yesOrNo = { "Sim", "Não" };
	public static int valueUser;
	public	static	String[]	option={"Inicializar Lista","Próximo Nó","Nó Anterior","Inserir Nó","Eliminar Nó","Sair"};
	public	static	int		valueOption;
	
	public static void main(String Args[]) {				

		JOptionPane.showMessageDialog(null,name,title,JOptionPane.PLAIN_MESSAGE);

		do {
			name = "Selecione o botão da opção desejada:";
			valueOption = JOptionPane.showOptionDialog(null,name,title,1,JOptionPane.QUESTION_MESSAGE,null,option,null);
			switch(valueOption)	{
				case	0:	startList();
							break;
				case	1:	nextNode();
							break;
				case	2:	previousNode();
							break;
				case	3:	insertList();
							break;
				case	4:	removeLast();
							break;
				case	5:	name = "Deseja realmente sair?";
							valueUser = JOptionPane.showOptionDialog(null,name,title,1,JOptionPane.QUESTION_MESSAGE,null,yesOrNo,null);
							if(valueUser == 1)	valueOption = -1;
							break;
			}
		}while(valueOption!=5);
				
      System.exit(0);
   }

	public	static	void	startList()	{
		if(lista.isEmpty())	name = "Lista Vazia!";
		else		{
			lista.startList();
			name = "Lista inicializada!";
		}
		JOptionPane.showMessageDialog(null,name,title,JOptionPane.PLAIN_MESSAGE);
	}

	public	static	void	nextNode()
	{
		Student	student;
		
		name="";
		if(lista.isEmpty())	name = "Lista Vazia!";
		
		else {
			student = lista.nextNode();
			if(student==null)	name += "Lista Encerrada!";
			else {
				name += student;
				if(lista.isLast())	name += "\nÚltimo Nó da Lista!";
				else if(lista.isFirst())  name += "\nPrimeiro nó da Lista!";
			}
		}
		JOptionPane.showMessageDialog(null,name,title,JOptionPane.PLAIN_MESSAGE);
	}

	public	static	void	previousNode()
	{
		Student	student;
		
		name = "";
		if(lista.isEmpty())	name = "Lista Vazia!";
		else {
			student=lista.previousNode();
			if(student==null)	name += "Lista Encerrada!";
			else {
				name += student;
				if(lista.isFirst())	name += "\nPrimeiro Nó da Lista!";
				else if(lista.isLast()) name += "\nÚltimo Nó da Lista!";
			}
		}
		JOptionPane.showMessageDialog(null,name,title,JOptionPane.PLAIN_MESSAGE);
	}	
	
	public	static	void	insertList() {
		String	name = JOptionPane.showInputDialog(null,"Digite o nome do aluno: ",title,JOptionPane.QUESTION_MESSAGE);
		long ra = Long.parseLong(JOptionPane.showInputDialog(null,"Digite o RA do aluno: ", title, JOptionPane.QUESTION_MESSAGE));
		
		if(lista.insertList(name, ra))	name = "Inserção na Lista com Sucesso!";
		
		else name = "Problemas na Inserção na Lista";
		
		JOptionPane.showMessageDialog(null,name,title,JOptionPane.PLAIN_MESSAGE);
	}
	
	public	static	void	removeLast() {
		Student	student;

		name = "";
		if(lista.isEmpty())	name="Lista Vazia!";
		else
		{
			student = lista.removeLast();
			if(student == null)	name="Não há nó a ser eliminado";
			
			else {
				name += student + "\n Eliminado da Lista";
				lista.startList();
			}
		}
		JOptionPane.showMessageDialog(null,name,title,JOptionPane.PLAIN_MESSAGE);
	}
}
