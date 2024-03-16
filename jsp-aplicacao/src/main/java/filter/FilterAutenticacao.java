package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

@WebFilter (urlPatterns = {"/principal/*"}) /*intercepta todas requisiçoes que vinherem do projeto ou mapeamento*/
public class FilterAutenticacao extends HttpFilter implements Filter {
       
    
  
	private static final long serialVersionUID = 1L;


	public FilterAutenticacao() {
        super();
       
    }

	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		

		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
