package com.rjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class loginController {
  @RequestMapping("/RequestPart")
  public String  requestPartHtml(){
    return "RequestPart";
  }
}
