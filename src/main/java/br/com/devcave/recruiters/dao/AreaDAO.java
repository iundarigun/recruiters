package br.com.devcave.recruiters.dao;

import br.com.devcave.recruiters.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaDAO extends JpaRepository<AreaEntity,Long> {
}
