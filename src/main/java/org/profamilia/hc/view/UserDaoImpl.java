package org.profamilia.hc.view;

import java.util.HashSet;
import java.util.Set;


public class UserDaoImpl implements UserDao {
    public AppUser findUser(String userName) {
        AppUser appUser = null;
        Set<String> roles = new HashSet<String>();
        if (userName.equals("andres")) {
            roles.add("ROLE_URLACCESS");
            appUser = 
                    new AppUser("andres", "Andres", "Turner", "andres", roles);
        } else if (userName.equals("norbey")) {
            appUser = new AppUser("norbey", "Norbey", "Daniel", "jim", roles);
        } else if (userName.equals("tina")) {
            roles.add("ROLE_ALLACCESS");
            appUser = new AppUser("tina", "Tina", "Joseph", "tina", roles);
        }
        return appUser;
    }

}
