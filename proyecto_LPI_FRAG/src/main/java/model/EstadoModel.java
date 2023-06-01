package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

import entity.Estado;
import util.MySqlConnexion;

public class EstadoModel {
	private static Logger log = Logger.getLogger(EstadoModel.class.getName());
	
	public ArrayList<Estado> listaEstado(){
		ArrayList<Estado> listaE = new ArrayList<Estado>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		 
		try {
			con = MySqlConnexion.getConexion();
			
			String sql = "select * from Estado" ;
			pst = con.prepareStatement(sql);
			
			log.info(">>>> " + pst);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Estado e = new Estado();
				e.setIdestado(rs.getInt(1));
				e.setEstado(rs.getString(2));
				
				listaE.add(e);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e2) {}
		}
		
		return listaE;
	}
}
