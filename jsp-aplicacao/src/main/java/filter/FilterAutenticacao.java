package filter;

import java.io.IOException;

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

@WebFilter (urlPatterns = {"/principal/*"}) /*intercepta todas requisiçoes que vinher do projeto ou mapeamento*/
public class FilterAutenticacao extends HttpFilter implements Filter {
       
    
  
	private static final long serialVersionUID = 1L;


	public FilterAutenticacao() {
        super();
       
    }

	/*Encerra os processo quando servidor e parado */
	public void destroy() {
		
	}
	/*Incia os os processos e recurso quando o servidor sobe o projeto */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String usuarioLogado = (String) session.getAttribute("usuario");
		
		String urlParaAutenticar = req.getServletPath(); //url que esta sendo Acessada
		
		//validar se esta logado se nao retorna para tela de login
		
		if(usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin"))  {
			
			RequestDispatcher redirecina = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por Favor Realise o Login");
			redirecina.forward(request, response);
			
			return ; //para a execução e redireciona para o login
			
		}else {
			chain.doFilter(request, response);
		}
		
		
		

		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
