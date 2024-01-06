package clustereddata.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import clustereddata.model.DealVO;
import clustereddata.repository.DealRepository;
import clustereddata.service.impl.DealServiceImpl;
import clustereddata.util.CurrencyCode;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class DealServiceTest {

	@Mock
	private DealRepository dealRepository;

	@InjectMocks
	private DealServiceImpl dealService;

	@Test
	void saveDeal_ValidDeal_ShouldReturnSavedDeal() {
		DealVO inputDeal = new DealVO("uniqueId", CurrencyCode.USD, CurrencyCode.EUR, LocalDateTime.now(), 100.0);
		Mockito.when(dealRepository.save(any(DealVO.class))).thenReturn(inputDeal);

		DealVO savedDeal = dealService.saveDeal(inputDeal);

		Mockito.verify(dealRepository, times(1)).save(any(DealVO.class));
		// Add more assertions based on your requirements

		Mockito.verify(log, times(1)).info("Saving deal: {}", inputDeal);
		Mockito.verify(log, times(1)).info("Deal saved successfully: {}", savedDeal);
	}

	@Test
	void saveDeal_WhenExceptionOccurs_ShouldLogError() {
		DealVO inputDeal = new DealVO("uniqueId", CurrencyCode.USD, CurrencyCode.EUR, LocalDateTime.now(), 100.0);
		Mockito.when(dealRepository.save(any(DealVO.class))).thenThrow(new RuntimeException("Simulating an exception"));

		try {
			dealService.saveDeal(inputDeal);
		} catch (Exception ignored) {
			// Ignoring the exception for this test
		}

		Mockito.verify(log, times(1)).error("Error occurred while saving deal: {}", inputDeal);
	}
}