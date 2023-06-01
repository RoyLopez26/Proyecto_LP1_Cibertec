package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Categoria;
import model.CategoriaModel;

@WebServlet("/cargaCategoria")
public class cboCategoriaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.- Obtenemos todas las categorias
		CategoriaModel model = new CategoriaModel();
		ArrayList<Categoria> lista = model.listaCategoria();
		
		//2.- Se convierte a JSON
		Gson gson = new Gson();
		String json = gson.toJson(lista);
		
		//3.- Se envia Json al browser
        resp.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println(json);
	}
}
