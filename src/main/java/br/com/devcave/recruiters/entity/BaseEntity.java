package br.com.devcave.recruiters.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidade abstrata base do resto. Mesmo que não tenha método abstrato,
 * é bom para garantir que ninguem vai instanciar um objeto
 */
@Data
@ToString
public abstract class BaseEntity {

    @Column(name="dat_creation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate;

    @Column(name="dat_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate;

    @Version
    @Column(name="num_version", nullable = false)
    private Long version;

    public abstract Long getId();

    @PrePersist
    public void prePersist(){
        this.creationDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updateDate = LocalDateTime.now();
    }
}
