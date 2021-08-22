package net.mindzone.mindshopui.models;


import java.io.Serializable;
import java.util.ArrayList;


import com.google.firebase.firestore.DocumentId;


public class OrderModel implements Serializable {

    @DocumentId
    public String id;
    public String orderStatus;
    public boolean isPending;

    public static ArrayList<OrderModel> getOrders() {
        ArrayList<OrderModel> OrderModel = new ArrayList<>();
        OrderModel.add(new OrderModel("0000001", "Waiting at customs", true));
        OrderModel.add(new OrderModel("2300001", "Has been shipped", false));
        OrderModel.add(new OrderModel("0056001", "Has been delivered", true));
        OrderModel.add(new OrderModel("0100201", "Waiting at customs", false));
        return OrderModel;
    }

    public OrderModel(String id, String orderStatus, boolean isPending) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.isPending = isPending;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", isPending=" + isPending +
                '}';
    }
}
