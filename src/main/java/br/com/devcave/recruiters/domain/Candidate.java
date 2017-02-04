package br.com.devcave.recruiters.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "candidate")
@Getter
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

    @Column(name ="fil_curriculum")
    private byte[] curriculum;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "CANDIDATE_AREA", //
            joinColumns = { @JoinColumn(name = "id_candidate", referencedColumnName = "id_candidate") }, //
            inverseJoinColumns = { @JoinColumn(name = "id_area", referencedColumnName = "id_area") })
    private Set<Area> areaList = new HashSet<>();

    public void addArea(Area area) {
        if (this.areaList == null) {
            this.areaList = new HashSet<>();
        }
    }

}
