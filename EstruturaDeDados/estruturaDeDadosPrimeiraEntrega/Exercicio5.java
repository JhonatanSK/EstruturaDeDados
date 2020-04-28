package estruturaDeDadosPrimeiraEntrega;

import javax.swing.JOptionPane;

/*Utilizando o mesmo princ�pio das fun��es do exerc�cio anterior, elaborar um
programa que realize as 4 opera��es matem�ticas entre 5 n�meros do tipo int, que dever�o
ser digitados primeiramente em sua totalidade e armazenados em uma pilha e s� ap�s
isto, conforme as opera��es matem�ticas que forem sendo digitadas, o resultado da conta
venha sendo apresentado sempre em rela��o aos �ltimos elementos da pilha
remanescente.

Exemplo: Digitados Apresentado Observa��o
		6 			6
		2 			2
		3			3
		4 			4
		5 			5
		+ 			9 <5+4>
		- 			6 <9-3>
		* 			12 <6*2>
		/ 			2 <12/6>
*/

public class Exercicio5 {
	public static int tamanho = 9;
	public static int tamanhoVetor = 0;
	public static int pilha[] = new int[tamanho];
	public static int vetorInt[] = new int[5];
	public static int pos = 0;
	public static String sIO, sTitle;
	public static String[] sSN = { "Sim", "N�o" };
	public static int iSN;
	public static String[] sOpcao = { "Iniciar Programa", "Sair" };
	public static int iOpcao;
	public static int result;
	
	public static void main(String Args[]) {
		sTitle = "Estrutura de dados - Exercicio 5";
		sIO = "Pilhas - Sistema de calculo de numeros";
		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
		do {
			sIO = "Selecione o bot�o da op��o desejada:";
			iOpcao = JOptionPane.showOptionDialog(null, sIO, sTitle, 1, JOptionPane.QUESTION_MESSAGE, null, sOpcao,
					null);
			switch (iOpcao) {
			case 0:
				iniciarCalculo();
				//reset();
				break;
			case 1:
				sIO = "Deseja realmente sair?";
				iSN = JOptionPane.showOptionDialog(null, sIO, sTitle, 1, JOptionPane.QUESTION_MESSAGE, null, sSN, null);
				if (iSN == 0)
					iOpcao = -1;
				break;
			}
		} while (iOpcao != -1);
		System.exit(0);
	}

	public static void iniciarCalculo() {
		int numero;
		sIO = "Digite o numero a ser colocado na Pilha:";
		
		for(int i = 0; i < 5; i++) {
			numero = Integer.parseInt(JOptionPane.showInputDialog(null, sIO, sTitle, JOptionPane.QUESTION_MESSAGE));
			vetorInt[i] = numero;
		}	
		sIO = "O resultado do calculo �: " + resultado();
		JOptionPane.showMessageDialog(null, sIO, sTitle, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static String resultado() {
		int cont = 0;
		//result = vetorInt[4];
		while(cont < 5) {
			push(vetorInt[cont]);
			cont++;
         pos++;
		}	
		return operacao();
	}
	
	public static String operacao() {
		String operacao;		
		int resultado;
      int valor;
		
		result = vetorInt[--pos];
		
		for(int i = 0; i < 4; i++) {
			sIO = "Digite a opera��o desejada:";
			operacao = JOptionPane.showInputDialog(null, sIO, sTitle, JOptionPane.QUESTION_MESSAGE);
         valor = pop();
			
			resultado = calculadora(result,valor,operacao);
			push(resultado);
			result = resultado;
		}
		return resultadoFinal();
	}
	
	public static int calculadora(int valor1, int valor2, String operacao) {
		if (operacao.equals("+")) return valor1 + valor2;
		else if (operacao.equals("-")) return valor1 - valor2;
		else if (operacao.equals("*")) return valor1 * valor2;
		else if (operacao.equals("/")) return valor1 / valor2;
		return -1;
	}
   	
	public static String resultadoFinal() {
		String vetorConcatenado = "";

		for (int i = 0; i < tamanho; i++) {
			vetorConcatenado += pilha[i] + ", ";
		}

		String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length() - 2);

		return vetorFinal;
	}

	public static int push(int cC) {
		if (pos >= tamanho)
			return 0;
		return pilha[tamanhoVetor++] = cC;
	}
	
	public static int pop() {
		return pilha[--pos];
	}
	
	/*public static void reset() {
		tamanho = 9;
		tamanhoVetor = 0;
		pos = 0;
	}
	*/
}
