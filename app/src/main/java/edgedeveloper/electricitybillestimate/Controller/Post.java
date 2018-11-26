package edgedeveloper.electricitybillestimate.Controller;

/**
 * Created by OPEYEMI OLORUNLEKE on 1/7/2017.
 */

public class Post {

    private String itemName;
    private String power;
    private String dailyUsage;
    private String monthlyBill;

    public Post(String itemName, String power, String dailyUsage, String monthlyBill) {
        this.itemName = itemName;
        this.power = power;
        this.dailyUsage = dailyUsage;
        this.monthlyBill = monthlyBill;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPower() {
        return power;
    }

    public String getDailyUsage() {
        return dailyUsage;
    }

    public String getMonthlyBill() {
        return monthlyBill;
    }
}
