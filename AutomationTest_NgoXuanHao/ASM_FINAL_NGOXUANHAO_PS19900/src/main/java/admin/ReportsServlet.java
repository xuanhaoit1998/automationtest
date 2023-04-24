package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FavoriteDAO;
import DAO.VideoDAO;
import common.FavoriteReport;
import common.FavoriteUserReport;
import entiy.Video;



@WebServlet("/Reports")
public class ReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		reportFavoritesByVideos(request,response);
		reportFavoriteUsersByVideos(request,response);
		reportShareByUser(request,response);
		
		request.setAttribute("VIEW","/views/admin/reports/reports.jsp");
		request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		request.setAttribute("VIEW","/views/admin/reports/reports.jsp");
		request.getRequestDispatcher("/views/indexAdmin.jsp").forward(request, response);
	}
	
	protected void reportFavoritesByVideos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		try {
			FavoriteDAO dao = new FavoriteDAO();
			List<FavoriteReport> list = dao.reportFavoritesByVideos();
			request.setAttribute("favList", list);
		}catch(Exception e){
			request.setAttribute("error", "Error: " + e.getMessage());
		}		
	}
	
	protected void reportFavoriteUsersByVideos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		try {
			String videoUserId=request.getParameter("videoUserId");
			VideoDAO vdao = new VideoDAO();
			List<Video> vList = vdao.getAll();
			if(videoUserId == null && vList.size()>0) {
				videoUserId = vList.get(0).getId();
			}
			FavoriteDAO dao = new FavoriteDAO();
			List<FavoriteUserReport> list = dao.reportFavoriteUsersByVideos(videoUserId);
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("vidList", vList);
			request.setAttribute("favUsers", list);
		}catch(Exception e){
			request.setAttribute("error", "Error: " + e.getMessage());
		}		
	}
	
	protected void reportShareByUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
