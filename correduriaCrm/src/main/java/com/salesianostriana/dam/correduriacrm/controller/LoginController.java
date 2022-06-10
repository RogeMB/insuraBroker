package com.salesianostriana.dam.correduriacrm.controller;

import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.repository.EmpleadoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class LoginController {

    //private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private EmpleadoRepository empleadoRepo;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @PostMapping("/login-in")
    public String autentificar(Empleado empleado, Model model, @AuthenticationPrincipal UserDetails user) {
        Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(empleado.getUsername());
        
        

        //log.info("inside");

        if (elUsuario.isPresent()) {
            Empleado empl = elUsuario.get();

            if (empl.getRole().equals("USER")) {
                model.addAttribute("usuario", elUsuario.get());
                return "dashboard/user/index";
            } else if (empl.getRole().equals("ADMIN")) {
                model.addAttribute("usuario", elUsuario.get());
                model.addAttribute("name", elUsuario.get().getUsername());
                return "dashboard/admin/index";
            }
        }
//        return "login";
        return "redirect:/login-error";
    }

    @GetMapping("/login-in")  // el código no está utilizando el get en la ejecución
    public String autentificarGet(Empleado empleado, Model model, @AuthenticationPrincipal UserDetails user) {
        Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(empleado.getUsername());

        //log.info("inside");

        if (elUsuario.isPresent()) {
            Empleado empl = elUsuario.get();

            if (empl.getRole().equals("USER")) {
                //model.addAttribute("usuario", elUsuario.get());
                return "dashboard/admin/index";
            } else if (empl.getRole().equals("ADMIN")) {
                //model.addAttribute("usuario", elUsuario.get());
                return "admin/user/index";
            }
        }
        return "index";
    }

}