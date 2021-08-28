package net.mindzone.mindshopui.models;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;
import java.util.ArrayList;

public class MyCartItems implements Serializable {


    @DocumentId
    public String id;
    public String title;
    public String color;
    public int price;
    public String size;
    public int count;

    public MyCartItems(String title, String color, int price, String size, int count) {
        this.title = title;
        this.color = color;
        this.price = price;
        this.size = size;
        this.count = count;
    }

    public static ArrayList<MyCartItems> getItemsCart() {
        ArrayList<MyCartItems> myCartItems = new ArrayList<>();
        myCartItems.add(new MyCartItems("Levi’s Jeans", "Dark Grey", 76, "L", 1));
        myCartItems.add(new MyCartItems("Milano Parada", "Silver", 96, "No size", 1));
        return myCartItems;
    }
}
