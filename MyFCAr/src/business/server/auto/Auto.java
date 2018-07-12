package business.server.auto;

public class Auto {
	private Integer id;
	private String VIN;
	private String targa;
	private String modello;
	
	public Auto(String v, String t, String m, Integer id){
		this.VIN = new String(v);
		this.targa = new String(t);
		this.modello = new String(m);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVIN() {
		return new String(VIN);
	}

	public String getTarga() {
		return new String(targa);
	}

	public String getModello() {
		return new String(modello);
	}
}
