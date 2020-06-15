

import java.util.Scanner;

public class placar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a quantidade de partidas: ");
		int qtd = sc.nextInt();
		while(qtd < 0) {
			System.out.println("A quantidade deve ser maior que 0: ");
			System.out.print("Digite a quantidade de partidas: ");
			qtd = sc.nextInt();
		}
		//sc.close();
		String [] vetor = new String[qtd];
		for(int i = 0; i < qtd; i++) {
			int casa, visitante, total;
			do {
				//Scanner sc1 = new Scanner(System.in);
				System.out.print("Digite o resultado da partida: ");
				String partida = sc.nextLine();
				
				String vetor1[] = partida.split(" ");
				casa = Integer.parseInt(vetor1[0]);
				visitante = Integer.parseInt(vetor1[1]);
				
				total = casa + visitante;	
				if(casa > 0 && visitante > 0) {
					vetor[i] = result(casa, visitante, total);
				}
				//sc1.close();
			}while(casa > 0 && visitante > 0);
		}
		
		sc.close();
		for(int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
	}
	public static String result(int casa, int visitante, int total) {
		if(total == 4 && casa == visitante) return "sem graça";
		else if(total == 6 && casa == visitante) return "emocionante";
		else if(casa > (visitante + 3) || visitante > (casa + 3)) return "goleada";
		return "normal";
		
	}

}
