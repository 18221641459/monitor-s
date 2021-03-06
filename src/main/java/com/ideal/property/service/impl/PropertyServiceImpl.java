package com.ideal.property.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ideal.property.dto.DictionaryDto;
import com.ideal.property.dto.OfferInstDto;
import com.ideal.property.dto.OfferInstRelDto;
import com.ideal.property.dto.OfferProdInstRelDto;
import com.ideal.property.dto.ProdInstAttrDto;
import com.ideal.property.dto.ProdInstDto;
import com.ideal.property.dto.ProductDto;
import com.ideal.property.dto.UserInfoDto;
import com.ideal.property.mapper.DictionaryMapper;
import com.ideal.property.mapper.OfferInstMapper;
import com.ideal.property.mapper.OfferInstRelMapper;
import com.ideal.property.mapper.OfferProdInstRelMapper;
import com.ideal.property.mapper.ProdInstAttrMapper;
import com.ideal.property.mapper.ProdInstMapper;
import com.ideal.property.mapper.ProductMapper;
import com.ideal.property.mapper.UserInfoMapper;


@Service
public class PropertyServiceImpl {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private OfferInstMapper offerInstMapper;

	@Autowired
	private OfferProdInstRelMapper offerProdInstRelMapper;

	@Autowired
	private ProdInstMapper prodInstMapper;

	@Autowired
	private ProdInstAttrMapper prodInstAttrMapper;

	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private OfferInstRelMapper offerInstRelMapper;

