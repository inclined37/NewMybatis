package com.test.controller;

import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
   @Autowired
   private MessageSource messageSource;
   
   //@RequestMapping("/welcome")
   @RequestMapping(value = {"/", "/welcome"})
   public String welcome(@RequestParam(name = "lang", required = false, defaultValue = "ko") String language, Model model) {
       Locale locale = new Locale(language);
       String welcomeMessage = messageSource.getMessage("welcome.message", null, locale);
       String ko_btn = messageSource.getMessage("korean.btn", null, locale);
       String en_btn = messageSource.getMessage("English.btn", null, locale);
       String main_btn = messageSource.getMessage("Main.btn", null, locale);
       String title = messageSource.getMessage("title", null, locale);
       model.addAttribute("welcomeMessage", welcomeMessage);
       model.addAttribute("title", title);
       model.addAttribute("ko_btn", ko_btn);
       model.addAttribute("en_btn", en_btn);
       model.addAttribute("main_btn", main_btn);
       return "welcomePage";
   }
}
