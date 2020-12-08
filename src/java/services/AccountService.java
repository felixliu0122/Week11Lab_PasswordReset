package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {

    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();

        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                // Log activity
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);

                // Send E-mail
//                String to = user.getEmail();
//                String subject = "Notes App Login";
//                String template = path + "/emailtemplates/login.html";
//                
//                HashMap<String, String> tags = new HashMap<>();
//                tags.put("firstname", user.getFirstName());
//                tags.put("lastname", user.getLastName());
//                tags.put("date", (new java.util.Date()).toString());
//                
//                GmailService.sendMail(to, subject, template, tags);
//                String msgBody = "Your account has logged in.";
//                GmailService.sendMail(email, "Log in Activity", msgBody, false);
                return user;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void resetPassword(String email, String path, String url) throws Exception {
        String uuid = UUID.randomUUID().toString();
        String link = url + "?uuid=" + uuid;

        UserDB userDB = new UserDB();

        User user = userDB.get(email);
        String to = user.getEmail();

        user.setResetpasswordUUID(uuid);
        userDB.update(user);

        String subject = "NotesKeepr Password";
        String template = path + "/emailtemplates/resetpassword.html";
        HashMap<String, String> tags = new HashMap<>();
        tags.put("firstname", user.getFirstName());
        tags.put("lastname", user.getLastName());
        tags.put("username", user.getEmail());
        tags.put("link", link);
        GmailService.sendMail(to, subject, template, tags);
    }

    public boolean changePassword(String uuid, String password) throws Exception {
        UserDB userDB = new UserDB();
        try {
            User user = userDB.getByUUID(uuid);
            user.setPassword(password);
            user.setResetpasswordUUID(null);
            userDB.update(user);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public User getByUUID(String uuid) {
        UserDB userDB = new UserDB();
        User user = userDB.getByUUID(uuid);
        return user;

    }
}
