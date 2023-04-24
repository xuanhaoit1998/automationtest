package common;

import java.util.Date;



public class FavoriteUserReport {
	private String id;
	private String fullname;
	private String email;
	private Date likeDate;
	public FavoriteUserReport(String id, String fullname, String email, Date likeDate) {
		
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.likeDate = likeDate;
	}
	public FavoriteUserReport() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
}
