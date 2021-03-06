package com.redhat.coolstore.model.kie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="shoppingcart",uniqueConstraints=@UniqueConstraint(columnNames="cartid"))
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = -1108043957592113528L;
	
	@Id
    @Column(name="cartid")
	private String cartId;
	@Column(name="cartitemtotal")
	private double cartItemTotal;
	@Column(name="cartitempromosavings")
	private double cartItemPromoSavings;
	@Column(name="shippingtotal")
	private double shippingTotal;
	@Column(name="shippingpromosavings")
	private double shippingPromoSavings;
	@Column(name="carttotal")
	private double cartTotal;
	
    
	
  @OneToMany(mappedBy="cartId", targetEntity = ShoppingCartItem.class,
		    fetch=FetchType.EAGER, cascade=CascadeType.ALL)
  @JsonManagedReference
    private List<ShoppingCartItem> shoppingCartItemList;

	public ShoppingCart() {
	}

	public ShoppingCart(String cartId) {
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public List<ShoppingCartItem> getShoppingCartItemList() {
		if(shoppingCartItemList == null) {
			return new ArrayList<ShoppingCartItem>();
		}
		return shoppingCartItemList;
	}

	public void setShoppingCartItemList(List<ShoppingCartItem> shoppingCartItemList) {
		this.shoppingCartItemList = shoppingCartItemList;
	}

	public void resetShoppingCartItemList() {
		shoppingCartItemList = new ArrayList<ShoppingCartItem>();
  }

	public void addShoppingCartItem(ShoppingCartItem sci) {
		
		if ( sci != null ) {
			
			getShoppingCartItemList().add(sci);
			
		}
		
	}
	
	public boolean removeShoppingCartItem(ShoppingCartItem sci) {
		
		boolean removed = false;
		
		if ( sci != null ) {
			
			removed = getShoppingCartItemList().remove(sci);
			
		}
		
		return removed;
		
	}

	public double getCartItemTotal() {
		return cartItemTotal;
	}

	public void setCartItemTotal(double cartItemTotal) {
		this.cartItemTotal = cartItemTotal;
	}

	public double getShippingTotal() {
		return shippingTotal;
	}

	public void setShippingTotal(double shippingTotal) {
		this.shippingTotal = shippingTotal;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	public double getCartItemPromoSavings() {
		return cartItemPromoSavings;
	}

	public void setCartItemPromoSavings(double cartItemPromoSavings) {
		this.cartItemPromoSavings = cartItemPromoSavings;
	}

	public double getShippingPromoSavings() {
		return shippingPromoSavings;
	}

	public void setShippingPromoSavings(double shippingPromoSavings) {
		this.shippingPromoSavings = shippingPromoSavings;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId
				+ ", cartItemTotal=" + cartItemTotal
				+ ", cartItemPromoSavings=" + cartItemPromoSavings
				+ ", shippingTotal=" + shippingTotal
				+ ", shippingPromoSavings=" + shippingPromoSavings
				+ ", cartTotal=" + cartTotal + ", shoppingCartItemList="
				+ getShoppingCartItemList() + "]";
	}
	
}
