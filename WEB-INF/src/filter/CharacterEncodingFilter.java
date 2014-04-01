package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	@Override
	public void destroy() {}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		req.setCharacterEncoding("Windows-31J");
		chain.doFilter(req, resp);
		if (!"0:0:0:0:0:0:0:1".equals(req.getRemoteAddr())) System.out.println(req.getRemoteAddr());
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
}
