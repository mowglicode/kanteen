package io.kanteen.configuration;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class UpdatableBCrypt {


//    private final int logRounds;
//
//    public UpdatableBCrypt(int logRounds) {
//        this.logRounds = logRounds;
//    }

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(11));
    }

    public static boolean verifyHash(String password, String hash) {
        System.out.println(password+" "+hash+" "+hash(password));
        return (BCrypt.checkpw(password,hash));
    }
}