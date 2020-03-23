import javax.swing.JOptionPane;

// 42, 44, 49 e 50.

public class ExerciciosTerceiraEntrega {

	public static void main(String[] args) {
		iniciarExercicios();

	}
	
	public static void iniciarExercicios() {
		while(true) {
			
			int pergunta = Integer.parseInt(JOptionPane.showInputDialog("Digite qual exercicio você deseja utilizar: \n "
					+ "Exercicio 42 - Busca binaria em vetor do tipo char. \n "
					+ "Exercicio 44 - Busca binaria em vetor do tipo int de 15 elementos. \n "
					+ "Exercicio 49 - Busca binaria recursiva em vetor não ordenado. \n "
					+ "Exercicio 50 - Busca binaria recursiva em vetor do tipo char ordenado decrescente. \n "
					+ "Digite '0' para sair\""));
			if (pergunta == 42) {
				char [] vetor = criarVetorChar(1);
				String valor = JOptionPane.showInputDialog("Digite o caractere desejado: ");
				char letra = valor.charAt(0);

				JOptionPane.showMessageDialog(null, "O caractere: (" + letra + ") inserido no vetor está na posição: " + exercicio42(vetor, letra));
			}
			else if (pergunta == 44) {	
				int [] vetor = criarVetor(15);
				int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado no vetor"));
				JOptionPane.showMessageDialog(null,"O valor: ("+ posicao +") inserido no vetor está na posição: " + exercicio44(vetor, posicao));
			}
			else if (pergunta == 49) {
				int [] vetor = criarVetorSemOrdenar(10);
				
				int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado: "));
				JOptionPane.showMessageDialog(null, "O valor: ("+ i +") está na posição: " + exercicio49(vetor, 0, vetor.length-1, i));
			}
			else if (pergunta == 50) {
				char [] vetor = criarVetorChar(0);
				
				String i = JOptionPane.showInputDialog("Digite o valor a ser buscado: ");
				char a = i.charAt(0);
				JOptionPane.showMessageDialog(null, "O valor: (" + a + ") está na posição: " + exercicio50(vetor, 0, vetor.length-1, a));
			}
			else if (pergunta == 0) {
				break;
			}
			else if (pergunta != 42 || pergunta != 44 || pergunta != 49 || pergunta != 50 || pergunta != 0) {
				JOptionPane.showMessageDialog(null, "Os unicos valores válidos são : 42, 44, 49, 50, 0");
			}
		}
	}
	

	public static char[] criarVetorChar(int tipo){
		int a = 10;
		char [] vetor = new char[a];
		char [] vetorOrdenado = new char[a];
		char [] vetorDesordenado = new char[a];
		      
	    for (int i = 0; i < a; i++) {
		    String valores = JOptionPane.showInputDialog("Digite uma letra para ser inserida no vetor");
	        char valor = valores.charAt(0);
	        vetor[i] = valor; 
	    }
	    if (tipo == 0) {
	    	vetorDesordenado = ordenarVetorCharDecrescente(vetor,a);
	    	return vetorDesordenado;
	    }
	    else if (tipo == 1){
		    vetorOrdenado = ordenarVetorChar(vetor, a);
			return vetorOrdenado;
	    }
	    return vetor;

	}
	public static char[] ordenarVetorChar(char vetor[], int a) {
		char aux;
		
		for(int i = 1; i < a; i++) {
			for(int j = 0; j < a; j++) {
				if(vetor[j] > vetor[i]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		return vetor;
	}
	
	public static char[] ordenarVetorCharDecrescente(char vetor[], int a) {
		char aux;
		
		for(int i = 1; i < a; i++) {
			for(int j = 0; j < a; j++) {
				if(vetor[j] < vetor[i]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		return vetor;
	}
	
	public static int[] criarVetorSemOrdenar(int a){
		int [] vetor = new int[a];
		      
		for (int i = 0; i < a; i++) {
			int valores = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para ser inserido no vetor"));
		    vetor[i] = valores;
		    	  
		}
		return vetor;
	}
    
	public static int[] criarVetor(int a){
		int [] vetor = new int[a];
		      
		for (int i = 0; i < a; i++) {
			int valores = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para ser inserido no vetor"));
		    vetor[i] = valores;
		    	  
		}
		int [] vetorOrdenado = ordenarVetor(vetor, a);
		return vetorOrdenado;
	}
	
	public static int[] ordenarVetor(int vetor[], int tamanho) {
		int aux;
		
		for(int i = 1; i < tamanho; i++) {
			for(int j = 0; j < tamanho; j++) {
				if(vetor[j] > vetor[i]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		return vetor;
	}
	
	//Exercicios..
	
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
	
	
	public static int exercicio44(int [] vetor, int posicao) {
		   
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
		
		return vetor.length;
    }
	

	
	public static int exercicio49(int [] vetor, int baixo, int alto, int posicao) {
		int meio;
		
		if(baixo <= alto) {
			meio = (baixo+alto)/2;
			if(posicao < vetor[meio]) {
				return exercicio49(vetor, baixo, meio-1, posicao);
			}
			else if (posicao > vetor[meio]) {
				return exercicio49(vetor, meio+1, alto, posicao);
			}
			else return meio;
		}
		return -1;
	}
	
	public static int exercicio50(char [] vetor, int baixo, int alto, char posicao) {
		int meio;
		
		if(baixo <= alto) {
			meio = (baixo+alto)/2;
			if(posicao > vetor[meio]) {
				return exercicio50(vetor, baixo, meio-1, posicao);
			}
			else if (posicao < vetor[meio]) {
				return exercicio50(vetor, meio+1, alto, posicao);
			}
			else return meio;
		}
		return -1;
	}
	
}







