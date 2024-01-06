package clustereddata.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import clustereddata.dto.DealDTO;
import clustereddata.model.DealVO;

@Mapper()
public interface DealMapper {

	DealDTO mapToDto(DealVO dealVO);

	@Mapping(target = "dealUniqueId", ignore = true)
	DealVO mapToEntity(DealDTO dealDTO);
}
