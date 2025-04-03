package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import entities.Pergunta;

public class Main {
	public static void main(String[] args) {
		String path = "src\\perguntas.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
