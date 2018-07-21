package domain;

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
		return ListaConfigurazioni;
		
	}
	
	public List<Auto> getAllAuto(){
		return ParcoAuto;
		
	}
	
	public List<ConfigurazioneAuto> getAllConfigurazioneAuto(){
		return ListaConfigurazioniAuto;
		
	}
	
	public Auto getAuto(Integer id){
		for (Iterator<Auto> iterator = ParcoAuto.iterator(); iterator.hasNext();) {
			Auto at = iterator.next();
			if(at.getId().equals(id))
				return at;
		}
		return null;
	}
	
	public Configurazione getConfigurazione(Integer id){
		for (Iterator<Configurazione> iterator = ListaConfigurazioni.iterator(); iterator.hasNext();) {
			Configurazione c = iterator.next();
			if(c.getId().equals(id))
				return c;
		}
		return null;
	}
	
	public ConfigurazioneAuto getConfigurazioneAuto(Auto a){
		for (Iterator<ConfigurazioneAuto> iterator = ListaConfigurazioniAuto.iterator(); iterator.hasNext();) {
			ConfigurazioneAuto c = iterator.next();
			if(c.getId().equals(a.getId()))
				return c;
		}
		return null;
	}
	
	public void rimuoviConfigurazioneAuto(ConfigurazioneAuto ca){
		ListaConfigurazioniAuto.remove(ca);
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
		System.out.println("\nPARCO AUTO");
		for (Iterator<Auto> iterator = ParcoAuto.iterator(); iterator.hasNext();) {
			Auto a = iterator.next();
			a.stampaAuto();
		}
		System.out.println("\nCONFIGURAZIONI");
		for (Iterator<Configurazione> iterator = ListaConfigurazioni.iterator(); iterator.hasNext();) {
			Configurazione c = iterator.next();
			c.stampaConfigurazione();
		}
		System.out.println("\nASSOCIAZIONI");
		for (Iterator<ConfigurazioneAuto> iterator = ListaConfigurazioniAuto.iterator(); iterator.hasNext();) {
			ConfigurazioneAuto ca = iterator.next();
			ca.stampaConfigurazioneAuto();
		}
	}
	

}
