package io.kanteen.controller;

import io.kanteen.dto.InformationDto;
import io.kanteen.persistance.entity.Information;
import io.kanteen.service.IInformationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informations")
public class InformationController {

    @Autowired
    private IInformationService informationService;

    @ApiOperation(value = "Get informations")
    @RequestMapping(method = RequestMethod.GET)
    public List<InformationDto> getAllInformations() {
        return informationService.getAllInformations();
    }

    @ApiOperation(value = "Get information by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public InformationDto getInformationById(@PathVariable long id) {
        return informationService.getInformationById(id);
    }

    @ApiOperation(value = "Save informations")
    @RequestMapping(method = RequestMethod.POST)
    public InformationDto saveInformation (@RequestBody InformationDto informationDto) {
        return informationService.saveInformation(informationDto);
    }

    @ApiOperation(value = "Delete information by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteInformation(@PathVariable long id) {
        informationService.deleteInformation(id);
    }
}
