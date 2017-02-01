package br.com.devcave.recruiters.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CandidateVO {
    private String name;
    private String email;
}
