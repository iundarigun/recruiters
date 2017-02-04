package br.com.devcave.recruiters.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Size;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class CandidateFilter extends PageFilter {
    @Size(max=255)
    private String name;
    @Size(max=255)
    private String email;
    private Long area;
}
