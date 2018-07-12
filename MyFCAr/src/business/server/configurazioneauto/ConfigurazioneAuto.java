package business.server.configurazioneauto;

import business.server.configurazione.Configurazione;

public class ConfigurazioneAuto {
	
	private Integer id;
	private Configurazione configurazione;
	
	public ConfigurazioneAuto(Configurazione config){
		configurazione = config;
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

}
