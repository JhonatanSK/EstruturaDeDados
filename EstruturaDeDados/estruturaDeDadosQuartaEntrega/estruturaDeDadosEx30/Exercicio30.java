package estruturaDeDadosEx30;

import javax.swing.JOptionPane;

public class Exercicio30 {
	public static BinaryTree tree = new BinaryTree();
	public	static	String[] options = {"Inserir nó pré-ordenado","Apresentar nós ordenados","Sair"};
	public	static	int	option;
	public static String message;
	public	static	String[] yesOrNo = {"Sim","Não"};
	
	
	public static void main (String [] args) {
		
		do {
			option = JOptionPane.showOptionDialog(null,"Selecione a operação desejada","ALGESD",1,JOptionPane.QUESTION_MESSAGE,null,options,null);
			switch(option) {
				case 0:
						int value = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser inserido na arvore"));
						tree.insertNode(value);
						break;
						
				case 1: 
						String output = tree.getTreeOrdered(tree.getRoot(), 0);
						JOptionPane.showMessageDialog(null, "Segue abaixo o resultado da arvore: \n\n" + output);
						break;
						
				case 2: 
						int confirm = JOptionPane.showOptionDialog(null,"Deseja realmente sair?","ALGESD",1,JOptionPane.QUESTION_MESSAGE,null,yesOrNo,null);
						if(confirm == 0) option = -1;
						break;
			}
		}while(option != -1);
	}
}
