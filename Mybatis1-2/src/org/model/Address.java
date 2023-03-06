package org.model;

import java.util.Date;

public class Address {
	private Integer id;				//涓婚敭ID
	private String postCode; 	//閭紪
	private String contact;		//鑱旂郴浜�
	private String addressDesc;	//鍦板潃
	private String tel;			//鑱旂郴鐢佃瘽
	private Integer createdBy; 		//鍒涘缓鑰�
	private Date creationDate; 	//鍒涘缓鏃堕棿
	private Integer modifyBy; 		//鏇存柊鑰�
	private Date modifyDate;	//鏇存柊鏃堕棿
	private Integer userId;			//鐢ㄦ埛ID
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddressDesc() {
		return addressDesc;
	}
	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}