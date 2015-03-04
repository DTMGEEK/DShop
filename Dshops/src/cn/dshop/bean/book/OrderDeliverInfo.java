package cn.dshop.bean.book;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * 配送信息
 * @author Administrator
 *
 */
@Entity
public class OrderDeliverInfo {
	
	private Integer deliverid;
	
	/*收货人姓名*/
	private String recipients;
	/*配送信息*/
	private String address;
	/*电子邮箱*/
	private String email;
	/*邮编*/
	private String postcode;
	/*电话*/
	private String tel;
	/*送货方式*/
	private DeliverWay deliverWay;
	/*支付方式*/
	private PaymentWay paymentWay;
	
	/*所属订单*/
	private Order order;
	
	
	
	@OneToOne(mappedBy="orderDeliverInfo",cascade=CascadeType.REFRESH)
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Id @GeneratedValue
	public Integer getDeliverid() {
		return deliverid;
	}
	public void setDeliverid(Integer deliverid) {
		this.deliverid = deliverid;
	}
	
	
	public PaymentWay getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(PaymentWay paymentWay) {
		this.paymentWay = paymentWay;
	}
	@Enumerated(EnumType.STRING) @Column(length=23,nullable=false)
	public DeliverWay getDeliverWay() {
		return deliverWay;
	}
	public void setDeliverWay(DeliverWay deliverWay) {
		this.deliverWay = deliverWay;
	}
	@Column(length=8,nullable=false)
	public String getRecipients() {
		return recipients;
	}
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	@Column(length=40,nullable=false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(length=40)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=6)
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	@Column(length=18)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deliverid == null) ? 0 : deliverid.hashCode());
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
		OrderDeliverInfo other = (OrderDeliverInfo) obj;
		if (deliverid == null) {
			if (other.deliverid != null)
				return false;
		} else if (!deliverid.equals(other.deliverid))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
