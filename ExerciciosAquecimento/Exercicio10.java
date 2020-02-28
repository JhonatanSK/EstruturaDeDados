/* Lista1: classe para exerc�cios de aquecimento. */
import javax.swing.*;

public class Exercicio10{
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
   
   // 10) b[0] deve receber o maior elemento de A que seja inferior a 50 (se n�o houver n�meros inferiores a 50, a resposta deve ser 0).
   // Considere que nunca haver� elementos negativos em a.
   

   int cont = 0;
   int contAux = 0;
   
   for (i = 0; i < n; i++) {
      if (a[i] >=0 && a[i] <= 50) {
         cont++;
         
      }
      contAux = cont;
      
   }    
      
   int aux2 = 0;
   int vetAux [] = new int [n];
   
   for (i=0; i < n; i++){
      vetAux[i] = a[i];
   }
   
   int vetAux2 [] = new int [contAux];   
   
   
   for (i=0; i<n; i++){
      for(int j = 1; j < n; j++){
         if (vetAux[j] > vetAux[i]){
            aux2 = vetAux[i];
            vetAux[i] = vetAux[j];
            vetAux[j] = aux2;
         }
         
      }
   }
   
   int cont1 = 0;
   
   for (i = 0; i < n; i++){
      if (vetAux[i] <=50) {
         vetAux2[cont1] = vetAux[i];
         cont1++;
      }
   }
   
   if (cont == 0){
      b[0] = 0;
   }
   else if (cont > 0) {
      b[0] = vetAux2[contAux];
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

//Finalizado