package com.example.controller;

import com.example.service.DemoService;
import com.example.vo.ResultVo;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class DemoController {
    @Autowired
    private DemoService demoService; //也可以使用@Resource(name="demoService")，不过Bean定义需要指定Id

    @ResponseBody
    @RequestMapping(value = "/demo")
    public ResultVo demo() throws Exception {
        System.out.println("demo");
        if(1==1){
            throw new Exception("该死的，出错了！");
        }
        return ResultVo.newSucInstance("该死的，竟然成功了！",1);
    }

    @ResponseBody
    @RequestMapping(value = "/demo2")
    public ResultVo demo2(){
        System.out.println("demo2");
        demoService.demoMethod1();
        return ResultVo.newSucInstance("该死的，竟然成功了！",1);
    }

    @ResponseBody
    @RequestMapping(value = "/demo3/{myname}")
    public ResultVo demo3(@PathVariable("myname") String name){
        System.out.println("demo3");
        demoService.demoMethod1();
        return ResultVo.newSucInstance("该死的，"+name+"竟然成功了！",1);
    }

    @ResponseBody
    @RequestMapping(value = "/demo4")
    public ResultVo demo4(@RequestParam(value = "myname",required = false,defaultValue = "走你") String name){ //默认required为true
        System.out.println("demo4");
        demoService.demoMethod1();
        return ResultVo.newSucInstance("该死的4，"+name+"竟然成功了！",1);
    }

    @ResponseBody
    @RequestMapping(value = "/demo5",method = RequestMethod.POST)
    public ResultVo demo5(@Valid UserVo user, BindingResult result){ //此处只需传入参数BindingResult即可，剩余的工作交给ValidationAspect执行
        System.out.println("demo5");
        return ResultVo.newSucInstance("该死的5，"+user.getName()+"竟然成功了！",1);
    }
}
