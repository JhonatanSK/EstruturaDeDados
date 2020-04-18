package AlgoritmosUltimaAtividade;

import java.util.Random;

import javax.swing.JOptionPane;

public class ConfrontoCincoMetodos {

	public static void main(String[] args) {
		int tamanho = 10000;
		int vetor[] = criarVetor(tamanho);
		
		int vetorCopiado1[] = copiarVetor(vetor, tamanho);
		int vetorCopiado2[] = copiarVetor(vetor, tamanho);
		int vetorCopiado3[] = copiarVetor(vetor, tamanho);
		int vetorCopiado4[] = copiarVetor(vetor, tamanho);
		int vetorCopiado5[] = copiarVetor(vetor, tamanho);
		
		//Bubble Sort
		
		long start = System.nanoTime();
		
		bubbleSort(vetorCopiado1, tamanho);
		
		long end = System.nanoTime();
		long microseconds = (end - start) / 1000;
		
		
		//Selection Sort
		long start2 = System.nanoTime();

		selectionSort(vetorCopiado2, tamanho);
		
		long end2 = System.nanoTime();
		long microseconds2 = (end2 - start2) / 1000;
			
		
		//Insertion Sort
		long start3 = System.nanoTime();

		insertionSort(vetorCopiado3);
		
		long end3 = System.nanoTime();
		long microseconds3 = (end3 - start3) / 1000;
			
		
		//Quick Sort
		long start4 = System.nanoTime();

		quickSort(vetorCopiado4, 0, vetorCopiado4.length-1);
		
		long end4 = System.nanoTime();
		long microseconds4 = (end4 - start4) / 1000;

		
		//Merge Sort
		long start5 = System.nanoTime();

		mergeSort(vetorCopiado5);
		
		long end5 = System.nanoTime();
		long microseconds5 = (end5 - start5) / 1000;
		
		
		JOptionPane.showMessageDialog(null, "O método Bubble Sort demorou: " + microseconds + " microssegundos  para ser ordenado" +"\n"
				+ "O método Selection Sort demorou: " + microseconds2 + " microssegundos para ser ordenado \n"
						+ "O método Insertion Sort demorou: " + microseconds3 + " microssegundos para ser ordenado \n"
								+ "O método Quick Sort demorou: " + microseconds4 + " microssegundos para ser ordenado \n"
										+ "O método Merge Sort demorou: " + microseconds5 + " microssegundos para ser ordenado");
	}

	public static int[] criarVetor(int a) {
		int[] vetor = new int[a];
		Random aleatorio = new Random();

		for (int i = 0; i < a; i++) {
			vetor[i] = aleatorio.nextInt(100);
		}
		return vetor;
	}
	
	public static int[] copiarVetor(int vetor[], int tamanho) {
		int[] vetorCopiado = new int[tamanho];
		
		for (int i = 0; i < vetor.length; i++) {
			vetorCopiado[i] = vetor[i];
		}
		
		return vetorCopiado;
	}
	
	//Primeiro Método
	public static void bubbleSort(int vetor[], int tamanho) {
		int aux;
		
		for(int i = 1; i < tamanho; i++) {
			for(int j = tamanho-1; j >= i; j--) {
				if(vetor[j-1] > vetor[j]) {
					aux = vetor[j-1];
					vetor[j-1] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
	}
	
	//Segundo Método
	public static void selectionSort(int vetor[], int a) {
		int posicao;
		int aux;
		
		for(int i = 0; i < a-1; i++) {
			posicao = i;
			aux = vetor[i];
			
			for(int j = i+1; j < a; j++) {
				if(vetor[j] > aux) {
					posicao = j;
					aux = vetor[j];
				}
			}
			vetor[posicao] = vetor[i];
			vetor[i] = aux;
		}
	}
	
	//Terceiro Método
	public static void insertionSort(int vetor[]) {
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
	}
	
	//Quarto Método
	public static void quickSort(int vetor[], int baixo, int alto) {
		int p,b,a;
		int pivot;
		
		b = baixo;
		a = alto;
		pivot = vetor[baixo];
		while(baixo < alto) {
			while((vetor[alto] >= pivot) && (baixo < alto)) { 
				alto--;
			}
				if(baixo != alto) {
					vetor[baixo] = vetor[alto];
					baixo++;
				}

			while((vetor[baixo] <= pivot) && (baixo < alto)) {
				baixo++;
			}
				if(baixo != alto) {
					vetor[alto] = vetor[baixo];
					alto--;
				}
		}
		vetor[baixo] = pivot;
		p = baixo;
		baixo = b;
		alto = a;
		if(baixo < p) quickSort(vetor, baixo, p-1);
		if(alto > p) quickSort(vetor, p+1, alto);
	}
	
	
	
	
}
