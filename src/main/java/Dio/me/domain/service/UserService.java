package Dio.me.domain.service;

import Dio.me.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
