package application;

public class Kli {
	
	private int ID;
	private String nazwisko;
	private String imie;
	
	public Kli(int iD, String nazwisko, String imie) {
		super();
		ID = iD;
		this.nazwisko = nazwisko;
		this.imie = imie;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	@Override
	public String toString() {
		return getNazwisko()+" "+getImie();
	}
}
