package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

import entity.Pais;
import util.MySqlConnexion;

public class PaisModel {
	private static Logger log = Logger.getLogger(PaisModel.class.getName());
	
	public ArrayList<Pais> listaPais(){
		ArrayList<Pais> listaP = new ArrayList<Pais>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySqlConnexion.getConexion();
			
			String sql = "select * from Pais";
			pst = con.prepareStatement(sql);
			
			log.info(">>>> " + pst);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Pais p = new Pais();
				p.setIdpais(rs.getInt(1));
				p.setNombrepais(rs.getString(2));
				
				listaP.add(p);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e2) {}
		}
		
		return listaP;
	}
}
