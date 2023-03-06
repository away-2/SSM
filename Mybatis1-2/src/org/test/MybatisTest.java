package org.test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.dao.BillMapper;
import org.dao.ProviderMapper;
import org.dao.UserMapper;
import org.model.Address;
import org.model.Bill;
import org.model.Provider;
import org.model.User;
import org.utils.MyBatisUtil;
public class MybatisTest {
	 public static SqlSession session=null;
	public static void main(String[] args) {
		
		 try{	
    		session=MyBatisUtil.CreateSession();
		    
		    querry();
		    //insert();
			//querry();
			//delete();
	        //querry();
		    //update();
			//querry();
    		//querryUser();
    		// querryAddress();
    		//querryBill_if();
    		//querryBill_where();
    		//modify_if_set();
    		//getBillByProviderId_foreach_array();
    		//getBillByProviderId_foreach_list();
    		//getBill_foreach_map();
    		//getUserList(1,10);
		 }catch (Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 MyBatisUtil.CloseSession(session);
    	 }
}
	     static void querry(){
	    	 int count=0;
 		     List<Provider> list=new ArrayList<Provider>();
	    	//读取provider表记录
	 		/*list=session.getMapper(ProviderMapper.class).fromProvider();
	 		for(int i=0; i<list.size(); i++) {
				Provider p = list.get(i);
				System.out.print(p.getProName()+"      ");
				System.out.print(p.getProDesc()+"      ");	
				System.out.println(p.getProAddress()+"     ");
				}
				
	    	  //查询记录条数
	 		    count=session.getMapper(ProviderMapper.class).count();
				System.out.println(count);
	 		*/
	 		/*
	 		//单条件查询
				list=session.getMapper(ProviderMapper.class).getListByName("北京");
				for(int i=0; i<list.size(); i++) {
					Provider p = list.get(i);
					System.out.println(p.getProName()+"      ");
					System.out.println(p.getProDesc()+"      ");	
					System.out.println(p.getProAddress()+"     ");
					System.out.println("-----------------");
				}	
				*/
	 		// 多条件查询
	 		Provider pro = new Provider();
	 		pro.setProAddress("江苏");
	 		pro.setProDesc("长期合作");
	 		list=session.getMapper(ProviderMapper.class).getListByAddressAndDesc(pro);
	 		for(int i=0; i<list.size(); i++) {
					Provider p = list.get(i);
					System.out.println(p.getProName()+"      ");
					System.out.println(p.getProDesc()+"      ");	
					System.out.println(p.getProAddress()+"     ");
					System.out.println("-----------------");
					}	
				 		
	 		// 自定义查询结果映射
	 		/*list=session.getMapper(ProviderMapper.class).getProductListByProvider("北京三木堂");
	    	 for(int i=0; i<list.size(); i++) {
					Provider p = list.get(i);
					System.out.print(p.getProName()+"      ");
					System.out.print(p.getProductName()+"      ");	
					System.out.println(p.getProductDesc()+"     ");
					}	
					*/					
	          }
	          
	     static void insert(){	    	 
 		     int count=0;
 		     try{	
	       Provider p=new Provider();
	       p.setProCode("ecut");
	       p.setProName("东华科技园");
	       p.setProAddress("枫林校区");
	       p.setProDesc("长期合作");
	       p.setProContact("张明");
	       p.setProFax("4008-1010");
	       p.setCreatedBy(1);
	       p.setCreationDate(new Date());
	       count=session.getMapper(ProviderMapper.class).addProvider(p);
	       //模拟异常，进行回滚
	       //int i=3/0;
	       session.commit();
	     } catch(Exception e){
	    	 e.printStackTrace();
	    	 session.rollback();	    		   
    		 count=0;
	    	  }finally{
	    		  }
 		    System.out.println(count);  
	     }
	     
	     static void delete(){
	    	 int count=0; 
	    	 try{
	     count=session.getMapper(ProviderMapper.class).delProvider("东华科技园");
	     session.commit();
	    	 } catch(Exception e){
		    	 e.printStackTrace();
		    	 session.rollback();	    		   
	    		 count=0;
		    	  }finally{
		    		  }
	 		    System.out.println(count); 
	    	 }
	     
