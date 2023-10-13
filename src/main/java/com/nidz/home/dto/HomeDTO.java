package com.nidz.home.dto;

import com.nidz.auditing.dto.AuditingDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class HomeDTO extends AuditingDTO {
    private UUID id;
    private UUID owner;
    private String floor;
    private UUID resident;
    private int num;
    private UUID building;
    private UUID created_by;
    private UUID updated_by;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
