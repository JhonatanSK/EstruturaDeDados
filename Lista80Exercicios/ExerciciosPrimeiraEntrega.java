import java.util.Random;

import javax.swing.JOptionPane;

public class ExerciciosPrimeiraEntrega {

	public static void main(String[] args){
		iniciarExercicios();

	}
	public static void iniciarExercicios(){
		
		int numero;
		while(true) {
		
			int pergunta = Integer.parseInt(JOptionPane.showInputDialog("Digite qual exercicio você deseja utilizar: \n "
					+ "Exercicio 22 - Fibonacci \n Exercicio 23 - Soma de vetores de tamanho 10 \n Exercicio 27 - Numero elevado \n "
					+ "Exercicio 28 - Multiplicação \n Digite '0' para sair"));
			if (pergunta == 22) {
				numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da posição de fibonacci desejado: "));
				JOptionPane.showMessageDialog(null, Exercicio22(numero));
			}
			else if (pergunta == 23) {
				int vetor23[] = vetorAleatorio();
				String vetorConcatenado = "";
				for (int i = 0; i < 10; i++) {
					vetorConcatenado += vetor23[i] + ", ";
				}
				
				String vetorFinal = vetorConcatenado.substring(0, vetorConcatenado.length()-2);
				
				JOptionPane.showMessageDialog(null,"Seu vetor é: "+ vetorFinal +". E a soma de todos os elementos é: " + Exercicio23(vetor23, 9));
			}
			else if (pergunta == 27) {
				numero = Integer.parseInt(JOptionPane.showInputDialog("Digite primeiro numero: "));
				int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser elevado: "));
				
				JOptionPane.showMessageDialog(null, "O numero " + numero + " elevado a o numero "+ numero2 + " é: " + Exercicio27(numero, numero2));
			}
			else if (pergunta == 28) {
				numero = Integer.parseInt(JOptionPane.showInputDialog("Digite primeiro numero: "));
				int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a ser multiplicado: "));
				JOptionPane.showMessageDialog(null, "O resultado da multiplicação é: " + Exercicio28(numero, numero2));
			}
			
			else if (pergunta == 0) {
				break;
			}
			else if (pergunta != 22 || pergunta != 23 || pergunta != 27 || pergunta != 28 || pergunta != 0) {
				JOptionPane.showMessageDialog(null, "Os unicos valores válidos são : 22, 23, 27, 28, 0");
			}
		}
	}
	
	public static int[] vetorAleatorio() {
		int vetor[] = new int [10];
		Random aleatorio = new Random();
		
		for (int i = 0; i < 10; i++) {
			vetor[i] = aleatorio.nextInt(100);
		}
		return vetor;
	}
	
	//Abaixo está a solução dos exercicios utilizando recursividade
	
	public static int Exercicio22(int a) {
		if (a == 0) {
			return 0;
		}
		if (a == 1) {
			return 1;
		}
		else {
			return Exercicio22(a-1) + Exercicio22(a-2);
		}
	}
	
	public static int Exercicio23(int vetor[], int i) {
		if (i > 0) {
			return vetor[i] + Exercicio23(vetor, i-1);
		}
		else {
			return vetor[i];
		}
	}
	
   public static int Exercicio27(int a, int b) {
		if(b > 0) {
			return  a * Exercicio27(a,b-1);
		}
		else {
         return 1;
      }
		
	}
   
	public static int Exercicio28(int a, int b) {
		if(a > 0) {
			return b + Exercicio28(a-1,b);
		}
		else {
         return 0;
		}
	}

}