package estruturaDeDadosEx26;

import javax.swing.JOptionPane;

import estruturaDeDadosEx26.ListaSE_Model.NodeSE;

public class ListaSE_Controller {	
	private static ListaSE_Model	lista;
	private static ListaSE_View	dspMs;
	
	private static String sC1 = "Estrutura de Dados";
	private static String sC2 = "Exercicio 26";
	private static String sM0 = "Até logo!";
	private static String sM1 = "Lista Singularmente Encadeada";
	private static String sM5 = "Lista Vazia!";
	private static String sM7 = "Cauda Removida: ";
	private static String sM11 = "Consultar Todos: ";
	private static String[] sDspMn = {	"Inserir Elementos", "Consultar Todos", "Remover um valor", "Sair"};
	
	public static void main(String Args[]) {	
		lista = new	ListaSE_Model();
		
		dspMs = new	ListaSE_View();
		dspMs.mostra(sC1, sM1);
		
		int iOpcao;
		do {
			iOpcao =  dspMs.menu(sC2, sDspMn);
			switch(iOpcao) {
				case	0:	insertElements();			break;
				case    1:  listElements();				break;
				case	2:	handleRemoveChars();		break;	
				default:	break;
			}
		}while(iOpcao != sDspMn.length-1);
		
		dspMs.mostra(sC2, sM0);
		System.exit(0);
   }
	
	public static void insertTail(String c) {	
		lista.putTail(c);
	}
	
	public static void takeTail() {
		if(lista.isEmpty())
			dspMs.mostra(sC2, sM5);
		else
			dspMs.mostra(sC2, sM7 + lista.takeTail());
	}
	
	public static String takeHead()	{
		if(lista.isEmpty())
			dspMs.mostra(sC2, sM5);	
		else
			return lista.viewHead();
		return "";
	}
	
	public static int size()	{
		if(lista.isEmpty()) {
			return 0;
		}
		return lista.size();		
	}
	
	public static void listElements() {
		NodeSE primeiroNo = null;
		int tamanho = size();
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
	
	public static void insertElements() {
		String elements = JOptionPane.showInputDialog("Digite a frase para ser inserida na lista: ");
		int tamanho = elements.length();
		for (int i = 0; i < tamanho; i++) {
			char c = elements.charAt(i);
			insertTail(String.valueOf(c));
		}
		dspMs.mostra(sC2, "Caracteres inseridos na lista");	
	}
	
	static void removeCharacters(NodeSE prevNode, NodeSE primeiroNo) {
		if (lista.isEmpty()) dspMs.mostra(sC2, sM5);
		else {
			char c = JOptionPane.showInputDialog("Digite a a letra para ser removida da lista: ").charAt(0);
			//primeiroNo = lista.new NodeSE(" ");
			String resultado = lista.listElements(primeiroNo,"");
			resultado = resultado.substring(0, resultado.length()-1);
			
			if (!resultado.contains(String.valueOf(c))) {
				dspMs.mostra(sC2, "Sua lista não contém o caracter informado!");
			} else {
				//prevNode = lista.new NodeSE();
				
				prevNode.setNext(lista.new NodeSE(" "));
				
				String allNodesRem = removeChar("", c, prevNode, lista.new NodeSE(" "));
				dspMs.mostra(sC2, "Resultado da frase após a remoção do caracter informado:\n\n" + allNodesRem);
			}
		}
	}

	static String removeChar(String allNodes, char c, NodeSE prev, NodeSE next) {
		String valor = Character.toString(c);
		if (next != null) {
			if (valor.equals(next.getElement())) {
				prev.setNext(next.getNext());
				if(next.getNext() != null) {
					allNodes += next.getNext().getElement() + ",";
					return removeChar(allNodes, c, prev.getNext(), next.getNext().getNext());					
				}
			} else {
				allNodes += next.getElement() + ",";
				return removeChar(allNodes, c, prev.getNext(), next.getNext());
			}
		}
		return allNodes;
	}
	
	public static void handleRemoveChars () {
		removeCharacters(lista.new NodeSE(),lista.new NodeSE(" "));
	}
}
