package application;

public class Sam {
	
	private int ID;
	private String model;
	
	public Sam(int iD, String model) {
		super();
		ID = iD;
		this.model = model;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
	    return this.getModel();
	}
}