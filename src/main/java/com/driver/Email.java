package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(password.equals(oldPassword) && newPassword.length()>=8){
            int count[]= new int[4];

            for (int i = 0; i < newPassword.length(); i++) {
                char c = newPassword.charAt(i);
                if(c>='A' && c<='Z'){
                    count[0]=1;
                }
                else if(c>='a' && c<='z'){
                    count[1]=1;
                }
                else if(Character.isDigit(c)){
                    count[2]=1;
                }
                else if(!Character.isLetterOrDigit(c)){
                    count[3]=1;
                }
            }
            for(int i:count){
                if(i!=1){
                    return;
                }
            }
            password=newPassword;
        }
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
