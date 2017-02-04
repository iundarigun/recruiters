package br.com.devcave.recruiters.service;

import br.com.devcave.recruiters.dto.AreaVO;
import br.com.devcave.recruiters.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<AreaVO> findAll() {
        return areaRepository.findAllToVO();
    }
}
