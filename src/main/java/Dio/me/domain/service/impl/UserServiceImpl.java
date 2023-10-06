package Dio.me.domain.service.impl;

import Dio.me.domain.model.User;
import Dio.me.domain.repository.UserRepository;
import Dio.me.domain.service.UserService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
//        if(userToCreate.getId() != null && (userRepository.existsById(userToCreate.getId()))){
//            throw new IllegalArgumentException("This User ID already exists.");
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
