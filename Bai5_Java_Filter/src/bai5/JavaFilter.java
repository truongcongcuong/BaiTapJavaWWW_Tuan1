package bai5;

import java.io.File;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "*.png", "*.jpg", "*.gif" }, initParams = {
		@WebInitParam(name = "notFoundImage", value = "/images/image-not-found.jpg") })
public class JavaFilter implements Filter {

	private String notFoundImage;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		notFoundImage = filterConfig.getInitParameter("notFoundImage");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) arg0;
		String servletPath = httpRequest.getServletPath();
		String imageRootPath = httpRequest.getServletContext().getRealPath("");
		String imagePath = imageRootPath + servletPath;
		File file = new File(imagePath);
		if(file.exists()) {
			arg2.doFilter(arg0, arg1);
		}else if (!servletPath.equalsIgnoreCase(notFoundImage)) {
			HttpServletResponse httpServletResponse = (HttpServletResponse) arg1;
			httpServletResponse.sendRedirect(httpRequest.getContextPath()+this.notFoundImage);
		}
	}
	

}
