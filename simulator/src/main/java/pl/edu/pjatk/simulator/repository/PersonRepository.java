package pl.edu.pjatk.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.simulator.model.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
