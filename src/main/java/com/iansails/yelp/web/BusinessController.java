package com.iansails.yelp.web;
import com.iansails.yelp.model.yelp.Business;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/businesses")
@Controller
@RooWebScaffold(path = "businesses", formBackingObject = Business.class)
public class BusinessController {
}
