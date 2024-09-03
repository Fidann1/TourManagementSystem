package az.springlesson.travel.demo5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourRequest {
    private Integer id;
    private Boolean car;//if there'll be car
    private String region;
    private String hotel;
    private Integer amountOfPeople;
    private Integer amountOfAdult;
    private Integer amountOfChildren;
    private Integer amountOfInfrant;
    private Double price;
    private Integer duration;// min 1 day
    private LocalDateTime startDay;
}
