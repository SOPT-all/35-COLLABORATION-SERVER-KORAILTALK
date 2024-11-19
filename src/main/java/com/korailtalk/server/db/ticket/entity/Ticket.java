package com.korailtalk.server.db.ticket.entity;

import com.korailtalk.server.db.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="tickets")
public class Ticket extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @Column(name = "price", columnDefinition = "int", nullable = false)
    private int price;

    @Column(name = "create_at", columnDefinition = "varchar(20)", nullable = false)
    private String createAt;

    @Column(name = "ticket_confirm", columnDefinition = "boolean", nullable = false)
    private boolean ticketConfirm;

    @Builder
    public Ticket(Integer price, String createAt, Boolean ticketConfirm){
        this.price = price;
        this.createAt = createAt;
        this.ticketConfirm = ticketConfirm;
    }

}
