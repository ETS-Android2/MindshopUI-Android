package net.mindzone.mindshopui.models;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductOptions implements Serializable
{
    @DocumentId
    public String id;
    public String title;
    public ArrayList<String> values;
}