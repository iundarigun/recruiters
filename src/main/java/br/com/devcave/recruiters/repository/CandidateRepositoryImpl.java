package br.com.devcave.recruiters.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.dto.CandidateFilter;

/**
 * Created by s2it_ocanalias on 2/1/17.
 */
public class CandidateRepositoryImpl implements CandidateRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Candidate> findByFilter(final CandidateFilter filterVO) {
        // Implementação
        return null;
    }
}
