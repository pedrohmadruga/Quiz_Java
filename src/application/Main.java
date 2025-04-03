package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

import entities.Pergunta;

public class Main {
	public static void main(String[] args) {
		String path = "src\\perguntas.txt";
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			mostrarMenu();
			System.out.println();
			System.out.print("Informe uma opção: ");
			n = sc.nextInt();
			
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				switch(n) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						String line = br.readLine();
						
						while (line != null) {
							System.out.println(line);
							line = br.readLine();
							}
						
						esperarInput();
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						System.out.println();
						System.out.println("Encerrando aplicação. Obrigado por jogar!");
						System.exit(0);
						break;
					default:
						System.out.println("Erro: informe uma opção válida");
						System.out.println();
						break;
					}
			}
			catch (FileNotFoundException e) {
				System.out.println("Arquivo não encontrado");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		} while (n != 6);
	}
	
	public static void mostrarMenu() {
		System.out.println("1. Começar o quiz");
		System.out.println("2. Cadastrar pergunta nova");
		System.out.println("3. Ver perguntas cadastradas");
		System.out.println("4. Remover uma pergunta do arquivo");
		System.out.println("5. Apagar todo o arquivo");
		System.out.println("6. Sair da aplicação");
	}
	
	public static void esperarInput() throws IOException {
		System.out.println("Aperte 'ENTER' para continuar");
		System.in.read();
	}
}
