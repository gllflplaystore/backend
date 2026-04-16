package com.gllfl.user_service.service;

import com.gllfl.user_service.dto.UserRequest;
import com.gllfl.user_service.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> createUser(UserRequest request);
    Flux<User> getAllUsers();
    Mono<User> getUserById(Long id);
    Mono<User> getUserByEmail(String email);
    Mono<User> updateUser(Long id, UserRequest request);
    Mono<Void> deleteUser(Long id);
}
