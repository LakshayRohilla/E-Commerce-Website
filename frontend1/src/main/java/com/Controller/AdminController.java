package com.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.dao.SupplierDao;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

@Transactional
@Controller
public class AdminController {
	

@Autowired
CategoryDao categoryDao;

@Autowired
SupplierDao supplierDao;

@Autowired
ProductDao productDao;

@RequestMapping("/adding")
ModelAndView showAdding()
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("catlist", categoryDao.retrieve());
	mv.addObject("supplist", supplierDao.getSupplierDetails());
	
	mv.setViewName("adding");
	return mv; 
}
	
/*@RequestMapping(value="/saveCategory", method=RequestMethod.POST)
public ModelAndView saveCategory(@ModelAttribute("category")Category category, BindingResult result, Model model)
{
	ModelAndView mv = new ModelAndView();
	categoryDao.insertOrUpdateCategory(category);
	
	//categoryDao.getCategoryDetails();
	mv.setViewName("adding");
	return mv;


}*/


@RequestMapping(value="/saveCategory", method=RequestMethod.POST)
public ModelAndView saveCategory(@RequestParam("cat_name")String cat__name,@RequestParam("cat_desc")String cat__desc,HttpServletRequest request)
{
	ModelAndView mv = new ModelAndView();
	Category category = new Category();
	category.setCat_desc(request.getParameter("cat_desc"));
	category.setCat_name(request.getParameter("cat_name"));
	categoryDao.insertOrUpdateCategory(category);
	
	//categoryDao.getCategoryDetails();
	mv.setViewName("adding");
	return mv;


}



/*@RequestMapping(value="/saveSupplier", method=RequestMethod.POST)
public ModelAndView saveSupplier(@ModelAttribute("supplier")Supplier supplier, BindingResult result, Model model)
{
	ModelAndView mv = new ModelAndView();
	supplierDao.insertOrUpdateSupplier(supplier)
		mv.setViewName("adding");
	return mv;
}

*/

@RequestMapping(value="/saveSupplier", method=RequestMethod.POST)
public ModelAndView saveSupplier(@RequestParam("supp_address")String supp_address,@RequestParam("supp_name")String supp_name,@RequestParam("contact")String contact,HttpServletRequest request)
{
	ModelAndView mv = new ModelAndView();
	Supplier supplier = new Supplier();
	supplier.setSupp_address(request.getParameter("supp_address"));
	supplier.setSupp_name(request.getParameter("supp_name"));
	supplier.setContact(request.getParameter("contact"));
	
	supplierDao.insertOrUpdateSupplier(supplier);
	
	mv.setViewName("adding");
	return mv;
}




@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
public String saveUpdate(@RequestParam("pro_name")String pro_name,@RequestParam("pro_stock")String pro_stock,@RequestParam("pro_price")String pro_price,@RequestParam("pro_image")MultipartFile pro_image, HttpServletRequest request, Model model)
{
	System.out.println("Save Product");
	
	Product product = new Product();
	model.addAttribute("category", new Category()); 
	model.addAttribute("supplier", new Supplier()); 
	model.addAttribute("product", new Product()); 
    String filepath = request.getSession().getServletContext().getRealPath("/");
	String filename = pro_image.getOriginalFilename();
	product.setPro_imagename(filename);
	product.setPro_name(request.getParameter("pro_name"));
	product.setPro_price(Integer.parseInt(request.getParameter("pro_price")));
	product.setPro_stock(Integer.parseInt(request.getParameter("pro_stock")));
	product.setPro_category(categoryDao.getCategory(Integer.parseInt(request.getParameter("pro_category.cat_id"))));
	product.setPro_supplier(supplierDao.getSupplier(Integer.parseInt(request.getParameter("pro_supplier.supp_id"))));
	productDao.insertOrUpdateProduct(product);
	System.out.println("File Path"+filepath);
	try 
	{
		byte imagebyte[] = pro_image.getBytes();
		BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
		System.out.println(fos);
		fos.write(imagebyte);
		fos.close();
	}catch(IOException e)
	{ 
		e.printStackTrace();
	}
	
	return "adding";
	//return "redirect:/admin/productAdminList?update";
}



@RequestMapping(value="/productUpdate", method=RequestMethod.POST)
public String productUpdate(@RequestParam("pro_name")String pro_name,@RequestParam("pro_stock")String pro_stock,@RequestParam("pro_price")String pro_price,@RequestParam("pro_image")MultipartFile pro_image, HttpServletRequest request, Model model)
{
	System.out.println("Save Product");
	
	Product product = new Product();
	model.addAttribute("category", new Category()); 
	model.addAttribute("supplier", new Supplier()); 
	model.addAttribute("product", new Product()); 
    String filepath = request.getSession().getServletContext().getRealPath("/");
	String filename = pro_image.getOriginalFilename();
	product.setPro_imagename(filename);
	product.setPro_name(request.getParameter("pro_name"));
	product.setPro_price(Integer.parseInt(request.getParameter("pro_price")));
	product.setPro_stock(Integer.parseInt(request.getParameter("pro_stock")));
	product.setPro_category(categoryDao.getCategory(Integer.parseInt(request.getParameter("pro_category.cat_id"))));
	product.setPro_supplier(supplierDao.getSupplier(Integer.parseInt(request.getParameter("pro_supplier.supp_id"))));
	productDao.insertOrUpdateProduct(product);
	System.out.println("File Path"+filepath);
	try 
	{
		byte imagebyte[] = pro_image.getBytes();
		BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
		System.out.println(fos);
		fos.write(imagebyte);
		fos.close();
	}catch(IOException e)
	{ 
		e.printStackTrace();
	}
	
	
	return "redirect:/productAdminList?update";
}


