package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pro_id;
	private String pro_name;
	private int pro_stock;
	private int pro_price;
	private String pro_imagename;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
	private Category pro_category;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pid")
	private Supplier pro_supplier;

	@Transient
	private MultipartFile pro_image;
	
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_stock() {
		return pro_stock;
	}
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public MultipartFile getPro_image() {
		return pro_image;
	}
	public void setPro_image(MultipartFile pro_image) {
		this.pro_image = pro_image;
	}
	public String getPro_imagename() {
		return pro_imagename;
	}
	public void setPro_imagename(String pro_imagename) {
		this.pro_imagename = pro_imagename;
	}
	public Category getPro_category() {
		return pro_category;
	}
	public void setPro_category(Category pro_category) {
		this.pro_category = pro_category;
	}
	public Supplier getPro_supplier() {
		return pro_supplier;
	}
	public void setPro_supplier(Supplier pro_supplier) {
		this.pro_supplier = pro_supplier;
	}
	
}
