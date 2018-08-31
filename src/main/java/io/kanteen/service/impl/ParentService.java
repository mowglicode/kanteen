package io.kanteen.service.impl;

import io.kanteen.dto.ParentDtoFull;
import io.kanteen.dto.ParentDtoLight;
import io.kanteen.exception.NotFoundException;
import io.kanteen.persistance.entity.Account;
import io.kanteen.persistance.entity.Child;
import io.kanteen.persistance.entity.Parent;
import io.kanteen.persistance.repository.IAccountRepository;
import io.kanteen.persistance.repository.IChildRepository;
import io.kanteen.persistance.repository.IParentRepository;
import io.kanteen.service.IAccountService;
import io.kanteen.service.IChildService;
import io.kanteen.service.IParentService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParentService implements IParentService {

    @Autowired
    private IParentRepository parentRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IChildService childService;
    @Autowired
    private IChildRepository childRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ParentDtoLight> displayAllParents() {
        List<Parent> tmp = parentRepository.findAll();
        List<ParentDtoLight> parents = new ArrayList<>();

        for (Parent p : tmp) {
            parents.add(modelMapper.map(p, ParentDtoLight.class));
        }
        return parents;
    }

    @Override
    public ParentDtoFull displayParentById(long id) {
        Optional<Parent> parent = parentRepository.findById(id);
        if (parent.isPresent()) {
            return modelMapper.map(parent.get(), ParentDtoFull.class);
        } else {
            throw new NotFoundException("Parent not found");
        }

    }

    @Override
    public ParentDtoFull saveParent(ParentDtoFull parentDtoFull) {
        Parent parent = modelMapper.map(parentDtoFull, Parent.class);
        Optional<Account> tmp = accountRepository.findById(parent.getId());
        if (tmp.isPresent()) {
            parent = parentRepository.save(parent);
        } else {
            //if no account, create it !
            Account account = modelMapper.map(parentDtoFull.getAccount(), Account.class);
            account = accountRepository.save(account);
            parent.setAccount(account);
            parentRepository.save(parent);
        }
        return displayParentById(parent.getId());
    }

    @Override
    public void deleteParent(long id) {
        Optional<Parent> parent = parentRepository.findById(id);
        if (parent.isPresent()) {
            parentRepository.deleteById(id);
        } else {
            throw new NotFoundException("Parent not found, can't be deleted");
        }
    }

    @Override
    public ParentDtoFull saveParentWithIdAccount(ParentDtoFull parentDtoFull, long id) {
        Optional<Account> tmp = accountRepository.findById(id);
        Parent parent = modelMapper.map(parentDtoFull, Parent.class);
        if (tmp.isPresent()) {
            Account account = modelMapper.map(tmp.get(), Account.class);
            parent.setAccount(account);
            parentRepository.save(parent);
            return displayParentById(parent.getId());
        } else {
            throw new NotFoundException("Account not found, parent can't be created");
        }
    }

    @Override
    public ParentDtoFull saveParentWithChildId(ParentDtoFull parentDtoFull, long id) {
        Parent parent = modelMapper.map(parentDtoFull, Parent.class);
        Optional<Child> tmp = childRepository.findById(id);

        if (parent.getAccount() != null){
            accountRepository.save(parent.getAccount());
        }

        if (tmp.isPresent()) {
            Child child = modelMapper.map(tmp.get(), Child.class);
            parent.getChildren().add(child);
            parentRepository.save(parent);
            return displayParentById(parent.getId());
        } else {
            throw new NotFoundException("Child not found, parent can't be created");
        }
    }

    @Override
    public ParentDtoFull removeChildFromParent(long id_parent, long id_child) {

        Optional<Parent> tmp_parent = parentRepository.findById(id_parent);
        Optional<Child> tmp_child = childRepository.findById(id_child);
        //check of both objects exists
        if (tmp_child.isPresent() && tmp_parent.isPresent()) {
            Parent parent = modelMapper.map(tmp_parent.get(), Parent.class);
            Child child = modelMapper.map(tmp_child.get(), Child.class);

            //check if child belong to parent

            for (int i = 0; i < parent.getChildren().size(); i++) {
                if (parent.getChildren().get(i).equals(child)) {
                    parent.getChildren().remove(child);
                    parentRepository.save(parent);
                    return displayParentById(parent.getId());
                }
            }

                throw new NotFoundException("Child don't belong to this parent");
        } else {
            if (!tmp_child.isPresent()) {
                throw new NotFoundException("Child not found, it can't be removed from parent");
            }
            throw new NotFoundException("Parent not found, you can't remove child from it");

        }

    }
}
