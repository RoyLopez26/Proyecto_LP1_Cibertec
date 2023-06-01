package Interfaces;

import java.util.ArrayList;

import entity.Responsable;

public interface InterfaceResponsable {
	public int registrarResponsable(Responsable res);
	public int modificarResponsable(Responsable res);
	public int eliminarResponsable(Responsable res);
	public ArrayList<Responsable> listadoResponsable();
	public Responsable buscarCodRespon(int codigo);
}
