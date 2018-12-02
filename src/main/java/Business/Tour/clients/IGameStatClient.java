package Business.Tour.clients;

import Business.Tour.models.GameScore;
import Business.Tour.models.GameStat;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient("GameStat")
public interface IGameStatClient {

    @RequestLine("GET /gamestats/{id}")
    Object getOneGameStats(@Param("id") Long id);

    @RequestLine("GET /gamestats")
    Object getAll();

    @RequestLine("POST /gamestats")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Object create(@ModelAttribute GameStat gameStat);


}
