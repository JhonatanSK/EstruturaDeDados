package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

import model.BinaryTree;
import model.ListaDuplamenteEncadeada;
import model.NoDuplamenteEncadeado;
import utils.Log;
import utils.Utils;


public class ConfrontoDoisMetodos {
	public static void main (String [] args) {
		int size = 1000;
		int vetor [] = Utils.createVet(size);
		
		ListaDuplamenteEncadeada list = new ListaDuplamenteEncadeada();
		
		BinaryTree tree = new BinaryTree();
		
		for(int i = 0; i < size; i++) {
			list.insertEnd(vetor[i]);
			tree.insertNode(vetor[i]);
		}
		
		NoDuplamenteEncadeado head = list.getHead();
		
		for(int i = 0; i < 100; i++) {
			int key = Utils.generateRandom(vetor);

			long start = System.nanoTime();
			
			tree.showNode(key);
			
			long end = System.nanoTime();
			long microseconds = (end - start) / 1000;
			
			long start2 = System.nanoTime();
			
			list.searchElement(head, key);
	
			long end2 = System.nanoTime();
			long microseconds2 = (end2 - start2) / 1000;

			String result = "Tree: ;" + microseconds + ";List: ;"+microseconds2;
			
			
			String logDirectory = System.getProperty("user.dir");
			if (!Files.exists(Paths.get(logDirectory), LinkOption.NOFOLLOW_LINKS)) new File(logDirectory).mkdir();
			
			synchronized (result) {
				try {
					Log arqLog = new Log();
					arqLog.abrir(logDirectory + File.separator + "src/resultado" + File.separator + Log.NOME);
					arqLog.escrever(result);
					arqLog.fechar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
