package application;

public class Pracownicy {
	
	private int id_prac;
	private String imie;
	private String nazwisko;
	private String telefon;
	private String pesel;
	
	public Pracownicy() {
		
	}

	public Pracownicy(int id_prac, String imie, String nazwisko, String telefon, String pesel) {
		super();
		this.id_prac = id_prac;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.telefon = telefon;
		this.pesel = pesel;
	}

	public int getId_prac() {
		return id_prac;
	}

	public void setId_prac(int id_prac) {
		this.id_prac = id_prac;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	
}
