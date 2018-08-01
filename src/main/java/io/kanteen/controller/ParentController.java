package io.kanteen.controller;

import io.kanteen.dto.ParentDtoFull;
import io.kanteen.dto.ParentDtoLight;
import io.kanteen.service.IParentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
public class ParentController {

    @Autowired
    private IParentService parentService;

    @ApiOperation(value = "Get parents")
    @RequestMapping(method = RequestMethod.GET)
    public List<ParentDtoLight> getParents(){
        return parentService.displayAllParents();
    }

    @ApiOperation(value = "Get parent by ID")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ParentDtoFull getParentById(@PathVariable long id){
        return parentService.displayParentById(id);
    }

    @ApiOperation(value = "Save parent",
            notes = "Parent can be save without account nor children")
    @RequestMapping(method = RequestMethod.POST)
    public ParentDtoFull saveParent(@RequestBody ParentDtoFull parentDtoFull){
        return parentService.saveParent(parentDtoFull);
    }

    @ApiOperation(value = "Save parent linked with account ID",
            notes = "")
    @RequestMapping(value = "/account/{id_account}",method = RequestMethod.POST)
    public ParentDtoFull saveParentWithAccountId(@PathVariable long id,@RequestBody ParentDtoFull parentDtoFull){
        return parentService.saveParentWithId(parentDtoFull,id);
    }

    @ApiOperation(value = "Save parent linked with child ID",
            notes = "")
    @RequestMapping(value = "/child/{id_child}", method = RequestMethod.POST)
    public ParentDtoFull saveParentWithChildId(@PathVariable long id, @RequestBody ParentDtoFull parentDtoFull){
        return parentService.saveParentWithChildId(parentDtoFull, id);
    }

    @ApiOperation(value = "Delete parent by ID")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteParent(@PathVariable long id){
        parentService.deleteParent(id);
    }

    @ApiOperation(value = "Remove child from parent",
            notes = "The link between child and parent is broken, the child is not deleted")
    @RequestMapping(value = "/{id_parent}/{id_child}",method = RequestMethod.DELETE)
    public ParentDtoFull removeChildFromParent(@PathVariable(name = "id_parent") long id_parent,@PathVariable(name = "id_child") long id_child){
        return parentService.removeChildFromParent(id_parent,id_child);
    }
}
