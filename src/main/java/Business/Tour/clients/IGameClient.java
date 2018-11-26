package Business.Tour.clients;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@FeignClient("Game")
public interface IGameClient {

    @RequestLine("GET /{id}")
    ResponseEntity getOneById(@Param("id") Long id);
}
