package br.com.park.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import br.com.park.model.conexaoBD;
import br.com.park.object.entrada;
import br.com.park.object.funcionarios;

/**
 * Servlet implementation class listagem
 */
@WebServlet(description = "Servlet para listagem dos carros já cadastradas", urlPatterns = { "/listagem" })
public class listagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private controle controle = new controle();
	conexaoBD banco = new conexaoBD();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession(true);
			funcionarios fun = (funcionarios) session.getAttribute("usu");
			if (fun == null) {
				response.sendRedirect("login.jsp");
			} else {

				String pg = request.getParameter("pg");
				if(pg == null) {
					pg = "1";
				}
				
				int pagina = Integer.parseInt(pg);
				List<entrada> carros = banco.selectAll(pagina);

				request.setAttribute("carros", carros);

				System.out.println(carros);
				
				// session.getAttribute();

				request.getRequestDispatcher("/listagem2.jsp").forward(request, response);
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
