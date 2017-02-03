package br.com.devcave.recruiters.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

import java.util.Calendar;

/**
 * Entidade abstrata base do resto. Mesmo que não tenha método abstrato,
 * é bom para garantir que ninguem vai instanciar um objeto
 */
@MappedSuperclass
@Getter
@ToString
public abstract class BaseEntity {

    @Column(name="dat_creation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDate;

    @Column(name="dat_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updateDate;

    @Version
    @Column(name="num_version", nullable = false)
    private Long version;

    public abstract Long getId();

    @PrePersist
    public void prePersist(){
        this.creationDate = Calendar.getInstance();
    }

    @PreUpdate
    public void preUpdate(){
        this.updateDate = Calendar.getInstance();
    }
}
