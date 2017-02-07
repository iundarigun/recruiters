package br.com.devcave.recruiters.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "area")
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class Area extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_area", nullable = false)
    private Long id;

    @Column(name = "nam_area", length = 100, nullable = false)
    private String name;

    protected Area(final Long id){
        this.id = id;
    }
}
