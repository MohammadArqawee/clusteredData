package clustereddata.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import clustereddata.util.ClusteredDataFormater;
import clustereddata.util.CurrencyCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "Clustered_Data_DEAL")
public class DealVO extends Audit {

	@Id
	@Column(name = "DEAL_UNIQUE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String dealUniqueId;

	@Column(name = "FROM_CURRENCY_ISO_CODE", nullable = false, length = 3)
	@NotNull(message = "From Currency ISO Code must not be null")
	private CurrencyCode fromCurrencyIsoCode;

	@Column(name = "TO_CURRENCY_ISO_CODE", nullable = false, length = 3)
	@NotNull(message = "To Currency ISO Code must not be null")
	private CurrencyCode toCurrencyIsoCode;

	@Column(name = "DEAL_TIMESTAMP")
	@NotNull(message = "Deal Timestamp must not be null")
	@JsonFormat(pattern = ClusteredDataFormater.DATE_FORMAT, timezone = ClusteredDataFormater.DATE_TIMEZONE)
	private LocalDateTime dealTimestamp;

	@Positive(message = "Deal Amount must be positive")
	@Column(name = "DEAL_AMOUNT", nullable = false)
	private double dealAmount;

}
