package com.example.thuchanh2.controller;

import com.example.thuchanh2.model.City;
import com.example.thuchanh2.service.HibernateCityService;
import com.example.thuchanh2.service.ICityService;
import jdk.internal.icu.text.NormalizerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/citys")
public class HomeController {
    @Autowired
    ICityService cityService;

    @GetMapping()
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("listCity", cityService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("city", cityService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid City city, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("listErr",bindingResult.getAllErrors());
            return modelAndView;

        }
        ModelAndView modelAndView = new ModelAndView("redirect:/citys");
        cityService.save(city);
        List<City> cityList = cityService.findAll();
        modelAndView.addObject("city", cityList);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("city", cityService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(City city) {
        ModelAndView modelAndView = new ModelAndView("redirect:/citys");
        cityService.delete(city.getId());
        return modelAndView;
    }


    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("city", cityService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@Valid City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("listErr",bindingResult.getAllErrors());
            return modelAndView;

        }
        ModelAndView modelAndView = new ModelAndView("redirect:/citys");
        cityService.save(new City(city.getId(),city.getName(),city.getCountry(),city.getAcreage(),city.getNumberOfPeople(),city.getGdp(),city.getDescription()));
        List<City> thanhPhoList = cityService.findAll();
        modelAndView.addObject("city", thanhPhoList);
        return modelAndView;
    }

}
