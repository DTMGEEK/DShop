package cn.dshop.bean.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Buyer implements Serializable {

	private static final long serialVersionUID = -6892794647213294143L;
	
	
	/*用户名*/
	private String username;
	/*密码*/
	private String password;
	/*真实姓名*/
	private String realname;
	/*电子邮件地址*/
	private String email;
	/*联系信息*/
	private ContactInfo contactInfo;
	/*是否可见*/
	private Boolean visible=true;
	/*注册日期*/
	private Date regTime=new Date();
	

	public Buyer() {
	}
	
	

	public Buyer(String username) {
		this.username = username;
	}
	
	

	public Buyer(String username, String password) {
		this.username = username;
		this.password = password;
	}
	


	public Buyer(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	


    @Id @Column(length=18)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length=32,nullable=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length=8)
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(length=50,nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contactid")
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Column(nullable=false)
	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@Temporal(TemporalType.TIMESTAMP) @Column(nullable=false)
	public Date getRegTime() {
		return regTime;
	}
    
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buyer other = (Buyer) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	

}
