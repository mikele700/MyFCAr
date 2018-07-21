package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.NomeOptional;
import domain.NomeSerie;
import domain.Setting;
import domain.SettingOptional;
import domain.SettingSerie;
import exception.*;

public class SettingDAO {
	protected static Map<Integer, Setting> restoredObjects= new java.util.HashMap<Integer, Setting>();

	public static List<Setting> readListConfigurazione(Integer idconfig) throws ServerError{
		List<Setting> lista = new ArrayList<Setting>();
		if(idconfig == null)
			return lista;
		Connection c = DBManager.getConnection();
		try(PreparedStatement pstat = c.prepareStatement("SELECT ID, Nome, Tipo, Valore FROM SETTINGCONFIGURAZIONI, SETTING WHERE ConfigurazioneID=? AND SettingID=ID")){
			pstat.setInt(1, idconfig);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				Setting setting;
				String tipo = new String(rs.getString("Tipo"));
				if(tipo.equals(new String("Optional")))
					setting = new SettingOptional(rs.getInt("ID"),rs.getFloat("Valore"), NomeOptional.StringToNomeOptional(rs.getString("Nome")));
				else
					setting = new SettingSerie(rs.getInt("ID"),rs.getFloat("Valore"), NomeSerie.StringToNomeSerie(rs.getString("Nome")));
				if(!restoredObjects.containsKey(setting.getId()))
					restoredObjects.put(setting.getId(), setting);
				lista.add(setting);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new ServerError("Errore di accesso ai dati.");
		} catch (DatoNonValido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			throw new ServerError("Dato di setting inconsistente.");
		}

		return lista;
	}
	
	public static List<SettingOptional> readListAuto(Integer idauto) throws ServerError{
		List<SettingOptional> lista = new ArrayList<SettingOptional>();
		if(idauto == null)
			return lista;
		Connection c = DBManager.getConnection();
		try(PreparedStatement pstat = c.prepareStatement("SELECT ID, Nome FROM OPTIONALAUTO, SETTING WHERE AutoID=? AND SettingID=ID")){
			pstat.setInt(1, idauto);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				SettingOptional setting = new SettingOptional(rs.getInt("ID"), NomeOptional.StringToNomeOptional(rs.getString("Nome")));
				if(!restoredObjects.containsKey(setting.getId()))
					restoredObjects.put(setting.getId(), (Setting)setting);
				lista.add(setting);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new ServerError("Errore di accesso ai dati.");
		} catch (DatoNonValido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			throw new ServerError("Dato di setting inconsistente.");
		}

		return lista;
	}

}
