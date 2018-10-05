package Alien.model;

import java.util.ArrayList;

public class AlienDictionary {
	private ArrayList<Word> dizionario;

	public AlienDictionary() {
		this.dizionario = new ArrayList<Word>();
	}

	public String addWord(String alienWord, String translation) {
		Word parola = new Word(alienWord, translation);
		if (dizionario.contains(parola)) {

			if (dizionario.get(dizionario.indexOf(parola)).getTranslation().equals(translation))
				return "La parola " + parola.getAlienWord() 
				+ " ha già come significato: " + parola.getTranslation();
			else {
				dizionario.set(dizionario.indexOf(parola), parola);
				return "Parola aggiornata con successo.";
			}
		} else {
			dizionario.add(parola);
			return "Nuova parola aggiunta.";
		}
	}

	public String translateWord(String alienWord) {
		Word parola = new Word(alienWord, "");
		String risposta = "";
		if (dizionario.contains(parola))
			risposta = dizionario.get(dizionario.indexOf(parola)).getTranslation();
		else
			risposta = "Parola non trovata.";
		return risposta;
	}

}
