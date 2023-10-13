package com.nidz.residence.dto;

import com.nidz.auditing.dto.AuditingDTO;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResidenceDTO extends AuditingDTO {
    private UUID id;
    private String name;
    private String description;
    @Nullable
    private UUID syndicate;
}
