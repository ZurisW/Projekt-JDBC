package application;

public class Samochody {
	
	private int id_sam;
	private String nr_rej;
	private String marka;
	private String model;
	private int rok_prod;
	private String kraj_prod;
	private int poj_sil;
	private int koszt_dnia;
	
	public Samochody() {
		
	}

	public Samochody(int id_sam, String nr_rej, String marka, String model, int rok_prod, String kraj_prod, int poj_sil,
			int koszt_dnia) {
		super();
		this.id_sam = id_sam;
		this.nr_rej = nr_rej;
		this.marka = marka;
		this.model = model;
		this.rok_prod = rok_prod;
		this.kraj_prod = kraj_prod;
		this.poj_sil = poj_sil;
		this.koszt_dnia = koszt_dnia;
	}

	public int getId_sam() {
		return id_sam;
	}

	public void setId_sam(int id_sam) {
		this.id_sam = id_sam;
	}

	public String getNr_rej() {
		return nr_rej;
	}

	public void setNr_rej(String nr_rej) {
		this.nr_rej = nr_rej;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRok_prod() {
		return rok_prod;
	}

	public void setRok_prod(int rok_prod) {
		this.rok_prod = rok_prod;
	}

	public String getKraj_prod() {
		return kraj_prod;
	}

	public void setKraj_prod(String kraj_prod) {
		this.kraj_prod = kraj_prod;
	}

	public int getPoj_sil() {
		return poj_sil;
	}

	public void setPoj_sil(int poj_sil) {
		this.poj_sil = poj_sil;
	}

	public int getKoszt_dnia() {
		return koszt_dnia;
	}

	public void setKoszt_dnia(int koszt_dnia) {
		this.koszt_dnia = koszt_dnia;
	}
	
	
}
