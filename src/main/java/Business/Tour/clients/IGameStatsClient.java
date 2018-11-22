package Business.Tour.clients;

import Business.Tour.models.GameStats;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
@FeignClient("GameStatsClient")
public interface IGameStatsClient {

    @RequestLine("GET /{id}")
    GameStats getOneById(@Param("id") Long id);

    @RequestLine("GET /ratioWL/{id}")
    Long getRatioWLById(@Param("id") Long id);

    @RequestLine("GET /averageMoneyEarned/{id}")
    Long getAverageMoneyEarned(@Param("id") Long id);

    @RequestLine("GET /averageDuration/{id}")
    Long getAverageDuration(@Param("id") Long id);
}
