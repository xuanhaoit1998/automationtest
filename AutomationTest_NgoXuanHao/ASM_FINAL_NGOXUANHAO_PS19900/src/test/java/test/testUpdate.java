package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import DAO.UserDAO;
import entiy.User;

public class testUpdate {
	UserDAO userdao = new UserDAO();
	User userThemVao = new User();
	
	@Test
	public void testUpdate1() {
		//update data đúng
		boolean moc=false;
		
		try {
			userThemVao.setId("abcd");
			userThemVao.setPassword("123");
			userThemVao.setFullname("Nguyễn Thành Đức Duy");
			userThemVao.setEmail("duy@gmail.com");
			userThemVao.setAdmin(true);
			userdao.update(userThemVao);
		} catch (Exception e) {
			// TODO: handle exception
		}
		User userSau = userdao.findById(userThemVao.getId());
		if (userSau!=null) {
			moc = (userSau.getId().equals(userThemVao.getId()) && userSau.getPassword().equals(userThemVao.getPassword()) && userSau.getFullname().equals(userThemVao.getFullname()) && userSau.getEmail().equals(userThemVao.getEmail())) ;
		}
		assertTrue(moc);
	}
	
	@Test
	public void testUpdate2() {
		//update ten email pass null
		boolean moc=false;
		try {
			userThemVao.setId("abc");
			userThemVao.setPassword("");
			userThemVao.setFullname("");
			userThemVao.setEmail("");
			userThemVao.setAdmin(true);
			userdao.update(userThemVao);
		} catch (Exception e) {
			// TODO: handle exception
		}
		User userSau = userdao.findById(userThemVao.getId());
		if (userSau!=null) {
			moc = (userSau.getId().equals(userThemVao.getId()) && userSau.getPassword().equals(userThemVao.getPassword()) && userSau.getFullname().equals(userThemVao.getFullname()) && userSau.getEmail().equals(userThemVao.getEmail())) ;
		}
		assertFalse(moc);
	}
	@Test
	public void testUpdate3() {
		//update nhưng username không có trong database
		boolean moc=false;
		try {
			userThemVao.setId("abcdrty");
			userThemVao.setPassword("1234");
			userThemVao.setFullname("Nguyễn Thành Đức Duy");
			userThemVao.setEmail("duy@gmail.com");
			userThemVao.setAdmin(true);
			userdao.update(userThemVao);
		} catch (Exception e) {
			// TODO: handle exception
		}
		User userSau = userdao.findById(userThemVao.getId());
		if (userSau!=null) {
			moc = (userSau.getId().equals(userThemVao.getId()) && userSau.getPassword().equals(userThemVao.getPassword()) && userSau.getFullname().equals(userThemVao.getFullname()) && userSau.getEmail().equals(userThemVao.getEmail())) ;
		}
		assertFalse(moc);
	}
}
