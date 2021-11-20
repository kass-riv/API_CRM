package com.acme.api_crm.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import com.acme.api_crm.model.Alumno;
import com.acme.api_crm.repository.AlumnoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller

public class HomeController {
    private final AlumnoRepository alumnoData;

    public HomeController(AlumnoRepository alumnoData){

        this.alumnoData = alumnoData;
        

    }

    private static final String VIEW_INDEX ="alumno/indexAlu"; 
    private static final String HOME_INDEX ="welcome"; 
    private static final String VIEW_DASHBOARD ="dashboard"; 
    private static final String VIEW_DASHBOARD2 ="dashboard2";
    private static final String VIEW_DASHBOARD3 ="dashboard3";
    private static final String VIEW_CREATE = "alumno/createAlu";
    private static String MODEL_ALUMNO="alumno";

    @GetMapping("/")
    public String index(Model model) {
        return HOME_INDEX;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return VIEW_DASHBOARD;
    }

    @GetMapping("/dashboard2")
    public String dashboard2(Model model) {
        return VIEW_DASHBOARD2;
    }

    @GetMapping("/dashboard3")
    public String dashboard3(Model model) {
        return VIEW_DASHBOARD3;
    }

    
    @GetMapping("alumno/indexAlu")
    public String indexAlu(Model model){
        List<Alumno> listAlumno = this.alumnoData.findAll();
        model.addAttribute("alumnos",listAlumno);
        return VIEW_INDEX;
    }    

    @GetMapping("alumno/createAlu")
    public String create(Model model) {
        model.addAttribute(MODEL_ALUMNO, new Alumno());
        return VIEW_CREATE;
    }    

    @PostMapping("alumno/createAlu")
    public String createSubmitForm(Model model, 
        @Valid Alumno objAlumno, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro un nuevo alumno");
        }else{
            this.alumnoData.save(objAlumno);
            model.addAttribute(MODEL_ALUMNO, objAlumno);
            model.addAttribute("mensaje", "Se registro un nuevo alumno");
        }
        return VIEW_CREATE;
    }


}
