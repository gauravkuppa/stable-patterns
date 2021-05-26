import java.util.ArrayList;
import java.util.Scanner;

public class HotmailAccount implements EmailAccount {
    
    private String emailAddress;
    private String password;
    private Person owner;
    private int triesLeft = 5;
    private boolean accountOpen = false; // open or closed
    private boolean loggedIn = false;
    private ArrayList<String> receivedEmails = new ArrayList<String>();
    private ArrayList<String> sentEmails = new ArrayList<String>();

    public static void main(String[] args) {
        Person p1 = new EmailPerson("Gaurav Kuppa", 0, "USA");
        Person p2 = new EmailPerson("Mohamed Fayad", 0, "Egypt");
        HotmailAccount email1 = new HotmailAccount();
        HotmailAccount email2 = new HotmailAccount();
        
        email1.open(p1, "gaurav.kuppa", "password987!");
        email2.open(p2, "mohamed.fayad", "password123!");

        String text = "Hello. I hope you are well. See you soon.";
        email1.sendEmail(email2, text);
        email2.viewEmail(0);
    }

    public HotmailAccount () {

    }

    public void open(Person accountOwner, String email_name, String pw) {
        owner = accountOwner;
        accountOpen = true;
        emailAddress = email_name + "@hotmail.com";
        password = pw;
        System.out.println(emailAddress);
    }

    public void close() {
        accountOpen = false;
    }

    public boolean sendEmail(EmailAccount recepient, String emailText) {
        while (!loggedIn && triesLeft > 0) {
            authenticate();
        }
        if (accountOpen && loggedIn) {
            sentEmails.add(emailText);
            recepient.receiveEmail(this, emailText);
            System.out.println("Sent email from " + getEmailAddress() + " to " + recepient.getEmailAddress());
            return true;
        } else {
            System.out.println("Email Account with address " + getEmailAddress() + " not Open");
            return false;
        }
    }
    public boolean deleteEmail(int emailId) {
        while (!loggedIn && triesLeft > 0) {
            authenticate();
        }
        if (accountOpen && loggedIn) {
            receivedEmails.remove(emailId);
            System.out.println(getEmailAddress() + " removed email with id #" + emailId);
            return true;
        } else {
            System.out.println("Email Account with address " + getEmailAddress() + " not Open");
            return false;
        }
    }
    public boolean receiveEmail(EmailAccount sender, String emailText) {
        if (accountOpen) {
            receivedEmails.add(emailText);
            System.out.println(getEmailAddress() + " received email from" + sender.getEmailAddress());
            return true;
        } else {
            System.out.println("Email Account with address " + getEmailAddress() + " not Open");
            return false;
        }
    }
    public boolean viewEmail(int emailId) {
        while (!loggedIn && triesLeft > 0) {
            authenticate();
        }
        if (accountOpen && loggedIn) {
            String email = receivedEmails.get(emailId);
            System.out.println("Here is the email.");
            System.out.println();
            for (int i = 0, size = email.length(); i < size; i += 80) {
                System.out.println(email.substring(i, Math.min(i + 80, size)));
            }
            return true;
        } else {
            System.out.println("Email Account with address " + getEmailAddress() + " not Open");
            return false;
        }
    }
    public boolean authenticate() {
        if (triesLeft > 0){ 
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter your password " + getEmailAddress() + ".");
            String pw = in.nextLine();
            if (pw.equals(password)) {
                loggedIn = true;
                System.out.println("Logged in.");
                return true;
            } else {
                triesLeft -= 1;
                System.out.println("Incorrect password. You have " + triesLeft + " attempts remaining.");
                return false;
            }
        } else {
            System.out.println("Account locked. Please contact admin.");
            return false;
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

}
