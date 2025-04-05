package entities;

import models.exceptions.ConstructionException;

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
			String opcaoE, char respostaCorreta) throws ConstructionException {
		this.ID = ID;
		this.textoPergunta = textoPergunta;
		this.opcaoA = opcaoA;
		this.opcaoB = opcaoB;
		this.opcaoC = opcaoC;
		this.opcaoD = opcaoD;
		this.opcaoE = opcaoE;
		this.respostaCorreta = Character.toUpperCase(respostaCorreta);
		
		
		if (this.respostaCorreta != 'A' && this.respostaCorreta != 'B' && this.respostaCorreta != 'C'
				&& this.respostaCorreta != 'D' && this.respostaCorreta != 'E') {
			throw new ConstructionException("Essa opção de resposta não é válida");
		}
	}

	public int getID() {
		return ID;
	}

	public String getTextoPergunta() {
		return textoPergunta;
	}

	public String getOpcaoA() {
		return opcaoA;
	}

	public String getOpcaoB() {
		return opcaoB;
	}

	public String getOpcaoC() {
		return opcaoC;
	}

	public String getOpcaoD() {
		return opcaoD;
	}

	public String getOpcaoE() {
		return opcaoE;
	}

	public char getRespostaCorreta() {
		return respostaCorreta;
	}
	
	public String toString() {
        return ID + "|" + textoPergunta + "|" + opcaoA + "|" + opcaoB + "|" + opcaoC + "|" + opcaoD + "|" + opcaoE + "|" + respostaCorreta;
    }
}
