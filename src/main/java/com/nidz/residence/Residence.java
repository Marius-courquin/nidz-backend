package com.nidz.residence;

import com.nidz.auditing.Auditing;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "residences")
public class Residence extends Auditing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Nullable
    @Column(name = "syndicate")
    private UUID syndicate;
}
