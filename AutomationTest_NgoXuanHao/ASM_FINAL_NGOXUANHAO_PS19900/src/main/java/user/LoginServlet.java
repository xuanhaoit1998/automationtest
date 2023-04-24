package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import entiy.User;



@WebServlet({ "/Login", "/account/sign-in" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		request.getRequestDispatcher("/views/account/sign-in.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = dao.findById(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				HttpSession s = request.getSession();
				s.setAttribute("user", user);
				//System.out.println(request.getSession().getAttribute("url"));
				if (request.getSession().getAttribute("url") != null) {
					response.sendRedirect(request.getSession().getAttribute("url").toString());
					request.getSession().setAttribute("url", null);
				} else
					
				response.sendRedirect(request.getContextPath() + "/Home");
			} else {	
				request.setAttribute("message", "Mật khẩu không đúng");
				request.getRequestDispatcher("/views/account/sign-in.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "Tài khoản không tồn tại");
			request.getRequestDispatcher("/views/account/sign-in.jsp").forward(request, response);
		}

	}

}
