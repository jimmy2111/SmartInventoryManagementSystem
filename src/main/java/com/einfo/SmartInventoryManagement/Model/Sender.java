package com.einfo.SmartInventoryManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sender {

	@Id
	private String Id;
	private String sender_name;
	private String Sender_Shop_name;
	private String sender_address;
	private String sender_contact;
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public String getSender_Shop_name() {
		return Sender_Shop_name;
	}
	public void setSender_Shop_name(String sender_Shop_name) {
		Sender_Shop_name = sender_Shop_name;
	}
	public String getSender_address() {
		return sender_address;
	}
	public void setSender_address(String sender_address) {
		this.sender_address = sender_address;
	}
	public String getSender_contact() {
		return sender_contact;
	}
	public void setSender_contact(String sender_contact) {
		this.sender_contact = sender_contact;
	}
	public Sender(String sender_name, String sender_Shop_name, String sender_address, String sender_contact) {
		super();
		this.sender_name = sender_name;
		Sender_Shop_name = sender_Shop_name;
		this.sender_address = sender_address;
		this.sender_contact = sender_contact;
	}
	public Sender() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Sender [Id=" + Id + ", sender_name=" + sender_name + ", sender_shop_name=" + Sender_Shop_name
				+ ", sender_address=" + sender_address + ", sender_contact=" + sender_contact + "]";
	}
}
