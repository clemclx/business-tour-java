package Business.Tour.repositories;

import Business.Tour.entities.GameScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameScoreRepository extends JpaRepository<GameScore, Long> {
    List<GameScore> getAllByidUser(Long id);
}
