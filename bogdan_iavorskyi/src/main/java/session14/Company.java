package session14;

/**
 * Created by bosyi on 29.06.15.
 */
public class Company {
    private String companyName;
    private Long totalMoneyAmount;
    private CEO ceo;
    private Car car;

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Company(String companyName, Long totalMoneyAmount, CEO ceo, Car car) {
        this.companyName = companyName;
        this.totalMoneyAmount = totalMoneyAmount;
        this.ceo = ceo;
        this.car = car;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getTotalMoneyAmount() {
        return totalMoneyAmount;
    }

    public void setTotalMoneyAmount(Long totalMoneyAmount) {
        this.totalMoneyAmount = totalMoneyAmount;
    }

    public CEO getCeo() {
        return ceo;
    }

    public void setCeo(CEO ceo) {
        this.ceo = ceo;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", totalMoneyAmount=" + totalMoneyAmount +
                ", car=" + car +
                '}';
    }
}
