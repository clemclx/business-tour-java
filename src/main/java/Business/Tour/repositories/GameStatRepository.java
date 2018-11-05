package Business.Tour.repositories;

import Business.Tour.entities.GameStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStatRepository extends JpaRepository<GameStat, Long> {
}
