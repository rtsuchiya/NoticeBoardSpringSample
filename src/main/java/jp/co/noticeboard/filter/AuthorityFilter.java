package jp.co.noticeboard.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.noticeboard.dto.UserDto;

@WebFilter(urlPatterns = { "/edit", "/signup", "/management" }, filterName = "authorityFilter")
public class AuthorityFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		UserDto user = (UserDto) session.getAttribute("loginUser");

		if (!(user.getBranchId() == 1 && user.getPositionId() == 1)) {
			// TODO エラーメッセージ
			((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/top");
			return;
		}

		chain.doFilter(request, response);
	}
}
