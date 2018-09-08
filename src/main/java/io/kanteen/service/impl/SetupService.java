package io.kanteen.service.impl;

import io.kanteen.configuration.UpdatableBCrypt;
import io.kanteen.persistance.entity.*;
import io.kanteen.persistance.repository.*;
import io.kanteen.service.ISetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private IContractRepository contractRepository;
    @Autowired
    private IInformationRepository infoRepository;
    @Autowired
    private IContractOptionRepository contractOptionRepository;
    @Autowired
    private IContractAnswerRepository contractAnswerRepository;
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
    Meal mealOne = new Meal(wilsonDoe, "2018-09-14");
    Meal mealTwo = new Meal(wilsonDoe, "2018-09-17");
    Meal mealThree = new Meal(wilsonDoe, "2018-09-18");
    Menu menuOne = new Menu("Lasagnes, Yaourt");
    Menu menuTwo = new Menu("Pizza, Frites");

    //Accounts for ghost database
    Account directorAccount = new Account("director@kanteen.com", "0123456789");
    Account accountOne = new Account("johnDoe@kanteen.com", "06.23.23.23.23");
    Account accountTwo = new Account("janeDoe@kanteen.com", "06.24.24.24.24");
    Account accountThree = new Account("bobSmith@kanteen.com", "06.25.25.25.25");
    Account accountFour = new Account("joanaSmith@kanteen.com", "06.26.26.26.26");

    //Contracts for ghost database

    Contract contractOne = new Contract("Conditions d'utilisation", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet atque beatae consectetur cumque dolorem ducimus, error facere fugiat", true, false);
    Contract contractTwo = new Contract("Voyage Angleterre", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet atque beatae consectetur cumque dolorem ducimus, error facere fugiat", true, false);
    Contract contractThree = new Contract("Repas de Noël", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet atque beatae consectetur cumque dolorem ducimus, error facere fugiat", false, true);
    Contract contractFour = new Contract("Kermesse annuelle", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet atque beatae consectetur cumque dolorem ducimus, error facere fugiat", true, false);

    ContractOption optionOne = new ContractOption(contractThree, "Fromage");
    ContractOption optionTwo = new ContractOption(contractThree, "Vin de messe");
    ContractOption optionFive = new ContractOption(contractThree, "Dessert");
    ContractOption optionThree = new ContractOption(contractFour, "choix3");
    ContractOption optionFour = new ContractOption(contractFour, "choix4");

    ContractAnswer answerOne = new ContractAnswer(contractThree, true, optionOne);
    ContractAnswer answerTwo = new ContractAnswer(contractThree, false,optionTwo );
    ContractAnswer answerThree = new ContractAnswer(contractFour, optionThree);
    ContractAnswer answerFour = new ContractAnswer(contractFour, optionFour);

    // THIS IS THE REAL VERSION OF INFORMATION SETUP. PLEASE KEEP IT.
    Information infoOne = new Information("Mme Oliviera sera absente jusqu\\'au 17/09/2018", "2018-06-05");
    Information infoTwo = new Information("Le bâtiment B est rénové toute cette semaine. La peinture est fraîche !", "2018-10-12");
    Information infoThree = new Information("Le carnaval aura lieu le vendredi 8 mars 2019.", "06-12-2018");

    public void setUp() {
        //Set up to start the ghost database

        wilsonDoe = childRepository.save(wilsonDoe);
        eliseDoe = childRepository.save(eliseDoe);
        tomSmith = childRepository.save(tomSmith);
        laraSmith = childRepository.save(laraSmith);

        List<Child> doeChild = new ArrayList<>();
        doeChild.add(wilsonDoe);
        doeChild.add(eliseDoe);

        accountOne.setPassword(UpdatableBCrypt.hash("toto"));
        accountTwo.setPassword(UpdatableBCrypt.hash("tata"));
        accountThree.setPassword(UpdatableBCrypt.hash("123456"));
        accountFour.setPassword(UpdatableBCrypt.hash("gj_@ç't5_qçzfo éjf'"));
        directorAccount.setPassword(UpdatableBCrypt.hash("admin"));
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

        contractOptionRepository.save(optionOne);
        contractOptionRepository.save(optionTwo);

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

        Meal mealFour = new Meal(eliseDoe, "2018-09-14");
        Meal mealFive = new Meal(eliseDoe, "2018-09-17");
        mealFour = mealRepository.save(mealFour);
        mealFive = mealRepository.save(mealFive);


        menuOne.setWeek(1);
        menuTwo.setWeek(2);
        menuOne = menuRepository.save(menuOne);
        menuTwo = menuRepository.save(menuTwo);

        contractOne = contractRepository.save(contractOne);
        contractTwo = contractRepository.save(contractTwo);
        contractThree = contractRepository.save(contractThree);
        contractFour = contractRepository.save(contractFour);

        optionOne = contractOptionRepository.save(optionOne);
        optionTwo = contractOptionRepository.save(optionTwo);
        optionThree = contractOptionRepository.save(optionThree);
        optionFive = contractOptionRepository.save(optionFive);

        answerOne = contractAnswerRepository.save(answerOne);
        answerTwo = contractAnswerRepository.save(answerTwo);


        infoOne = infoRepository.save(infoOne);
        infoTwo = infoRepository.save(infoTwo);
        infoThree = infoRepository.save(infoThree);
    }

    //Clean the database to let it empty at the end
    public void tearDown() {
        parentRepository.deleteAll();
        childRepository.deleteAll();
        mealRepository.deleteAll();
        accountRepository.deleteAll();
        contractRepository.deleteAll();
        infoRepository.deleteAll();
        contractOptionRepository.deleteAll();
    }
}
