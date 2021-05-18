interface CopyMachineAccount {
    public void open(Person accountOwner);
    public void close();
    public boolean copy(int numberOfPages);
    public float payBalance(float amountToPay);
    public void checkBalance();
}