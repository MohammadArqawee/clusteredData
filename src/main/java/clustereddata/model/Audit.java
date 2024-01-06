package clustereddata.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import clustereddata.util.ClusteredDataFormater;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public abstract class Audit {

	private Date createdBy;

	@JsonFormat(pattern = ClusteredDataFormater.DATE_FORMAT, timezone = ClusteredDataFormater.DATE_TIMEZONE)
	private Date createdDate;

	private Date modifiedBy;

	@JsonFormat(pattern = ClusteredDataFormater.DATE_FORMAT, timezone = ClusteredDataFormater.DATE_TIMEZONE)
	private Date modifiedDate;

}
