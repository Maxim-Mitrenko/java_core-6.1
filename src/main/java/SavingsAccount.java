public class SavingsAccount extends Account {

    @Override
    public void pay (int amount) {
        throw new RuntimeException("Ошибка! Оплата со сберегательного счета невозможна!");
    }

    @Override
    public void transfer (Account account, int amount) {
        if (money - amount < 0 ) throw new IllegalArgumentException("Ошибка! Баланс не может быть ниже 0!");
            account.addMoney(amount);
            money -= amount;
    }

    @Override
    public void addMoney(int amount) {
        money += amount;
    }

    public String toString() {
        return "Сберегательный счет, баланс: " + money;
    }
}