public interface EmailAccount {
    public void open(Person accountOwner, String email_name, String pw);
    public void close();
    public boolean sendEmail(EmailAccount recepient, String emailText);
    public boolean receiveEmail(EmailAccount sender, String emailText);
    public boolean deleteEmail(int emailId);
    public boolean viewEmail(int emailId);
    public boolean authenticate();
    public String getEmailAddress();
}

