package clustereddata.util;

public enum CurrencyCode {

	USD("USD"), EUR("EUR"), GBP("GBP");

	private final String code;

	CurrencyCode(String string) {
		this.code = "";
	}

	public String getCode() {
		return code;
	}

}
