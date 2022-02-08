package application;

public class Kli {
	
	private int ID;
	private String nazwisko;
	
	public Kli(int iD, String nazwisko) {
		super();
		ID = iD;
		this.nazwisko = nazwisko;
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
	
	@Override
	public String toString() {
		return nazwisko;
	}
}
