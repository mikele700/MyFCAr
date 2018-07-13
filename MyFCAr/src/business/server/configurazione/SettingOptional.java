package business.server.configurazione;

public class SettingOptional extends Setting {
	
	private NomeOptional nome;

	public SettingOptional(Integer id, Float v, NomeOptional n) {
		super(id, v);
		nome = n;
		// TODO Auto-generated constructor stub
	}

	public NomeOptional getNome() {
		return nome;
	}

	
}
