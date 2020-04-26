public class Exercicio2{
   public static void main(String [] args){
        /* 2) Elaborar um programa, em linguagem Java, capaz de, em um vetor do tipo int de 100
        elementos, carregar seus índices pares com o número 0 (zero) e seus índices ímpares com
        o valor do próprio índice (ex.: [ 0, 1, 0, 3, 0, 5, 0, 7, ..., 97, 0, 99 ] ), utilizando-se de
        malhas;
        */
        
        
        int vetor [] = new int [100];
        
        for (int i = 0; i < 100; i++){
           if (i % 2 == 0){
               vetor[i] = 0;
           }
           else{
               vetor[i] = i;
           }
            
           System.out.println(vetor[i]);
       }
       
   }
}