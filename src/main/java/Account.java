public abstract class Account {

    protected int money;

    public abstract void pay (int amount);

    public abstract void transfer (Account account, int amount);

    public abstract void addMoney (int amount);

    public int getMoney() {
        return money;
    }
}