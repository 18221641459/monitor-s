package com.ideal.sales.service;

import java.util.List;

import com.ideal.sales.dto.SalesByDto;
import com.ideal.sales.dto.SalesDto;


/**
* @author JJB
* @version 创建时间：2019年1月22日 下午4:17:37
* 
*/
public interface SalesService {

	List<SalesDto> queryAllSales();

	SalesByDto querySalesBy(String oFFER_ID);

	Object addSalesCart(String oFFER_ID, String uSER_NAME);
	
	

}
