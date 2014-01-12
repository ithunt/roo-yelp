// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.iansails.yelp.web;

import com.iansails.yelp.model.Text;
import com.iansails.yelp.web.TextController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect TextController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String TextController.create(@Valid Text text, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, text);
            return "texts/create";
        }
        uiModel.asMap().clear();
        text.persist();
        return "redirect:/texts/" + encodeUrlPathSegment(text.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String TextController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Text());
        return "texts/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String TextController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("text", Text.findText(id));
        uiModel.addAttribute("itemId", id);
        return "texts/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String TextController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("texts", Text.findTextEntries(firstResult, sizeNo));
            float nrOfPages = (float) Text.countTexts() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("texts", Text.findAllTexts());
        }
        return "texts/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String TextController.update(@Valid Text text, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, text);
            return "texts/update";
        }
        uiModel.asMap().clear();
        text.merge();
        return "redirect:/texts/" + encodeUrlPathSegment(text.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String TextController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Text.findText(id));
        return "texts/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String TextController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Text text = Text.findText(id);
        text.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/texts";
    }
    
    void TextController.populateEditForm(Model uiModel, Text text) {
        uiModel.addAttribute("text", text);
    }
    
    String TextController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}