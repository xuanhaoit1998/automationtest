package test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.UserDAO;
import entiy.User;
public class testDelete {
	UserDAO userdao = new UserDAO();
	int soNguoiSauKhiXoa,soNguoiTruocKhiXoa=0;
	
	public int demsonguoi(){
		int songuoi=0;
		try {
			List<User> user = userdao.findAll();
			songuoi= user.size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return songuoi;
	}
	@Before
	public void demnguoi() {
		System.out.println("bắt đầu test ");
		soNguoiTruocKhiXoa=demsonguoi();
	}
	@Test
	public void testdeleteusernameright() {
		//xóa khi username đúng
		try {
			String id="abcdef";
			userdao.remove(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		soNguoiSauKhiXoa=demsonguoi();
		assertEquals(soNguoiTruocKhiXoa, soNguoiSauKhiXoa+1);
	}
	
	@Test
	public void testdeleteusernameisnull() {
		//xóa khi username rỗng
		try {
			String id="";
			userdao.remove(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		soNguoiSauKhiXoa=demsonguoi();
		assertEquals(soNguoiTruocKhiXoa, soNguoiSauKhiXoa);
	}
	
	@Test
	public void testdeleteusernameisfalse() {
		//xóa khi username không có trong database
		try {
			String id="abcfghgy";
			userdao.remove(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		soNguoiSauKhiXoa=demsonguoi();
		assertEquals(soNguoiTruocKhiXoa, soNguoiSauKhiXoa);
	}

	@After
	public void after() {
		System.out.println("kết thúc test ");
		
		
	}
}
