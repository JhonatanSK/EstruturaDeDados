/* Lista1: classe para exerc�cios de aquecimento. */
import javax.swing.*;

public class Exercicio8{
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
   
   //8) b[0] deve receber a m�dia aritm�tica dos elementos de a (arredondada para baixo).
   int aux = 0;
   
   for (i = 0; i <n; i++){
      aux += a[i];
   }
   int aux2 = aux/n;
   
   int valorFinal = (int) Math.floor(aux2); 
   
   b[0] = valorFinal;
      
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