package az.springlesson.travel.demo5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "customers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Integer age;

    @ManyToMany()
    @JoinTable(name = "customers_tours",
    joinColumns = @JoinColumn(name = "customer_id"),
    inverseJoinColumns = @JoinColumn(name="tour_id"))
    private List<TourEntity> tours;


}
