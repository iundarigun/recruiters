package br.com.devcave.recruiters.dto;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForm {

    private Long id;
    @NotBlank(message = "{recruiters.candidate.validation.name.empty}")
    @Size(max = 255)
    private String name;
    @Email
    @NotBlank
    @Size(max = 255)
    private String email;
    @Size(max = 20)
    private String phoneNumber;
    @Size(max = 255)
    private String skypeUser;
    @NotEmpty
    private List<Long> area;
}
