package io.kanteen.service;

import io.kanteen.dto.ChildDto;

import java.util.List;

public interface IChildService {
    List<ChildDto> displayChildren();
    ChildDto displayChildrenById(long id);
    void deleteChildren(long id);
    ChildDto saveChild(ChildDto childDto);
    List<ChildDto> getChildrenByParentId(long parentId);
}
