package estruturaDeDadosPrimeiraEntrega;

import javax.swing.JOptionPane;

public class Exercicio17 {
	public static int iTam = 0;
	public static int tamanhoVetor = 10;
	public static char cFila[] = new char[tamanhoVetor];
	public static int iSPos = 9; //9
	public static int iRPos = 9;
	public static boolean bQueueFull = false;
	public static String sIO, sTitle;
	public static String[] sSN = { "Sim", "Não" };
	public static int iSN;
	public static String[] sOpcao = { "Inserir Elemento", "Consultar Elemento", "Retirar Elemento", "Sair" };
	public static int iOpcao;

	public static void main(String Args[]) {
		sTitle = "Estrutura de dados - Exercicio 17";
		sIO = "Fila Circular - Inserindo os valores em um vetor de forma decrescente";
		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
		do {
			sIO = "Selecione o botão da opção desejada:";
			iOpcao = JOptionPane.showOptionDialog(null, sIO, sTitle, 1, JOptionPane.QUESTION_MESSAGE, null, sOpcao,
					null);
			switch (iOpcao) {
			case 0:
				inserir_elemento();
				break;
			case 1:
				consultar_elemento();
				break;
			case 2:
				retirar_elemento();
				break;
			case 3:
				sIO = "Deseja realmente sair?";
				iSN = JOptionPane.showOptionDialog(null, sIO, sTitle, 1, JOptionPane.QUESTION_MESSAGE, null, sSN, null);
				if (iSN == 1)
					iOpcao = -1;
				break;
			}
		} while (iOpcao != 3);
//Termina execução
		System.exit(0);
	}

	public static void inserir_elemento() {
		String sDigitado;
		int iTamanho;
		if (isOver())
			sIO = "Fila Circular Cheia!";
		else {
			iTamanho = size();
			sIO = "Digite o caractere a ser colocado na Fila Circular:";
			sDigitado = JOptionPane.showInputDialog(null, sIO, sTitle, JOptionPane.QUESTION_MESSAGE);
			enQueueC(sDigitado.charAt(sDigitado.length() - 1));
			sIO = "Este foi o " + (iTamanho + 1) + "o. caractere colocado na Fila Circular com sucesso!";
		}

		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
	}

	public static void consultar_elemento() {
		int iTamanho;
		iTamanho = size();
		if (iTamanho == 0)
			sIO = "Fila Circular Vazia!";
		else
			sIO = "Tamanho da Fila Circular: " + iTamanho + " caractere(s)\nCaractere na Frente da Fila Circular: "
					+ front();
		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
	}

	public static void retirar_elemento() {
		int iTamanho;
		iTamanho = size();
		if (iTamanho == 0)
			sIO = "Fila Circular Vazia!";
		else
			sIO = "Caractere retirado da Fila Circular: " + deQueueC();
		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
	}

	public static void enQueueC(char cC) {
		cFila[iSPos--] = cC;
		if (iSPos < 0)
			iSPos = 9;
		if (iSPos == iRPos)
			bQueueFull = true;
	}

	public static char deQueueC() {
		int iIndice = iRPos--;
		if (iRPos < 0)
			iRPos = 9;
		bQueueFull = false;
		return cFila[iIndice];
	}

	public static char front() {
		return cFila[iRPos];
	}

	public static int size() {
		if (iSPos <= iRPos && !bQueueFull)
			return iRPos - iSPos;
		else
			return iRPos + cFila.length - iSPos;
	}

	public static boolean isOver() {
		if (iSPos == iRPos && bQueueFull)
			return true;
		return false;
	}
}
