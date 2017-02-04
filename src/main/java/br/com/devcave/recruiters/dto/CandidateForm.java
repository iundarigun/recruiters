package br.com.devcave.recruiters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForm {
    private Long id;
    @NotBlank
    @Size(max=255)
    private String name;
    @Email
    @NotBlank
    @Size(max=255)
    private String email;
    @Size(max=20)
    private String phoneNumber;
    @NotEmpty
    private List<Long> area;
}
