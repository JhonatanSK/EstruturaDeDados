package utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utils {
	public static int[] createVet(int size) {
		int [] vetor = new int [size];
		Set<Integer> used = new HashSet<Integer>();  
		
		Random aleatorio = new Random();

		for (int i = 0; i < size; i++) {
			int newRandom;  
			do {  
				newRandom = aleatorio.nextInt(size);  
			} while (used.contains(newRandom));  
			vetor[i] = newRandom;  
			used.add(newRandom);  
		}
		return vetor;
	}
	
	public static int generateRandom(int [] vetor) {
		Random aleatorio = new Random();
		int value = aleatorio.nextInt(vetor.length);
		return vetor[value];
	}
	
	
}



 