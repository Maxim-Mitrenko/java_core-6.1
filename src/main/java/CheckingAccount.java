public class CheckingAccount extends Account {

    @Override
    public void pay (int amount) {
        if (money - amount < 0) throw new IllegalArgumentException("Ошибка! Баланс расчетного счёта не может быть отрицательным!");
        money -= amount;
    }

    @Override
    public void transfer (Account account, int amount) {
        if (money - amount < 0) throw new IllegalArgumentException("Ошибка! Баланс расчетного счёта не может быть отрицательным!");
        account.addMoney(amount);
        money -= amount;
    }

    @Override
    public void addMoney (int amount) {
        money += amount;
    }

    public String toString() {
        return "Расчетный счёт, баланс: " + money;
    }
}