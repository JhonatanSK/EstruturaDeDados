// Exercicios 32, 33, 39, 40

import javax.swing.JOptionPane;

public class ExerciciosSegundaEntrega {
	public static void main(String[] args){
		iniciarExercicios();	
    }

	public static void iniciarExercicios() {
		while(true) {
			
			int pergunta = Integer.parseInt(JOptionPane.showInputDialog("Digite qual exercicio você deseja utilizar: \n "
					+ "Exercicio 32 - Buscar numeros no vetor \n Exercicio 33 - Buscar caracteres no vetor \n Exercicio 39 - buscar numeros no vetor(Recursivo) \n "
					+ "Exercicio 40 - Buscar caracteres no vetor (Recursivo) \n Digite '0' para sair\""));
			if (pergunta == 32) {
				JOptionPane.showMessageDialog(null, "O valor inserido está na posição: "+ exercicio32(0));
			}
			else if (pergunta == 33) {	
				JOptionPane.showMessageDialog(null,"O valor inserido está na posição: " + exercicio33("A"));
			}
			else if (pergunta == 39) {
				int [] vetor = criarVetor(10); 
				int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado: "));
				JOptionPane.showMessageDialog(null, "O valor está na posição: " + exercicio39(vetor,1, i));
			}
			else if (pergunta == 40) {
				char [] vetor = criarVetorChar(10);
				String i = JOptionPane.showInputDialog("Digite o valor a ser buscado: ");
				char a = i.charAt(0);
				JOptionPane.showMessageDialog(null, "O valor está na posição: " + exercicio40(vetor,9, a));
			}
			else if (pergunta == 0) {
				break;
			}
			else if (pergunta != 32 || pergunta != 33 || pergunta != 39 || pergunta != 40 || pergunta != 0) {
				JOptionPane.showMessageDialog(null, "Os unicos valores válidos são : 32, 33, 39, 40, 0");
			}
		}
	}
	
   public static int[] criarVetor(int a){
      int [] vetor = new int[a];
      
      for (int i = 0; i < a; i++) {
    	  int valores = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para ser inserido no vetor"));
    	  vetor[i] = valores;
    	  
      }
      return vetor;
   }
   
   public static char[] criarVetorChar(int a){
	   char [] vetor = new char[a];
	      
	   for (int i = 0; i < a; i++) {
		   String valores = JOptionPane.showInputDialog("Digite uma letra para ser inserida no vetor");
	       char valor = valores.charAt(0);
	       vetor[i] = valor; 
	   }
	   return vetor;
   }
   
	//Exercicio 32
   public static int exercicio32(int pergunta) {
	   int vetorValores[] = criarVetor(15);
	   
	   int resultado = -2;
	   pergunta = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser buscado no vetor"));
	   
	   for(int i = 0; i < 15; i++) {
		   if(vetorValores[i] == pergunta) {
			   resultado = i;
			   break;
		   }
	   }
	   if(resultado == -2) {
		   resultado = vetorValores.length + 1;
	   }
	   
	   return resultado;
   }
      
 //Exercicio 33
   public static int exercicio33(String pergunta){
	   char vetorValores[] = criarVetorChar(15);
	   
	   int resultado = -2;
	   pergunta = JOptionPane.showInputDialog("Digite a letra que deseja buscar no vetor");
	   char valor = pergunta.charAt(0);
	   
	   for(int i = 0; i < 15; i++) {
		   if(vetorValores[i] == valor) {
			   resultado = i;
			   break;
		   }
	   }
	   if(resultado == -2) {
		   resultado = vetorValores.length + 1;
	   }
	   
	   return resultado;
   }

   //Exercicio 39	
   
   public static int exercicio39(int vetor[], int a, int valor){
	  if(vetor[a] == valor) return a;
      
      else return exercicio39(vetor, a+2, valor);     
   }
   
   //Exercicio 40

   public static int exercicio40(char vetor[], int a, char valor){
	   if (vetor[a] == valor) return a;
	   
	   else return exercicio40(vetor, a-1, valor);      
   }
}


