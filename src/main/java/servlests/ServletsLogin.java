package servlests;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletLogin") /*mapemanto da url que vem da tela*/
public class ServletsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletsLogin() {
        super();
        
    }

    /*recebe os dados pela url em parametros*/	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	/*recebe os dados envidados por um formulario*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
