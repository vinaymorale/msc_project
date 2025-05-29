package com.example.polishCommunity.controller;

import com.example.polishCommunity.model.CreatePolicy;
import com.example.polishCommunity.model.Rights;
import com.example.polishCommunity.model.SubRights;
import com.example.polishCommunity.service.RightsService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AddRightsPolicyController {
    private RightsService rightsService;

    public AddRightsPolicyController(RightsService rightsService){
        this.rightsService = rightsService;
    }

    @GetMapping("/addNewPolicy/{title_id}")
    public ModelAndView getRightsAddPolicyPage(@PathVariable int title_id){
        ModelAndView modelAndView=new ModelAndView("Pages/createRightsPolicy");
        SubRights subRights = new SubRights();
        subRights.setTitleId(title_id);
        modelAndView.addObject("subRights",subRights);
        return modelAndView;
    }

    @PostMapping("/addNewPolicy")
    public ModelAndView submitForm(@ModelAttribute("subRights") SubRights subRights){
        ModelAndView mav;
        rightsService.setRights(subRights);
        mav=new ModelAndView("redirect:/rights/1");
        return mav;
    }

    @GetMapping("/editNewPolicy/{sub_title_id}")
    public ModelAndView getRightsEditPolicyPage(@PathVariable int sub_title_id){
        ModelAndView modelAndView=new ModelAndView("Pages/EditRights");
        SubRights subRights = rightsService.getSubRightsBySubRightsId(sub_title_id);
//        subRights.setTitleId(title_id);
        modelAndView.addObject("subRights",subRights);
        return modelAndView;
    }

    @PostMapping("/editNewPolicy")
    public ModelAndView getRightsEditPolicyPage(@ModelAttribute("subRights") SubRights subRights){
        ModelAndView mav;
        rightsService.editSubRight(subRights);
        mav=new ModelAndView("redirect:/rights/1");
        return mav;
    }

    @GetMapping("/deletePolicy/{id}")
    public ModelAndView submitForm(@PathVariable("id") int id){
        ModelAndView mav;
        rightsService.deleteSubRights(id);
        mav=new ModelAndView("redirect:/rights/1");
        return mav;
    }
}

