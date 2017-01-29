package br.com.devcave.recruiters.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "area")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class AreaEntity extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "id_area", nullable = false)
    private Long id;

    @Column(name = "nam_area", length = 100, nullable = false)
    private String name;

}
