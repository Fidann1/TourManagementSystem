package az.springlesson.travel.demo5.services.impl;

import az.springlesson.travel.demo5.dto.TourRequest;
import az.springlesson.travel.demo5.dto.UserRequest;
import az.springlesson.travel.demo5.entities.TourEntity;
import az.springlesson.travel.demo5.entities.UserEntity;
import az.springlesson.travel.demo5.enums.RoleEnum;
import az.springlesson.travel.demo5.repository.TourRepository;
import az.springlesson.travel.demo5.repository.UserRepository;
import az.springlesson.travel.demo5.services.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TourRepository tourRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, TourRepository tourRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tourRepository = tourRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserRequest user) {
        UserEntity userEntity = UserEntity.builder().age(user.getAge()).id(user.getId()).email(user.getEmail())
                .username(user.getUsername()).password(passwordEncoder.encode(user.getPassword())).role(user.getRole())
                .build();

        userRepository.save(userEntity);

        System.out.println("Operation is performed successfully.");

    }

    @Override
    public UserEntity getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createTrip(Integer id, TourRequest tourRequest) {
        UserEntity user= userRepository.findById(id).orElse(null);
        if(user.getRole().equals(RoleEnum.CONSULTANT)){
            TourEntity tour = TourEntity.builder().id(tourRequest.getId()).car(tourRequest.getCar())
                    .amountOfPeople(tourRequest.getAmountOfPeople()).amountOfAdult(tourRequest.getAmountOfAdult())
                    .amountOfChildren(tourRequest.getAmountOfChildren()).
                    amountOfInfrant(tourRequest.getAmountOfInfrant()).price(tourRequest.getPrice())
                    .duration(tourRequest.getDuration()).startDay(tourRequest.getStartDay()).
                    build();
            tour.setUser(user);


            tourRepository.save(tour);
        }

    }

    @Override
    public UserDetails findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    public UserEntity registerUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
