package Business.Tour.clients;

import Business.Tour.models.GameScore;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("Game")
public interface IGameClient {

    @RequestLine("GET /gameStats/ratioWL/{id}")
    Object getRatioWL(@Param("id") Long id);

    @RequestLine("GET /gameStats/averageMoneyEarned/{id}")
    Object getAverageMoneyEarned(@Param("id") Long id);

    @RequestLine("GET /gameStats/averageDuration/{id}")
    Object getAverageDuration(@Param("id") Long id);

    @RequestLine("GET /gameStatsUpdated/{id}")
    Object getGameStatsUpdated(@Param("id") Long id);

}

