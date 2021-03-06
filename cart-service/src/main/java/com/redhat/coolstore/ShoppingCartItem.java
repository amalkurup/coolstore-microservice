package com.redhat.coolstore;
@org.kie.api.definition.type.Label("Shopping Cart Item1")
public class ShoppingCartItem {
	static final long serialVersionUID = 1L;

	   @org.kie.api.definition.type.Label("Item ID")
	   @org.kie.api.definition.type.Position(0)
	   private java.lang.String itemId;

	   @org.kie.api.definition.type.Label("Name")
	   @org.kie.api.definition.type.Position(1)
	   private java.lang.String name;

	   @org.kie.api.definition.type.Label("Price")
	   @org.kie.api.definition.type.Position(2)
	   private double price;

	   @org.kie.api.definition.type.Label("Promotional Savings")
	   @org.kie.api.definition.type.Position(4)
	   private double promoSavings1;

	   @org.kie.api.definition.type.Label("Quantity")
	   @org.kie.api.definition.type.Position(3)
	   private int quantity;

	   @org.kie.api.definition.type.Label("Shopping Cart")
	   @org.kie.api.definition.type.Position(5)
	   private com.redhat.coolstore.ShoppingCart shoppingCart;

	   public ShoppingCartItem()
	   {
	   }

	   public java.lang.String getItemId()
	   {
	      return this.itemId;
	   }

	   public void setItemId(java.lang.String itemId)
	   {
	      this.itemId = itemId;
	   }

	   public java.lang.String getName()
	   {
	      return this.name;
	   }

	   public void setName(java.lang.String name)
	   {
	      this.name = name;
	   }

	   public com.redhat.coolstore.ShoppingCart getShoppingCart()
	   {
	      return this.shoppingCart;
	   }

	   public void setShoppingCart(com.redhat.coolstore.ShoppingCart shoppingCart)
	   {
	      this.shoppingCart = shoppingCart;
	   }

	   public double getPrice()
	   {
	      return this.price;
	   }

	   public void setPrice(double price)
	   {
	      this.price = price;
	   }

	   public double getPromoSavings()
	   {
	      return this.promoSavings1;
	   }

	   public void setPromoSavings(double promoSavings)
	   {
	      this.promoSavings1 = promoSavings;
	   }

	   public int getQuantity()
	   {
	      return this.quantity;
	   }

	   public void setQuantity(int quantity)
	   {
	      this.quantity = quantity;
	   }

	   public ShoppingCartItem(java.lang.String itemId, java.lang.String name,
	         double price, double promoSavings, int quantity,
	         com.redhat.coolstore.ShoppingCart shoppingCart)
	   {
	      this.itemId = itemId;
	      this.name = name;
	      this.price = price;
	      this.promoSavings1 = promoSavings;
	      this.quantity = quantity;
	      this.shoppingCart = shoppingCart;
	   }

	   public ShoppingCartItem(java.lang.String itemId, java.lang.String name,
	         double price, int quantity, double promoSavings,
	         com.redhat.coolstore.ShoppingCart shoppingCart)
	   {
	      this.itemId = itemId;
	      this.name = name;
	      this.price = price;
	      this.quantity = quantity;
	      this.promoSavings1 = promoSavings;
	      this.shoppingCart = shoppingCart;
	   }
}
