package com.gllfl.user_service.service.impl;

import com.gllfl.user_service.dto.UserRequest;
import com.gllfl.user_service.entity.User;
import com.gllfl.user_service.repository.UserRepository;
import com.gllfl.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Mono<User> createUser(UserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .role(request.getRole())
                .build();
        return userRepository.save(user);
    }

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public Mono<User> updateUser(Long id, UserRequest request) {
        return userRepository.findById(id)
                .flatMap(user -> {
                    user.setName(request.getName());
                    user.setEmail(request.getEmail());
                    user.setMobile(request.getMobile());
                    user.setRole(request.getRole());
                    return userRepository.save(user);
                });
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }


}