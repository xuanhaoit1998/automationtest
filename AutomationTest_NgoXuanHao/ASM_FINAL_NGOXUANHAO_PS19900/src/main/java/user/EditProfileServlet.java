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



@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		request.setAttribute("isLogin", true);
		request.setAttribute("VIEW","/views/users/edit-profile.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("isLogin", true);
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		UserDAO dao = new UserDAO();
		User user = (User) request.getSession().getAttribute("user");
		String method = request.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			// TODO: CẬP NHẬT
			try {
				if (dao.findById(request.getParameter("id"))!=null){
				BeanUtils.populate(user, request.getParameterMap());				
				user = dao.update(user);
				request.setAttribute("message", "Cập nhật tài khoản thành công!");
			}else {
				request.setAttribute("message", "Cập nhật tài khoản thất bại! (Username là không được cập nhật!)");
			}				
			} catch (Exception e) {
				request.setAttribute("message", "Lỗi cập nhật tài khoản!");
			}
			request.setAttribute("VIEW","/views/users/edit-profile.jsp");
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);
		}
	}
}
