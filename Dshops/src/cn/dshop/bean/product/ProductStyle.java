package cn.dshop.bean.product;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.SearchableReference;
import org.compass.annotations.Store;

@Entity @Searchable(root=false)
public class ProductStyle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3512383166265452803L;
	
	/*样式id*/
	private Integer id;
	/*样式名称*/
	private String name;
	/*样式图片*/
	private String imagesname;
	/*是否可见*/
	private Boolean visible=true;
    /*样式对应产品*/
	private ProductInfo product;
	
	
	
	
	public ProductStyle() {
	}
	
	
	public ProductStyle(Integer id) {
		this.id = id;
	}


	public ProductStyle(String name, String imagesname) {
		this.name = name;
		this.imagesname = imagesname;
	}
	
	
	@Transient
	public String getImageFullPath(){
	
		return "/images/product/"+this.getProduct().getType().getTypeid()+"/"+this.getProduct().getId()+"/prototype/"+this.imagesname;
		
	}
	
	@Transient
	public String getImage140FullPath(){
		
		return "/images/product/"+this.getProduct().getType().getTypeid()+"/140x/"+this.getProduct().getId()+"/prototype/"+this.imagesname;
		
	}
	
	@Id  @GeneratedValue @SearchableProperty(index=Index.NO,store=Store.YES)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(nullable=false,length=30)
	@SearchableProperty(index=Index.NO,store=Store.YES,name="styleName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=40,nullable=false)
	@SearchableProperty(index=Index.NO,store=Store.YES)
	public String getImagesname() {
		return imagesname;
	}
	public void setImagesname(String imagesname) {
		this.imagesname = imagesname;
	}
	@Column(nullable=false)
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="productid")
	@SearchableReference
	public ProductInfo getProduct() {
		return product;
	}
	public void setProduct(ProductInfo product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProductStyle other = (ProductStyle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

	
	
}
