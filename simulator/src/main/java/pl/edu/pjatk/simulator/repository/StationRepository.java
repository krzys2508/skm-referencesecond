package pl.edu.pjatk.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.simulator.model.Station;

public interface StationRepository extends JpaRepository<Station,Long> {
}
