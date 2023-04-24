package user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FavoriteDAO;
import DAO.VideoDAO;
import entiy.Favorite;
import entiy.User;
import entiy.Video;




@WebServlet(urlPatterns = {"/Home","/like", "/share", "/video","/dislike"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VideoDAO dao = new VideoDAO();
	private FavoriteDAO favdao = new FavoriteDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");
		
		req.setAttribute("isLogin", true);
		String uri = req.getRequestURI();
		User u = (User)req.getSession().getAttribute("user");
		if (uri.contains("dislike")) {
			String idVideo = req.getParameter("v");
			favdao.remove(u.getId(), idVideo);
			resp.sendRedirect(req.getContextPath()+"/Home");
			return;
		}
		else if (uri.contains("like")) {
			String idVideo = req.getParameter("v");
			Video v = dao.getVideobyId(idVideo);
			Date likeDate = new Date();
			Favorite fav = new Favorite(u, v, likeDate);
			favdao.create(fav);			
			resp.sendRedirect(req.getContextPath()+"/Home");
			return;
		} else if (uri.contains("share")) {			
			req.setAttribute("VIEW", "/views/videos/share.jsp");
		} else if (uri.contains("video")) {
			String idVideo = req.getParameter("v");
			Video v = dao.getVideobyId(idVideo);
			if (v == null) {
				resp.sendRedirect(req.getContextPath()+"/Home");
				return;
			} else {
				Cookie[] c = req.getCookies();
				Cookie lichsu = null;
				for (int i = 0; i < c.length; i++) {
					if (c[i].getName().equals("lichsu")) {
						lichsu = c[i];
					}
				}
				if (lichsu == null) {
					lichsu = new Cookie("lichsu", v.getId());
				} else {
					if (!lichsu.getValue().contains(v.getId()))
						lichsu.setValue(lichsu.getValue() + "#" + v.getId());
				}
				resp.addCookie(lichsu);
				dao.tangLuotXem(v);
				String []ls = lichsu.getValue().split("#");
				List<String> listLS = new ArrayList<String>();
				for(String id: ls)
					listLS.add(id);				
				req.setAttribute("lichsu",dao.getVideo(listLS));
				req.setAttribute("video", v);
				req.setAttribute("VIEW", "/views/sub-views/detailVideo.jsp");
			}
		} else {
			int page = 0;
			try {
				page = Integer.parseInt(req.getParameter("page")) - 1;
			} catch (Exception ex) {
				page = 0;
			}
			req.setAttribute("videos", getVideo(page));
			req.setAttribute("totalPage", dao.getTotalPage());
			if(u != null) {
				List<Video> likeVideo = favdao.findVideoByUserLike(u);
				String likeid = "";
				for(Video v: likeVideo) {
					likeid +=v.getId()+"#";
				}
				req.setAttribute("likeid",likeid);
			}			
			req.setAttribute("VIEW", "/views/sub-views/list_view.jsp");
		}
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

	public List<Video> getVideo(int page) {
		return dao.getVideoPaging(page);
	}
}
