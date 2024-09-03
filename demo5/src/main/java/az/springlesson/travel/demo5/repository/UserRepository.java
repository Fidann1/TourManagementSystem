package az.springlesson.travel.demo5.repository;

import az.springlesson.travel.demo5.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity, Integer> {
    public UserEntity findByUsername(String username);
    public UserEntity findByEmail(String email);
}
