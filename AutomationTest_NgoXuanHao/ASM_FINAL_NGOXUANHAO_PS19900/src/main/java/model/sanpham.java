package model;

public class sanpham {
	private String tieude;
	private String anh;
	private int like;
	private int share;
	
	public sanpham(String tieude, String anh, int like, int share) {
		super();
		this.tieude = tieude;
		this.anh = anh;
		this.like = like;
		this.share = share;
	}

	public sanpham() {
		
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}
	
}
