package beans;

import java.io.Serializable;
import java.util.Date;

public class UserInfoBeans  implements Serializable {

	private int id;
	private String loginId;
	private String name;
	private String password;
	private String phone;
	private String postalCode;
	private String address;
	private Date createDate;

	// コンストラクタ
	public UserInfoBeans() {
		this.loginId = "";
		this.name = "";
		this.password = "";
		this.phone = "";
		this.postalCode = "";
		this.address = "";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateUserInfoBeans(int id, String loginId, String name, String password, String phone, String postalCode, String address, Date createDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.postalCode = postalCode;
		this.address = address;
		this.createDate = createDate;
	}
}
