interface HotmailAccount {
    public void open(Person accountOwner);
    public void close();
    public boolean sendEmail(HotmailAccount recepient, String emailText);
    public void deleteEmail(int emailId);
    public void viewEmail(int emailId);
    public void authenticate();
}
