package br.com.park.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.park.controler.controle;
import br.com.park.object.entrada;
import br.com.park.object.funcionarios;

/**
 * Servlet implementation class cadastro
 */
@WebServlet("/cadastro")
public class cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(true);
			funcionarios fun = (funcionarios) session.getAttribute("usu");
			
			PreparedStatement ps = null;
			Connection con = null;
			
			if (fun != null) {
				
				controle control = new controle();
				entrada entrar = new entrada();
				PrintWriter out = response.getWriter();
				// TODO Auto-generated method stub

				entrar.setModelo(request.getParameter("modelo"));
				entrar.setMarca(request.getParameter("marca"));
				entrar.setCor(request.getParameter("cor"));
				entrar.setPlaca(request.getParameter("placa"));

				control.insert(entrar);

				request.getRequestDispatcher("listagem").forward(request, response);
			} else {
				response.sendRedirect("login.jsp");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
