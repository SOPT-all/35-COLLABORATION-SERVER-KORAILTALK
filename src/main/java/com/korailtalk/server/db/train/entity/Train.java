package com.korailtalk.server.db.train.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 기본 엔티티 스펙
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) //같은 패키지 내에서
@Getter
@Table(name="trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false) //nullable=flase null값 안됨
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(255)", nullable = false)
    private String name;

    //public Train(){
    //}
    //@NoArgsConstructor과 같은 것
    //기본 생성자가 필요한 이유
    //객체 -> 영속성 -> db
    //기본 생성자가 영속성을 주기 때문에 필요함

    @Builder
    public Train(final String name){
        this.name = name;
    }

}
