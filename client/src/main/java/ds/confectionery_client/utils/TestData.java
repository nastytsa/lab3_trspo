package ds.confectionery_client.utils;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestData {

    public static final Random rand = new Random();
    private static final List<String> names = Arrays.asList("Maryna", "Anna", "Ingrid", "Kub");
    private static final List<String> surnames = Arrays.asList("Kubein", "Liskin", "Help", "Alone");
    private static final List<String> desserts = Arrays.asList("Napoleon", "Tiramisu", "Cheesecake");

    public static String getName(){
        return names.get(rand.nextInt(names.size()));
    }

    public static String getSurname(){
        return surnames.get(rand.nextInt(surnames.size()));
    }

    public static String getDessert(){
        return desserts.get(rand.nextInt(desserts.size()));
    }

    public static double getPrice(){
        return (rand.nextInt(2) + 1) * 1.5 * 80.;
    }

    public static double getSalary(){
        return (rand.nextInt(2) + 1) * 1.5 * 500.;
    }
}
