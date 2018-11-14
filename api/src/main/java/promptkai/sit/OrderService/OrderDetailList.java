package promptkai.sit.OrderService;

import java.util.List;

public class OrderDetailList {
    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int addOrderDetail(OrderDetail od){
        return 1;
    }

    public int deleteOrderDetail(OrderDetail od){
        return 1;
    }
}
