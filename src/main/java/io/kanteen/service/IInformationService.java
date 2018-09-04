package io.kanteen.service;

import io.kanteen.dto.InformationDto;
import io.kanteen.persistance.entity.Information;

import java.util.List;

public interface IInformationService {
    List<InformationDto> getAllInformations();
    InformationDto saveInformation(InformationDto informationDto);
    InformationDto getInformationById(long id);
    void deleteInformation(long id);

}
