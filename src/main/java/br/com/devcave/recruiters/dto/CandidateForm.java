package br.com.devcave.recruiters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CandidateForm {
    private String name;
    private String email;
}
