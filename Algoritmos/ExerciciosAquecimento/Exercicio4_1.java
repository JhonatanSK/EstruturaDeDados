/* Lista1: classe para exercícios de aquecimento. */
import javax.swing.*;

public class Exercicio4_1{
   public static void main ( String args [] ){
   
   /* Vetor de "entrada", que já é alocado e inicializado.
   Neste caso, o new é dispensado, pois o compilador já
   deduz o número de posições que devem ser alocadas. */
   int a[] = {32,45,89,66,12,35,10,96,38,15,13,11,65,81,35,64,16,89,54,19};
   
   /* A variável n conterá sempre o tamanho do vetor a.
   Isto irá facilitar novos testes caso queira
   mudar o conteúdo do vetor a */
   int n = a.length;
   
   /* Declaração e alocação do vetor b, em que será escrita a saída.
   Não sabemos quantos elementos serão necessários, mas sabemos
   que n serão suficientes. O objetivo dos exercícios é mudar o
   conteúdo do vetor b. A variável m declarada a seguir também deve
   ser alterada, indicando quantos elementos de b são realmente
   importantes para a resposta. */
   
   int b [] = new int [n];
   int m = 0;
   /* A variável a seguir é usada como índice de laços. */
   int i;
   
   // Variante: modifique o programa para que, em caso de empate entre dois índices (posições), indique o maior índice (posição).
   
   int aux2;
   int vetAux [] = a;
   
   
   for (i=0; i<=n; i++){
      for(int j = 1; j <= n-1; j++){
         if (vetAux[j] < vetAux[i]){
            aux2 = vetAux[i];
            vetAux[i] = vetAux[j];
            vetAux[j] = aux2;
         }
         
      }
   }
   
   int aux3 = vetAux[0];
   int aux4;
   
   for (i = n; i <= m; i--){
      if (a[i] == aux3) {
         aux4 = i;
         break;
      }
   }

   
   /* O código abaixo mostra o resultado. Não deve ser alterado */
   String saida = "Resposta:\n";
   for (i = 0; i < m; i++)
      saida = saida + b[i] + " ";
      saida = saida + "\nFim.";
      JOptionPane.showMessageDialog(null,saida,"Lista1",
      JOptionPane.PLAIN_MESSAGE);
      
      System.exit (0);
   }
}