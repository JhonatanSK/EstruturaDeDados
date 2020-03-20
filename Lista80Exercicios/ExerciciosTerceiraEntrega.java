import javax.swing.JOptionPane;

// 42, 44, 49 e 50.

public class ExerciciosTerceiraEntrega {

	public static void main(String[] args) {
		iniciarExercicios();

	}
	
	public static void iniciarExercicios() {
		while(true) {
			
			int pergunta = Integer.parseInt(JOptionPane.showInputDialog("Digite qual exercicio você deseja utilizar: \n "
					+ "Exercicio 42 - Busca \n Exercicio 44 - Buscar \n Exercicio 49 - busca \n "
					+ "Exercicio 50 - Busca \n Digite '0' para sair\""));
			if (pergunta == 42) {
				char [] vetor = criarVetorChar();
				String valor = JOptionPane.showInputDialog("Digite o caractere desejado: ");
				char letra = valor.charAt(0);
								
				JOptionPane.showMessageDialog(null, "O valor inserido está na posição: " + exercicio42(vetor, letra));
			}
			else if (pergunta == 44) {	
				JOptionPane.showMessageDialog(null,"O valor inserido está na posição: ");
			}
			else if (pergunta == 49) {
				
				int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado: "));
				JOptionPane.showMessageDialog(null, "O valor está na posição: ");
			}
			else if (pergunta == 50) {
				
				String i = JOptionPane.showInputDialog("Digite o valor a ser buscado: ");
				char a = i.charAt(0);
				JOptionPane.showMessageDialog(null, "O valor está na posição: ");
			}
			else if (pergunta == 0) {
				break;
			}
			else if (pergunta != 42 || pergunta != 44 || pergunta != 49 || pergunta != 50 || pergunta != 0) {
				JOptionPane.showMessageDialog(null, "Os unicos valores válidos são : 42, 44, 49, 50, 0");
			}
		}
	}
	
	/*
	 * 42 - Elaborar um programa, em linguagem Java, capaz de receber 10 elementos diferentes
	do tipo char, em ordem crescente, armazená-los em um vetor do mesmo tipo e tamanho,
	no sentido do menor para o maior índice. O programa deverá pedir ao operador para que
	digite mais um caractere, o qual será localizado no determinado vetor. O programa
	apresentará em tela o resultado de uma busca binária por todos os índices, do menor para
	o maior, informando ao operador o número do índice do vetor no qual se encontra o
	caractere digitado, ou, se for o caso, que o caractere não se encontra no vetor (utilizar o
	tamanho máximo do vetor como terminador da busca no vetor). Utilizar um método
	iterativo de busca binária construído com passagem de parâmetros.
	 */

	public static char[] criarVetorChar(){
		int a = 10;
		char [] vetor = new char[a];
		char [] vetorOrdenado = new char[10];
		      
	    for (int i = 0; i < a; i++) {
		    String valores = JOptionPane.showInputDialog("Digite uma letra para ser inserida no vetor");
	        char valor = valores.charAt(0);
	        vetor[i] = valor; 
	    }
	    vetorOrdenado = ordenarVetorChar(vetor);
	    return vetorOrdenado;
	}
	public static char[] ordenarVetorChar(char vetor[]) {
		char aux;
		
		for(int i = 1; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(vetor[j] > vetor[i]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		return vetor;
	}
    
	public static int exercicio42(char vetor[], char posicao) {
		int baixo = 0;
		int alto = vetor.length-1;
		
		while(baixo <= alto) {
			int meio = (baixo+alto)/2;
			if (posicao < vetor[meio]) {
				alto = meio-1;
			}
			else if (posicao > vetor[meio]) {
				baixo = meio+1;
			}
			else {
				return meio;
			}
		}
		
		return -1;
	}
}







