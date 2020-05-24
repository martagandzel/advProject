package config;

import javax.mail.Session;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MailConfig {

    private Properties properties; //klasa Properties jest mapą
    private String username;
    private String password;

    public MailConfig() {
        prepareConfig();
    }

    private void prepareConfig() {
        properties = new Properties();
        try {FileReader reader = new FileReader("mail.properties");
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//        username = "login"; // dane powinny być zczytywane z bazy danych lub pliku, nigdy w kodzie!
//        password = "hasło";

        username = properties.getProperty("mail.username");
        password = properties.getProperty("mail.password");


    }

    public Session createSession() {
        return Session.getDefaultInstance(properties, new GmailAuthenticator(username, password));

    }
}
