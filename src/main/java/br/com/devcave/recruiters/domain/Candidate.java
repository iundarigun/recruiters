package br.com.devcave.recruiters.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.com.devcave.recruiters.dto.CandidateForm;
import br.com.devcave.recruiters.dto.CandidateVO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "candidate")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Candidate extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_candidate", nullable = false)
    private Long id;

    @Column(name = "nam_candidate", nullable = false, length = 255)
    @NotBlank
    @Size(max = 255)
    private String name;

    @Column(name = "des_email", nullable = false, unique = true, length = 255)
    @NotBlank
    @Size(max = 255)
    private String email;

    @Column(name = "num_phone", length = 20)
    @Size(max = 20)
    private String phoneNumber;

    @Column(name = "des_skype", length = 255)
    @Size(max = 255)
    private String skypeUser;

    @Column(name = "nam_curriculum", length = 255)
    @Size(max = 255)
    private String fileName;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fil_curriculum")
    private byte[] curriculum;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "CANDIDATE_AREA", //
            joinColumns = {@JoinColumn(name = "id_candidate", referencedColumnName = "id_candidate")}, //
            inverseJoinColumns = {@JoinColumn(name = "id_area", referencedColumnName = "id_area")})
    private Set<Area> areaList = new HashSet<>();

    public void addAreas(List<Area> area) {
        if (this.areaList == null) {
            this.areaList = new HashSet<>();
        }
        this.areaList.clear();
        this.areaList.addAll(area);
    }

    public void updateBasicInformations(CandidateForm candidateForm) {
        this.name = candidateForm.getName();
        this.email = candidateForm.getEmail();
        this.phoneNumber = candidateForm.getPhoneNumber();
        this.skypeUser = candidateForm.getSkypeUser();
    }

    public void updateCurriculum(String fileName, byte[] curriculum) {
        this.fileName = fileName;
        this.curriculum = curriculum;
    }

    public CandidateForm getCandidateForm() {
        CandidateForm candidateForm = new CandidateForm();
        candidateForm.setId(this.id);
        candidateForm.setName(this.name);
        candidateForm.setEmail(this.email);
        candidateForm.setSkypeUser(this.skypeUser);
        candidateForm.setPhoneNumber(this.phoneNumber);
        candidateForm.setHasCurriculum(this.curriculum != null && this.curriculum.length>0);
        this.areaList.forEach(a -> candidateForm.getArea().add(a.getId()));
        return candidateForm;
    }

}
