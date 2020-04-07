/* 5) Dado um vetor do tipo int de 16 elementos, a serem digitados aleatoriamente, elaborar
um programa, em linguagem Java, capaz de apresentar a quantidade de capicuas de 4
elementos existentes ao longo desse vetor (capicua: número que representa o mesmo valor
quando lido da esquerda para a direita e vice-versa). Exemplo: Vetor digitado
índices: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
elementos: 0 1 1 0 3 2 4 4 2 2 4 7 7 7 7 7;
Total de Capicuas: 5
Obs.: Foram encontradas as seguintes capicuas: 0110 (índices 0, 1, 2 e 3), 2442 (índices
5, 6, 7 e 8), 4224 (índices 7, 8, 9 e 10), 7777 (índices 11, 12, 13 e 14) e 7777 (índices 12,
13, 14 e 15).
*/

public class Exercicio5{
   public static void main(String [] args){
          	int cont = 0;
    	String capicua = "";
    	
    	int[] vetor = {0,1,1,0,3,2,4,4,2,2,4,7,7,7,7,7};
    	
    	for(int i = 0; i < 16; i++) {
         if(i > 2){
       		if(vetor[i-1] == vetor[i-2]) {
       			if(vetor[i] == vetor[i-3]) {
       				cont++;
       				capicua = vetor[i-3] + "" + vetor[i-2] + "" + vetor[i-1] + "" + vetor[i];
       				System.out.println(capicua);
       			}
       		}
         }
    	}
    	System.out.println("Total de capicuas: " + cont);
   }
}
