package com.iansails.yelp.web;
import com.iansails.yelp.model.Span;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/spans")
@Controller
@RooWebScaffold(path = "spans", formBackingObject = Span.class)
public class SpanController {
}
