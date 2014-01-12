package com.iansails.yelp.web;
import com.iansails.yelp.model.Text;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/texts")
@Controller
@RooWebScaffold(path = "texts", formBackingObject = Text.class)
public class TextController {
}
