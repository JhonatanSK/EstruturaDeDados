package estruturaDeDadosPrimeiraEntrega;

import javax.swing.JOptionPane;

/*Idem ao exercício 1, porém levando-se em conta que o elemento de índice 9 deverá
ser o primeiro armazenado e o elemento de índice 0 deverá ser o último armazenado na
pilha.
*/

public class Exercicio3 {
	public static int tamanho = 0;
	public static int tamanhoVetor = 10;
	public static char pilha[] = new char[tamanhoVetor];
	public static int pos = 9;
	public static String sIO, sTitle;
	public static String[] sSN = { "Sim", "Não" };
	public static int iSN;
	public static String[] sOpcao = { "Inserir Elemento", "Consultar Elemento", "Retirar Elemento", "Sair" };
	public static int iOpcao;

	public static void main(String Args[]) {
		// Tela inicial
		sTitle = "Estrutura de dados - Exercicio 3";
		sIO = "Pilhas - Inserindo os valores em um vetor de forma decrescente";
		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
		// Tela de menu
		do {
			sIO = "Selecione o botão da opção desejada:";
			iOpcao = JOptionPane.showOptionDialog(null, sIO, sTitle, 1, JOptionPane.QUESTION_MESSAGE, null, sOpcao,
					null);
			switch (iOpcao) {
			case 0:
				Inserir_Elemento();
				break;
			case 1:
				Consultar_Elemento();
				break;
			case 2:
				Retirar_Elemento();
				break;
			case 3:
				sIO = "Deseja realmente sair?";
				iSN = JOptionPane.showOptionDialog(null, sIO, sTitle, 1, JOptionPane.QUESTION_MESSAGE, null, sSN, null);
				if (iSN == 1)
					iOpcao = -1;
				break;
			}
		} while (iOpcao != 3);
		// Termina execução
		System.exit(0);
	}

	public static void Inserir_Elemento() {
		String sDigitado;
		char cCaractere;
		sIO = "Digite o caractere a ser colocado na Pilha:";
		sDigitado = JOptionPane.showInputDialog(null, sIO, sTitle, JOptionPane.QUESTION_MESSAGE);
		cCaractere = sDigitado.charAt(sDigitado.length() - 1);
		if (Push(cCaractere) == 0)
			sIO = "Pilha Cheia. Caractere não colocado na Pilha!";
		else
			sIO = "Caractere colocado na Pilha com sucesso!";
		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
	}

	public static void Consultar_Elemento() {
		int iTamanho;
		char cCaractere;

		iTamanho = Size();
		if (iTamanho == 0)
			sIO = "Pilha Vazia!";
		else {
			cCaractere = Top();
			sIO = "Tamanho da Pilha: " + iTamanho + "\nTopo da Pilha: " + cCaractere;
		}
		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
	}

	public static void Retirar_Elemento() {
		char cCaractere;
		cCaractere = Pop();
		if (cCaractere == 10)
			sIO = "Pilha Vazia!";
		else
			sIO = "Caractere retirado da Pilha: " + cCaractere;
		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
	}

	public static char Push(char cC) {
		if (pos < 0)
			return 0;
		tamanho++;
		return pilha[pos--] = cC;
	}

	public static char Pop() {
		if (pos == 10)
			return 0;
		tamanho--;
		return pilha[++pos];
	}

	public static int Size() {
		return tamanho;
	}

	public static char Top() {
		return pilha[pos + 1];
	}
}
