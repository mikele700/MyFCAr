package business.domain;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Configurazione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private List<Setting> setting;
	
	public Configurazione(Integer id, List<Setting> s){
		this.id = id;
		setting = s;
	}

	public Integer getId() {
		return id;
	}

	public List<Setting> getSetting() {
		return setting;
	}
	
	public void stampaSetting(){
		for (Iterator<Setting> iterator = setting.iterator(); iterator.hasNext();) {
			Setting s = iterator.next();
			if(s instanceof SettingOptional)
				System.out.println("ID Setting "+s.getId()+"\tNome "+((SettingOptional)s).getNome()+"\tValore "+s.getValore());
			else
				System.out.println("ID Setting "+s.getId()+"\tNome "+((SettingSerie)s).getNome()+"\tValore "+s.getValore());
		}
	}
	
	public void stampaConfigurazione(){
		System.out.println("ID Configurazione "+id);
		this.stampaSetting();
	}

}
