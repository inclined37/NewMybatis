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
   public String welcome(@RequestParam(name = "lang", required = false, defaultValue = "nomal") String language, Model model) {
       Locale locale = new Locale(language);
       String welcomeMessage = messageSource.getMessage("welcome.message", null, locale);
       model.addAttribute("welcomeMessage", welcomeMessage);
       return "welcomePage";
   }
}
