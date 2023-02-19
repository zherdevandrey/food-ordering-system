package com.food.order.entity;


import com.food.order.valueobject.Money;
import com.food.order.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;


    public Product(ProductId id, String name, Money price) {
        super.setId(id);
        this.name = name;
        this.price = price;
    }

    public Product(ProductId id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public void updateWithConfirmedNameAndPrice(String name, Money price) {

        this.name = name;
        this.price = price;

    }
}
