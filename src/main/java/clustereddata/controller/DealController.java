package clustereddata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import clustereddata.dto.DealDTO;
import clustereddata.mapper.DealMapper;
import clustereddata.model.DealVO;
import clustereddata.service.DealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/deals")
@RequiredArgsConstructor
public class DealController {

	private final DealService dealService;
	private final DealMapper dealMapper;

	@PostMapping
	public ResponseEntity<String> createDeal(@Valid @RequestBody DealDTO deal, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(getValidationErrorMessage(bindingResult), HttpStatus.BAD_REQUEST);
		}

		DealVO dealVO = dealMapper.mapToEntity(deal);
		dealService.saveDeal(dealVO);
		return new ResponseEntity<>("Deal created successfully", HttpStatus.CREATED);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String handleValidationExceptions(MethodArgumentNotValidException ex) {
		return getValidationErrorMessage(ex.getBindingResult());
	}

	private String getValidationErrorMessage(BindingResult bindingResult) {
		StringBuilder errorMessage = new StringBuilder("Validation error(s): ");
		bindingResult.getFieldErrors().forEach(error -> errorMessage.append(error.getField()).append(" ")
				.append(error.getDefaultMessage()).append("; "));
		return errorMessage.toString().trim();
	}
}