package entities;

public class Pergunta {
	private int ID;
	private String textoPergunta;
	private String opcaoA;
	private String opcaoB;
	private String opcaoC;
	private String opcaoD;
	private String opcaoE;
	private char respostaCorreta;
	
	public Pergunta() {
	}

	public Pergunta(int ID, String textoPergunta, String opcaoA, String opcaoB, String opcaoC, String opcaoD,
			String opcaoE, char respostaCorreta) {
		this.ID = ID;
		this.textoPergunta = textoPergunta;
		this.opcaoA = opcaoA;
		this.opcaoB = opcaoB;
		this.opcaoC = opcaoC;
		this.opcaoD = opcaoD;
		this.opcaoE = opcaoE;
		this.respostaCorreta = respostaCorreta;
	}

	public int getID() {
		return ID;
	}

	public String getTexto_pergunta() {
		return textoPergunta;
	}

	public String getOpcao_A() {
		return opcaoA;
	}

	public String getOpcao_B() {
		return opcaoB;
	}

	public String getOpcao_C() {
		return opcaoC;
	}

	public String getOpcao_D() {
		return opcaoD;
	}

	public String getOpcao_E() {
		return opcaoE;
	}

	public char getRespostaCorreta() {
		return respostaCorreta;
	}
	
	public String toString() {
        return ID + "|" + textoPergunta + "|" + opcaoA + "|" + opcaoB + "|" + opcaoC + "|" + opcaoD + "|" + opcaoE + "|" + respostaCorreta;
    }
}