	       static void update(){
	    	int count=0;
	    	try{
	    	count=session.getMapper(ProviderMapper.class).updateProvider("乐天日用品厂","乐摆日用品厂");
	    	//int s=2/0;
	    	session.commit();} catch(Exception e){
		    	 e.printStackTrace();
		    	 session.rollback();	    		   
	    		 count=0;
		    	  }finally{
		    		  }
	 		    System.out.println(count); 
	       }
	       
	     //assocation 一对一  
	       static void querryUser(){
	    	   	 int count=0;
	   		     List<User> list=new ArrayList<User>();
	  	    	  		 
	  	    	//读取user表记录
	  	 		list=session.getMapper(UserMapper.class).getUserListByRoleId(2);
	  	 	    for(int i=0; i<list.size(); i++) {
	  				User u = list.get(i);
	  				System.out.print(u.getId()+"      ");
	  				System.out.print(u.getUserName()+"      ");
	  				System.out.print(u.getRole().getId()+"      ");
	  				System.out.print(u.getRole().getRoleCode()+"      ");
	  				System.out.println(u.getRole().getRoleName()+"      ");
	  			    }
	       }
	  		//collection 一对多
	  	 	 static void querryAddress(){
	    	   	 int count=0;
	   		     List<User> list=new ArrayList<User>();
	   		  List<Address> list1=new ArrayList<Address>();	 
	  	    			  	    	     		 
			  	    	//读取user地址列表
			  	 		list=session.getMapper(UserMapper.class).getAddressListByUserId(1);
			  	 	    for(int i=0; i<list.size(); i++) {
			  				User u = list.get(i);
			  				System.out.print(u.getId()+"      ");
			  				System.out.println(u.getUserName()+"      ");
			  			  list1=u.getAddressList();
			  			  System.out.println(list.size());
			  				for(int j=0; j<list1.size(); j++) {
				  				Address a = list1.get(j);
				  				System.out.print(a.getAddressDesc()+"      ");
				  				System.out.println(a.getContact());
			  		        		
			  	 	 }
			  	 		
			  	 	 }
	  		
	  	          }
	  	 	  
	  	 	 static void querryBill_if(){
	  	 		List<Bill> billList = new ArrayList<Bill>();
	  	 		String productName = null;
				Integer providerId = null;
				Integer isPayment = 1;				
				billList = session.getMapper(BillMapper.class).getBillListIf(productName,providerId,isPayment); 
				for(Bill bill: billList){
					System.out.println("testGetBillList id: " + bill.getId() + 
								" and BillCode: " + bill.getBillCode() + 
								" and ProductName: " + bill.getProductName() + 
								" and totalPrice: " + bill.getTotalPrice() + 
								" and isPayment: " + bill.getIsPayment() + 
								" and providerId : " + bill.getProviderId() +
								" and providerName: " + bill.getProviderName() +
								" and creationDate: " + new SimpleDateFormat("yyyy-MM-dd").format(bill.getCreationDate()));
				}
	  	 	 }
	  	 	static void querryBill_where(){
	  	 		List<Bill> billList = new ArrayList<Bill>();
	  	 		String productName = "泰国香米";
				Integer providerId = null;
				Integer isPayment = 1;				
				billList = session.getMapper(BillMapper.class).getBillListwhere(productName,providerId,isPayment); 
				for(Bill bill: billList){
					System.out.println( bill.getId() + 
								"    " + bill.getBillCode() + 
								" ProductName: " + bill.getProductName() + 
								"     : " + bill.getTotalPrice() + 
								" and isPayment: " + bill.getIsPayment() + 
								" and providerId : " + bill.getProviderId() +
								"   " + new SimpleDateFormat("yyyy-MM-dd").format(bill.getCreationDate()));
				}
				
	  	 	 }
	  	 	 
