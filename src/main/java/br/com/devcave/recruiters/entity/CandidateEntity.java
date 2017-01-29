package br.com.devcave.recruiters.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "candidate")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CandidateEntity extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name="id_candidate", nullable = false)
    private Long id;

    @Column(name = "nam_candidate", nullable = false, length = 255)
    @NotBlank
    @Size(max=255)
    private String name;

    @Column(name = "des_email", nullable = false, unique = true, length = 255)
    @NotBlank
    @Size(max=255)
    private String email;

    @Column(name = "num_phone", length = 20)
    @Size(max=20)
    private String phoneNumber;

    // TODO relacionamento ManyToMany

}
