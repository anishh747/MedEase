package com.example.medease.Model;

public class Products {
    String productName;
    String productPrice;
    String imageUrl;

    String productType;
    public Products(String productName, String productPrice, String imageUrl, String productType) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageUrl = imageUrl;
        this.productType = productType;
    }

    public Products(){}
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public String getProductQty() {
//        return productQty;
//    }
//
//    public void setProductQty(String productQty) {
//        this.productQty = productQty;
//    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

//    public Integer getProductid() {
//        return productid;
//    }
//
//    public void setProductid(Integer productid) {
//        this.productid = productid;
//    }
}
