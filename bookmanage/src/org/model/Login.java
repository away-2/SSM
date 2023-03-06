package org.model;

public class Login {
	
		//属性（成员变量）
		private String sname;		//用户名
		private String password;	//密码
		private int role;		//角色
		
		//属性 name 的 get/set 方法
		public String getSname(){
			return this.sname;
		}
		public void setSname(String sname){
			this.sname = sname;
		}
		//属性 password 的 get/set 方法
		public String getPassword(){
			return this.password;
		}
		public void setPassword(String password){
			this.password = password;
		}
		//属性 role 的 get/set 方法
		public int getRole(){
			return this.role;
		}
		public void setRole(int role){
			this.role = role;
		}
	}

