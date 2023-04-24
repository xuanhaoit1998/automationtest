package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.nguoidung;
import tienich.docGhiFile;


@WebServlet("/dangnhapServlet")
public class dangnhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String duongdan="C:\\Users\\Acer\\eclipse-workspace\\asm\\nguoidung.txt";
    List<nguoidung> dsnguoidung = new ArrayList<nguoidung>();
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	nguoidung nd = new nguoidung("abc","123");
    	dsnguoidung.add(nd);
    	try {
			List<nguoidung> readObject = (List<nguoidung>) docGhiFile.readObject(duongdan);
			dsnguoidung= readObject;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String taikhoan = request.getParameter("taikhoan");
		String matkhau = request.getParameter("matkhau");
		
		
		for(int i =0;i<dsnguoidung.size();i++) {
			if(dsnguoidung.get(i).getTaikhoan().equals(taikhoan) && dsnguoidung.get(i).getMatkhau().equals(matkhau)) {
				request.getRequestDispatcher("/views/index.jsp").forward(request, response);
				System.out.print("a");
			}else {
				request.setAttribute("thongbaoloi", "sai tài khoản mật khẩu");
				request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
				System.out.print("b");
			}
		}
	}

}
