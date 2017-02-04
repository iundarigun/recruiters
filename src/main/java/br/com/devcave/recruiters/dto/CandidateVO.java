package br.com.devcave.recruiters.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CandidateVO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
