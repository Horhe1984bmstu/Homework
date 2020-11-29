package cucumber;

public enum SortCategory {
    По_умолчанию("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select/option[1]"),
    Дешевле("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select/option[2]"),
    Дороже("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select/option[3]"),
    По_дате("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select/option[4]");


    String type;

   SortCategory(String type) {
        this.type = type;
    }
}