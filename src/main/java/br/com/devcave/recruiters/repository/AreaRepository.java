package br.com.devcave.recruiters.repository;

import br.com.devcave.recruiters.domain.Area;
import br.com.devcave.recruiters.dto.AreaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area,Long> {
    @Query("select new br.com.devcave.recruiters.dto.AreaVO(a.id, a.name) "
    + "from Area a ")
    List<AreaVO> findAllToVO();
}
