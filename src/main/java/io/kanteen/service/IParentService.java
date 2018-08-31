package io.kanteen.service;

import io.kanteen.dto.ParentDtoFull;
import io.kanteen.dto.ParentDtoLight;
import io.kanteen.persistance.entity.Parent;

import java.util.List;

public interface IParentService {
    List<ParentDtoLight> displayAllParents();
    ParentDtoFull displayParentById(long id);
    ParentDtoFull saveParent(ParentDtoFull parentDtoFull);
    void deleteParent(long id);
    ParentDtoFull saveParentWithIdAccount(ParentDtoFull parentDtoFull, long id);
    ParentDtoFull saveParentWithChildId(ParentDtoFull parentDtoFull,long id);
    ParentDtoFull removeChildFromParent(long id_parent, long id_child);
}
