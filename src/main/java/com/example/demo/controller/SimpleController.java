package com.example.demo.controller;

import com.example.demo.dao.SensorDao;
import com.example.demo.model.Sensor;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.SensorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {

    @Value("Vitali")
    String appName;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private SensorDao sensorDao;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping({"/listBooks"})
    public ModelAndView getAllBooks() {
        ModelAndView mav = new ModelAndView("list-books");
        mav.addObject("books", bookRepository.findAll());
        return mav;
    }

    @GetMapping({"/listSensor"})
    public ModelAndView getAllSensor() {
        ModelAndView mav = new ModelAndView("list-sensor");
        mav.addObject("sensors", sensorRepository.findAll());
        return mav;
    }

    @GetMapping({"/getFormForAdd"})
    public String showForm(Model model) {
        Sensor sensor = new Sensor();
        model.addAttribute("sensor", sensor);
        return "sensor-form";
    }

   /* @PostMapping("/saveSensor")
    public String save(@RequestBody Sensor sensor) {
        sensorDao.save(sensor);
        return "list-sensor";
    }*/
/*
    @PostMapping("/saveSensor")
    public String addSensor(@Valid Sensor sensor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "sensor-form";
        }
        sensorRepository.save(sensor);
        return "list-sensor";
    }
*/

  /*  @PostMapping(path="/saveSensor")
    public @ResponseBody String addNewUser (
            @RequestParam String names,
            @RequestParam String models,
            @RequestParam String types,
            @RequestParam String ranges,
            @RequestParam String units,
            @RequestParam String location,
            @RequestParam String description) {

        Sensor sensor = new Sensor();
        sensor.setNames(names);
        sensor.setModels(models);
        sensor.setTypes(types);
        sensor.setRanges(ranges);
        sensor.setUnits(units);
        sensor.setUnits(location);
        sensor.setDescription(description);
        sensorRepository.save(sensor);
        return "list-sensor";
    }*/
  @RequestMapping(value = "/saveSensor", method = RequestMethod.POST)
  public String saveSensor(@ModelAttribute("sensor") Sensor sensor) {
      sensorRepository.save(sensor);

      return "redirect:/";
  }

  /* @PostMapping("/saveSensor")
   public String saveSensor(@ModelAttribute("sensor") Sensor sensor) {
       // save employee to database
       sensorDao.saveSensor(sensor);
       return "list-sensor";
   }*/
    /*
    @PostMapping("/saveSensor")
    public String save(Model model, @ModelAttribute("sensor") Sensor sensor) {
        model.addAttribute("sensor", sensor);
      //  sensorDao.save(sensor);
        return "list-sensor";
    }
     */

    @GetMapping("/delete/{id}")
    public String deleteSensor(@PathVariable("id") long id, Model model) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        sensorRepository.delete(sensor);
        return "list-sensor";
    }
}
