package com.dao;

import java.util.Date;
import java.util.List;

import com.model.OrderDetails;

public interface OrderDetailsDao
{
	
	public void insertOrderDetails(OrderDetails orderdetails);
	public List<OrderDetails> getOrder(String userEmail);
	public OrderDetails getOrderDetails(String userEmail);
	public List<Integer> getOrderId(int cartid);
	public List<Date> getOrderDate(int cartid);
	public void deleteOrderDetails(String userEmail);
}




































/*package com.niit.dao;

import com.niit.model.OrderDetails;

public interface OrderDetailsDao 
{
	public void insertOrderDetails(OrderDetails orderDetails);
	public OrderDetails getOrderDetails(String username,int cart_id);
	public void deleteOrderDetails(String username);

}
*/