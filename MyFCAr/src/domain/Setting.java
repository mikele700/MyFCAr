package domain;

import java.io.Serializable;

public abstract class Setting implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
