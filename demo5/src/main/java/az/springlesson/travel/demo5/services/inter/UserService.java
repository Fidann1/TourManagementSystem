package az.springlesson.travel.demo5.services.inter;

import az.springlesson.travel.demo5.dto.TourRequest;
import az.springlesson.travel.demo5.dto.UserRequest;
import az.springlesson.travel.demo5.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    public void createUser(UserRequest user);
    public UserEntity getUser(int id);
    public List<UserEntity> getAllUsers();
    public void createTrip(Integer id, TourRequest tourRequest);

    public UserDetails findByUsername(String username);
    public UserEntity registerUser(UserEntity user);
    public UserEntity findUserByEmail(String email);
}