	  	 	 static void modify_if_set(){
	  	 				int count = 0;
	  	 			try {
	  	 				Provider provider = new Provider();
	  	 				provider.setId(14);
	  	 				//provider.setProCode("BJ_GYS123");
	  	 				//provider.setProName("供应商测试修改");
	  	 				//provider.setProContact("李四");
	  	 				/*provider.setProAddress("供应商测试地址修改");
	  	 				provider.setProPhone("13500002222");
	  	 				provider.setModifyBy(1);
	  	 				provider.setModifyDate(new Date());*/
	  	 				//provider.setProFax("010-588876565");
	  	 				//provider.setProDesc("供应商测试描述修改");
	  	 				count = session.getMapper(ProviderMapper.class).modify(provider);
	  	 				//模拟异常，进行回滚
	  	 				//int i = 2/0;
	  	 				session.commit();
	  	 			} catch (Exception e) {
	  	 				// TODO: handle exception
	  	 				e.printStackTrace();
	  	 				session.rollback();
	  	 				count = 0;
	  	 			}finally{
	  	 				
	  	 			}
	  	 			
	  	 		}
	  	 		 
	  	 	 static void getBillByProviderId_foreach_array(){
	  			
	  			List<Bill> list = new ArrayList<Bill>();
	  			Integer[] providerIds = {2,3};
	  			list = session.getMapper(BillMapper.class).getBillByProviderId_foreach_array(providerIds);
	  					for(Bill bill : list){
	  				System.out.println("id: " + bill.getId()+
	  							", billCode: " + bill.getBillCode() + 
	  							", productName: " + bill.getProductName() +
	  							", productDesc: " + bill.getProductDesc()+
	  							", providerId: " + bill.getProviderId()
	  							);
	  			}
	  		}
            static void getBillByProviderId_foreach_list(){
	  			
	  			List<Bill> list = new ArrayList<Bill>();
	  			List<Integer> providerList=new ArrayList<Integer>();
	  	      providerList.add(2); providerList.add(3);
	  		 list = session.getMapper(BillMapper.class).getBillByProviderId_foreach_list(providerList);

	  					for(Bill bill : list){
	  				System.out.println("id: " + bill.getId()+bill.getBillCode()+
	  							", billCode: " + bill.getBillCode() + 
	  							", productName: " + bill.getProductName() +
	  							", productDesc: " + bill.getProductDesc()+
	  							", providerId: " + bill.getProviderId()
	  							);
	  			}
	  		}
            //
            public static void getBill_foreach_map(){
        		
        		List<Bill> billList = new ArrayList<Bill>();
        		Map<String, Object> conditionMap = new HashMap<String,Object>();
        		List<Integer> providerList = new ArrayList<Integer>();
        		providerList.add(2);
        		providerList.add(3);
        		//conditionMap.put("desc", "饮料");
        		conditionMap.put("providerIds",providerList);
        		billList = session.getMapper(BillMapper.class).getBillByConditionMap_foreach_map(conditionMap);
        		for(Bill bill : billList){
        			System.out.println(" id: " + bill.getId()+
        						", billCode: " + bill.getBillCode() + 
        						", productName: " + bill.getProductName()+
        						", desc: " + bill.getProductDesc() +
        						", id: " + bill.getProviderId()
        						);
        		}
        	}
            
            //分页显示
            public static void getUserList(Integer pageNo,Integer pageSize){
        		
        		List<User> userList = new ArrayList<User>();
        		    String userName = "";
        			Integer roleId = null;
        			Integer currentPageNo = (pageNo-1)*pageSize;
 userList = session.getMapper(UserMapper.class).getUserList(userName,roleId,currentPageNo,pageSize);
        		     		System.out.println("userlist.size ----> " + userList.size());
        		for(User user: userList){
        			System.out.println(" id: " + user.getId() +
        						" and userCode: " + user.getUserCode() + 
        						" and userName: " + user.getUserName() + 
        						" and userRole: " + user.getUserRole() + 
        						" and userRoleName: " + user.getRole().getRoleName() +
        						" and phone: " + user.getPhone() +
        						" and gender: " + user.getGender()+
       " and creationDate: " + new SimpleDateFormat("yyyy-MM-dd").format(user.getCreationDate()));
        		}
        	}
            
	  	 	 }
	       
	     
	     
	
