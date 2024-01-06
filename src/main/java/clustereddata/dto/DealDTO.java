package clustereddata.dto;

import java.time.LocalDateTime;

import clustereddata.util.CurrencyCode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DealDTO {

	@NotNull(message = "From Currency ISO Code must not be null")
	private CurrencyCode fromCurrencyIsoCode;

	@NotNull(message = "To Currency ISO Code must not be null")
	private CurrencyCode toCurrencyIsoCode;

	@NotNull(message = "Deal Timestamp must not be null")
	private LocalDateTime dealTimestamp;

	@Positive(message = "Deal Amount must be positive")
	private double dealAmount;

}
