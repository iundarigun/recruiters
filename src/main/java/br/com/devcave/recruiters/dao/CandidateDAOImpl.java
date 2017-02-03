package br.com.devcave.recruiters.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.devcave.recruiters.entity.CandidateEntity;
import br.com.devcave.recruiters.vo.CandidateFilter;

/**
 * Created by s2it_ocanalias on 2/1/17.
 */
public class CandidateDAOImpl implements CandidateDAOCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<CandidateEntity> findByFilter (final CandidateFilter filterVO) {
        // Implementação
        return null;
    }
}
