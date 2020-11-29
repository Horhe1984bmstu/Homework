package cucumber;

public enum AdsCategory {
    Фототехника("//option[@data-marker='option(105)']"),
    Товары_для_компьютера ("//option[@data-marker='option(101)']"),
    Телефоны("//option[@data-marker='option(84)']"),
    Оргтехника_и_расходники("//option[@data-marker='option(99)']"),
    Настольные_компьютеры("//option[@data-marker='option(31)']");


    String type;

    AdsCategory(String type) {
        this.type = type;
    }
}