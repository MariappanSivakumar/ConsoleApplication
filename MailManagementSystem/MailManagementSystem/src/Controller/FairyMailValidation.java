package Controller;

public class FairyMailValidation {

    public boolean mailValidate(String mail) {
        return ( ( mail.indexOf("@fairy.com") != -1 )&& ( mail.lastIndexOf("@fairy.com")) != -1);
    }

    public boolean passwordValidation(String password) {
        return password.length()>=6;
    }

    public boolean usernameValidation(String username) {
       return username.length()>=3;
    }
}
