package user;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ShareDAO;
import DAO.VideoDAO;
import entiy.Share;
import entiy.User;



@WebServlet("/sendmail")
public class SendMail extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ShareDAO dao = new ShareDAO();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setAttribute("isLogin", true);
		
		User u = (User) req.getSession().getAttribute("user");
		String idVideo = req.getParameter("id");
		String email = req.getParameter("email");
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
	    props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "duyntdps19969@fpt.edu.vn";
				String password = "0169254360113a";
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(u.getEmail()));
			message.setRecipients(Message.RecipientType.TO, email);
			message.setSubject("Share video", "utf-8");
			message.setText("<a href='http://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/video?v="+idVideo+"'>Link</a>", "utf-8", "html");
			message.setReplyTo(message.getFrom());
			
			Transport.send(message);
			VideoDAO videodao = new VideoDAO();
			
			Share s = new Share(u,videodao.getVideobyId(idVideo),new Date(),email);
			dao.create(s);
			
			req.setAttribute("message", "Gửi gmail thành công!");
		} catch (MessagingException e) {
		
			e.printStackTrace();
			req.setAttribute("message", "Gửi gmail thất bại!");
		}
		req.setAttribute("VIEW", "/views/videos/share.jsp");
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

}
