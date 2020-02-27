/* Lista1: classe para exerc�cios de aquecimento. */
import javax.swing.*;
public class Lista1{
   public static void main ( String args [] ){
   /* Vetor de "entrada", que j� � alocado e inicializado.
   Neste caso, o new � dispensado, pois o compilador j�
   deduz o n�mero de posi��es que devem ser alocadas. */
   int a[] = {32,45,89,66,12,35,10,96,38,15,13,11,65,81,35,64,16,89,54,19};
   
   /* A vari�vel n conter� sempre o tamanho do vetor a.
   Isto ir� facilitar novos testes caso queira
   mudar o conte�do do vetor a */
   int n = a.length;
   
   /* Declara��o e aloca��o do vetor b, em que ser� escrita a sa�da.
   N�o sabemos quantos elementos ser�o necess�rios, mas sabemos
   que n ser�o suficientes. O objetivo dos exerc�cios � mudar o
   conte�do do vetor b. A vari�vel m declarada a seguir tamb�m deve
   ser alterada, indicando quantos elementos de b s�o realmente
   importantes para a resposta. */
   
   int b [] = new int [n];
   int m = 0;
   
   /* A vari�vel a seguir � usada como �ndice de la�os. */
   int i;
   
   /* Coloque aqui o c�digo necess�rio para resolver o problema.
   * Novas vari�veis podem ser criadas, se necess�rio. No
   * final, b e m devem ser modificados.
   */
   
   //1) O vetor b deve se tornar uma c�pia do vetor a.
   for (i = 0; i <=n; i++){
      b[i] = a[i];
   }
   System.out.println(b);
   
   //2) O vetor b deve se tornar uma c�pia revertida do vetor a (a ordem dos elementos deve ser trocada).
   for (i = n; i <=m; i--){
      for (int j = 0; j <=n; j++){
         b[j] = a[i];
      }
   }
   System.out.println(b);
   
   //3) b[0] deve receber o valor do maior elemento (conte�do) de a.
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
   
   // 4) b[0] deve receber o �ndice (posi��o) do menor elemento (conte�do) de a. Em caso de empate, o �ndice indicado deve ser o menor.
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
   
   /* O c�digo abaixo mostra o resultado. N�o deve ser alterado */
   
   String saida = "Resposta:\n";
   
   for (i = 0; i < m; i++)
      saida = saida + b[i] + " ";
      saida = saida + "\nFim.";
      JOptionPane.showMessageDialog(null,saida,"Lista1",
      JOptionPane.PLAIN_MESSAGE);
      
      System.exit (0);
   }
}