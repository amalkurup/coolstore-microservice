package com.redhat.coolstore.model.kie;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="product",uniqueConstraints = @UniqueConstraint(columnNames = "itemid"),schema="public")
public class Product implements Serializable {

	private static final long serialVersionUID = -7304814269819778382L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="itemid")
	private String itemId;
	@Column(name="name")
	private String name;
	@Column(name="desc")
	private String desc;
	@Column(name="price")
	private double price;
	
	public Product() {
		
	}
	
	public Product(String itemId, String name, String desc, double price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	} 
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [itemId=" + itemId + ", name=" + name + ", desc="
				+ desc + ", price=" + price + "]";
	}
}
