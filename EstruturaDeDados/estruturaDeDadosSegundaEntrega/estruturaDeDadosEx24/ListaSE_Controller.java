package estruturaDeDadosEx24;

import estruturaDeDadosEx24.ListaSE_Model.NodeSE;

public class ListaSE_Controller {	
	private static ListaSE_Model	lista;
	private static ListaSE_View	dspMs;
	
	private static String sC1 = "Estrutura de Dados";
	private static String sC2 = "Exercicio 24";
	private static String sM0 = "Até logo!";
	private static String sM1 = "Lista Singularmente Encadeada";
	private static String sM2 = "Digite o elemento do nó:";
	private static String sM4 = "Inserção da Cauda com sucesso!";
	private static String sM5 = "Lista Vazia!";
	private static String sM7 = "Cauda Removida: ";
	private static String sM11 = "Consultar Todos: ";
	private static String[] sDspMn = {	"Inserir", "Consultar Todos", "Remover(Cauda)", "Sair"};
	
	public static void main(String Args[]) {	
		lista = new	ListaSE_Model();
		
		dspMs = new	ListaSE_View();
		dspMs.mostra(sC1, sM1);
		
		int iOpcao;
		do {
			iOpcao =  dspMs.menu(sC2, sDspMn);
			switch(iOpcao) {
				case	0:	inserirCauda();					break;
				case    1:  listElements();					break;
				case	2:	removerCauda();					break;	
				default:	break;
			}
		}while(iOpcao != sDspMn.length-1);
		
		dspMs.mostra(sC2, sM0);
		System.exit(0);
   }
	
	public static void inserirCauda() {	
		lista.putTail(dspMs.recebe(sC2, sM2));
		dspMs.mostra(sC2, sM4);	
	}
	
	public static void removerCauda() {
		if(lista.isEmpty())
			dspMs.mostra(sC2, sM5);
		else
			dspMs.mostra(sC2, sM7 + lista.takeTail());
	}
	
	public static String pegarCabeca()	{
		if(lista.isEmpty())
			dspMs.mostra(sC2, sM5);	
		else
			return lista.viewHead();
		return "";
	}
	
	public static int tamanho()	{
		if(lista.isEmpty()) {
			return 0;
		}
		return lista.size();		
	}
	
	public static void listElements() {
		NodeSE primeiroNo = null;
		int tamanho = tamanho();
		if(lista.isEmpty())	dspMs.mostra(sC2, sM5);
		else {
			if(tamanho > 1) {
				primeiroNo = lista.new NodeSE(" ");
				String resultado = lista.listElements(primeiroNo,"");
				resultado = resultado.substring(0, resultado.length()-1);
				dspMs.mostra(sC2, sM11 + resultado);							
			}
			else {
				dspMs.mostra(sC2, sM11 + lista.viewHead());
			}
		}
	}
}
