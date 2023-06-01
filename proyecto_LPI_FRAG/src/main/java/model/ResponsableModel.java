package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Logger;

import Interfaces.InterfaceResponsable;
import entity.Responsable;
import util.MySqlConnexion;

public class ResponsableModel implements InterfaceResponsable{
	
	private static Logger log = Logger.getLogger(ResponsableModel.class.getName());

	@Override
	public int registrarResponsable(Responsable res) {
		int rs = -1;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySqlConnexion.getConexion();
			String sql = "insert Responsable values(null,?,?,?,?,?,?,?,?,?,?,?,?);";
			pst = con.prepareStatement(sql);
			pst.setString(1, res.getNomrespon());                      //Nombres
			pst.setString(2, res.getAperespon());                      //Apellidos
			pst.setString(3, res.getDirecrespon());                    //Dirección
			pst.setString(4, res.getDnirespon());                      //Dni
			pst.setString(5, res.getGenero());                         //Género
			pst.setString(6, res.getCelrespon());                      //Celular
			pst.setNString(7, res.getCorreorespon());                  //Correo
			pst.setInt(8, res.getIdpais().getIdpais());                //IdPis
			pst.setString(9, res.getUsuariorespon());                  //Usuario
			pst.setString(10, res.getContrarespon());                  //Contraseña
			pst.setInt(11, res.getIdcategoria().getIdCategoria());     //IdCategoria
			pst.setInt(12, res.getIdestado().getIdestado());           //Estado
			
			log.info(">>>> " + pst);
			
			rs = pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e2) {}
		}
		
		return rs;
	}

	@Override
	public int modificarResponsable(Responsable res) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarResponsable(Responsable res) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Responsable> listadoResponsable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responsable buscarCodRespon(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
