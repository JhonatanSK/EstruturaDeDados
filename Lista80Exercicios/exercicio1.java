public class exercicio1{
   public static void main(String [] args){
     //1) - Elaborar um programa, em linguagem Java, capaz inicializar com 0 (zero) um vetor
     // do tipo int de 100 elementos, utilizando-se das malhas (laços, loops, etc.) while, do-while e for;
        
       int vetor [] = new int [100]; 
       
       for (int i = 0; i < 100; i++){
           vetor[i] = 0;
           System.out.println(vetor[i]);
       }
   }
}