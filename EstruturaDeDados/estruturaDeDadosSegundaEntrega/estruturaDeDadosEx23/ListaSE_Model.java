package estruturaDeDadosEx23;

public class ListaSE_Model {
	public class NodeSE	{	
		private int	iElement;
		private NodeSE	nsNext;

		public NodeSE()	{
			iElement = 0;
			nsNext = null;
		}
		
		public NodeSE(int iE, NodeSE nsN) {
			iElement = iE;
			nsNext = nsN;
		}
		
		public NodeSE(String a) {
			iElement = nsInicio.getElement();
			nsNext = nsInicio.getNext();
		}
		
		void setNext(NodeSE nsN) {
			nsNext = nsN;
		}
		
		int getElement() {
			return iElement;
		}
		
		NodeSE getNext() {
			return nsNext;
		}
	}
	
	private NodeSE	nsInicio;
	private NodeSE	nsFim;
	private int iTamanho;
	
	public ListaSE_Model() {
		nsInicio = null;
		nsFim = null;
		iTamanho = 0;
	}
	
	public void putHead(int iI) {
		NodeSE nsNovo = new NodeSE(iI, null);
		
		if(isEmpty()) nsFim = nsNovo;
		else  nsNovo.setNext(nsInicio);
		
		nsInicio = nsNovo;
		iTamanho++;
	}
	
	public void putTail(int iI)	{
		NodeSE nsNovo = new NodeSE(iI, null);
		if(isEmpty())
			nsInicio = nsNovo;
		else
			nsFim.setNext(nsNovo);
		nsFim = nsNovo;
		iTamanho++;
	}
	
	public int takeHead() {
		int iI = -1;	
		if(!isEmpty()) {	
			iI = nsInicio.getElement();
			if(size() == 1) {
				nsInicio = null;
				nsFim = null;
			}
			else  nsInicio = nsInicio.getNext();
			iTamanho--;
		}
		return iI;
	}
	
	public int takeTail() {
		int iI = -1;
		if(!isEmpty()) {
			iI = nsFim.getElement();
			if(size() == 1)	{
				nsInicio = null;
				nsFim = null;
			}
			else {
				NodeSE nsAux = new NodeSE();
				nsAux = nsInicio;
				while(nsAux.getNext() != nsFim)	
					nsAux = nsAux.getNext();
				nsFim = nsAux;
				nsAux.setNext(null);
			}
			iTamanho--;
		}
		return iI;
	}
	
	public int viewHead(){
		int iI = -1;
		if(!isEmpty())	
			iI = nsInicio.getElement();	
		return iI;
	}
	
	public int viewTail(){
		int iI = -1;
		if(!isEmpty())	
			iI = nsFim.getElement();
		return iI;
	}
	
	public int size(){
		return iTamanho;
	}
	
	public boolean isEmpty(){
		boolean bR = false;
		if(size() == 0)
			bR = true;
		return	bR;
	}
	
	public String listElements(NodeSE next, String valores){
		if(next != null){
			valores += next.getElement() + ",";
			return listElements(next.getNext(), valores);
		}
		return valores;
	}
}