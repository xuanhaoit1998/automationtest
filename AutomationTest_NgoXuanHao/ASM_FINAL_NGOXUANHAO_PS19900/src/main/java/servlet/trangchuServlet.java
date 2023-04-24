package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.sanpham;

/**
 * Servlet implementation class trangchuServlet
 */
@WebServlet("/trangchuServlet")
public class trangchuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ArrayList<sanpham> list = new ArrayList<sanpham>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		list.removeAll(list);
		list.add(new sanpham("video1","https://giaiphapxyz.com/wp-content/uploads/2022/04/rom-goc-samsung-galaxy-m33-sm-m336b.jpg",10,3));
		list.add(new sanpham("video2","https://giaiphapxyz.com/wp-content/uploads/2022/04/rom-goc-samsung-galaxy-m33-sm-m336b.jpg",15,2));
		list.add(new sanpham("video3","https://giaiphapxyz.com/wp-content/uploads/2022/04/rom-goc-samsung-galaxy-m33-sm-m336b.jpg",30,10));
		list.add(new sanpham("video4","https://giaiphapxyz.com/wp-content/uploads/2022/04/rom-goc-samsung-galaxy-m33-sm-m336b.jpg",9,2));
		list.add(new sanpham("video5","https://giaiphapxyz.com/wp-content/uploads/2022/04/rom-goc-samsung-galaxy-m33-sm-m336b.jpg",50,40));
		list.add(new sanpham("video6","https://giaiphapxyz.com/wp-content/uploads/2022/04/rom-goc-samsung-galaxy-m33-sm-m336b.jpg",17,1));
		list.add(new sanpham("video7","https://giaiphapxyz.com/wp-content/uploads/2022/04/rom-goc-samsung-galaxy-m33-sm-m336b.jpg",80,20));
		list.add(new sanpham("video8","https://giaiphapxyz.com/wp-content/uploads/2022/04/rom-goc-samsung-galaxy-m33-sm-m336b.jpg",27,5));
		request.setAttribute("items", list);
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
