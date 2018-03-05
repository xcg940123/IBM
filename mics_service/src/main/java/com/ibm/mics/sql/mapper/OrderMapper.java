package com.ibm.mics.sql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;

import com.ibm.mics.entity.util.Order;

public interface OrderMapper {
	@Select("SELECT * FROM order")
	List<Order> getAll();
	//@Insert("INSERT INTO baodan(date,ageType) VALUES(#{order.date},#{order.ageType})")
//	@Select("SELECT * FROM user WHERE userName=#{userName}")
//	User getUser(String userName);
	@Insert("INSERT INTO baodan (date,ageType,personCount,kind1,range1,customQuotation11,range2,customQuotation12,kind2,range3,customQuotation21,range4,customQuotation22,kind3,range5,customQuotation31,range6,customQuotation32,range7,customQuotation33,range8,customQuotation34,total,totalValue) VALUES(#{order.date},#{order.ageType},#{order.personCount},#{order.kind1},#{order.range1},#{order.customQuotation11},#{order.range2},#{order.customQuotation12},#{order.kind2},#{order.range3},#{order.customQuotation21},#{order.range4},#{order.customQuotation22},#{order.kind3},#{order.range5},#{order.customQuotation31},#{order.range6},#{order.customQuotation32},#{order.range7},#{order.customQuotation33},#{order.range8},#{order.customQuotation34},#{order.total},#{order.totalValue})")
	void insertOrder(@Param("order") Order order);
//	@Update("UPDATE user SET password=#{password} WHERE userName =#{userName}")
//	void update(User user);
//	@Delete("DELETE FROM user WHERE userName =#{userName}")
//	void Delete(String username);

}

