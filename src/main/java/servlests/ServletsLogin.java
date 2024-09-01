package servlests;



import java.io.IOException;

import dao.DAOLoginRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;


@WebServlet(urlPatterns = {"/principal/ServletLogin","/ServletLogin"}) /*mapemanto da url que vem da tela*/
public class ServletsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAOLoginRepository daoLoginRepository = new DAOLoginRepository();
       
    
    public ServletsLogin() {
        super();
        
    }

    /*recebe os dados pela url em parametros*/	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	/*recebe os dados envidados por um formulario*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String url = request.getParameter("url");
		
		try {
			
		
		if(login != null && !login.isEmpty() && password != null && !password.isEmpty()){
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setPassword(password);
			
			
			if(daoLoginRepository.validarAutenticar(modelLogin)) {
				
				request.getSession().setAttribute("usuario", modelLogin.getLogin());
				
				if(url == null || url.equals("null")) {
					url = "principal/principal.jsp";
					
				}
				RequestDispatcher redirecionar = request.getRequestDispatcher(url);
				
				redirecionar.forward(request, response);
				
				
			}else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "informe o login e a senha corretamente!");
				redirecionar.forward(request, response);
			}
			
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "informe o login e a senha corretamente!");
			redirecionar.forward(request, response);
			
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
