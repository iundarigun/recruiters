package br.com.devcave.recruiters.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.dto.CandidateFilter;

public class CandidateRepositoryImpl implements CandidateRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Candidate> findByFilter(final CandidateFilter filterVO) {
        return null;
    }
}
