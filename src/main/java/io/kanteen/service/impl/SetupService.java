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
    private IContractRepository contractRepository;
    @Autowired
    private IContractOptionRepository contractOptionRepository;

    //Children for ghost database
    @Autowired
    private IAdminRepository adminRepository;


    Child wilsonDoe = new Child("Wilson Doe", "CM2");
    Child eliseDoe = new Child("Elise Doe", "CE1");
    Child tomSmith = new Child("Tom Smith", "CE2");
    Child laraSmith = new Child("Lara Smith", "CM1");

    //Parents for ghost database
    Parent johnDoe;
    Parent janeDoe;
    Parent bobSmith;
    Parent joanaSmith;
    Admin director;

    //Meals for ghost database
    Meal mealOne = new Meal(wilsonDoe, "20190315");
    Meal mealTwo = new Meal(wilsonDoe, "20190316");
    Meal mealThree = new Meal(wilsonDoe, "20190317");
    Menu menuOne = new Menu("Lasagnes, Yaourt");
    Menu menuTwo = new Menu("Pizza, Frites");

    //Accounts for ghost database
    Account directorAccount = new Account("director@kanteen.com", "0123456789");
    Account accountOne = new Account("johnDoe@kanteen.com", "06.23.23.23.23");
    Account accountTwo = new Account("janeDoe@kanteen.com", "06.24.24.24.24");
    Account accountThree = new Account("bobSmith@kanteen.com", "06.25.25.25.25");
    Account accountFour = new Account("joanaSmith@kanteen.com", "06.26.26.26.26");

    //Contracts for ghost database
    Contract contractOne = new Contract("Demande d'autorisation", "description autorisation", true, false);
    Contract contractTwo = new Contract("Prélévement automatique", "description prélèvement", false, true);
    Contract contractThree = new Contract("Sortie scolaire", "description sortie", false, true);

    //Contracts options for ghost database
    ContractOption contractOptionOne = new ContractOption("options");
    ContractOption contractOptionTwo = new ContractOption("options");
    ContractOption contractOptionThree = new ContractOption("options");

    //Informations for ghost database
    Information infoOne = new Information("Absence de Mme Oliviera", "Mme Oliviera sera absente jusqu\\'au 17/09/2018");
    Information infoTwo = new Information("Bâtiment B renové", "Le bâtiment B est rénové toute cette semaine. La peinture est fraîche !");
    Information infoThree = new Information("Carnaval", "Le carnaval aura lieu le vendredi 8 mars 2019.");
    Information infoFour = new Information("Les élèves candidats doivent remettre leur candidature à la vie scolaire.", "2018-12-12");

    public void setUp() {
        //Set up to start the ghost database

        wilsonDoe = childRepository.save(wilsonDoe);
        eliseDoe = childRepository.save(eliseDoe);
        tomSmith = childRepository.save(tomSmith);
        laraSmith = childRepository.save(laraSmith);

        List<Child> doeChild = new ArrayList<>();
        doeChild.add(wilsonDoe);
        doeChild.add(eliseDoe);

        accountOne.setPassword("toto");
        accountTwo.setPassword("tata");
        List<Child> smithChild = new ArrayList<>();
        smithChild.add(laraSmith);
        smithChild.add(tomSmith);

        accountRepository.save(accountOne);
        accountRepository.save(accountTwo);
        accountRepository.save(accountThree);
        accountRepository.save(accountFour);

        contractRepository.save(contractOne);
        contractRepository.save(contractTwo);
        contractRepository.save(contractThree);

        contractOptionRepository.save(contractOptionOne);
        contractOptionRepository.save(contractOptionTwo);
        contractOptionRepository.save(contractOptionThree);

        accountRepository.save(directorAccount);

        johnDoe = new Parent(accountOne, "John Doe", doeChild);
        janeDoe = new Parent(accountTwo, "Jane Doe", doeChild);
        director = new Admin(directorAccount, "Jeanne");
        adminRepository.save(director);
        johnDoe = new Parent(accountOne, "John Doe", doeChild);
        janeDoe = new Parent(accountTwo, "Jane Doe", doeChild);
        bobSmith = new Parent(accountThree, "Bob Smith", smithChild);
        joanaSmith = new Parent(accountFour, "Joana Smith", smithChild);

        johnDoe = parentRepository.save(johnDoe);
        janeDoe = parentRepository.save(janeDoe);
        bobSmith = parentRepository.save(bobSmith);
        joanaSmith = parentRepository.save(joanaSmith);

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

        infoFour = infoRepository.save(infoFour);
    }

    //Clean the database to let it empty at the end
    public void tearDown() {
        parentRepository.deleteAll();
        childRepository.deleteAll();
        mealRepository.deleteAll();
        accountRepository.deleteAll();
        contractRepository.deleteAll();
        infoRepository.deleteAll();
    }
}
