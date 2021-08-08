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
    public String authorId;
    public ArrayList<ProductOptions> options;

}
