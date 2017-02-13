package br.com.devcave.recruiters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devcave.recruiters.dto.AreaVO;
import br.com.devcave.recruiters.repository.AreaRepository;

@Service
@Transactional(readOnly = true)
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    @Cacheable(value = "area")
    public List<AreaVO> findAll() {
        return areaRepository.findAllToVO();
    }
}
