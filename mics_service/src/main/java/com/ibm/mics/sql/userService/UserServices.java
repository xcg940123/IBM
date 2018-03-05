package com.ibm.mics.sql.userService;

import java.net.MalformedURLException;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.ibm.mics.entity.util.*;
import com.ibm.mics.json.entity.base.JacksonUtil;
import com.ibm.mics.json.entity.base.Json_fabric;
import com.ibm.mics.sql.mapper.*;

import cn.mics.brank.main.test.mainTest;

@Controller
@RequestMapping("/user/*")
@PropertySources({ @PropertySource(value = "classpath:micsApplication.properties", ignoreResourceNotFound = true) })
public class UserServices {
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private OrderMapper ordermapper;
	@Autowired
	private OrderContractMapper ordercontractmapper;
	@Autowired
	private MadicalCareMapper madicalcaremapper;
   //首页
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
//	//填保
//		@RequestMapping("/orderContract")
//		public String orderContract() {
//			return "orderContract";
//		}
	
	//电子病历
		@RequestMapping("/medicalCare")
		public String medicalCare() {
			return "medicalCare";
		}	
		
//	//合同
//		@RequestMapping("/contract")
//		public String contract() {
//			return "contract";
//		}
//		
	//保险
	@RequestMapping("/buy")
	public String buy() {
		return "buy";
	}
	
	//立即购买
		@RequestMapping("/order")
		public String order() {
			return "order";
		}

	// 登录页面
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	// 注册页面
	@RequestMapping("/register")
	public String register() {
		return "/register";
	}

	
	// 登录方法
	@RequestMapping("/addlogin")
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		password=mdPassword(password,username);
		User user = new User(username, password);
		User userVerify = usermapper.getUser(username);
		while (username.equals(userVerify.getUserName()) && password.equals(userVerify.getPassword())) {
			return "success";
		}
		return "failure";
	}
	
	//注册方法
	@RequestMapping("/addregister")
	public String register(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		//System.out.println("===="+username+"======"+password+"========"+password2);
		if(password.equals(password2)) {
			password=mdPassword(password,username);
			User user=new User(username,password);
			//System.out.println("===="+username+"======"+password+"========"+password2);
			usermapper.insert(user);
			return "success";
		}
		return "failure";
	}
	
	//读取order数据存储
		@RequestMapping("/saveMedicalCare")
		public String medicalCare(HttpServletRequest request) {
			String kind=request.getParameter("kind");
			String range=request.getParameter("range");
			String payment=request.getParameter("payment");
			String patientName=request.getParameter("patientName");

            MedicalCare medicalcare=new MedicalCare(kind,range,payment,patientName);
            madicalcaremapper.insertomedical(medicalcare);;
          
			return "success";
		}
		
		//madicalCare数据存储
		//读取order数据存储
				@RequestMapping("/contract")
				public String contract(HttpServletRequest request) {
					String orderName=request.getParameter("orderName");
					String certifitype=request.getParameter("certifitype");
					String certifiNumber=request.getParameter("certifiNumber");
					String sex=request.getParameter("sex");
					String birthday=request.getParameter("birthday");
					String phonenumber=request.getParameter("phonenumber");
					String email=request.getParameter("email");
					String orderedName=request.getParameter("orderedName");
					String relationship=request.getParameter("relationship");
					String certifiType2=request.getParameter("certifiType2");
					String certifiNumber2=request.getParameter("certifiNumber2");
					String birthday2=request.getParameter("birthday2");
					String sex2=request.getParameter("sex2");
					String phoneNumber2=request.getParameter("phoneNumber2");

		            OrderInfo orderinfo=new OrderInfo(orderName,certifitype,certifiNumber,sex,birthday,phonenumber,email);
		            ordercontractmapper.insertorderinfo(orderinfo);
		            OrderedInfo orderedinfo=new OrderedInfo(orderedName,relationship,certifiType2,certifiNumber2,birthday2,sex2,phoneNumber2);
		            ordercontractmapper.insertorderedinfo(orderedinfo);
					return "contract";
				}

		
		//读取投保人与被投保人信息
		//读取order数据存储
				@RequestMapping("/orderContract")
				public String order(HttpServletRequest request) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, MalformedURLException {
					String date=request.getParameter("date");
					String ageType=request.getParameter("ageType");
					String personCount=request.getParameter("personCount");
					String kind1=request.getParameter("kind1");
					String range1=request.getParameter("range1");
					String customQuotation11=request.getParameter("customQuotation11");
					String range2=request.getParameter("range2");
					String customQuotation12=request.getParameter("customQuotation12");
					String kind2=request.getParameter("kind2");
					String range3=request.getParameter("range3");
					String customQuotation21=request.getParameter("customQuotation21");
					String range4=request.getParameter("range4");
					String customQuotation22=request.getParameter("customQuotation22");
					String kind3=request.getParameter("kind3");
					String range5=request.getParameter("range5");
					String customQuotation31=request.getParameter("customQuotation31");
					String range6=request.getParameter("range6");
					String customQuotation32=request.getParameter("customQuotation32");
					String range7=request.getParameter("range7");
					String customQuotation33=request.getParameter("customQuotation33");
					String range8=request.getParameter("range8");
					String customQuotation34=request.getParameter("customQuotation34");
					String total=request.getParameter("total");
					String totalValue=request.getParameter("totalValue");

		            Order order=new Order(date,ageType,personCount,kind1,range1,customQuotation11,range2,customQuotation12,kind2,range3,customQuotation21,range4,customQuotation22,kind3,range5,customQuotation31,range6,customQuotation32,range7,customQuotation33,range8,customQuotation34,total,totalValue);
		            ordermapper.insertOrder(order);
		            
		    		String resMsgJson = "";
		            
		            Json_fabric message=new Json_fabric();
		            
		            message.setName("a");
		            message.setNamevalue("200");
		            message.setMoney("b");
		            message.setMoneyvalue("400");
		            
		            resMsgJson=JacksonUtil.toJSon(message);
		            Json_fabric messageToBase=JacksonUtil.readValue(resMsgJson, Json_fabric.class);
		            System.out.println("我在service"+"======"+resMsgJson+"========");
		            mainTest maintest = new mainTest();
		            maintest.getInformation(resMsgJson);
		            System.out.println("=============="+"hahah"+"===============");
					return "success";
				}
	
	//密码加密
	private static String mdPassword(String password, String username) {
		String md = "";
		try {
			String passw = "{dhjdfu34i34u34-zmew8732dfhjd-";
			String usern = "dfhjdf8347sdhxcye-ehjcbeww34}";
			String pass = password + passw + username + usern;
			md = md5(pass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return md;
	}
	private static String md5(String str) {
		try {
			byte[] returnByte = str.getBytes("utf-8");
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			returnByte = md5.digest(str.getBytes("utf-8"));
			StringBuffer buf = new StringBuffer("");
			int i;
			for (int offset = 0; offset < returnByte.length; offset++) {
				i = returnByte[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}


}
