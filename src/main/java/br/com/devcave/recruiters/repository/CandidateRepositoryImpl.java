package br.com.devcave.recruiters.repository;

import javax.persistence.EntityManager;

import br.com.devcave.recruiters.dto.CandidateVO;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.devcave.recruiters.domain.Candidate;
import br.com.devcave.recruiters.dto.CandidateFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class CandidateRepositoryImpl implements CandidateRepositoryCustom {

    @Value("${recruiters.search.pag-size:10}")
    private Integer pageSize;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Page<CandidateVO> findByFilter(final CandidateFilter candidateFilter) {
        Session session = (Session) entityManager.getDelegate();
        Criteria criteria = session.createCriteria(Candidate.class);
        if (candidateFilter.getArea() != null) {
            criteria.createAlias("areaList", "area");
            criteria.add(Restrictions.eq("area.id", candidateFilter.getArea()));
        }
        if (StringUtils.isNotBlank(candidateFilter.getName())) {
            criteria.add(Restrictions.like("name", candidateFilter.getName(), MatchMode.ANYWHERE).ignoreCase());
        }
        if (StringUtils.isNotBlank(candidateFilter.getEmail())) {
            criteria.add(Restrictions.like("email", candidateFilter.getEmail(), MatchMode.ANYWHERE).ignoreCase());
        }
        // Contar o total de registros
        criteria.setProjection(Projections.countDistinct("id"));
        Long totalRows = (Long) criteria.uniqueResult();

        criteria.setProjection(Projections.projectionList().
                add(Projections.groupProperty("id"),"id").
                add(Projections.groupProperty("name"),"name").
                add(Projections.groupProperty("email"),"email").
                add(Projections.groupProperty("phoneNumber"),"phoneNumber"));
        criteria.setResultTransformer(Transformers.aliasToBean(CandidateVO.class));

        criteria.setFirstResult(candidateFilter.getPage() - 1 * pageSize);
        criteria.setMaxResults(pageSize);

        return new PageImpl<CandidateVO>(criteria.list(),
                new PageRequest(candidateFilter.getPage(), pageSize),
                totalRows);
    }
}
