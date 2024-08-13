import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZipCodeSearch zipCodeSearch = new ZipCodeSearch();

        System.out.println("Type a zip code for query: ");
        var zipCode = scanner.nextLine();

        try {
            Address newAddress = zipCodeSearch.searchAddress(zipCode);
            System.out.println(newAddress);
            FileGenerator generator = new FileGenerator();
            generator.saveJson(newAddress);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finishing application");
        }

    }
}