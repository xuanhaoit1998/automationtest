package user;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import entiy.User;
import tienich.SessionUtils;



@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");	
		
		request.setAttribute("isLogin", true);
		request.setAttribute("VIEW","/views/users/change-password.jsp");	
		String username = SessionUtils.getLoginedUsername(request);
		
		request.setAttribute("username", username);
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");		
		req.setAttribute("isLogin", true);

		User user = (User) req.getSession().getAttribute("user");
		String oldpass = req.getParameter("oldpassword");
		String newpass = req.getParameter("password");
		String confirmpass = req.getParameter("confirmpassword");
		String method = req.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			// TODO: ĐỔI MẬT KHẨU
			try {
				if (user.getPassword().equals(oldpass) && newpass.equals(confirmpass)) {
					BeanUtils.populate(user, req.getParameterMap());
					dao.update(user);
					req.setAttribute("message", "Đổi mật khẩu thành công!");
				} else if (!newpass.equals(confirmpass)) {
					req.setAttribute("message", "Xác nhận mật khẩu là không khớp!");
				} else {
					req.setAttribute("message", "Mật khẩu cũ là không chính xác");
				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				req.setAttribute("message", "Thông tin tài khoản không chính xác!");
			}
		req.setAttribute("VIEW","/views/users/change-password.jsp");	
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}	
	}
}
