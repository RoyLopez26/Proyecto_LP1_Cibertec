package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Responsable {
	private int codrespon;
	private String nomrespon;
	private String aperespon; 
	private String direcrespon; 
	private String dnirespon;
	private String genero;
	private String celrespon;
	private String correorespon;
	private Pais idpais;
	private String usuariorespon;
	private String contrarespon;
	private Categoria idcategoria;
	private Estado idestado;
	
} 