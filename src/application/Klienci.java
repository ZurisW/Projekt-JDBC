package application;

public class Klienci {
	
	private int id_kli;
	private String nazwisko;
	private String imie;
	private String nr_dowodu;
	private String miejscowosc;
	private String ulica;
	
	public Klienci() {
		
	}

	public Klienci(int id_kli, String nazwisko, String imie, String nr_dowodu, String miejscowosc, String ulica) {
		super();
		this.id_kli = id_kli;
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.nr_dowodu = nr_dowodu;
		this.miejscowosc = miejscowosc;
		this.ulica = ulica;
	}

	public int getId_kli() {
		return id_kli;
	}

	public void setId_kli(int id_kli) {
		this.id_kli = id_kli;
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

	public String getNr_dowodu() {
		return nr_dowodu;
	}

	public void setNr_dowodu(String nr_dowodu) {
		this.nr_dowodu = nr_dowodu;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	
}
