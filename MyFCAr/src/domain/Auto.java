package domain;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Auto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String VIN;
	private String targa;
	private String modello;
	private ConfigurazioneAuto confAssociata;
	private List<SettingOptional> optional;
	
	public Auto(Integer id, String v, String t, String m, List<SettingOptional> so){
		this.VIN = new String(v);
		this.targa = new String(t);
		this.modello = new String(m);
		this.id = id;
		optional = so;
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

	public List<SettingOptional> getOptional() {
		return optional;
	}
	
	public void stampaOptional(){
		for (Iterator<SettingOptional> iterator = optional.iterator(); iterator.hasNext();) {
			SettingOptional s = iterator.next();
			System.out.println("ID Setting "+s.getId()+"\tNome "+s.getNome());
		}
	}
	
	public void stampaAuto(){
		System.out.println("ID Auto: "+id+"\tVIN: "+VIN+"\tTarga: "+targa+"\tModello: "+modello);
		this.stampaOptional();
	}
	
}
