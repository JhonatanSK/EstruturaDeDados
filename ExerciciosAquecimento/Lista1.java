/* Lista1: classe para exercícios de aquecimento. */
import javax.swing.*;
public class Lista1{
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
   
   /* Coloque aqui o código necessário para resolver o problema.
   * Novas variáveis podem ser criadas, se necessário. No
   * final, b e m devem ser modificados.
   */
   
   //1) O vetor b deve se tornar uma cópia do vetor a.
   for (i = 0; i <=n; i++){
      b[i] = a[i];
   }
   System.out.println(b);
   
   //2) O vetor b deve se tornar uma cópia revertida do vetor a (a ordem dos elementos deve ser trocada).
   for (i = n; i <=m; i--){
      for (int j = 0; j <=n; j++){
         b[j] = a[i];
      }
   }
   System.out.println(b);
   
   //3) b[0] deve receber o valor do maior elemento (conteúdo) de a.
   int aux;
   
   for (i=0; i<=n; i++){
      for(int j = 1; j <= n+1; j++){
         if (a[j] > a[i]){
            aux = a[j];
         }
      }
   }
   //b[0] = aux;
   
   System.out.println(b[0]);
   
   // 4) b[0] deve receber o índice (posição) do menor elemento (conteúdo) de a. Em caso de empate, o índice indicado deve ser o menor.
   int aux2;
   
   for (i=0; i<=n; i++){
      for(int j = 1; j <= n+1; j++){
         if (a[j] > a[i]){
            aux2 = a[j];
         }
         if (a[j] == a[i]){
            
         }
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