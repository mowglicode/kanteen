package io.kanteen.controller;

import io.kanteen.dto.ChildDto;
import io.kanteen.service.IChildService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/children")
public class ChildController {

    @Autowired
    private IChildService childService;

    @ApiOperation(value = "Get children")
    @RequestMapping(method = RequestMethod.GET)
    public List<ChildDto> getAllChildren() {
        return childService.displayChildren();
    }

    @ApiOperation(value = "Get child by ID")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ChildDto getChildById(@PathVariable long id) {
        return childService.displayChildrenById(id);
    }

    @ApiOperation(value = "Save child")
    @RequestMapping(method = RequestMethod.POST)
    public ChildDto saveChild(@RequestBody ChildDto childDto){
        return childService.saveChild(childDto);
    }

    @ApiOperation(value = "Delete child by ID")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteChild(@PathVariable long id){
        childService.deleteChildren(id);
    }

    @ApiOperation( value = "Get children by parent id")
    @RequestMapping (value = "/{id_parent}", method = RequestMethod.GET)
    public List<ChildDto> getChildrenByParentId(@PathVariable long parentId) {
        return childService.getChildrenByParentId( parentId);
    }

}
