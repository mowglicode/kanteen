package io.kanteen.service.impl;

import io.kanteen.dto.InformationDto;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Information;
import io.kanteen.persistance.repository.IInformationRepository;
import io.kanteen.service.IInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InformationService implements IInformationService {


    @Autowired
    private IInformationRepository informationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<InformationDto> getAllInformations(){
        List<Information> informations = informationRepository.findAll();
        List<InformationDto> result = new ArrayList<>();
        for(Information i: informations) {
            result.add(modelMapper.map(i,InformationDto.class));
        }
        return result;
    }

    @Override
    public InformationDto saveInformation(InformationDto informationDto) {
        Information information = modelMapper.map(informationDto, Information.class);
        informationRepository.save(information);
        return getInformationById(information.getId());
    }

    @Override
    public InformationDto getInformationById (long id) {
        Optional<Information> information = informationRepository.findById(id);
        if (information.isPresent()) {
            return modelMapper.map(information.get(), InformationDto.class);
        } else {
            throw new NotFoundException("Information not found");
        }
    }

    @Override
    public void deleteInformation (long id) {
        Optional<Information> information = informationRepository.findById(id);
        if (information.isPresent()) {
            informationRepository.deleteById(id);
        } else {
            throw new NotFoundException("Information not found, can't be deleted");
        }

    }
}
