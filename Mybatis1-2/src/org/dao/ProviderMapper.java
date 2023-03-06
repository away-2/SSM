package org.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.model.Bill;
import org.model.Provider;
public interface ProviderMapper {
 public int count();
 public List<Provider> fromProvider();//无参
 public List<Provider> getListByName(String proName);//单个参数
 public List<Provider> getListByAddressAndDesc(Provider provider);//以对象为参数
 public List<Provider>getProductListByProvider(String pname);
 public int addProvider(Provider p);
 public int delProvider(String s);
 public int updateProvider(@Param("proName1")String name1,@Param("proName2")String name2);//多个参数
 public int modify(Provider provider);//if+set
 
}
