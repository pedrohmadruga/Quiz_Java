package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Pergunta;
import models.exceptions.*;

public class Main {
	public static void main(String[] args) {
		String arquivo = "src\\perguntas.txt";
		Scanner sc = new Scanner(System.in);
		int n;
		
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
						int maxPerguntas = 0;
						BufferedReader brContador = new BufferedReader(new FileReader(arquivo));
						while ((brContador.readLine()) != null) {
				            maxPerguntas++;
				        }
						
						brContador.close();
						
						System.out.println("Iniciando o Quiz! Quantas perguntas você quer responder (Max = " + maxPerguntas + ")?");
						int quantidadePerguntas = sc.nextInt();
						sc.nextLine();
						
						if (quantidadePerguntas < 1 || quantidadePerguntas > maxPerguntas) throw new LineNotFoundException("Quantidade de perguntas inválida");
						
						BufferedReader brPerguntas = new BufferedReader(new FileReader(arquivo));
						List<Pergunta> perguntas = new ArrayList<Pergunta>();
						
						String linhaLida;
						while ((linhaLida = brPerguntas.readLine()) != null) {
							String campo[] = linhaLida.split("\\|");
							
							Pergunta pergunta = new Pergunta(Integer.parseInt(campo[0]), campo[1], campo[2], campo[3],
									campo[4], campo[5], campo[6], campo[7].charAt(0));
							
							perguntas.add(pergunta);
						}
						
						brPerguntas.close();
						Collections.shuffle(perguntas);
						
						int acertos = 0;
						for (int i = 0; i < quantidadePerguntas; i++) {
							limparTela();
							System.out.println(perguntas.get(i).getTextoPergunta());
							System.out.println("A. " + perguntas.get(i).getOpcaoA());
							System.out.println("B. " + perguntas.get(i).getOpcaoB());
							System.out.println("C. " + perguntas.get(i).getOpcaoC());
							System.out.println("D. " + perguntas.get(i).getOpcaoD());
							System.out.println("E. " + perguntas.get(i).getOpcaoE());
							
							System.out.println();
							
							char resposta = ' ';
							do {
								System.out.print("Informe a sua resposta: ");
							    String input = sc.nextLine().trim();
							    
							    if (input.isEmpty()) {
							    	/*
							    	 Isso é uma gambiarra. Não sei por que, mas a
							    	 linha de leitura está pegando algum valor no
							    	 buffer e pulando a leitura, deixando o input
							    	 vazio. Consegui resolver dessa forma, mas
							    	 pretendo achar uma solução definitiva.
							    	*/
							    	input = sc.nextLine().trim();
							        
							    }

							    resposta = Character.toUpperCase(input.charAt(0));

								
								if (!respostaValida(resposta)) {
									System.out.println("Opção inválida. Tente novamente");
								}
								
							} while (!respostaValida(resposta));
							
							if (resposta == perguntas.get(i).getRespostaCorreta()) {
								System.out.println("Parabéns! Você acertou!");
								acertos++;
								esperarInput();
							}
							else {
								System.out.println("Que pena! Você errou!");
								esperarInput();
							}	
						}
						
						limparTela();
						
						System.out.println();
						System.out.println("Fim do quiz. Você acertou " + acertos + " pergunta(s)");
						
						sc.nextLine();
						esperarInput();
						limparTela();
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
				        
				        while (brContagem.readLine() != null) {
				            idPergunta++;
				        }
					     
						Pergunta pergunta = new Pergunta(idPergunta, textoPergunta, opcaoA, opcaoB, opcaoC,
								opcaoD, opcaoE, opcaoCorreta);
						
						bw.write(pergunta.toString());
						bw.newLine();
						bw.flush();
						
						brContagem.close();
						
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
				        
				        brLeitura.close();

				        esperarInput();
						break;
					case 4:
						System.out.print("Informe o ID da pergunta a ser removida: ");
						int idRemovido = sc.nextInt();
						sc.nextLine();
						List<String> linhas = new ArrayList<>();
						boolean encontrou = false;
						
						
						BufferedReader brLer = new BufferedReader(new FileReader(arquivo));
						
						String linhaReescrita;

				        while ((linhaReescrita = brLer.readLine()) != null)  {
				        	int idLinha = Integer.parseInt(linhaReescrita.substring(0, linhaReescrita.indexOf('|')));
				        	
				        	if (idLinha < idRemovido) {
					            linhas.add(linhaReescrita);
				        	}
				        	else if (idLinha == idRemovido) {
				        		encontrou = true;
				        	}
				        	else {
				        		String novaLinha = (idLinha - 1) + linhaReescrita.substring(linhaReescrita.indexOf('|'));
				                linhas.add(novaLinha);
				        	}
				        }
				        
				        brLer.close();
				        
				        if (!encontrou) throw new LineNotFoundException("Pergunta com esse ID não existe");
				        
				        BufferedWriter bwEscrever = new BufferedWriter(new FileWriter(arquivo));
				        for (String linha:linhas) {
				        	bwEscrever.write(linha);
			                bwEscrever.newLine();
			                bwEscrever.flush();
				        }
				        
				        bwEscrever.close();
				        
				        System.out.println("Pergunta removida com sucesso!");						
						esperarInput();
						break;
					case 5:
						System.out.println("Deseja mesmo apagar todo o arquivo (s/n)? ");
						char confirmacao = sc.nextLine().charAt(0);
						
						if (confirmacao == 'n') {
							System.out.println("Operação abortada");
						}
						else {
							BufferedWriter bwApagarTudo = new BufferedWriter(new FileWriter(arquivo));
							bwApagarTudo.write("");
							bw.flush();
							System.out.println("Arquivo apagado com sucesso");
							bwApagarTudo.close();
						}
												
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
				System.out.println("Erro: ocorreu um erro desconhecido.");
			}
			catch (ConstructionException e) {
				System.out.println("Erro na construção da pergunta: " + e.getMessage());
			}
			catch (LineNotFoundException e) {
				System.out.println("Erro: " + e.getMessage());
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
			System.out.println();
			System.out.println("Aperte 'ENTER' para continuar");
			System.in.read();
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public static void limparTela() {  
		// Isso é uma gambiarra, não limpa de fato a tela, apenas imprime 10 linhas em branco
		for (int i = 0; i < 10; i++) System.out.println();
	}
	
	public static boolean respostaValida(char resposta) {
		if (resposta != 'A' && resposta != 'B' && resposta != 'C'
			&& resposta != 'D' && resposta != 'E') return false;
		return true;
	}
}