	public List<Map> getPropertiesForPage(String phoneNum){
		List<Map> list_data = new ArrayList<Map>();

		List<Map> list_product = new ArrayList<Map>();




		UserInfoDto userInfo = userInfoMapper.getUserInfo(phoneNum);
		String username = userInfo.getUser_name(); //获取用户

		if(null == userInfo){

		}

		List<OfferInstDto> offerInsts = offerInstMapper.getOfferInst(username);

		for(OfferInstDto offerInst_dad : offerInsts){


			int sale_dadId = offerInst_dad.getOFFER_INST_ID();//父销售品id
			List<OfferInstRelDto> offerInstRels = offerInstRelMapper.getOfferInstRel(sale_dadId);
			List<OfferInstRelDto> offerInstRelBySon_list = offerInstRelMapper.getOfferInstRelBySonId(sale_dadId);

			//1.29_alan_添加基础销售品
			if(offerInstRels.size()==0){

				//1.29_alan_验证添加销售品实例表增加的子销售品逻辑
				/*int flag = 1;
				for(OfferInstRelDto verification : offerInstRelBySon_list){
					if(!StringUtils.isEmpty(verification)){
						flag = 0;
						break;
					}
				}
				if(flag==1){*/
				if(offerInstRelBySon_list.size()==0){

					Map<String,Object> map_sale_jichu = new HashMap<String,Object>();
					List<Map> list_product_jichu = new ArrayList<Map>();


					String saleName = offerInst_dad.getOFFER_INST_NAME();//销售品名
//					map_sale.put("propertyid", sale_dadId);
//					map_sale.put("propertyName", saleName);
					map_sale_jichu.put("propertyid", sale_dadId);
					map_sale_jichu.put("propertyName", saleName);


					int saleId = sale_dadId;//单销售品id



					List<OfferProdInstRelDto> offerProdInsts = offerProdInstRelMapper.getOfferProdInstRel(saleId);
					for(OfferProdInstRelDto offerProdInst : offerProdInsts){
						Map<String,Object> map_product_jichu = new HashMap<String,Object>();
						//TODO 联系人  getContactUser(用户名,产品id) return List<用户>

						//产品id
						int product_inst_id = offerProdInst.getPROD_INST_ID();
						ProdInstDto prodInst2 = prodInstMapper.getProdInstByProInsId(product_inst_id);
						int productId = prodInst2.getPROD_ID();

						ProdInstDto prodInst = prodInstMapper.getProdInst(product_inst_id, username);
//						ProdInstDto prodInst = prodInst_list.get(0);

						//通过PROD_INST_ID 主键
						/*ProdInstDto prodInst = prodInstMapper.getProdInst(productId);*/

						map_product_jichu.put("productid", productId);//产品id
						map_product_jichu.put("title", prodInst.getPROD_INST_NAME());//产品名称

						List<ProdInstAttrDto> prodInstAttrs = prodInstAttrMapper.getProdInstAttr(productId);

						//产品属性--缩略图地址,产品状态,联系人
						List<String> contactUser_list = new ArrayList<String>();
						for(ProdInstAttrDto prodInstAttr : prodInstAttrs){
							Integer dictionaryId = prodInstAttr.getATTR_ID(); //属性编码
							String attr_VAL = prodInstAttr.getATTR_VAL();//属性值

							DictionaryDto dictionary = dictionaryMapper.getDictionary(dictionaryId);
							String attr_NAME = dictionary.getATTR_NAME();
							if("缩略图地址".equals(attr_NAME)){
								map_product_jichu.put("thumb", attr_VAL);
							}else if("产品状态".equals(attr_NAME)){
								map_product_jichu.put("isinstall", attr_VAL);
							}else if("联系人".equals(attr_NAME)){
								contactUser_list.add(attr_NAME);
							}else if("图片地址".equals(attr_NAME)){

							}else{
								try {
									throw new Exception("字典表未定义~");
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							map_product_jichu.put("contact", contactUser_list);
						}

						//产品属性--产品类型,产品描述
						ProductDto product = productMapper.getProduct(productId);
						String producttype = product.getPROD_TYPE();
						String productdesc = product.getPROD_DESC();
						if("M".equals(producttype)){
							map_product_jichu.put("producttype", "监控类");
						}else if("A".equals(producttype)){
							map_product_jichu.put("producttype", "加装包类");
						}
						map_product_jichu.put("desc", productdesc);
						//是否安装,生效--------------
						map_product_jichu.put("isinstall", 0);

						list_product_jichu.add(map_product_jichu);
						System.out.println("list_product_jichu:"+list_product_jichu);
				}
					//System.out.println("map_sale_jichu:"+map_sale_jichu);
					//System.out.println("map_sale_jichu--size:"+map_sale_jichu.size());
					map_sale_jichu.put("product", list_product_jichu);
					list_data.add(map_sale_jichu);

				}




			}else{
				Map<String,Object> map_sale = new HashMap<String,Object>();
				String saleName = offerInst_dad.getOFFER_INST_NAME();//销售品名
				map_sale.put("propertyid", sale_dadId);
				map_sale.put("propertyName", saleName);

				for(OfferInstRelDto offerInstRel : offerInstRels){
//					Map<String,Object> map_sale = new HashMap<String,Object>();
					int saleId = offerInstRel.getOFFER_INST_ID();//单销售品id
					//map_sale.put("propertyid", saleId);

					List<OfferProdInstRelDto> offerProdInsts = offerProdInstRelMapper.getOfferProdInstRel(saleId);
					for(OfferProdInstRelDto offerProdInst : offerProdInsts){
						Map<String,Object> map_product = new HashMap<String,Object>();
						//TODO 联系人  getContactUser(用户名,产品id) return List<用户>

						//产品id
						int product_inst_id = offerProdInst.getPROD_INST_ID();
						ProdInstDto prodInst2 = prodInstMapper.getProdInstByProInsId(product_inst_id);
						int productId = prodInst2.getPROD_ID();

						ProdInstDto prodInst = prodInstMapper.getProdInst(product_inst_id, username);
//						ProdInstDto prodInst = prodInst_list.get(0);

						//通过PROD_INST_ID 主键
						/*ProdInstDto prodInst = prodInstMapper.getProdInst(productId);*/

						map_product.put("productid", productId);//产品id
						map_product.put("title", prodInst.getPROD_INST_NAME());//产品名称

						List<ProdInstAttrDto> prodInstAttrs = prodInstAttrMapper.getProdInstAttr(productId);

						//产品属性--缩略图地址,产品状态,联系人
						List<String> contactUser_list = new ArrayList<String>();
						for(ProdInstAttrDto prodInstAttr : prodInstAttrs){
							Integer dictionaryId = prodInstAttr.getATTR_ID(); //属性编码
							String attr_VAL = prodInstAttr.getATTR_VAL();//属性值

							DictionaryDto dictionary = dictionaryMapper.getDictionary(dictionaryId);
							String attr_NAME = dictionary.getATTR_NAME();
							if("缩略图地址".equals(attr_NAME)){
								map_product.put("thumb", attr_VAL);
							}else if("产品状态".equals(attr_NAME)){
								map_product.put("isinstall", attr_VAL);
							}else if("联系人".equals(attr_NAME)){
								contactUser_list.add(attr_NAME);
							}else if("图片地址".equals(attr_NAME)){

							}else{
								try {
									throw new Exception("字典表未定义~");
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							map_product.put("contact", contactUser_list);
						}

						//产品属性--产品类型,产品描述
						ProductDto product = productMapper.getProduct(productId);
						String producttype = product.getPROD_TYPE();
						String productdesc = product.getPROD_DESC();
						if("M".equals(producttype)){
							map_product.put("producttype", "监控类");
						}else if("A".equals(producttype)){
							map_product.put("producttype", "加装包类");
						}
						map_product.put("desc", productdesc);
						//是否安装,生效--------------
						map_product.put("isinstall", 0);

						list_product.add(map_product);
				}

			}
				map_sale.put("product", list_product);
				list_data.add(map_sale);
			}




		//List<OfferInstDto> offerInsts = offerInstMapper.getOfferInst(username);
		/*for(OfferInstDto offerInst : offerInsts){
			Map<String,Object> map_sale = new HashMap<String,Object>();
			int saleId = offerInst.getOFFER_ID();//单销售品id
			String saleName = offerInst.getOFFER_INST_NAME();//销售品名
			map_sale.put("propertyid", saleId);
			map_sale.put("propertyName", saleName);

			List<OfferProdInstRelDto> offerProdInsts = offerProdInstRelMapper.getOfferProdInstRel(saleId);
			for(OfferProdInstRelDto offerProdInst : offerProdInsts){
				Map<String,Object> map_product = new HashMap<String,Object>();
				//TODO 联系人  getContactUser(用户名,产品id) return List<用户>

				//产品id
				int productId = offerProdInst.getPROD_ID();

				List<ProdInstDto> prodInst_list = prodInstMapper.getProdInst(productId, username);
				ProdInstDto prodInst = prodInst_list.get(0);
				map_product.put("productid", productId);//产品id
				map_product.put("title", prodInst.getPROD_INST_NAME());//产品名称

				List<ProdInstAttrDto> prodInstAttrs = prodInstAttrMapper.getProdInstAttr(productId);

				//产品属性--缩略图地址,产品状态,联系人
				List<String> contactUser_list = new ArrayList<String>();
				for(ProdInstAttrDto prodInstAttr : prodInstAttrs){
					Integer dictionaryId = prodInstAttr.getATTR_ID(); //属性编码
					String attr_VAL = prodInstAttr.getATTR_VAL();//属性值

					DictionaryDto dictionary = dictionaryMapper.getDictionary(dictionaryId);
					String attr_NAME = dictionary.getATTR_NAME();
					if("缩略图地址".equals(attr_NAME)){
						map_product.put("thumb", attr_VAL);
					}else if("产品状态".equals(attr_NAME)){
						map_product.put("isinstall", attr_VAL);
					}else if("联系人".equals(attr_NAME)){
						contactUser_list.add(attr_NAME);
					}else if("图片地址".equals(attr_NAME)){

					}else{
						try {
							throw new Exception("字典表未定义~");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					map_product.put("contact", contactUser_list);
				}

				//产品属性--产品类型,产品描述
				ProductDto product = productMapper.getProduct(productId);
				String producttype = product.getPROD_TYPE();
				String productdesc = product.getPROD_DESC();
				if("M".equals(producttype)){
					map_product.put("producttype", "监控类");
				}else if("A".equals(producttype)){
					map_product.put("producttype", "加装包类");
				}
				map_product.put("desc", productdesc);
				//是否安装,生效--------------
				map_product.put("isinstall", 0);

				list_product.add(map_product);
			}*/



			/*map_sale.put("product", list_product);
			list_data.add(map_sale);*/
		}
		return list_data;
	}


	public static void main(String args[]){
		List list = new ArrayList();
		for(int i=0; i<3; i++){
			Map<String, String> map = new HashMap<String, String>();
			map.put(i+"", i*111+"");

			System.out.println(map.hashCode());
			list.add(map);
		}
		System.out.println("list:"+list);

	}




}
