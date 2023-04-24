package admin;

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



@WebServlet({ "/user/index", "/user/edit/*", "/user/update", "/user/delete", "/user/create" })
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID =1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");;
		
		UserDAO dao = new UserDAO();
		User user = new User();
		String uri = req.getRequestURI();
		if (uri.contains("edit")) {
			String id = uri.substring(uri.lastIndexOf("/") + 1);
			user = dao.findById(id);
			
		} else if (uri.contains("create")) {
			try {
				if (dao.findById(req.getParameter("id"))==null){
					BeanUtils.populate(user, req.getParameterMap());				
					dao.create(user);					
					user = new User();
					req.setAttribute("message", "Thêm tài khoản thành công!");
				}else {
					req.setAttribute("message", "Thêm tài khoản thất bại! (Tài khoản tồn tại!)");
				}												
			} catch (IllegalAccessException | InvocationTargetException e) {
				req.setAttribute("message", "Thông tin tài khoản không chính xác!");
			}
		} else if (uri.contains("update")) {
			try {
				if (dao.findById(req.getParameter("id"))!=null){
					BeanUtils.populate(user, req.getParameterMap());
					user = dao.update(user);
					req.setAttribute("message", "Cập nhật tài khoản thành công!");
				}else {
					req.setAttribute("message", "Cập nhật tài khoản thất bại! (Username là không được cập nhật!)");
				}				
			} catch (IllegalAccessException | InvocationTargetException e) {
				req.setAttribute("message", "Thông tin tài khoản không chính xác!");
			}
		} else if (uri.contains("delete")) {
			try {				
				dao.remove(req.getParameter("id"));
				user = new User();
				req.setAttribute("message", "Xóa tài khoản thành công!");
			} catch (Exception e) {
				req.setAttribute("error", "Xóa thất bại bị dính khóa bảng (Favorites)!");
				req.setAttribute("message", "Xóa tài khoản thất bại!");
			}
		}
		req.setAttribute("users", user);
		req.setAttribute("list", dao.findAll());
		req.setAttribute("VIEW", "/views/admin/users/users.jsp");
		req.getRequestDispatcher("/views/indexAdmin.jsp").forward(req, resp);
	}
}