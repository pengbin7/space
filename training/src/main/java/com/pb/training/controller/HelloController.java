package com.pb.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author pengbin
 * @date 2020/5/11 15:25
 */
@RestController
public class HelloController {

    @GetMapping("")
    public String index(){
        return "success";
    }

}
