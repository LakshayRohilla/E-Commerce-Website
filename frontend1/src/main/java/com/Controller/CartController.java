package com.Controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CartDao;
import com.dao.CategoryDao;
import com.dao.OrderDetailsDao;
import com.dao.ProductDao;
import com.dao.SupplierDao;
import com.dao.userdao;
import com.model.Cart;
import com.model.OrderDetails;
import com.model.Product;
import com.model.User;


@ComponentScan(basePackages = "com.niit.Online_Store,com.niit.Online_StoreBackend")
@Controller
public class CartController {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	ProductDao productDao;		
	@Autowired
	CartDao cartDao;
	@Autowired
	OrderDetailsDao orderDetailsDao;
	@Autowired
	userdao userDao;
	
	
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public ModelAndView goTocart(HttpServletRequest request)
	{
		
		ModelAndView mv = new ModelAndView();
		Principal principal= request.getUserPrincipal();
		String userEmail=principal.getName();
		mv.addObject("catlist", categoryDao.retrieve());
		
		mv.addObject("cartInfo",cartDao.findByCartId(userEmail));
		mv.setViewName("cart");
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	public ModelAndView addtocart(HttpServletRequest request)
	{
		
		ModelAndView mv = new ModelAndView();
		Principal principal= request.getUserPrincipal();
		
		String userEmail=principal.getName();
		User u=userDao.getUser(userEmail);
		System.out.println(userEmail);
		
		mv.addObject("catlist", categoryDao.retrieve());
		
		
		System.out.println("AddToCart");
		try
		{
			int pro_id = Integer.parseInt(request.getParameter("pro_id"));
			Double price= Double.parseDouble(request.getParameter("pro_price"));
			int qty = 1;
			String pro_name = request.getParameter("pro_name");
			String pro_imagename = request.getParameter("pro_imagename");
			boolean notexist= true;
			List<Cart> cartExist = cartDao.findByCartId(userEmail);
			
			System.out.println(cartDao.findByCartId(userEmail));
			//Cart cartExist = cartDao.getCartById(pro_id, userEmail);
			
			for(Cart cart:cartExist)
				if(cart.getCartProductId()==pro_id)
				{
					
					System.out.println("CartExist");
					notexist= false;
					Cart cm= new Cart();
					cm.setCartId(cart.getCartId());
					cm.setCartPrice(price);
					cm.setCartProductId(pro_id);
					cm.setCartStock(cart.getCartStock()+qty);
					cm.setCartImage(pro_imagename);
					cm.setCartProductName(pro_name);
					cm.setStatus(cart.getStatus());
					//User u=userDao.getUser(userEmail);
					cm.setCartUserDetails(u);
					cartDao.updateCart(cm);	
				}
			if(notexist)
			{
				Cart cm= new Cart();
				
				cm.setCartPrice(price);
				cm.setCartProductId(pro_id);
				cm.setCartStock(qty);
				cm.setCartImage(pro_imagename);
				cm.setCartProductName(pro_name);
				cm.setStatus("n");
				
				//User u=userDao.getUser(userEmail);
				System.out.println(userEmail);
				System.out.println("AfterGetttingUser");
				cm.setCartUserDetails(u);
				System.out.println(u);
				cartDao.insertCart(cm);	
				
			}
			
			
			/*for(Cart cart:cartExist)
			{
				
				System.out.println("ForLoop");
				if(cart.getCartProductId()==pro_id)
				{
					
					System.out.println("CartExist");
					notexist= true;
					Cart cm= new Cart();
					cm.setCartId(cart.getCartId());
					cm.setCartPrice(price);
					cm.setCartProductId(pro_id);
					cm.setCartStock(cart.getCartStock()+qty);
					cm.setCartImage(pro_imagename);
					cm.setCartProductName(pro_name);
					
					//User u=userDao.getUser(userEmail);
					cm.setCartUserDetails(u);
					cartDao.updateCart(cm);	
				}
				else if(notexist==true)
				{
					System.out.println("NoCart");
					Cart cm = new Cart();
					cm.setCartPrice(price);
					cm.setCartProductId(pro_id);
					cm.setCartStock(qty);
					cm.setCartImage(pro_imagename);
					cm.setCartProductName(pro_name);
					
					//User u=userDao.getUser(userEmail);
					System.out.println(userEmail);
					System.out.println("AfterGetttingUser");
					cm.setCartUserDetails(u);
					System.out.println(u);
					cartDao.insertCart(cm);	
					System.out.println("InsertCart");
				}
			}
			*/
			/*System.out.println(cartExist.isEmpty());
			if(cartExist.isEmpty()==true)
			{
				
				System.out.println("NoCart");
				Cart cm = new Cart();
				cm.setCartPrice(price);
				cm.setCartProductId(pro_id);
				cm.setCartStock(qty);
				cm.setCartImage(pro_imagename);
				cm.setCartProductName(pro_name);
				
				//User u=userDao.getUser(userEmail);
				System.out.println(userEmail);
				System.out.println("AfterGetttingUser");
				cm.setCartUserDetails(u);
				System.out.println(u);
				cartDao.insertCart(cm);	
				System.out.println("InsertCart");
				
			}
			else if(cartExist != null)
			{
				for(Cart cart:cartExist)
				{
					System.out.println("CartExist");
					Cart cm= new Cart();
					cm.setCartId(cart.getCartId());
					cm.setCartPrice(price);
					cm.setCartProductId(pro_id);
					cm.setCartStock(cart.getCartStock()+qty);
					cm.setCartImage(pro_imagename);
					cm.setCartProductName(pro_name);
					
					//User u=userDao.getUser(userEmail);
					cm.setCartUserDetails(u);
					cartDao.updateCart(cm);	
				
				}
				
			}*/
			
			mv.addObject("cartInfo",cartDao.findByCartId(userEmail));
			mv.addObject("cartSize", (cartExist.size()+1));
			System.out.println(cartExist.size()+1);
			System.out.println("CartAdded");
			mv.setViewName("cart");
			return mv;	
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			mv.addObject("cartInfo", cartDao.findByCartId(userEmail));
			mv.addObject("catlist", categoryDao.retrieve());
			
			mv.setViewName("index");
			return mv;	
		}
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request)
	{
		
		ModelAndView mv = new ModelAndView();
		Principal principal= request.getUserPrincipal();
		String userEmail=principal.getName();
		User u=userDao.getUser(userEmail);
		List<Cart> cart=cartDao.findByCartId(userEmail);
		mv.addObject("catlist", categoryDao.retrieve());
		
		mv.addObject("user",u);
		mv.addObject("cart",cart);
		mv.setViewName("checkout");
		return mv;
		
	}
	
	@RequestMapping(value="/Orderprocess", method=RequestMethod.POST)
	public ModelAndView orderProcess(HttpServletRequest request)
	{
		
		ModelAndView mv = new ModelAndView();
		Calendar c = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date today = new Date();

		Product product = new Product();
		OrderDetails order= new OrderDetails();
		Principal principal= request.getUserPrincipal();
		String userEmail=principal.getName();
		Double total=Double.parseDouble(request.getParameter("total"));
		String payment=request.getParameter("payment");
		String date=request.getParameter("date");
		System.out.println(date);
		List<Cart> cartList=cartDao.findByCartId(userEmail);
		System.out.println(cartDao.findByCartId(userEmail));
		User u=userDao.getUser(userEmail);
		for(Cart cart:cartList)
		{
			order.setUser(u);
			order.setTotal(total);
			order.setPayment(payment);
			order.setCartId(cart.getCartId());
			order.setName(request.getParameter("name"));
			order.setShippingAddress(request.getParameter("address"));
			order.setPhone(request.getParameter("mobile"));
			
			try {
				Date todayWithZeroTime = formatter.parse(formatter.format(today));
				order.setOrderPlacedOn(todayWithZeroTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			orderDetailsDao.insertOrderDetails(order);
		}
		List<Cart> cartExist=cartDao.findByCartId(userEmail);
		List<Integer> orderId = new ArrayList<Integer>();
		
		for(Cart cart:cartExist)
		{
			orderId.addAll(orderDetailsDao.getOrderId(cart.getCartId()));
		}
		System.out.println(cartExist);
		Cart cm= new Cart();
		for(Cart cart:cartExist)
		{
			System.out.println("ForLoop");
			
				System.out.println("CartExist");
				
				
				
				cm.setCartId(cart.getCartId());
				cm.setCartPrice(cart.getCartPrice());
				cm.setCartProductId(cart.getCartProductId());
				cm.setCartStock(cart.getCartStock());
				cm.setCartImage(cart.getCartImage());
				cm.setCartProductName(cart.getCartProductName());
				cm.setStatus("y");
				cm.setCartOrderID(orderId.get((orderId.size()-1)));
				//User u=userDao.getUser(userEmail);
				try {
					Date todayWithZeroTime = formatter.parse(formatter.format(today));
					cm.setCartOrderPlacedOn(todayWithZeroTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cm.setPaymentMode(order.getPayment());
				cm.setCartUserDetails(u);
				int pid = productDao.getProductIdByProductName(cart.getCartProductName());
				System.out.println("PRODUCT ID----"+pid);
				Product p = productDao.getProduct(pid);
				p.setPro_stock((p.getPro_stock())-(cart.getCartStock()));
				productDao.insertOrUpdateProduct(p);
				cartDao.updateCart(cm);	
			
		}
		/*List<Integer> orderId = new ArrayList<Integer>();
		
		for(Cart cart:cartExist)
		{
			orderId.addAll(orderDetailsDao.getOrderId(cart.getCartId()));
		}*/
		/*
		for(int id=0;id<orderId.size();id++)
		{
			System.out.println(orderId.get(id));
			cm.setCartOrderID(orderId.get(id));
			cartDao.insertCart(cm);	
		}
		*/
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("orderId", orderId.get(orderId.size()-1));
		mv.addObject("orderDetails",u);
		mv.setViewName("ack");
		return mv;
		
	}
	
	@RequestMapping("/ack")
	public String ack()
	{
		return "ack";
	}
	
	
	@RequestMapping("/myOrders")
	public ModelAndView orders(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		LinkedHashMap<Cart, Integer> list = new LinkedHashMap<Cart, Integer>();
		Principal principal= request.getUserPrincipal();
		String userEmail=principal.getName();
		/*List<Cart> cartList = cartDao.getPurchasedProducts(userEmail);
		for(Cart cart:cartList)
		list.put(cart, orderDetailsDao.getOrderDetails(userEmail).getOrderId());
		mv.addObject("list", list.entrySet());
		
		*/
		
		
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("orderInfo", orderDetailsDao.getOrder(userEmail));
		mv.addObject("cartInfo",cartDao.getPurchasedProducts(userEmail));
		mv.setViewName("myOrders");
		return mv;	
		
	}
	
	@RequestMapping(value="/add")
	public ModelAndView addCartItem(@RequestParam("cartId") int cartId,HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		Principal principal= request.getUserPrincipal();
		String userEmail=principal.getName();
		User u=userDao.getUser(userEmail);
		List<Cart> cartExist=cartDao.getCartByCartId(cartId);
		System.out.println(cartExist);
		Cart cm= new Cart();
		for(Cart cart:cartExist)
		{
			System.out.println("ForLoop");
			System.out.println("CartExist");
			cm.setCartId(cart.getCartId());
			cm.setCartPrice(cart.getCartPrice());
			cm.setCartProductId(cart.getCartProductId());
			cm.setCartStock(cart.getCartStock()+1);
			cm.setCartImage(cart.getCartImage());
			cm.setCartProductName(cart.getCartProductName());
			cm.setStatus(cart.getStatus());
			cm.setCartUserDetails(u);
			cartDao.updateCart(cm);	
		}
		mv.addObject("cartInfo", cartDao.findByCartId(userEmail));
		mv.addObject("cartSize", (cartExist.size()+1));
		mv.addObject("catlist", categoryDao.retrieve());
		mv.setViewName("cart");
		return mv;	
	}
	
	
	@RequestMapping(value="/sub")
	public ModelAndView subCartItem(@RequestParam("cartId") int cartId,HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		Principal principal= request.getUserPrincipal();
		String userEmail=principal.getName();
		User u=userDao.getUser(userEmail);
		List<Cart> cartExist=cartDao.getCartByCartId(cartId);
		System.out.println(cartExist);
		Cart cm= new Cart();
		for(Cart cart:cartExist)
		{
			if(cart.getCartStock()>=2)
			{
				System.out.println("ForLoop");
				System.out.println("CartExist");
				cm.setCartId(cart.getCartId());
				cm.setCartPrice(cart.getCartPrice());
				cm.setCartProductId(cart.getCartProductId());
				cm.setCartStock(cart.getCartStock()-1);
				cm.setCartImage(cart.getCartImage());
				cm.setCartProductName(cart.getCartProductName());
				cm.setStatus(cart.getStatus());
				cm.setCartUserDetails(u);
				cartDao.updateCart(cm);	
			}
			else if(cart.getCartStock()==1)
			{
				cartDao.deleteCart(cartId);
				mv.addObject("cartInfo", cartDao.findByCartId(userEmail));
				mv.addObject("catlist", categoryDao.retrieve());
				
				mv.setViewName("redirect:/cart?del");
				return mv;	
			}
			
		}
		mv.addObject("cartInfo", cartDao.findByCartId(userEmail));
		mv.addObject("cartSize", (cartExist.size()+1));
		mv.addObject("catlist", categoryDao.retrieve());
		mv.setViewName("cart");
		return mv;	
	}
	
	
	@RequestMapping(value="/deletePCart/{cartId}")
	public ModelAndView deleteCartItem(@PathVariable("cartId") int cartId,HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		Principal principal= request.getUserPrincipal();
		String userEmail=principal.getName();
		cartDao.deleteCart(cartId);
		mv.addObject("cartInfo", cartDao.findByCartId(userEmail));
		mv.addObject("catlist", categoryDao.retrieve());
		
		mv.setViewName("redirect:/cart?del");
		return mv;	
		
	}
}
