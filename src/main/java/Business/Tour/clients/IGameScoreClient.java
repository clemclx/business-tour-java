package Business.Tour.clients;

import Business.Tour.models.GameScore;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient("GameScoreClient")
public interface IGameScoreClient {
    @RequestLine("GET /gamestats/{id}")
    List<GameScore> getAllByGameStatId(@Param("id") Long id);
}
