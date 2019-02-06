package com.redhat.coolstore.model.kie;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="shoppingcartitem")
public class ShoppingCartItem implements Serializable {
	
	private static final long serialVersionUID = 6964558044240061049L;
	@Column(name="price")
	private double price;
	@Column(name="quantity")
	private int quantity;
	@Column(name="promosavings")
	private double promosavings;
	
	@ManyToOne
	@JoinColumn(name="cartid")
	@JsonBackReference
	private ShoppingCart cartId;
	
	
	
	@OneToOne
	@JoinColumn(name="itemid",unique=true)
	private Product product;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", updatable=false,nullable=false)
	private long id;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	public ShoppingCart getCartId() {
		return cartId;
	}

	public void setCartId(ShoppingCart cartId) {
		this.cartId = cartId;
	}

	public ShoppingCartItem() {
		
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPromoSavings() {
		return promosavings;
	}

	public void setPromoSavings(double promoSavings) {
		this.promosavings = promoSavings;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [price=" + price + ", quantity=" + quantity
				+ ", promoSavings=" + promosavings + ", product=" + product
				+ "]";
	}
		
	
}
