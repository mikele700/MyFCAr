package Auto;

public class Auto {

	//COSTRUTTORE
	public Auto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Auto(int id, String targa, String VIN, String modello) {
		super();
		this.id = id;
		this.targa = targa;
		this.VIN = VIN;
		this.modello = modello;
	}
	
	//ATTRIBUTI
	private int id;
	private String targa;
	private String VIN;
	private String modello;
	
	//GETTER e SETTER
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String VIN) {
		this.VIN = VIN;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	

}
