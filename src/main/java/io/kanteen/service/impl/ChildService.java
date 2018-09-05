package io.kanteen.service.impl;

import io.kanteen.dto.ChildDto;
import io.kanteen.dto.ParentDtoFull;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Child;
import io.kanteen.persistance.repository.IChildRepository;
import io.kanteen.service.IChildService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChildService implements IChildService {

    @Autowired
    private IChildRepository childRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ParentService parentService;
    @Override
    public List<ChildDto> displayChildren() {
        List<Child> tmp = childRepository.findAll();
        List<ChildDto> children = new ArrayList<>();

        for (Child c : tmp) {
            children.add(modelMapper.map(c, ChildDto.class));
        }
        return children;
    }

    @Override
    public ChildDto displayChildrenById(long id) {
        Optional<Child> tmp = childRepository.findById(id);
        if (tmp.isPresent()) {
            return modelMapper.map(tmp.get(), ChildDto.class);
        } else {
            throw new NotFoundException("Child not found");
        }
    }

    @Override
    public void deleteChildren(long id) {
        Optional<Child> tmp = childRepository.findById(id);
        if (tmp.isPresent()) {
            childRepository.deleteById(id);
        } else {
            throw new NotFoundException("Child not found or already deleted");
        }
    }

    @Override
    public ChildDto saveChild(ChildDto childDto) {
        Child child = modelMapper.map(childDto, Child.class);
        childRepository.save(child);
        return displayChildrenById(child.getId());
    }

    @Override
    public List<ChildDto> getChildrenByParentId(long parentId){
        ParentDtoFull parentDtoFull = parentService.displayParentById(parentId);
        List<Child> children = parentDtoFull.getChildren();
        List<ChildDto> childrenDto= new ArrayList<>();
        for (Child c: children){
            childrenDto.add(modelMapper.map(c, ChildDto.class));
        }
        return childrenDto;
    }
}
