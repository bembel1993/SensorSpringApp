package com.example.demo.controller;

import com.example.demo.dao.SensorDao;
import com.example.demo.model.Person;
import com.example.demo.model.Sensor;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.PersonService;
import com.example.demo.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    @Autowired
    private SensorService sensorService;
    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String loginForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "login";
    }

    @GetMapping("/register")
    public String registrForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "register";
    }

    @GetMapping("/home")
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

    @GetMapping("/getFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("sensor", sensor);
        return "sensor-form-update";
    }

    @PostMapping("/update")
    public String updateSensor(@ModelAttribute("sensor") Sensor sensor) {
        sensorRepository.save(sensor);
        return "redirect:/listSensor";
    }

    @RequestMapping(value = "/saveSensor", method = RequestMethod.POST)
    public String saveSensor(@ModelAttribute("sensor") Sensor sensor, Model model) {
        //sensorRepository.save(sensor);
        sensorService.save(sensor);
        return "redirect:/listSensor";
    }

    @RequestMapping(value = "/savePerson", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person person, Model model) {
        //personRepository.save(sensor);
        personService.save(person);
        return "page-user";
    }

    @GetMapping("/delete/{id}")
    public String deleteSensor(@PathVariable("id") int id, Model model) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        sensorRepository.delete(sensor);
        return "redirect:/listSensor";
    }

    @GetMapping("/searchByName")
    public String searchByName(@RequestParam("searchName") String searchName, Model model) {
        List<Sensor> sensorList = sensorService.searchByName(searchName);
        if (sensorList.isEmpty()) {
            model.addAttribute("searchWarning", "Sorry!! Search not found.");
        }
        model.addAttribute("sensors", sensorList);
        return "search-result";
    }
   /* @PostMapping("/saveSensor")
    public String save(@RequestBody Sensor sensor) {
        sensorDao.save(sensor);
        return "list-sensor";
    }*/

    /*@PostMapping("/saveSensor")
    public String addSensor(@Valid Sensor sensor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/getFormForAdd";
        }
       // Sensor sens = new Sensor(6, "s","s","s","s","s","s","s");
        sensorRepository.save(sensor);
        return "redirect:/listSensor";
    }*/

    /*@PostMapping(path="/saveSensor")
    public @ResponseBody String saveSensor (
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
        //sensorDao.saveSensor(sensor);
        sensorRepository.save(sensor);
        return "redirect:/listSensor";
    }*/

  /* @PostMapping("/saveSensor")
   public String saveSensor(@ModelAttribute("sensor") Sensor sensor) {
       // save employee to database
       sensorDao.saveSensor(sensor);
       return "list-sensor";
   }*/

    /*@PostMapping("/saveSensor")
    public String save(Model model, @ModelAttribute("sensor") Sensor sensor) {
        model.addAttribute("sensor", sensor);
        sensorDao.save(sensor);
        return "list-sensor";
    }*/
}
