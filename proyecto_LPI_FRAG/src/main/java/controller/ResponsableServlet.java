package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Categoria;
import entity.Estado;
import entity.Pais;
import entity.Responsable;
import entity.Respuesta;
import model.ResponsableModel;

@WebServlet("/registraResponsable")
public class ResponsableServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String vnomrespon = req.getParameter("nombre");
    	String vaperespon = req.getParameter("apellido"); 
    	String vdirecrespon = req.getParameter("direccion"); 
    	String vdnirespon = req.getParameter("dni"); // int
    	String vgenero = req.getParameter("genero");
    	String vcelrespon = req.getParameter("celular"); // int
    	String vcorreorespon = req.getParameter("correo");
    	String vidpais = req.getParameter("pais"); // int
    	String vusuariorespon = req.getParameter("usuario");
        String vcontrarespon = req.getParameter("contraseña");
    	String vidcategoria = req.getParameter("categoria"); // int
    	String videstado = req.getParameter("estado"); // int
    	
    	Pais objPais = new Pais();
    	objPais.setIdpais(Integer.parseInt(vidpais));
    	
    	Categoria objCategoria = new Categoria();
    	objCategoria.setIdCategoria(Integer.parseInt(vidcategoria));
    	
    	Estado objEstado = new Estado();
    	objEstado.setIdestado(Integer.parseInt(videstado));
    	
    	Responsable r = new Responsable();
    	r.setNomrespon(vnomrespon);
    	r.setAperespon(vaperespon);
    	r.setDirecrespon(vdirecrespon);
    	r.setDnirespon(vdnirespon);
    	r.setGenero(vgenero);
    	r.setCelrespon(vcelrespon);
    	r.setCorreorespon(vcorreorespon);
    	r.setIdpais(objPais);
    	r.setUsuariorespon(vusuariorespon);
    	r.setContrarespon(vcontrarespon);
    	r.setIdcategoria(objCategoria);
    	r.setIdestado(objEstado);
    	
    	ResponsableModel model = new ResponsableModel();
    	int rs = model.registrarResponsable(r); //AQUI
    	Respuesta objRespuesta = new Respuesta();
    
    	if (rs > 0) {
			objRespuesta.setMensaje("Se a registrado correctamente al Responsable");
		}else {
			objRespuesta.setMensaje("Error al registrar al Responsable");
		}
    	
    	Gson gson = new Gson();
		String json = gson.toJson(objRespuesta);

		resp.setContentType("application/json;charset=UTF-8");

		PrintWriter	 out = resp.getWriter();
		out.println(json);
    }
	
}
