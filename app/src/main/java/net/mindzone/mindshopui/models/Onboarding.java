package net.mindzone.mindshopui.models;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;

public class Onboarding implements Serializable {

    @DocumentId
    public String id;

    public String title;
    public String desc;
    public String imageUrl;

}