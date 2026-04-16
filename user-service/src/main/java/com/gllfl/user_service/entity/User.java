package com.gllfl.user_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("users")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String role;
}