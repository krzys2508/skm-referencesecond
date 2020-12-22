package pl.edu.pjatk.simulator.service;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.simulator.model.Compartment;
import pl.edu.pjatk.simulator.model.Station;
import pl.edu.pjatk.simulator.model.Train;
import pl.edu.pjatk.simulator.repository.TrainRepository;

import java.util.Collection;
import java.util.List;

@Service
public class TrainService {
    TrainRepository trainRepository;
    private final Collection<Train> trains;

    public TrainService() {
        this.trains = trainRepository.findAll();
    }

    public void moveTimeForward() {
        trains.forEach(Train::move);
    }

    public Collection<Train> getAll() {
        return trains;
    }

    public Train getById(Long id) {
        return trains.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteTrain(Long id) {
        if (trainRepository.findById(id).isPresent()) {
            trainRepository.deleteById(id);
        }
        else {
            System.out.println("Not Found");
        }
    }

    public void createTrain (Train train){
        trainRepository.save(train);
    }

    public void updateTrain (Long id, List<Compartment> compartments, Station currentStation, boolean goingToGdansk, int currentPauseTime){
        if(trainRepository.findById(id).isPresent()){
            Train found = trainRepository.findById(id).get();
            found.setCompartments(compartments);
            found.setCurrentStation(currentStation);
            found.setCurrentPauseTime(currentPauseTime);
            found.setGoingToGdansk(goingToGdansk);
    }
}}
