package pl.edu.pjatk.simulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjatk.simulator.model.Compartment;
import pl.edu.pjatk.simulator.service.CompartmentService;

@RestController
public class CompartmentController {
    @Autowired
    private CompartmentService compartmentService;

    @GetMapping("/cars")
    public Iterable<Compartment> getCompartments(){
        return compartmentService.getAllCompartments();
    }
}
