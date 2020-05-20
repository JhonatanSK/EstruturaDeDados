package estruturaDeDadosEx27;

import javax.swing.JOptionPane;

public class ListaExercicio27 {

	public static ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

	public static String name =  "Listas Duplamente Encadeadas";
	public static String title = "Estrutura de Dados";
	
	public static String[] yesOrNo = { "Sim", "Não" };
	public static int valueUser;
	public static String[] option = { "Inserir ao Final", "Remover do Final", "Nó Atual", "Nó Próximo", "Nó Anterior",	"Sair" };
	public static int valueOption;

	public static void main(String Args[]) {

		JOptionPane.showMessageDialog(null, name, title, JOptionPane.PLAIN_MESSAGE);

		do {
			name = "Selecione o botão da opção desejada:";
			valueOption = JOptionPane.showOptionDialog(null, name, title, 1, JOptionPane.QUESTION_MESSAGE, null, option, null);
			switch (valueOption) {
			
			case 0: 	insertElement();	break;
			case 1:		removeElement();	break;
			case 2:		showCurrent();		break;
			case 3:		showNext();			break;
			case 4:		showBefore();		break;
			case 5:
				name = "Deseja realmente sair?";
				valueUser = JOptionPane.showOptionDialog(null, name, title, 1, JOptionPane.QUESTION_MESSAGE, null, yesOrNo, null);
				if (valueUser == 1) 	valueOption = -1;
				
				break;
			}
		} while (valueOption != 5);

		// Termina execução
		System.exit(0);
	}

	public static void insertElement() {
		name = "Digite o número a ser inserido na Lista:";
		if (lista.insertEnd(Integer.parseInt(JOptionPane.showInputDialog(null, name, title, JOptionPane.QUESTION_MESSAGE))))
			name = "Inserção na Lista com sucesso!";
		else
			name = "Problemas na Inserção na Lista";
		JOptionPane.showMessageDialog(null, name, title, JOptionPane.PLAIN_MESSAGE);
	}

	public static void removeElement() {
		name = "";

		if (lista.isEmpty())
			name = "Lista Vazia!";
		else
			name += "Nó removido: "+ lista.removeEnd();
		JOptionPane.showMessageDialog(null, name, title, JOptionPane.PLAIN_MESSAGE);
	}

	public static void showCurrent() {
		name = "";

		if (lista.isEmpty())
			name = "Lista Vazia!";
		else
			name += "Nó atual: "+ lista.showCurrent();
		JOptionPane.showMessageDialog(null, name, title, JOptionPane.PLAIN_MESSAGE);
	}

	public static void showNext() {
		name = "";

		if (lista.isEmpty())
			name = "Lista Vazia!";
		else if (lista.isLast())
			name = "Lista Encerrada!";
		else
			name += "Proximo nó: "+ lista.showNext();
		JOptionPane.showMessageDialog(null, name, title, JOptionPane.PLAIN_MESSAGE);
	}

	public static void showBefore() {
		name = "";

		if (lista.isEmpty())
			name = "Lista Vazia!";
		else if (lista.isFirst())
			name = "Lista Encerrada!";
		else
			name += "Nó anterior: "+ lista.showBefore();
		JOptionPane.showMessageDialog(null, name, title, JOptionPane.PLAIN_MESSAGE);
	}

}
