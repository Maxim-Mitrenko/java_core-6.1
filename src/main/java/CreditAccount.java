public class CreditAccount extends  Account{

    @Override
    public void pay (int amount) {
        money -= amount;
    }

    @Override
    public void transfer (Account account, int amount) {
        account.addMoney(amount);
        money -= amount;
    }

    @Override
    public void addMoney (int amount) {
        if (money + amount > 0) throw new IllegalArgumentException("Ошибка баланс кредитного счета не может быть выше 0!");
        money += amount;
    }

    public String toString() {
        return "Кредитный счет, баланс: " + money;
    }
}
