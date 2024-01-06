package clustereddata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import clustereddata.model.DealVO;

@Repository
public interface DealRepository extends JpaRepository<DealVO, Long> {

}