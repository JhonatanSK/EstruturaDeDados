import java.util.Scanner;

public class soma {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o numero de alunos: ");
		String valor = sc.nextLine();
		sc.close();
		String vetor[] = valor.split(" ");
		int resultado = 0;
		for(String x: vetor) {
			resultado += Integer.parseInt(x);
		}
		System.out.print(resultado);

	}

}
