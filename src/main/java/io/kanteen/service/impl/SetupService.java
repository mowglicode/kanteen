package io.kanteen.service.impl;

import io.kanteen.persistance.entity.*;
import io.kanteen.persistance.repository.*;
import io.kanteen.service.ISetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class SetupService implements ISetupService {

    @Autowired
    private IParentRepository parentRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IChildRepository childRepository;
    @Autowired
    private IMealRepository mealRepository;
    @Autowired
    private IMenuRepository menuRepository;
    @Autowired
    private IInformationRepository infoRepository;

    @Autowired
    private IAdminRepository adminRepository;


    Child wilsonDoe = new Child("Wilson Doe", "CM2");
    Child eliseDoe = new Child("Elise Doe", "CE1");

    Parent johnDoe;
    Parent janeDoe;
    Admin director;

    Meal mealOne = new Meal(wilsonDoe, "20190315");
    Meal mealTwo = new Meal(wilsonDoe, "20190316");
    Meal mealThree = new Meal(wilsonDoe, "20190317");
    Menu menuOne = new Menu("Lasagnes, Yaourt");
    Menu menuTwo = new Menu("Pizza, Frites");
    Account directorAccount = new Account("director@kanteen.com", "0123456789");
    Account accountOne = new Account("johnDoe@kanteen.com", "06.23.23.23.23");

    Account accountTwo = new Account("janeDoe@kanteen.com", "06.24.24.24.24");

    Information infoOne = new Information("Absence de Mme Oliviera","Mme Oliviera sera absente jusqu\\'au 17/09/2018");
    Information infoTwo = new Information("Bâtiment B renové", "Le bâtiment B est rénové toute cette semaine. La peinture est fraîche !");
    Information infoThree = new Information("Carnaval", "Le carnaval aura lieu le vendredi 8 mars 2019.");

    public void setUp() {

        wilsonDoe = childRepository.save(wilsonDoe);
        eliseDoe = childRepository.save(eliseDoe);

        List<Child> doeChild = new ArrayList<>();
        doeChild.add(wilsonDoe);
        doeChild.add(eliseDoe);

        accountOne.setPassword("toto");
        accountTwo.setPassword("tata");
        accountRepository.save(accountOne);
        accountRepository.save(accountTwo);

        accountRepository.save(directorAccount);

        johnDoe = new Parent(accountOne, "John Doe", doeChild);
        janeDoe = new Parent(accountTwo, "Jane Doe", doeChild);
        director = new Admin(directorAccount,"Jeanne");
        adminRepository.save(director);
        johnDoe = parentRepository.save(johnDoe);
        janeDoe = parentRepository.save(janeDoe);
        mealOne = mealRepository.save(mealOne);
        mealTwo = mealRepository.save(mealTwo);
        mealThree = mealRepository.save(mealThree);

        Meal mealFour = new Meal(eliseDoe, "20190315");
        Meal mealFive = new Meal(eliseDoe, "20190316");
        mealFour = mealRepository.save(mealFour);
        mealFive = mealRepository.save(mealFive);


        menuOne = menuRepository.save(menuOne);
        menuTwo = menuRepository.save(menuTwo);

        infoOne = infoRepository.save(infoOne);
        infoTwo = infoRepository.save(infoTwo);
        infoThree = infoRepository.save(infoThree);
    }

    public void tearDown() {
        parentRepository.deleteAll();
        childRepository.deleteAll();
        mealRepository.deleteAll();
        accountRepository.deleteAll();
        infoRepository.deleteAll();
    }
}
