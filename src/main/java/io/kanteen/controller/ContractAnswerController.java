package io.kanteen.controller;


import io.kanteen.dto.ContractAnswerDto;
import io.kanteen.persistance.entity.ContractAnswer;
import io.kanteen.service.IContractAnswerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContractAnswerController {

    @Autowired
    private IContractAnswerService contractAnswerService;

    @ApiOperation(value = "Get all answer")
    @RequestMapping(value = "/admin/privacy/contracts/answers", method = RequestMethod.GET)
    public List <ContractAnswerDto> getAllContractAnswers(){
        return contractAnswerService.displayContractAnswersDto();
    }

    @ApiOperation(value = "Get answer by contract_id")
    @RequestMapping(value = "/admin/privacy/contracts/answers/{id}", method = RequestMethod.GET)
    public List<ContractAnswerDto> getContractAnswerById(@PathVariable long id){
        return contractAnswerService.displayContractAnswerDtoByContractId(id);
    }

    @ApiOperation(value = "Save Answers")
    @RequestMapping(value = "/admin/privacy/contracts/answers", method = RequestMethod.POST)
    public ContractAnswerDto saveContractAnswer(@RequestBody ContractAnswerDto contractAnswerDto){
        System.out.println("POSTED a contract DTO");
        System.out.println(contractAnswerDto);
        return  contractAnswerService.saveContractAnswer(contractAnswerDto);
    }

    @ApiOperation(value = "Delete contract answer by id")
    @RequestMapping(value = "/admin/privacy/contracts/answers/{id}", method = RequestMethod.DELETE)
    public void deleteContractAnswer(@PathVariable long id){
        contractAnswerService.deleteContractAnswer(id);
    }
}
