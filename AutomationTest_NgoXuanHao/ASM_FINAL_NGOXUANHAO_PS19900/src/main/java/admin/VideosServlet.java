package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.VideoDAO;
import entiy.Video;
import tienich.UploadUtils;



@WebServlet({ "/Videos", "/Videos/create", "/Videos/update", "/Videos/delete", "/Videos/reset", "/Videos/edit" })
@MultipartConfig
public class VideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String url = request.getRequestURL().toString();
		if (url.contains("edit")) {
			edit(request, response);
			return;
		}
		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}
		Video video = new Video();
		//video.setPoster("image/hinhreset.jpg");
		findAll(request, response);
		request.setAttribute("video", video);
		request.setAttribute("VIEW", "/views/admin/videos/videos.jsp");
		request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String url = request.getRequestURL().toString();
		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}
		request.setAttribute("VIEW", "/views/admin/videos/videos.jsp");
		request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		if (id == null) {
			request.setAttribute("error", "Vui lòng nhập VideoID!");
			request.setAttribute("VIEW", "/views/admin/videos/videos.jsp");
			request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
			return;
		}
		try {
			VideoDAO dao = new VideoDAO();
			Video video = dao.findById(id);
			request.setAttribute("video", video);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		request.setAttribute("VIEW", "/views/admin/videos/videos.jsp");
		request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);

	}

	private void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			// Video video = new Video();
			VideoDAO dao = new VideoDAO();
			List<Video> list = dao.findAll();
			request.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");		
		try {
			Video video = new Video();
			VideoDAO dao = new VideoDAO();
			if (dao.findById(request.getParameter("id")) != null) {
				BeanUtils.populate(video, request.getParameterMap());
				video.setPoster( UploadUtils.processUploadField("cover", request, response, "/uploads", video.getPoster()));
				dao.update(video);
				request.setAttribute("video", video);
				request.setAttribute("message", "Cập nhật video thành công!");
				findAll(request, response);
			}else {
				request.setAttribute("message", "Cập nhật video thất bại! (Không được cập nhật VideoId!)");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Thông tin video không chính xác!");
		}
		findAll(request, response);
		request.setAttribute("VIEW", "/views/admin/videos/videos.jsp");
		request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		Video video = new Video();
		//video.setPoster("image/hinhreset.jpg");
		request.setAttribute("video", video);
		findAll(request, response);
		request.setAttribute("VIEW", "/views/admin/videos/videos.jsp");
		request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			String id = request.getParameter("id");
			VideoDAO dao = new VideoDAO();
			Video video = dao.findById(id);
			if (video == null) {
				request.setAttribute("error", "Xóa thất bại (Favorites)!");
				findAll(request, response);
				request.setAttribute("VIEW", "/views/admin/videos/videos.jsp");
				request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
				return;
			}
			dao.delete(id);
			request.setAttribute("message", "Xóa video thành công!");
			request.setAttribute("video", new Video());
			findAll(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "Xóa thất bại(Favorites)!");
			findAll(request, response);
		}
		request.setAttribute("VIEW", "/views/admin/videos/videos.jsp");
		request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		Video video = new Video();
		VideoDAO dao = new VideoDAO();
		try {
			if (dao.findById(request.getParameter("id")) == null) {
				BeanUtils.populate(video, request.getParameterMap());
				video.setPoster(UploadUtils.processUploadField( "cover", request, response, "/uploads", video.getPoster()));
				dao.insert(video);
				request.setAttribute("video", video);
				request.setAttribute("message", "Thêm video thành công!");
			} else {
				request.setAttribute("message", "Thêm video thất bại! (Video tồn tại!)");
			}
		} catch (Exception e) {
			request.setAttribute("message", "Thông tin video không chính xác!");
		}
		findAll(request, response);
		request.setAttribute("VIEW", "/views/admin/videos/videos.jsp");
		request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
	}
}