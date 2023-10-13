package com.nidz.home;

import com.nidz.auditing.Auditing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "homes")
public class Home extends Auditing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "owner")
    private UUID owner;
    @Column(name="floor")
    private String floor;
    @Column(name="resident")
    private UUID resident;
    @Column(name="num")
    private int num;
    @Column(name="building")
    private UUID building;
}
