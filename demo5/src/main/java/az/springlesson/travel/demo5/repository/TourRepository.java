package az.springlesson.travel.demo5.repository;

import az.springlesson.travel.demo5.entities.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository  extends JpaRepository<TourEntity,Integer> {
}
