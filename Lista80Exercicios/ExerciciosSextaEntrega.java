/*
80) Elaborar um programa, em linguagem Java, capaz de receber, via teclado e em ordem
aleatória, o conteúdo de cada um dos elementos de um vetor do tipo int, de tamanho
variável, também digitado, executar a ordenação crescente do mesmo e apresentar o vetor
ordenado em tela. Utilizar um método de ordenação Merge-Sort.

81) Elaborar um programa, em linguagem Java, capaz de receber, em ordem aleatória, o
conteúdo de cada elemento de um vetor do tipo double, de tamanho 20, via teclado,
executar uma ordenação decrescente do mesmo e apresentar o vetor ordenado em tela.
Utilizar uma função de ordenação Merge-Sort.

83) Elaborar um programa, em linguagem Java, capaz de realizar a busca de um
determinado caractere, digitado, em um vetor qualquer de tamanho 10, também com seus
elementos do tipo char digitados, informando qual o índice do vetor que esse caractere se
localiza. Utilizar ordenação do tipo Merge-Sort e busca binária recursiva.

*/

import javax.swing.JOptionPane;

public class ExerciciosSextaEntrega {

	public static void main(String[] args) {
		iniciarExercicios();
	}

	public static void iniciarExercicios() {
		while (true) {

			int pergunta = Integer
					.parseInt(JOptionPane.showInputDialog("Digite qual exercicio você deseja utilizar: \n "
							+ "Exercicio 80 - Ordenação por merge-sort \n "
							+ "Exercicio 81 - Ordenação por merge-sort decrescente \n "
							+ "Exercicio 83 - Busca binária recursiva em vetor ordenado por merge-sort \n "
							+ "Digite '0' para sair\""));
			if (pergunta == 80) {
				int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do seu vetor"));
				int[] vetor = criarVetor(tamanho);
				int[] vetorOrdenado = mergeSort(vetor);

				String vetorConcatenado = "";

				for (int i = 0; i < tamanho; i++) {
					vetorConcatenado += vetorOrdenado[i] + ", ";
				}

				String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length() - 2);

				JOptionPane.showMessageDialog(null, "Seu vetor ordenado: " + vetorFinal);
			}
			else if (pergunta == 81) {
				double vetor[] = criarVetorDouble(20);
				double vetorOrdenado[] = mergeSortDesordena(vetor);
				
				String vetorConcatenado = "";
				for (int i = 0; i < vetorOrdenado.length; i++) {
					vetorConcatenado += vetorOrdenado[i] + ", ";
				}
				
				String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length()-2);
				JOptionPane.showMessageDialog(null, "Seu vetor desordenado: " + vetorFinal);
			}
			else if (pergunta == 83) {
				char[] vetor = criarVetorChar(10);

				String i = JOptionPane.showInputDialog("Digite o valor a ser buscado: ");
				char a = i.charAt(0);
				JOptionPane.showMessageDialog(null, "O valor: (" + a + ") está na posição: " + exercicio83(vetor, 0, vetor.length - 1, a));
			}
			else if (pergunta == 0) {
				break;
			}
			else if (pergunta != 80 || pergunta != 81 || pergunta != 83 || pergunta != 0) {
				JOptionPane.showMessageDialog(null, "Os unicos valores válidos são : 80, 81, 83, 0");
			}
		}
	}

	/*
	80) Elaborar um programa, em linguagem Java, capaz de receber, via teclado e em ordem
	aleatória, o conteúdo de cada um dos elementos de um vetor do tipo int, de tamanho
	variável, também digitado, executar a ordenação crescente do mesmo e apresentar o vetor
	ordenado em tela. Utilizar um método de ordenação Merge-Sort.
	 */
	public static int[] criarVetor(int a) {
		int[] vetor = new int[a];

		for (int i = 0; i < a; i++) {
			int valores = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para ser inserido no vetor: ("+i+"/"+a+")"));
			vetor[i] = valores;
		}
		return vetor;
	}

	public static int[]	mergeSort(int v[])
    {  
        if(v.length > 1)
        {   int t1 = v.length/2;  
            int t2 = v.length-t1;  
            int v1[] = new int[t1];  
            int v2[] = new int[t2];  
              
            for(int i = 0; i < t1; i++) 
            {
                v1[i] = v[i];
            }
            for(int i = t1; i < (t1+t2); i++)
            {
                v2[i-t1] = v[i];  
            }
            mergeSort(v1);  
            mergeSort(v2);  
            merge(v, v1, v2);
        }
        return v;
    }
    
    public static void merge(int	w[], int w1[], int w2[])
    {	int	i = 0, j = 0, k = 0;  
    	
    	while(w1.length != j && w2.length != k)
        {  
        	if(w1[j] <= w2[k])
            {  
        		w[i] = w1[j];  
                i++;  
                j++;  
            }
            else
            {  
            	w[i] = w2[k];  
                i++;  
                k++;  
            }  
        }  
        while(w1.length != j) 
        {  
        	w[i] = w1[j];  
            i++;  
            j++;  
        }  
        while(w2.length != k)
        {  
        	w[i] = w2[k];  
            i++;  
            k++;  
        }  
    }  


	/*
	 81) Elaborar um programa, em linguagem Java, capaz de receber, em ordem aleatória, o
	conteúdo de cada elemento de um vetor do tipo double, de tamanho 20, via teclado,
	executar uma ordenação decrescente do mesmo e apresentar o vetor ordenado em tela.
	Utilizar uma função de ordenação Merge-Sort.
	 */
	
	public static double[] criarVetorDouble(int a){
		double [] vetor = new double[a];
		      
		for (int i = 0; i < a; i++) {
			double valores = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor para ser inserido no vetor: ("+i+"/"+a+")"));
		    vetor[i] = valores;   	  
		}
		return vetor;
	}
	
	public static double[]	mergeSortDesordena(double v[])
    {  
        if(v.length > 1)
        {   int t1 = v.length/2;  
            int t2 = v.length-t1;  
            double v1[] = new double[t1];  
            double v2[] = new double[t2];  
              
            for(int i = 0; i < t1; i++) 
            {
                v1[i] = v[i];
            }
            for(int i = t1; i < (t1+t2); i++)
            {
                v2[i-t1] = v[i];  
            }
            mergeSortDesordena(v1);  
            mergeSortDesordena(v2);  
            mergeDesordena(v, v1, v2);
        }
        return v;
    }
    
    public static void mergeDesordena(double w[], double w1[], double w2[])
    {	int	i = 0, j = 0, k = 0;  
    	
    	while(w1.length != j && w2.length != k)
        {  
        	if(w1[j] <= w2[k])
            {  
            	w[i] = w2[k];  
                i++;  
                k++;  
            }
            else
            {  
        		w[i] = w1[j];  
                i++;  
                j++; 
            }  
        }  
        while(w1.length != j) 
        {  
        	w[i] = w1[j];  
            i++;  
            j++;  
        }  
        while(w2.length != k)
        {  
        	w[i] = w2[k];  
            i++;  
            k++;  
        }  
    }
	

	/*83) Elaborar um programa, em linguagem Java, capaz de realizar a busca de um
	determinado caractere, digitado, em um vetor qualquer de tamanho 10, também com seus
	elementos do tipo char digitados, informando qual o índice do vetor que esse caractere se
	localiza. Utilizar ordenação do tipo Merge-Sort e busca binária recursiva.*/
	
    public static char[] criarVetorChar( int a) {
		char[] vetor = new char[a];
		char[] vetorOrdenado = new char[a];

		for (int i = 0; i < a; i++) {
			String valores = JOptionPane.showInputDialog("Digite um valor para ser inserido no vetor: ("+i+"/"+a+")");
			char valor = valores.charAt(0);
			vetor[i] = valor;
		}
		
		vetorOrdenado = mergeSortChar(vetor);
		return vetorOrdenado;
		
	}
	
	public static char[] mergeSortChar(char v[])
    {  
        if(v.length > 1)
        {   int t1 = v.length/2;  
            int t2 = v.length-t1;  
            char v1[] = new char[t1];  
            char v2[] = new char[t2];  
              
            for(int i = 0; i < t1; i++) 
            {
                v1[i] = v[i];
            }
            for(int i = t1; i < (t1+t2); i++)
            {
                v2[i-t1] = v[i];  
            }
            mergeSortChar(v1);  
            mergeSortChar(v2);  
            mergeChar(v, v1, v2);
        }
        return v;
    }
    
    public static void mergeChar(char w[], char w1[], char w2[])
    {	int	i = 0, j = 0, k = 0;  
    	
    	while(w1.length != j && w2.length != k)
        {  
        	if(w1[j] <= w2[k])
            {  
        		w[i] = w1[j];  
                i++;  
                j++;  
            }
            else
            {  
            	w[i] = w2[k];  
                i++;  
                k++;  
            }  
        }  
        while(w1.length != j) 
        {  
        	w[i] = w1[j];  
            i++;  
            j++;  
        }  
        while(w2.length != k)
        {  
        	w[i] = w2[k];  
            i++;  
            k++;  
        }  
    }  
    
    public static int exercicio83(char[] vetor, int baixo, int alto, char posicao) {
		int meio;

		if (baixo <= alto) {
			meio = (baixo + alto) / 2;
			if (posicao < vetor[meio]) {
				return exercicio83(vetor, baixo, meio - 1, posicao);
			} else if (posicao > vetor[meio]) {
				return exercicio83(vetor, meio + 1, alto, posicao);
			} else {
				return meio;
			}
		}
		return -1;
	}
}
