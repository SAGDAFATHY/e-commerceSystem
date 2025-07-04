public class Customer {
    private String name;
    private double balance;
    public Customer(String name,double balance)
    {
        this.name = name;
        this.balance = balance;
    }
    public String getName()
    {
        return name;
    }
    public double getBalance()
    {
        return balance;
    }
    public void increaseBalance(double  amount)
    {
        if(amount > 0)
            balance += amount;
        else
            System.out.println("Must be positive number");
    }
    public void decreaseBalance(double amount)
    {
        if (amount > balance)
            System.out.println("Customer's balance is insucient");
        else
            if(amount > 0)
                balance -= amount;
            else
                System.out.println("Must be positive number");
    }
}
