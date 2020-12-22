package pl.edu.pjatk.simulator.model;

import pl.edu.pjatk.simulator.service.Identifiable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "compartment")

public class Compartment implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int capacity;
    List <Person> occupants;

    public Compartment(){

    }

    public Compartment(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        occupants = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<Person> getOccupants() {
        return occupants;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setOccupants(List<Person> occupants) {
        this.occupants = occupants;
    }

    public void embark(Person person) {
        if (occupants.size() < capacity) {
            occupants.add(person);
        }
    }

    public void disembark(Station station) {
        List<Person> leaving = occupants.stream()
                .filter(p -> p.getDestination().equals(station))
                .collect(Collectors.toList());

        occupants.removeAll(leaving);
    }

}
