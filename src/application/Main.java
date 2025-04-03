package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;


import java.util.Scanner;

import entities.Pergunta;
import models.exceptions.ConstructionException;

public class Main {
	public static void main(String[] args) {
		String path = "src\\perguntas.txt";
		Scanner sc = new Scanner(System.in);
		int n;
		String line;
		
		do {
			mostrarMenu();
			System.out.println();
			System.out.print("Informe uma opção: ");
			n = sc.nextInt();
			
			sc.nextLine();
			System.out.println();
			
			try (
				BufferedReader br = new BufferedReader(new FileReader(path));
				BufferedWriter bw = new BufferedWriter(new FileWriter(path))
				) {
				switch(n) {
					case 1:
						break;
					case 2:
						System.out.println("Informe o texto da pergunta: ");
						String textoPergunta = sc.nextLine();
						
						System.out.println("Informe a opção A da pergunta: ");
						String opcaoA = sc.nextLine();
						
						System.out.println("Informe a opção B da pergunta: ");
						String opcaoB = sc.nextLine();
						
						System.out.println("Informe a opção C da pergunta: ");
						String opcaoC = sc.nextLine();
						
						System.out.println("Informe a opção D da pergunta: ");
						String opcaoD = sc.nextLine();
						
						System.out.println("Informe a opção E da pergunta: ");
						String opcaoE = sc.nextLine();
						
						System.out.println("Por fim, informe qual é a alternativa correta (A, B, C, D, E): ");
						char opcaoCorreta = sc.next().charAt(0);
						
						
						line = br.readLine();
						int i = 0;
						
						while (line != null) {
							i++;
							line = br.readLine();
							}
						
						Pergunta pergunta = new Pergunta(i+1, textoPergunta, opcaoA, opcaoB, opcaoC,
								opcaoD, opcaoE, opcaoCorreta);
						
						System.out.println();
						System.out.println(pergunta);
						
						break;
					case 3:
						line = br.readLine();
						
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
						System.out.println("Encerrando aplicação. Obrigado por jogar!");
						
						sc.close();
						bw.close();
						br.close();
						
						System.exit(0);
					default:
						System.out.println("Erro: informe uma opção válida");
						System.out.println();
						break;
					}
			}
			catch (FileNotFoundException e) {
				System.out.println("Erro: Arquivo não encontrado");
			}
			catch (IOException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			catch (InputMismatchException e) {
				System.out.println("Erro: entrada não foi do tipo esperado");
			}
			catch (RuntimeException e) {
				System.out.println("Ocorreu um erro desconhecido");
			}
			catch (ConstructionException e) {
				System.out.println("Erro na construção da pergunta: " + e.getMessage());
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
	
	public static void esperarInput() {
		try {
			System.out.println("Aperte 'ENTER' para continuar");
			System.in.read();
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}
}
