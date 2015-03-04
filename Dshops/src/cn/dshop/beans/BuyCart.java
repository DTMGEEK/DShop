package cn.dshop.beans;

import java.util.ArrayList;
import java.util.List;

import cn.dshop.bean.book.OrderContactInfo;
import cn.dshop.bean.book.OrderDeliverInfo;
import cn.dshop.bean.book.PaymentWay;

public class BuyCart {

	/**
	 * 添加购物项
	 * 没有购物项时 添加购物项
	 * 有购物项是 取出对象 增加购物数量
	 */
	/*购物项*/
	private List<BuyItem> items=new ArrayList<BuyItem>();
	/*配送信息*/
	private OrderDeliverInfo deliverInfo;
	/*用户联系信息*/
	private OrderContactInfo contactInfo;
	/*支付方式*/
	private PaymentWay paymentWay;	
	/*配送费*/
	private float deliveFee=10f;
	/*附言*/
	private String note;
	
	
	

	
	

	public OrderContactInfo getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(OrderContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public float getDeliveFee() {
		return deliveFee;
	}


	public void setDeliveFee(float deliveFee) {
		this.deliveFee = deliveFee;
	}


	public PaymentWay getPaymentWay() {
		return paymentWay;
	}


	public void setPaymentWay(PaymentWay paymentWay) {
		this.paymentWay = paymentWay;
	}


	public OrderDeliverInfo getDeliverInfo() {
		return deliverInfo;
	}


	public void setDeliverInfo(OrderDeliverInfo deliverInfo) {
		this.deliverInfo = deliverInfo;
	}


	public List<BuyItem> getItems() {
		return items;
	}


	public void setItems(List<BuyItem> items) {
		this.items = items;
	}


	public void addItem(BuyItem item){
		
		if(!items.contains(item)){
			items.add(item);
			
		}else{
			
			for(BuyItem com:items){				
				if(com.equals(item)){
					com.setAmount(com.getAmount()+1);
					break;

				}
				
			}

		}	
	}
	
	
	
	
	/**
	 * 清除所有购物项
	 */
	
	public void removeAll(){
		
		this.items.clear();
	}
	
	
	/**
	 * 清除指定购物项
	 * @param item
	 */
	public void removeBuyItem(BuyItem item){		
		if(this.items.contains(item)){
			this.items.remove(item);
			
		}
	}
	
	
	
	
	
	/**
	 * 更新购物数量
	 * @param item
	 */
	public void updateAmout(BuyItem item){
		
		for(BuyItem it:items){	
			
			if(it.equals(item)){
				it.setAmount(item.getAmount());
				   break;	
			  }
		}
			
	}
	
	
	
	
	/**
	 * 批量更新购买数量
	 * @param items
	 */
	public void updateAmout(BuyItem[] items){
		
		for(BuyItem it:this.items){
			
			for(BuyItem item:items){
				
				if(it.equals(item)){
				
					it.setAmount(item.getAmount());
					break;
				}
			}
			
			
		}

	}
	
	
	/**
	 * 计算总金额
	 * @return
	 */
	public float getTotalPrice(){
		
		float total=0;
		for(BuyItem bi :this.items){			
			total+=bi.getProduct().getSellprice()*bi.getAmount();
			
		}
		
		return total;
		
	}
	
	
	/**
	 * 计算订单总金额
	 * @return
	 */
	public float getorderTotalPrice(){
		
		return getTotalPrice()+this.getDeliveFee();
		
		
		
	}

	
	

	
	
	
	
}
