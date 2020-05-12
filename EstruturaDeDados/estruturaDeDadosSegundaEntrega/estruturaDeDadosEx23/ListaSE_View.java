package estruturaDeDadosEx23;

import javax.swing.*;	

public class ListaSE_View {	
	private	String[]  sSN = {"Sim", "Não"};
	private	String 	sIO = "Selecione a opção desejada:";
	private	String	sExit = "Deseja sair?";

	public void	mostra(String sT, String sI) {
		JOptionPane.showMessageDialog(null, sI, sT,JOptionPane.PLAIN_MESSAGE);		
	}
	
	public int recebe(String sT, String sI) {
		String sN = JOptionPane.showInputDialog(null,sI,sT,JOptionPane.QUESTION_MESSAGE);
		int iN = Integer.parseInt(sN);
		return iN;
	}
	
	public int menu(String sT, String[] sOpc) {
		int iOpcao, iSN;
		do		{
			iOpcao = JOptionPane.showOptionDialog(	null,sIO,sT,1,JOptionPane.QUESTION_MESSAGE,null, sOpc,null	);
			if(iOpcao == sOpc.length-1) {
				iSN = JOptionPane.showOptionDialog(	null,sExit,sT,1, JOptionPane.QUESTION_MESSAGE,null,sSN,null	);
				if(iSN == 1)	iOpcao = -1;
			}
		}while(iOpcao < 0 || iOpcao > sOpc.length-1);
		return iOpcao;
	}
}