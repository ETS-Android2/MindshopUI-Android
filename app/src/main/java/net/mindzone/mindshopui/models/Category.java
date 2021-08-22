package net.mindzone.mindshopui.models;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    @DocumentId
    public String id;

    public String title;
    public String authorId;


    public static ArrayList<String> getCategories() {
        ArrayList<String> Products = new ArrayList<>();
        Products.add("Shoes");
        Products.add("Trousers");
        Products.add("Skirts");
        Products.add("Other");
        return Products;
    }
}