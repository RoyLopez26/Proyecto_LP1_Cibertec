package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

import entity.Categoria;
import util.MySqlConnexion;

public class CategoriaModel {
	private static Logger log = Logger.getLogger(CategoriaModel.class.getName());
	
	public ArrayList<Categoria> listaCategoria(){
		ArrayList<Categoria> listaC = new ArrayList<Categoria>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try{
			con = MySqlConnexion.getConexion();
			
			String sql = "select * from Categorias";
            pst = con.prepareStatement(sql);
            
            log.info(">>>> " + pst);
            
            rs = pst.executeQuery();
            
            while(rs.next()) {
            	Categoria c = new Categoria();
            	c.setIdCategoria(rs.getInt(1));
            	c.setNombreCategoria(rs.getString(2));
            	
            	listaC.add(c);
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e2) {}
		}
		
		return listaC;
		
	}
}
