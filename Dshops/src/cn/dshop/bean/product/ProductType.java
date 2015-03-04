package cn.dshop.bean.product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

@Entity @Searchable(root=false)
public class ProductType implements Serializable {
	/*商品类型id*/
	private Integer typeid;
	/*描述*/
	private String note;
	/*名称*/
	private String name;
	/*是否可见*/
	private Boolean visible=true;
	/*子类集合*/
	private Set<ProductType> childrenType=new HashSet<ProductType>();
	/*父类*/
	private ProductType parentType;
	
	private Set<ProductInfo> products=new HashSet<ProductInfo>();
	

	public ProductType() {

	}

	public ProductType(Integer typeid) {
		this.typeid = typeid;
	}

	

	public ProductType(String name, String note) {
		this.note = note;
		this.name = name;
	}
	
	

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableProperty(index=Index.NO,store=Store.YES)
	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	@Column(length=150)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(length=36,nullable=false)
	@SearchableProperty(index=Index.NOT_ANALYZED,store=Store.YES,name="typeName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable=false)
	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="parentType")
	public Set<ProductType> getChildrenType() {
		return childrenType;
	}

	public void setChildrenType(Set<ProductType> childrenType) {
		this.childrenType = childrenType;
	}

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="parentid")
	public ProductType getParentType() {
		return parentType;
	}

    @OneToMany(mappedBy="type",cascade=CascadeType.REMOVE)
	public Set<ProductInfo> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductInfo> products) {
		this.products = products;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeid == null) ? 0 : typeid.hashCode());
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
		ProductType other = (ProductType) obj;
		if (typeid == null) {
			if (other.typeid != null)
				return false;
		} else if (!typeid.equals(other.typeid))
			return false;
		return true;
	}

	public void setParentType(ProductType parentType) {
		this.parentType = parentType;
	}
	
	

}
