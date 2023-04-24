package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import entiy.User;



@WebServlet({ "/account/sign-up","/account/forgot-password"})

public class AccountServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf8");
	resp.setCharacterEncoding("utf8");
	
	String uri = req.getRequestURI();
	if (uri.contains("sign-up")) {
		this.doSignUp(req, resp);
	}  else if (uri.contains("forgot-password")) {
		this.doForgotPassword(req, resp);
	}
}

private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf8");
	resp.setCharacterEncoding("utf8");
	
	UserDAO dao = new UserDAO();
	User user = new User();
	String method = req.getMethod();
	if (method.equalsIgnoreCase("POST")) {
		// TODO: ĐĂNG KÝ
		try {
			if (dao.findById(req.getParameter("id"))==null){
				BeanUtils.populate(user, req.getParameterMap());
				dao.create(user);
				user = new User();
				req.setAttribute("message", "Đăng ký tài khoản thành công!");
			}else {
				req.setAttribute("message", "Đăng ký tài khoản thất bại! (Tài Khoản tồn tại!)");
			}
		} catch (Exception e) {
			req.setAttribute("message", "Thông tin đăng ký không chính xác!");
		}
	}
	req.getRequestDispatcher("/views/account/registration.jsp").forward(req, resp);
	
}

private void doForgotPassword(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("utf8");
	resp.setCharacterEncoding("utf8");
	
	String method = req.getMethod();
	if (method.equalsIgnoreCase("POST")) {
		// TODO: QUÊN MẬT KHẨU
		User user = new User();
		String Username = req.getParameter("id");
		String Email = req.getParameter("email");
		try {
			UserDAO dao = new UserDAO();
			user = dao.findById(Username);
			
			String Password = user.getPassword();
			if (!user.getEmail().equals(Email)) {
				req.setAttribute("message", "Email không đúng!");
				
			} else {
				req.setAttribute("message", "Mật khẩu của bạn là: " + Password);
				req.getRequestDispatcher("/views/account/forgot-password.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("message", "Username này không tồn tại!");
		}

	}
	req.getRequestDispatcher("/views/account/forgot-password.jsp").forward(req, resp);
 }
}