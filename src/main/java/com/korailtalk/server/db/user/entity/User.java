package com.korailtalk.server.db.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @Column(name = "point_password", columnDefinition = "int", nullable = false)
    private Integer pointPassword;

    @Column(name = "point", columnDefinition = "int", nullable = false)
    private Integer point;

    @Builder
    public User(Integer pointPassword, Integer point){
        this.pointPassword = pointPassword;
        this.point = point;
    }
}
