package beans;

import java.io.Serializable;
import java.sql.Date;

public class NewsBeans  implements Serializable {

	private int id;
	private Date createDate;
	private String info;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
