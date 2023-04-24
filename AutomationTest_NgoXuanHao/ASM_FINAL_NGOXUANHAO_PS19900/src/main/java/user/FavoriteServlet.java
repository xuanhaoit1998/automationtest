package user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FavoriteDAO;
import DAO.VideoDAO;
import entiy.User;
import entiy.Video;



@WebServlet({ "/Favorite","/dislike1"})
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO dao = new VideoDAO();
	private FavoriteDAO favdao = new FavoriteDAO();
	public FavoriteServlet() {
		super();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");		
		req.setAttribute("isLogin", true);
		
		User u = (User)req.getSession().getAttribute("user");
		//lay list views
		List<Video> likeVideo = favdao.findVideoByUserLike(u);
		String likeid = "";
		for (Video v : likeVideo) {
			likeid += v.getId() + "#";
		}
		req.setAttribute("likeid", likeid);
		//
		VideoDAO dao = new VideoDAO();
		Video video = new Video();
		String uri = req.getRequestURI();
		if(uri.contains("Favorite")){
			int page = 0;
			try {
				page = Integer.parseInt(req.getParameter("page")) - 1;
			} catch (Exception ex) {
				page = 0;
			}
			req.setAttribute("videofavorite",getVideoFavorite(page,u.getId()));
			req.setAttribute("totalPage", dao.getTotalPage_1(u.getId()));
		}else  if (uri.contains("dislike1")) {
			String idVideo = req.getParameter("v");
			favdao.remove(u.getId(), idVideo);
			resp.sendRedirect(req.getContextPath()+"/Favorite");
			return;
		}
		
		req.setAttribute("v", video);
		req.setAttribute("VIEW", "/views/sub-views/list_view_favorite.jsp");
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
		
	}
	public List<Object[]> getVideoFavorite(int page, String userid) {
		return dao.getVideoFavorite(page,userid);
	}
}

