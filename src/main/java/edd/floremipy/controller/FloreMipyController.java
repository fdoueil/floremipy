package edd.floremipy.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class FloreMipyController {
    
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String catalogue(ModelMap model) {

        List<Object> catalogue = Collections.emptyList();
        model.addAttribute("catalogue", catalogue);
        return "index";
    }


}
