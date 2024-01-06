package clustereddata.validation;

import java.util.Currency;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CurrencyValidator implements ConstraintValidator<CurrencyValidation, Currency> {

	@Override
	public boolean isValid(Currency value, ConstraintValidatorContext context) {
		return value != null;
//        return value != null && Arrays.asList(Currency.values()).contains(value);
	}
}