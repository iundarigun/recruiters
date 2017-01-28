package br.com.devcave.recruiters.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "candidate")
@ToString(callSuper = true)
public class Candidate extends BaseEntity{

    @Id
    @Column(name="id_candidate", nullable = false)
    private Long id;

    @Column(name = "nam_candidate", nullable = false)
    private String name;

    @Column(name = "des_email")
    private String email;

    @Column(name = "num_phone")
    private String phoneNumber;

    // TODO relacionamento ManyToMany

}
