package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import DAO.UserDAO;
import entiy.User;
import javassist.bytecode.stackmap.BasicBlock.Catch;


public class testCreate {
	UserDAO userdao = new UserDAO();
	User usermongmuon = new User();
	int songuoibandau,songuoisaukhithem=0;
	
	public int laySoNguoi() {
		int songuoi;
		List<User> list = userdao.findAll();
		songuoi=list.size();
		return songuoi;
	}
	@Before
	public void songuoibandau() {
		songuoibandau=laySoNguoi();
	}
	
	@Test
	public void testCreate1() {
		//username đúng
		try {
			usermongmuon.setId("abcdef");
			usermongmuon.setPassword("1234567");
			usermongmuon.setFullname("Nguyễn Thành Đức Duy");
			usermongmuon.setEmail("duy@gmail.com");
			usermongmuon.setAdmin(true);
			userdao.create(usermongmuon);
		} catch (Exception e) {
			// TODO: handle exception
		}
		User userthucte = userdao.findById(usermongmuon.getId());
		
		if(userthucte !=null) {
			assertEquals(usermongmuon, userthucte);
		}
		
	}
	
	@Test
	public void testCreate2() {
		//username trùng
		try {
			usermongmuon.setId("abc");
			usermongmuon.setPassword("123456789");
			usermongmuon.setFullname("Nguyễn Thành Đức Duy");
			usermongmuon.setEmail("duy@gmail.com");
			usermongmuon.setAdmin(true);
			userdao.create(usermongmuon);
		} catch (Exception e) {
			// TODO: handle exception
		}
		songuoisaukhithem=laySoNguoi();
		assertEquals(songuoisaukhithem, songuoibandau);
		
		
		
	}
	@Test
	public void testCreate3() {
		//username bị null
		try {
			usermongmuon.setId(null);
			usermongmuon.setPassword(null);
			usermongmuon.setFullname(null);
			usermongmuon.setEmail("abcd@gmail.com");
			usermongmuon.setAdmin(true);
			userdao.create(usermongmuon);
		} catch (Exception e) {
			// TODO: handle exception
		}
		songuoisaukhithem=laySoNguoi();
		assertEquals(songuoisaukhithem, songuoibandau);
		
	}
	
}
