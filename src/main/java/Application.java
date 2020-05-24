import config.MailConfig;
import gui.UserInterface;
import mail.GmailMailService;

import java.util.Scanner;

public class Application {

    private Scanner scanner;

    public Application() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    private void start() {
        MailConfig mailConfig = new MailConfig();
        UserInterface userInterface = new UserInterface(new GmailMailService(mailConfig));
        userInterface.showMenu();
        userInterface.listen(scanner);


    }
}
