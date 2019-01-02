package com.Controller;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.dao.SupplierDao;
import com.dao.userdao;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;
import com.model.User;


@Transactional
@Controller
public class IndexController 
{
	@Autowired
	userdao userDao;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired 
	SupplierDao supplierDao;
	
	@RequestMapping("/")
	ModelAndView showIndex()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("category", new Category()); 
		mv.addObject("supplier", new Supplier()); 
		mv.addObject("product", new Product()); 
		mv.setViewName("index");
		return  mv;
	}
	
	@RequestMapping("/goToContact")
	ModelAndView showContact()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("category", new Category()); 
		mv.setViewName("contactUs");
		return mv;
	}
	
	@RequestMapping(value="/goToRegister")
	public ModelAndView showRegister()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv; 
	}
	
	@RequestMapping("/goToLogin")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv; 
	}
	
	@RequestMapping("/goToAbout")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("category", new Category()); 
		mv.setViewName("about");
		return mv; 
	}
	
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam(value="id",required=false) String id)
	{	ModelAndView m=new ModelAndView("login");
		if(id!=null){
		if(id.equals("1"))
			m.addObject("msg","Invalid Username or Password");
		else if(id.equals("2"))
			m.addObject("msg","You've been logged out");
		else if(id.equals("3"))
			m.addObject("msg","Your Account has been Deactivated");		
		}
		m.addObject("supplist", supplierDao.retrieve());
		m.addObject("catlist", categoryDao.retrieve());
		m.addObject("prodList", productDao.retrieve());
		return m;	
	}
	
	
	@RequestMapping(value="/login_success",method=RequestMethod.POST)
	public ModelAndView loginsuccess(@RequestParam Map<String,String> user,HttpSession session)
	{ 
		ModelAndView m = new ModelAndView();
		String username= SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(username);
		String name = userDao.getUserName(username);
		User userDetails=userDao.getUser(user.get("username"));
		userDetails.setEnabled(true);
		userDao.insertOrUpdateUser(userDetails);
		session.setAttribute("username",username);
		session.setAttribute("name", name);
		session.setAttribute("usertitle",name.charAt(0));
		session.setAttribute("loggedIn",true);
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority role:authorities)
		{
			System.out.println("Role:"+role.getAuthority()+"username"+username);
			if(role.getAuthority().equals("ROLE_ADMIN"))
				session.setAttribute("user",null);
			else
				session.setAttribute("user","user");
			}
		m.addObject("supplist", supplierDao.retrieve());
		m.addObject("catlist", categoryDao.retrieve());
		m.addObject("prodList", productDao.retrieve());
		m.setViewName("index");
		return m;
	}

	
	@RequestMapping("myAccount")
	public ModelAndView showAccount(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		String phone=(String)session.getAttribute("phone");
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		mv.addObject("supplist", supplierDao.retrieve());
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("prodList", productDao.retrieve());
		mv.addObject("user", userDao.getUser(email));
		mv.addObject("phone" ,phone);
		mv.setViewName("myAccount");
		return mv; 
	}
	
	
	
	@RequestMapping(value="/addUserDetails",method=RequestMethod.POST)
	public ModelAndView addProduct(@RequestParam Map<String,String> user,@RequestParam("contact") String contact)
	{	ModelAndView m=new ModelAndView();
		/*User userDetails=userDao.getUser(user.get("name"));
		if(userDetails!=null&&userDetails.isEnabled()==true){
		m.addObject("userExist","Username Already Exist");
		m.setViewName("register");
		}
		else{*/
		User userDetails =new User();
		userDetails.setAddress(user.get("address"));
		userDetails.setEmailId(user.get("emailId"));
		userDetails.setName(user.get("name"));
		userDetails.setPassword(user.get("password"));
		userDetails.setContact("contact");
		userDetails.setEnabled(true);
		userDetails.setRole("ROLE_USER");
		userDao.insertOrUpdateUser(userDetails);
		m.addObject("userCreate","Account Created");
		m.setViewName("login");
		/*}*/
		return m;
	}
	
	@RequestMapping(value="/allProducts")
	public ModelAndView allProducts()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("prodList",productDao.retrieve());
		mv.setViewName("allProducts");
		return mv; 
	}
	
	@RequestMapping("viewProducts")
	public ModelAndView showProducts(@RequestParam("cat_id") int cid)
	{
		System.out.println("Shop By Category");
		ModelAndView mv = new ModelAndView();
		mv.addObject("prodList", productDao.getProductByCatID(cid));
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("catId", categoryDao.getCategory(cid));
		mv.setViewName("proCategory");
		return mv; 
	}
	
	@RequestMapping("productDetails")
	public ModelAndView showProductDetails(@RequestParam("pro_id") int pid)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("prod", productDao.getProduct(pid));
		mv.addObject("catlist", categoryDao.retrieve());
		
		int cid = categoryDao.getCategoryByPid(pid);
		
		mv.addObject("prodList", productDao.getProductByCatID(cid));
		
		mv.setViewName("prodDetails");
		return mv; 
	}
	
}


