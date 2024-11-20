package com.korailtalk.server.db.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @Column(name = "point_password", columnDefinition = "int", nullable = false)
    private int pointPassword;

    @Column(name = "point", columnDefinition = "int", nullable = false)
    private int point;

    @Builder
    public User(final int pointPassword, final int point) {
        this.pointPassword = pointPassword;
        this.point = point;
    }

    public void updatePoint(final int usedPoint) {
        this.point -= usedPoint;
    }
}
