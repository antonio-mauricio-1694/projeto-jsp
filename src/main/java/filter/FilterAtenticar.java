package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SigleConnection;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/principal/*" }) /* intercepta todas as requisições que vinherem do projeto ou mapeamento */
public class FilterAtenticar extends HttpFilter implements Filter {

	private static Connection connection;

	private static final long serialVersionUID = 1L;

	public FilterAtenticar() {
		super();

	}

	/* encerra os processos quando o servidor e parado */
	public void destroy() {
		try {
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/* intercepta dodas as requisições que vem do sistema e retorna as repostas */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();

			String usuarioLogado = (String) session.getAttribute("usuario"); // url que esta sendo acessda
			String urlParaAutenticar = req.getServletPath();

			if (usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) { // nao esta
																											// logado

				RequestDispatcher redeciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Por favor realize o login");
				redeciona.forward(req, response);
				return; // para a execucao e redireciona para o login
			} else {
				chain.doFilter(request, response);
			}
			
			connection.commit();//commita alterações no banco de dados
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

	/* e executado os procesos quandoo servidor sebe o projeto */
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SigleConnection.getConnection();
	}

}
