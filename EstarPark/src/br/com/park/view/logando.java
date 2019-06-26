package br.com.park.view;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.park.model.funcionariosBD;
import br.com.park.object.funcionarios;

/**
 * Servlet implementation class logando
 */
@WebServlet(description = "Servlet para autneticaçăo de usuários", urlPatterns = { "/logando" })
public class logando extends HttpServlet {
	private static final long serialVersionUID = 1L;
	funcionariosBD banco = new funcionariosBD();

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(req, resp);
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// aqui mostra se a autenticação não existe
		if (request.getSession(true).getAttribute("funcionario") == null) {
			String recebelogin = request.getParameter("login");
			String recebesenha = request.getParameter("senha");

			System.out.println(recebelogin);
			System.out.println(recebesenha);

			System.out.println(recebelogin == null || recebesenha == null);
			
			
			if (recebelogin == null ||recebelogin.isEmpty() || recebesenha == null || recebesenha.isEmpty()) {
				response.sendRedirect("login.jsp");
			} else {
				funcionarios usu;

				try {
					usu = banco.verificaUsuario(recebelogin, recebesenha);
					System.out.println("texto"+ usu);
					request.getSession(true).setAttribute("usu", usu);
					request.getRequestDispatcher("/layout.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					response.sendError(401);
					// TODO: handle exception

				}
			}
		}
	}
}
