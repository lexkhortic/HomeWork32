public class Programmer{
    private Lang lang;
    private String fio;
    private int salary;
    private boolean isDistant;

    public Programmer(Lang lang, String fio, int salary, boolean isDistant) {
        this.lang = lang;
        this.fio = fio;
        this.salary = salary;
        this.isDistant = isDistant;
    }

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isDistant() {
        return isDistant;
    }

    public void setDistant(boolean distant) {
        isDistant = distant;
    }

    @Override
    public String toString() {
        return
                "Язык: " + lang +
                ", ФИО: " + fio +
                ", ЗП: " + salary + "$" +
                ", Удаленка: " + isDistant;
    }
}
