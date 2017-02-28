package br.com.devcave.recruiters.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import br.com.devcave.recruiters.domain.Candidate;
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

    private Boolean hasCurriculum;

    @NotEmpty
    private List<Long> area = new ArrayList<>();

    public void update(CandidateForm other){
        this.id = other.id;
        this.name = other.name;
        this.email=other.email;
        this.phoneNumber=other.phoneNumber;
        this.skypeUser = other.skypeUser;
        this.area = other.area;
    }
}
