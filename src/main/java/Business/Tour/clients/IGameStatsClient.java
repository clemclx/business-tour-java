package Business.Tour.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("GameStatsClient")
public interface IGameStatsClient {

}