@RequestMapping(value="/categoryUpdate", method=RequestMethod.POST)
public String categoryUpdate(@RequestParam("cat_id")int cat_id, @RequestParam("cat_name")String cat_name, @RequestParam("cat_desc")String cat_desc,Model model)
{
	Category category = new Category();
	category.setCat_name(cat_name);
	category.setCat_desc(cat_desc);
	category.setCat_id(cat_id);
	categoryDao.insertOrUpdateCategory(category);
	return "redirect:/catAdminList?update";
	//return "redirect:/admin/catAdminList?update";
	}

@RequestMapping(value="supplierUpdate", method=RequestMethod.POST)
public String productUpdate(@RequestParam("supp_id")int supp_id, @RequestParam("supp_name")String supp_name,@RequestParam("contact")String contact, @RequestParam("supp_address")String supp_address,Model model)
{
	Supplier supplier = new Supplier();
	supplier.setSupp_name(supp_name);
	supplier.setSupp_address(supp_address);
	supplier.setSupp_id(supp_id);
	supplier.setContact(contact);
	
	supplierDao.insertOrUpdateSupplier(supplier);
	//return "redirect:/admin/suppAdminList?update";
	return "redirect:/suppAdminList?update";
	}


@RequestMapping("productAdminList")
public ModelAndView showAdminList()
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("category", new Category());
	mv.addObject("supplier", new Supplier());
	mv.addObject("catlist", categoryDao.retrieve());
	
	mv.addObject("prodList", productDao.retrieve());
	mv.setViewName("productAdminList");
	return mv;
}


@RequestMapping("updateProd")
public ModelAndView updateProduct(@RequestParam("pro_id") int pro_id)
{
	ModelAndView mv = new ModelAndView();
	Product p = productDao.getProduct(pro_id);
	mv.addObject("prod",p);
	mv.addObject("catlist", categoryDao.retrieve());
	mv.addObject("supplist", supplierDao.retrieve());
	mv.setViewName("updateProduct");
	return mv;
}

@RequestMapping("updateCat")
public ModelAndView updateCategory(@RequestParam("cat_id") int cat_id)
{
	ModelAndView mv = new ModelAndView();
	Category c = categoryDao.getCategory(cat_id);
	mv.addObject("catlist", categoryDao.retrieve());
	mv.addObject("cat",c);
	mv.setViewName("updateCategory");
	return mv;
}

@RequestMapping("updateSupp")
public ModelAndView updateSupplier(@RequestParam("supp_id") int supp_id)
{
	ModelAndView mv = new ModelAndView();
	Supplier s = supplierDao.getSupplier(supp_id);
	mv.addObject("catlist", categoryDao.retrieve());
	mv.addObject("supp",s);
	mv.setViewName("updateSupplier");
	return mv;
}

@RequestMapping("suppAdminList")
public ModelAndView showSuppAdminList()
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("supplist", supplierDao.retrieve());
	mv.addObject("catlist", categoryDao.retrieve());
	mv.setViewName("suppAdminList");
	return mv;
}

@RequestMapping("catAdminList")
public ModelAndView showCatAdminList()
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("catlist", categoryDao.retrieve());
	mv.setViewName("catAdminList");
	return mv;
}


@RequestMapping("deleteProd")
public String deleteProduct(@RequestParam("pro_id") int pro_id)
{
	productDao.deleteProd(pro_id);
	
	return "redirect:/productAdminList?del";
	//return "redirect:/admin/productAdminList?del";
}

@RequestMapping("deleteCat")
public ModelAndView deleteCategory(@RequestParam("cat_id") int cat_id)
{
	ModelAndView mv = new  ModelAndView();
	try{
		
		categoryDao.deleteCat(cat_id);
	//mv.setViewName("redirect:/admin/catAdminList?del");
		mv.setViewName("redirect:/catAdminList?del");
		
	}
	catch(Exception e){
		
		mv.addObject("catlist", categoryDao.retrieve());
		
		mv.addObject("warning","Edit the Assosiated Products First");
		mv.setViewName("catAdminList");
	}
	return mv;
}

@RequestMapping("deleteSupp")
public ModelAndView deleteSupplier(@RequestParam("supp_id") int supp_id)
{
	ModelAndView mv = new  ModelAndView();
	try{
		
		supplierDao.deleteSupp(supp_id);
	//mv.setViewName("redirect:/admin/suppAdminList?del");
	mv.setViewName("redirect:/suppAdminList?del");
	
	}
	catch(Exception e){
		
		mv.addObject("catlist", categoryDao.retrieve());
		mv.addObject("supplist", supplierDao.retrieve());
		
		mv.addObject("warning","Edit the Assosiated Products First");
		mv.setViewName("suppAdminList");
	}
	return mv;

}






}
