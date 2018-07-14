package business.domain;

import java.io.Serializable;

public class ConfigurazioneAuto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Configurazione configurazione;
	
	public ConfigurazioneAuto(Configurazione config){
		configurazione = config;
	}
	
	public ConfigurazioneAuto(Configurazione config, Integer id){
		configurazione = config;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Configurazione getConfigurazione() {
		return configurazione;
	}
	
	public void stampaConfigurazioneAuto(){
		System.out.println("ID Auto: "+id+"\tID Configurazione: "+this.getConfigurazione().getId());
	}

}
