package az.springlesson.travel.demo5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tours")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String region;
    private String hotel;
    private Boolean car;//if there'll be car
    private Integer amountOfPeople;
    private Integer amountOfAdult;
    private Integer amountOfChildren;
    private Integer amountOfInfrant;
    private Double price;
    private Integer duration;// min 1 day
    private LocalDateTime startDay;

    @ManyToOne
    @JoinColumn(name = "consultant_id")
    private UserEntity user;

    @ManyToMany()
    @JoinTable(name = "customers_tours",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name="customer_id"))
    private List<CustomerEntity> customers;

}
