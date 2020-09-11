package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import model.GetTopNewerBoxLogic;
import model.TopBox;

/**
 * Servlet Filter implementation class Common_Parts
 */
@WebFilter("/*")
public class Common_Parts implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		System.out.println("<(Filter for sidebar) Create NewerBox>");
		GetTopNewerBoxLogic getNewerBox = new GetTopNewerBoxLogic();
		List<TopBox> newerBox = getNewerBox.execute();
		request.setAttribute("newerBox", newerBox);

		chain.doFilter(request, response);
	}
	public void destroy() {}
}
