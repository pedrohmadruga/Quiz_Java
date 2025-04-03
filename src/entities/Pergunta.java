package entities;

public class Pergunta {
	private int ID;
	private String texto_pergunta;
	private String opcao_A;
	private String opcao_B;
	private String opcao_C;
	private String opcao_D;
	private String opcao_E;
	private char respostaCorreta;
	
	public Pergunta() {
	}

	public Pergunta(int ID, String texto_pergunta, String opcao_A, String opcao_B, String opcao_C, String opcao_D,
			String opcao_E, char respostaCorreta) {
		this.ID = ID;
		this.texto_pergunta = texto_pergunta;
		this.opcao_A = opcao_A;
		this.opcao_B = opcao_B;
		this.opcao_C = opcao_C;
		this.opcao_D = opcao_D;
		this.opcao_E = opcao_E;
		this.respostaCorreta = respostaCorreta;
	}

	public int getID() {
		return ID;
	}

	public String getTexto_pergunta() {
		return texto_pergunta;
	}

	public String getOpcao_A() {
		return opcao_A;
	}

	public String getOpcao_B() {
		return opcao_B;
	}

	public String getOpcao_C() {
		return opcao_C;
	}

	public String getOpcao_D() {
		return opcao_D;
	}

	public String getOpcao_E() {
		return opcao_E;
	}

	public char getRespostaCorreta() {
		return respostaCorreta;
	}	
}
