package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import business.domain.Account;
import business.domain.Auto;

public class AutoDAO {
	
	protected static Map<Integer, Auto> restoredObjects= new java.util.HashMap<Integer, Auto>();

	public static List<Auto> readList(Account ac){
		List<Auto> lista = new ArrayList<Auto>();
		Connection c = DBManager.getConnection();
		try(PreparedStatement pstat = c.prepareStatement("SELECT ID, VIN, Targa, Modello FROM AUTO, ACCOUNTAUTO WHERE AccountID=? AND AutoID=ID")){
			pstat.setInt(1, ac.getId());
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				Auto at = new Auto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), SettingDAO.readListAuto(rs.getInt(1)));
				if(!restoredObjects.containsKey(at.getId()))
					restoredObjects.put(at.getId(), at);
				lista.add(at);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return lista;
	}

}
