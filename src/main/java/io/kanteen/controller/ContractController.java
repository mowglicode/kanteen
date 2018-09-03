package io.kanteen.controller;

import io.kanteen.dto.ContractDto;
import io.kanteen.persistance.repository.IContractRepository;
import io.kanteen.service.IContractService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @ApiOperation(value = "Get contracts")
    @RequestMapping(value = "/admin/privacy/contracts", method = RequestMethod.GET)
    public List<ContractDto> getAllContracts() {
        return contractService.displayContracts();
    }


    @ApiOperation(value = "Get Contract by Id")
    @RequestMapping(value = "/admin/privacy/contracts/{id}", method = RequestMethod.GET)
    public ContractDto getContractById(@PathVariable long id) {
        return contractService.displayContractById(id);
    }

    @ApiOperation(value = "Save Contract")
    @RequestMapping(value = "admin/privacy/contracts", method = RequestMethod.POST)
    public ContractDto saveContract(@RequestBody ContractDto contractDto) {
        System.out.println(contractDto.getOptions());
        return contractService.saveContract(contractDto);
    }

    @ApiOperation(value = "Delete contract by id")
    @RequestMapping(value = "admin/privacy/contracts/{id}", method = RequestMethod.DELETE)
    public void deleteContract(@PathVariable long id) {
        contractService.deleteContract(id);
    }

}
