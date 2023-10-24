package com.nidz.auditing.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class AuditingDTO {
    @Nullable
    private LocalDateTime created_at;
    @Nullable
    private LocalDateTime updated_at;
    @Nullable
    private UUID created_by;
    @Nullable
    private UUID updated_by;
}
