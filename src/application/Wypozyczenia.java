package application;

import java.util.Date;

public class Wypozyczenia {

	private int id_wyp;
	private String samochod;
	private String pracownik;
	private String pracownikImie;
	private String klient;
	private String klientImie;
	private Date data_wyp;
	private Date data_zwr;
	private int koszt;
	
	public Wypozyczenia() {
		
	}

	public Wypozyczenia(int id_wyp, String samochod, String pracownik, String pracownikImie, String klient,
			String klientImie, Date data_wyp, Date data_zwr, int koszt) {
		super();
		this.id_wyp = id_wyp;
		this.samochod = samochod;
		this.pracownik = pracownik;
		this.pracownikImie = pracownikImie;
		this.klient = klient;
		this.klientImie = klientImie;
		this.data_wyp = data_wyp;
		this.data_zwr = data_zwr;
		this.koszt = koszt;
	}

	public int getId_wyp() {
		return id_wyp;
	}

	public void setId_wyp(int id_wyp) {
		this.id_wyp = id_wyp;
	}

	public String getSamochod() {
		return samochod;
	}

	public void setSamochod(String samochod) {
		this.samochod = samochod;
	}

	public String getPracownik() {
		return pracownik;
	}

	public void setPracownik(String pracownik) {
		this.pracownik = pracownik;
	}

	public String getPracownikImie() {
		return pracownikImie;
	}

	public void setPracownikImie(String pracownikImie) {
		this.pracownikImie = pracownikImie;
	}

	public String getKlient() {
		return klient;
	}

	public void setKlient(String klient) {
		this.klient = klient;
	}

	public String getKlientImie() {
		return klientImie;
	}

	public void setKlientImie(String klientImie) {
		this.klientImie = klientImie;
	}

	public Date getData_wyp() {
		return data_wyp;
	}

	public void setData_wyp(Date data_wyp) {
		this.data_wyp = data_wyp;
	}

	public Date getData_zwr() {
		return data_zwr;
	}

	public void setData_zwr(Date data_zwr) {
		this.data_zwr = data_zwr;
	}

	public int getKoszt() {
		return koszt;
	}

	public void setKoszt(int koszt) {
		this.koszt = koszt;
	}
	
}
