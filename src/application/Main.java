package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;


import java.util.Scanner;

import entities.Pergunta;
import models.exceptions.ConstructionException;

public class Main {
	public static void main(String[] args) {
		String arquivo = "src\\perguntas.txt";
		Scanner sc = new Scanner(System.in);
		int n;
		String line;
		
		try (
			BufferedReader br = new BufferedReader(new FileReader(arquivo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))
			) {	
			do {			
			
				mostrarMenu();
				System.out.println();
				System.out.print("Informe uma opção: ");
				n = sc.nextInt();
				
				sc.nextLine();
				System.out.println();
				
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
						sc.nextLine();
						
						int idPergunta = 1; 

					    BufferedReader brContagem = new BufferedReader(new FileReader(arquivo));
				        String linhaContagem;
				        
				        while ((linhaContagem = brContagem.readLine()) != null) {
				            idPergunta++;
				        }
					     
						Pergunta pergunta = new Pergunta(idPergunta, textoPergunta, opcaoA, opcaoB, opcaoC,
								opcaoD, opcaoE, opcaoCorreta);
						
						bw.write(pergunta.toString());
						bw.newLine();
						bw.flush();
						
			            System.out.println("Pergunta cadastrada com sucesso!");
			            esperarInput();
						break;
					case 3:
						BufferedReader brLeitura = new BufferedReader(new FileReader(arquivo));  // Novo BufferedReader
				        String linhaLeitura = brLeitura.readLine();

				        while (linhaLeitura != null) {
				            System.out.println(linhaLeitura);
				            linhaLeitura = brLeitura.readLine();
				        }

				        esperarInput();
						break;
					case 4:
						System.out.print("Informe o ID da pergunta a ser removida: ");
						int idRemovido = sc.nextInt();
						sc.nextLine();
						
						BufferedReader brRemove = new BufferedReader(new FileReader(arquivo));
						String linhaRemovida = brRemove.readLine();

				        while (linhaRemovida != null)  {
				        	if (Integer.parseInt(linhaRemovida.substring(0, linhaRemovida.indexOf('|'))) != idRemovido) {
					            linhaRemovida = brRemove.readLine();
				        	}
				        	else {
				        		break;
				        	}
				        }
				        
				        System.out.println(linhaRemovida);
						
												
						esperarInput();
						break;
					case 5:
						esperarInput();
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
				} while (n != 6);
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
				System.out.println("Ocorreu um erro: " + e.getMessage());
			}
			catch (ConstructionException e) {
				System.out.println("Erro na construção da pergunta: " + e.getMessage());
			}
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
