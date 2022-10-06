import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        checkLeapYears(2022);
        getDeviceLink(0, 2005);
        int deliveryDays = calculateDeliveryDays (60);
        System.out.println("потребуется дней"+ deliveryDays );



    }
    public static void checkLeapYears(int year) {
        if ((year % 4 ==0 && year % 100 !=0) || year % 400 == 0) {
            System.out.println(year + " высокосный");
        } else {
            System.out.println(year+" не высокосный");
        }

    }
    public static void getDeviceLink(int osType, int manufacturingYears) throws IllegalAccessException {
        if (osType != 1 && osType != 0) {
            throw new IllegalAccessException("Wrong OS type");
        }
        int currentYear = LocalDate.now().getYear();
        if (manufacturingYears > currentYear) {
            throw new IllegalAccessException("Wrong manufacturing year");
        }
        String osString = osType == 0 ? "IOS" : "Android";
        String versionString = manufacturingYears > 2015 ? "полную" : "облегченную";
        System.out.println(versionString + osString);
    }
    public static int calculateDeliveryDays (int deliveryDistance) {
        if (deliveryDistance <=20) {
            return 1;
        } else {
            return (int) Math.round((double) deliveryDistance / 40) + 1;
        }
    }

}

