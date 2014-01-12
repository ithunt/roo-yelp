package com.iansails.yelp.web;
import com.iansails.yelp.model.Coordinate;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/coordinates")
@Controller
@RooWebScaffold(path = "coordinates", formBackingObject = Coordinate.class)
public class CoordinateController {
}
