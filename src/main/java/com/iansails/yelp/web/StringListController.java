package com.iansails.yelp.web;
import com.iansails.yelp.model.StringList;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stringlists")
@Controller
@RooWebScaffold(path = "stringlists", formBackingObject = StringList.class)
public class StringListController {
}
