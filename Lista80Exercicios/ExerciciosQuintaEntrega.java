/*70) Elaborar um programa, em linguagem Java, capaz de receber, via teclado e em ordem
aleatória, o conteúdo de cada um dos elementos de um vetor do tipo int, de tamanho
variável, também digitado, executar a ordenação crescente do mesmo e apresentar o vetor
ordenado em tela. Utilizar um método de ordenação por inserção.

73) Elaborar um programa, em linguagem Java, capaz de realizar a busca de um
determinado caractere, digitado, em um vetor qualquer de tamanho 10, também com seus
elementos do tipo char digitados, informando qual o índice do vetor que esse caractere se
localiza. Utilizar ordenação do tipo inserção e busca binária recursiva.

74) Elaborar um programa, em linguagem Java, capaz de receber, em ordem aleatória, o
conteúdo de cada elemento de um vetor do tipo char, de tamanho 5, via teclado, executar
uma ordenação crescente do mesmo e apresentar o vetor ordenado em tela. Utilizar um
método de ordenação Quick-Sort.

76) Elaborar um programa, em linguagem Java, capaz de receber, em ordem aleatória, o
conteúdo de cada elemento de um vetor do tipo double, de tamanho 20, via teclado,
executar uma ordenação decrescente do mesmo e apresentar o vetor ordenado em tela.
Utilizar uma função de ordenação Quick-Sort.
*/

import javax.swing.JOptionPane;

public class ExerciciosQuintaEntrega {

	public static void main(String[] args) {
		iniciarExercicios();
	}

	public static void iniciarExercicios() {
		while (true) {

			int pergunta = Integer
					.parseInt(JOptionPane.showInputDialog("Digite qual exercicio você deseja utilizar: \n "
							+ "Exercicio 70 - Ordenação por inserção (Insertion-sort) \n "
							+ "Exercicio 73 - Busca binaria recursiva em vetor ordenado por insertion-sort do tipo char. \n "
							+ "Exercicio 74 - Ordenação por Quick-Sort. \n "
							+ "Exercicio 76 - Vetor do tipo double desordenado por Selection-Sort. \n "
							+ "Digite '0' para sair\""));
			if (pergunta == 70) {
				int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do seu vetor"));
				int[] vetor = criarVetor(tamanho);
				int[] vetorOrdenado = exercicio70(vetor);

				String vetorConcatenado = "";

				for (int i = 0; i < tamanho; i++) {
					vetorConcatenado += vetorOrdenado[i] + ", ";
				}

				String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length() - 2);

				JOptionPane.showMessageDialog(null, "Seu vetor ordenado: " + vetorFinal);
			} else if (pergunta == 73) {
				char[] vetor = criarVetorChar(0, 10);

				String i = JOptionPane.showInputDialog("Digite o valor a ser buscado: ");
				char a = i.charAt(0);
				JOptionPane.showMessageDialog(null, "O valor: (" + a + ") está na posição: " + exercicio73(vetor, 0, vetor.length - 1, a));
				
			} else if (pergunta == 74) {
				char[] vetor = criarVetorChar(1,5);

				String vetorConcatenado = "";

				for (int i = 0; i < 5; i++) {
					vetorConcatenado += vetor[i] + ", ";
				}

				String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length() - 2);

				JOptionPane.showMessageDialog(null, "Seu vetor ordenado: " + vetorFinal);
			}

			else if (pergunta == 76) {
				double vetor[] = criarVetorDouble(20);
				double vetorOrdenado[] = ordenacaoQuickSortDouble(vetor, 0, vetor.length-1);
				
				String vetorConcatenado = "";
				for (int i = 0; i < vetorOrdenado.length; i++) {
					vetorConcatenado += vetorOrdenado[i] + ", ";
				}
				
				String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length()-2);
				JOptionPane.showMessageDialog(null, "Seu vetor desordenado: " + vetorFinal);
			} else if (pergunta == 0) {
				break;
			} else if (pergunta != 70 || pergunta != 73 || pergunta != 74 || pergunta != 76 || pergunta != 0) {
				JOptionPane.showMessageDialog(null, "Os unicos valores válidos são : 70, 73, 74, 76, 0");
			}
		}
	}
   
   //Exercicio 70
	public static int[] criarVetor(int a) {
		int[] vetor = new int[a];

		for (int i = 0; i < a; i++) {
			int valores = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para ser inserido no vetor: ("+i+"/"+a+")"));
			vetor[i] = valores;
		}
		return vetor;
	}

	public static int[] exercicio70(int vetor[]) {
		int a, b;
		int t;

		for (a = 1; a < vetor.length; a++) {
			t = vetor[a];
			b = a - 1;
			while (b >= 0 && t < vetor[b]) {
				vetor[b + 1] = vetor[b];
				b--;
			}
			vetor[b + 1] = t;
		}
		return vetor;
	}
   
   //Exercicio 73
   public static char[] criarVetorChar(int tipo, int a) {
		char[] vetor = new char[a];
		char[] vetorOrdenado = new char[a];

		for (int i = 0; i < a; i++) {
			String valores = JOptionPane.showInputDialog("Digite uma letra para ser inserida no vetor");
			char valor = valores.charAt(0);
			vetor[i] = valor;
		}
		if (tipo == 0) {
			vetorOrdenado = ordenarVetorInsercao(vetor);
			return vetorOrdenado;
		}
		
		 else if (tipo == 1) {
			 vetorOrdenado = ordenacaoQuickSort(vetor, 0, a-1);
			 return vetorOrdenado;
		 }
		 
		return vetorOrdenado;
	}

	public static char[] ordenarVetorInsercao(char vetor[]) {
		int a, b;
		char t;

		for (a = 1; a < vetor.length; a++) {
			t = vetor[a];
			b = a - 1;
			while (b >= 0 && t < vetor[b]) {
				vetor[b + 1] = vetor[b];
				b--;
			}
			vetor[b + 1] = t;
		}
		return vetor;
	}

	public static int exercicio73(char[] vetor, int baixo, int alto, char posicao) {
		int meio;

		if (baixo <= alto) {
			meio = (baixo + alto) / 2;
			if (posicao < vetor[meio]) {
				return exercicio73(vetor, baixo, meio - 1, posicao);
			} else if (posicao > vetor[meio]) {
				return exercicio73(vetor, meio + 1, alto, posicao);
			} else {
				return meio;
			}
		}
		return -1;
	}

}






