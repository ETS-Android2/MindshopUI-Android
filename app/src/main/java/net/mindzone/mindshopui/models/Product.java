package net.mindzone.mindshopui.models;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

    @DocumentId
    public String id;
    public String categoryID;
    public String title;
    public String desc;
    public int price;
    public  int discount;
    public int price_afterDiscount;
    public String authorId;
    public ArrayList<ProductOptions> options;


    public Product(String title, int price, int discount, int price_afterDiscount) {
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.price_afterDiscount = price_afterDiscount;
    }

    public static ArrayList<String> getBTNProducts() {
        ArrayList<String> Products = new ArrayList<>();
        Products.add("Shoes");
        Products.add("Trousers");
        Products.add("Skirts");
        Products.add("Other");
        return Products;
    }
    public static ArrayList<Product> getProducts() {
        ArrayList<Product> Products = new ArrayList<>();
        Products.add(new Product("Camelia Heels",64,50,125));
        Products.add(new Product("Nike Shoes",89,40,135));
        Products.add(new Product("Levi’s Jacket",94,40,135));
        return Products;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", price_afterDiscount=" + price_afterDiscount +
                '}';
    }
}
