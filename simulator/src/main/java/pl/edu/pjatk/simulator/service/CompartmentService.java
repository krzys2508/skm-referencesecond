package pl.edu.pjatk.simulator.service;

import pl.edu.pjatk.simulator.model.Compartment;
import pl.edu.pjatk.simulator.repository.CompartmentRepository;

import java.util.List;
import java.util.Optional;

public class CompartmentService {
    private CompartmentRepository compartmentRepository;

    public List<Compartment> getAllCompartments() {
        return compartmentRepository.findAll();
    }

    public Compartment getById (Long id ){
        return compartmentRepository.findById(id).get();
    }

    public void delete(Long id) {
        Optional<Compartment> found = compartmentRepository.findById(id);

        if (found.isPresent()) {
            compartmentRepository.delete(found.orElseThrow());
        }
    }
    public void createCompartment (Compartment compartment){
        compartmentRepository.save(compartment);
    }

    public void updateCompartment (long id, int capacity){
if (compartmentRepository.findById(id).isPresent()){
    compartmentRepository.findById(id).get().setCapacity(capacity);
}
else {
    System.out.println("Not found");
}
    }
}
