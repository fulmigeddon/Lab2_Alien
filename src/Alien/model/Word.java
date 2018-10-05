package Alien.model;

public class Word {

	private String alienWord;
	private String translation;

	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getTranslation() {
		return translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord.toLowerCase() != null)
				return false;
		} else if (!alienWord.equalsIgnoreCase(other.alienWord))
			return false;
		return true;
	}

}
