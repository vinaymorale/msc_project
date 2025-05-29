package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.Rights;
import com.example.polishCommunity.service.RightsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RightsController {

 private RightsService rightsService;

 public RightsController(RightsService rightsService){
  this.rightsService=rightsService;
 }
    @GetMapping("/rights/{id}")
    public ModelAndView getRightsPage(@PathVariable int id){
        ModelAndView mav=new ModelAndView("/admin/Rights");
        Rights rights =rightsService.getRightsByTitleId(id);

        mav.addObject("rights",rights);
        return mav;
    }

    @GetMapping("/rightsView/{id}")
    public ModelAndView getRightsAdminPage(@PathVariable int id){
        ModelAndView mav=new ModelAndView("Pages/RightsView");
        Rights rights =rightsService.getRightsByTitleId(id);

        mav.addObject("rights",rights);
        return mav;
    }
}





