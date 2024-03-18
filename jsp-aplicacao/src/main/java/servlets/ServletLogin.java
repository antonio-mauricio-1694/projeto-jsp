package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

import java.io.IOException;



@WebServlet
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletLogin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");
		
		if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			
			if(modelLogin.getLogin().equalsIgnoreCase("adm") && modelLogin.getSenha().equalsIgnoreCase("adm")) {
				
				request.getSession().setAttribute("usuario", modelLogin.getLogin());
				
				if(url == null || url.contentEquals("null")) {
					
					url = "principal/principal.jsp";
					
				}
				RequestDispatcher redirecionar =  request.getRequestDispatcher(url);
				redirecionar.forward(request, response);
			}else {
				
				
				RequestDispatcher redirecionar =  request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "informe o loginm e senha corretamente");
				redirecionar.forward(request, response);
				
			}
		}else {
			RequestDispatcher redirecionar =  request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "informe o loginm e senha corretamente");
			redirecionar.forward(request, response);
		}
	}

}
