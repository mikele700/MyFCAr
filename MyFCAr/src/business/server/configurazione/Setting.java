package business.server.configurazione;

public abstract class Setting {

	private Integer id;
	private Float Valore;
	
	public Integer getId() {
		return id;
	}

	public Setting(Integer id){
		this.id = id;
	}
	
	public Setting(Integer id, Float v){
		this.id = id;
		Valore = v;
	}

	public Float getValore() {
		return Valore;
	}
	
}
