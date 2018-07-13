package business.server.auto;

import business.server.configurazioneauto.ConfigurazioneAuto;

public class Auto {
	private Integer id;
	private String VIN;
	private String targa;
	private String modello;
	private ConfigurazioneAuto confAssociata;
	
	public Auto(Integer id, String v, String t, String m){
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
	
	public ConfigurazioneAuto getConfigurazioneAuto() {
		return confAssociata;
	}

	public void setConfigurazioneAuto(ConfigurazioneAuto confAssociata) {
		this.confAssociata = confAssociata;
	}
	
}
