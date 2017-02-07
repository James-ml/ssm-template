package cn.jims.controller;

import cn.jims.entity.BookCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <p>Title: JsonTest</p>
 * <p>Description: json交互测试</p>
 */
@Controller
public class JsonTest {
	
	//请求json串(商品信息)，输出json(商品信息)
	//@RequestBody将请求的商品信息的json串转成bookCustom对象
	//@ResponseBody将bookCustom转成json输出
	@RequestMapping(value = "/requestJson",method = RequestMethod.POST)
	public @ResponseBody BookCustom requestJson(@RequestBody BookCustom bookCustom){
		System.out.println("=========1==========");
		System.out.println(bookCustom.getName());
		System.out.println(bookCustom.getNumber());
		//@ResponseBody将bookCustom转成json输出
		return bookCustom;
	}
	
	//请求key/value，输出json
	@RequestMapping(value = "/responseJson",method = RequestMethod.POST)
	public @ResponseBody BookCustom responseJson(BookCustom bookCustom){
		System.out.println("=========2==========");
		System.out.println(bookCustom.getName());
		System.out.println(bookCustom.getNumber());
		//@ResponseBody将bookCustom转成json输出
		return bookCustom;
	}

}
