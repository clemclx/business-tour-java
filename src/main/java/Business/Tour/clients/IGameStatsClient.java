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

    @RequestLine("GET /kda/{id}")
    Long getRatioWLById(@Param("id") Long id);
}
