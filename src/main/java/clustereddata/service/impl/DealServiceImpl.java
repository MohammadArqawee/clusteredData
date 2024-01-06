package clustereddata.service.impl;

import org.springframework.stereotype.Service;

import clustereddata.model.DealVO;
import clustereddata.repository.DealRepository;
import clustereddata.service.DealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

	private final DealRepository dealRepository;

	@Override
	public DealVO saveDeal(DealVO deal) {
		try {
			log.info("Saving deal: ", deal);
			DealVO savedDeal = dealRepository.save(deal);
			log.info("Deal saved successfully: ", savedDeal);
			return savedDeal;
		} catch (Exception e) {
			log.error("Error occurred while saving deal: ", deal, e);
			throw new RuntimeException("Error occurred while saving deal", e);
		}
	}
}