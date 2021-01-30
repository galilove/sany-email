package com.sany.email.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author lijiali
 * @ClassName: EchoController
 * @ProjectName sany-email
 * @date 2021/1/30 0030下午 2:05
 */
@RestController
@RequestMapping("/echo")
public class EchoController {

    @ResponseBody
    @GetMapping(value = "/name/{str}")
    public String echo(@PathVariable("str") String str){
        return "你好,我是服务提供者" + str;
    }
}
