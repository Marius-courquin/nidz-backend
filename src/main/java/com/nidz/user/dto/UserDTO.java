package com.nidz.user.dto;

import com.nidz.auditing.dto.AuditingDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserDTO extends AuditingDTO {
    private UUID id;
    private String last_name;
    private String first_name;
    private LocalDate birth_date;
    private String country;
    private String gender;
    private String avatar;
    private String email;
    private String phone;
}
