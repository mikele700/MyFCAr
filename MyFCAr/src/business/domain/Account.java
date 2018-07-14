package business.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6420897393005764896L;
	private Integer id;
	private String email;
	private String password;
	private List<Auto> ParcoAuto;
	private List<Configurazione> ListaConfigurazioni;
	private List<ConfigurazioneAuto> ListaConfigurazioniAuto;
	
	public Account(Integer id, String e, String pw){
		this.id =id;
		email = e;
		password = pw;
		ParcoAuto = new ArrayList<Auto>();
		ListaConfigurazioni = new ArrayList<Configurazione>();
		ListaConfigurazioniAuto = new ArrayList<ConfigurazioneAuto>();
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void aggiungiAuto(Auto a){
		ParcoAuto.add(a);
	}
	
	public void aggiungiConfigurazione(Configurazione c){
		ListaConfigurazioni.add(c);
	}
	
	public void aggiungiConfigurazioneAuto(ConfigurazioneAuto ca){
		ListaConfigurazioniAuto.add(ca);
	}
	
	public List<Configurazione> getAllConfigurazione(){
		return new ArrayList<Configurazione>(ListaConfigurazioni);
		
	}
	
	public List<Auto> getAllAuto(){
		return new ArrayList<Auto>(ParcoAuto);
		
	}
	
	public List<ConfigurazioneAuto> getAllConfigurazioneAuto(){
		return new ArrayList<ConfigurazioneAuto>(ListaConfigurazioniAuto);
		
	}
	
	public Auto getAuto(Integer id){
		for (Iterator<Auto> iterator = ParcoAuto.iterator(); iterator.hasNext();) {
			Auto at = iterator.next();
			if(at.getId()==id)
				return at;
		}
		return null;
	}
	
	public Configurazione getConfigurazione(Integer id){
		for (Iterator<Configurazione> iterator = ListaConfigurazioni.iterator(); iterator.hasNext();) {
			Configurazione c = iterator.next();
			if(c.getId()==id)
				return c;
		}
		return null;
	}
	
	public boolean cercaConfigurazioneAuto(Integer id){
		for (Iterator<ConfigurazioneAuto> iterator = ListaConfigurazioniAuto.iterator(); iterator.hasNext();) {
			ConfigurazioneAuto c = iterator.next();
			if(c.getId()==id)
				return true;
		}
		return false;
	}

	public void setParcoAuto(List<Auto> parcoAuto) {
		ParcoAuto = parcoAuto;
	}

	public void setListaConfigurazioni(List<Configurazione> listaConfigurazioni) {
		ListaConfigurazioni = listaConfigurazioni;
	}

	public void setListaConfigurazioniAuto(List<ConfigurazioneAuto> listaConfigurazioniAuto) {
		ListaConfigurazioniAuto = listaConfigurazioniAuto;
	}
	
	public void stampaAccount(){
		System.out.println("ID: "+id+"\tEmail: "+email+"\tPassword: "+password);
		System.out.println("PARCO AUTO");
		for (Iterator<Auto> iterator = ParcoAuto.iterator(); iterator.hasNext();) {
			Auto a = iterator.next();
			a.stampaAuto();
			if(this.cercaConfigurazioneAuto(a.getId()))
				System.out.println("Configurazione associata: "+a.getConfigurazioneAuto().getConfigurazione().getId());
		}
		for (Iterator<Configurazione> iterator = ListaConfigurazioni.iterator(); iterator.hasNext();) {
			Configurazione c = iterator.next();
			c.stampaConfigurazione();
		}
	}
	

}
