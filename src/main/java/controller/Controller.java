package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.UsuarioBean;
import model.VooBean;

@WebServlet(urlPatterns = {"/Controller", "/main", "/select", "/novousuario"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAO dao = new DAO();
    VooBean voo = new VooBean();
    UsuarioBean usuario = new UsuarioBean();
 
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		if (action.equals("/main")) {
			voos(request, response);
		} else if (action.equals("/select")) {
			selecionarVoos(request, response);
		} else if (action.equals("/novousuario")) {
			novoUsuario(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void voos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<VooBean> lista = dao.listarVoos();
		
		request.setAttribute("voos", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		
		rd.forward(request, response);
	}

	
	protected void selecionarVoos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idVoo = request.getParameter("idVoo");
		
		voo.setIdvoo(idVoo);
		
		dao.selecionarVoo(voo);
		
		request.setAttribute("idProd", voo.getIdvoo());
		request.setAttribute("origem", voo.getOrigem());
		request.setAttribute("destino", voo.getDestino());
		request.setAttribute("data", voo.getData());
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}
	
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setIdUser(request.getParameter("email"));
		usuario.setNome(request.getParameter("name"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setSenha(request.getParameter("pass"));
		
		dao.criarUsuario(usuario);
		response.sendRedirect("main");
	}
}
