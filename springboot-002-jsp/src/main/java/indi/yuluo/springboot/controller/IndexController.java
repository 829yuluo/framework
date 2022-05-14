package indi.yuluo.springboot.controller;

import indi.yuluo.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: yuluo
 * @FileName: IndexController.java
 * @createTime: 2022/5/7 18:28
 * @Description:
 */

@Controller
public class IndexController {

    /*
    Model和view分开
     */
    @RequestMapping(value = "/springboot/jsp")
    public String jsp(Model model) {

        User user = new User(1001, "yuluo");
        model.addAttribute("user", user);

        return "user";
    }

    /*
    ModelAndView
     */
    @RequestMapping(value = "/springboot/jsp2")
    public ModelAndView jsp2() {

        ModelAndView mv = new ModelAndView();
        // 设置数据
        mv.addObject("message", "hello jsp");
        // 设置视图名
        mv.setViewName("user");

        return mv;
    }

}
