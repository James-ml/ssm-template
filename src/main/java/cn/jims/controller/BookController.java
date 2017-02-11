package cn.jims.controller;

import cn.jims.controller.validation.ValidGroup1;
import cn.jims.entity.Book;
import cn.jims.entity.BookCustom;
import cn.jims.exception.CustomException;
import cn.jims.service.BookCustomService;
import cn.jims.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Jims on 2017/2/7.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //@RequestMapping("/queryBook/{id}") RESTful url格式
    @RequestMapping("/queryBook/{id}")
    public String queryBook(Model model, @PathVariable("id") long id) {
        Book book = null;
        try {
            book = bookService.selectByPrimaryKey(id);
        } catch (CustomException e) {
            model.addAttribute("error",e.getMessage());
            return "error";
        }
        model.addAttribute("book", book);
        return "form0";
    }

    @Autowired
    private BookCustomService bookCustomService;

    @RequestMapping(value = "/findBook", method = {RequestMethod.GET,RequestMethod.POST})
    public String findBook(Model model) {
        List<BookCustom> bookList = null;
        try {
            bookList = bookCustomService.findBookList(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("list", bookList);
        return "form";
    }

    @RequestMapping(value = "/editBook/{id}", method = {RequestMethod.POST,
            RequestMethod.GET})
    public String editBook(Model model, @PathVariable("id") long id) {
        Book book = null;
        try {
            book = bookService.selectByPrimaryKey(id);
        } catch (CustomException e) {
            model.addAttribute("error",e.getMessage());
        }
        model.addAttribute("book", book);
        return "edit";
    }

    //封装表单数据
    //要求表单的name属性和实体类中的属性名一致
    //实体类被多个controller共用，需要分组校验
    //@Validated BookCustom bookCustom,BindingResult bindingResult:捕获表单错误信息
    @RequestMapping(value = "/editSubmit/{id}", method = {RequestMethod.POST,
            RequestMethod.GET})
    public String editSubmit(Model model, @PathVariable("id") long id, @Validated(value = {ValidGroup1.class}) BookCustom bookCustom, BindingResult bindingResult) {
        //校验表单提交的信息
        if (bindingResult.hasErrors()) {
            //获取错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                System.out.println(objectError.getDefaultMessage());
            }

            model.addAttribute("errors", allErrors);
            model.addAttribute("book",bookCustom);

            return "edit";
        }

        int i = bookService.updateByPrimaryKey(id, bookCustom);
        System.out.println(i);
        return "success";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test() {
        ModelAndView m = new ModelAndView();
        m.setViewName("/json.jsp");
        return m;
    }
}
