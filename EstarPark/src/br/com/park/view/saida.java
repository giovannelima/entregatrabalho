package br.com.park.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.park.model.conexaoBD;
import br.com.park.object.entrada;

/**
 * Servlet implementation class saida
 */
@WebServlet(description = "detar carros", urlPatterns = { "/deletar" })
public class saida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	conexaoBD banco = new conexaoBD();

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int recebeCod = Integer.parseInt(request.getParameter("id"));
		try {
			banco.deletar(recebeCod);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// session.getAttribute();

		request.getRequestDispatcher("/listagem2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
