package cn.dshop.productinfo.formbean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.dshop.bean.product.Brand;
import cn.dshop.bean.product.ProductStyle;
import cn.dshop.bean.product.ProductType;

public class ProductInfoFormBean {
	
	
	/*id*/
	private Integer id;
	/*货号*/
	private String code;
	/*产品名称*/
	private String name;
	/*品牌*/
	private String brandid;
	/*型号*/
	private String model;
	/*底价*/
	private Float baseprice;
	/*市场价*/
	private Float marketprice;
	/*销售价*/
	private Float sellprice;
	/*产品重量  单位:克*/
	private Float weight;
	/*产品简介*/
	private String description;
	/*购买说明*/
	private String buyeexplain;
	/*样式名称*/
	private String stylename;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getBrandid() {
		return brandid;
	}
	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}
	public String getStylename() {
		return stylename;
	}
	public void setStylename(String stylename) {
		this.stylename = stylename;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Float getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(Float baseprice) {
		this.baseprice = baseprice;
	}
	public Float getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(Float marketprice) {
		this.marketprice = marketprice;
	}
	public Float getSellprice() {
		return sellprice;
	}
	public void setSellprice(Float sellprice) {
		this.sellprice = sellprice;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBuyeexplain() {
		return buyeexplain;
	}
	public void setBuyeexplain(String buyeexplain) {
		this.buyeexplain = buyeexplain;
	}
	
	
	
	

}
