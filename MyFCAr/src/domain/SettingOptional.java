package domain;

public class SettingOptional extends Setting {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NomeOptional nome;

	public SettingOptional(Integer id, Float v, NomeOptional n) {
		super(id, v);
		nome = n;
		// TODO Auto-generated constructor stub
	}
	
	public SettingOptional(Integer id, NomeOptional n){
		super(id);
		nome = n;
	}

	public String getNome() {
		return nome.toString();
	}

	
}
