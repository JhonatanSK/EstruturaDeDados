public class Exercicio4{
   public static void main(String [] args){
        /* 4) - Dado o vetor gerado pelo exercício 3 ( [ ‘A’, ‘B’, ‘C’, ‘D’, ... , ‘W’, ‘X’, ‘Y’, ‘Z’ ] ),
        elaborar um programa em linguagem Java capaz de trocar a ordem de seus elementos, de
        dois em dois, até o final do mesmo ( [ ‘B’, ‘A’, ‘D’, ‘C’, ... , ‘X’, ‘W’, ‘Z’, ‘Y’ ] ),
        utilizando malhas;
        */

        char[] vetor = new char[26];
        
        char[] vetorChar = new char[91];
        
        for (char i = 'A'; i <= 'Z'; i++) {
            vetorChar[i] = i;
        }
        int j = 0;
        for (int i = 65; i <= 90; i++){
            vetor[j] = vetorChar[i];
            j++;
        }
        char[] vetorFinal = new char[26];
        
        int k = 0;
        
        for (int i = 0; i < 26; i++) {
        	if (i % 2 == 0) {
        		vetorFinal[k] = vetor[i+1];
        		k++;
        		vetorFinal[k] = vetor[i];
        	}
         else{
         k++;
         }
        	System.out.println(vetorFinal[i]);
        }
        
   }
}