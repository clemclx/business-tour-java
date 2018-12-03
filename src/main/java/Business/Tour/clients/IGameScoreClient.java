package Business.Tour.clients;

import Business.Tour.models.GameScore;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("GameScore")
public interface IGameScoreClient {

    @RequestLine("GET /gamescores/{id}")
    Object getOneGameScore(@Param("id") Long id);

    @RequestLine("GET /gamescores")
    Object getAll();

    @RequestLine("POST /gamescores")
    @Headers("Content-Type: application/json")
    Object create(Object gameScore);
}
