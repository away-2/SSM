package org.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.model.Bill;
public interface BillMapper {
public List<Bill>getBillListIf(@Param("productName")String x,@Param("providerId")Integer y,@Param("isPayment")Integer z);
public List<Bill>getBillListwhere(@Param("productName")String x,@Param("providerId")Integer y,@Param("isPayment")Integer z);
public List<Bill>getBillByProviderId_foreach_array(Integer[]providerIds);
public List<Bill>getBillByProviderId_foreach_list(List<Integer>providerList);
public List<Bill> getBillByConditionMap_foreach_map(Map<String,Object> conditionMap);

}
