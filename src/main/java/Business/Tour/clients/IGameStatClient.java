package Business.Tour.clients;

import Business.Tour.models.GameStat;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("GameStat")
public interface IGameStatClient {

    @RequestLine("GET /gamestats/{id}")
    Object getOneGameStats(@Param("id") Long id);

    @RequestLine("GET /gamestats")
    Object getAll();

    @RequestLine("POST /gamestats")
    @Headers("Content-Type: application/json")
    Object create(@RequestBody Object gameStat);

    @RequestLine("PUT /gamestat/{id}")
    Object addScore(@Param("id") Long id, Object gameScore);
}
