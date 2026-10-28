package delivery_management;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Delivery> deliveries = new ArrayList<>();

        int numberOfDeliveries;
        System.out.print("How many deliveries? ");
        numberOfDeliveries = scanner.nextInt();
// forced
        while (numberOfDeliveries < 1 || numberOfDeliveries > 100) {
            System.out.print("Enter a number from 1 to 100: ");
            numberOfDeliveries = scanner.nextInt();
        }

        for (int i = 1; i <= numberOfDeliveries; i++) {
            String type;

            System.out.print("delivery_management.Delivery " + i + " - type (R/E): ");
            type = scanner.next().trim().toUpperCase();

            while (!type.equals("R") && !type.equals("E")) {
                System.out.print("Enter R for Regular or E for Express: ");
                type = scanner.next().trim().toUpperCase();
            }

            int distance;
            System.out.print("delivery_management.Delivery " + i + " - distance (km): ");
            distance = scanner.nextInt();
//forced
            while (distance < 1 || distance > 1000) {
                System.out.print("Enter a distance from 1 to 1000 km: ");
                distance = scanner.nextInt();
            }

            int weight;
            System.out.print("delivery_management.Delivery " + i + " - weight (kg): ");
            weight = scanner.nextInt();
//forced
            while (weight < 1 || weight > 1000) {
                System.out.print("Enter a weight from 1 to 1000 kg: ");
                weight = scanner.nextInt();
            }

            Delivery delivery;

            if (type.equals("R")) {
                delivery = new RegularDelivery(distance, weight);
            } else {
                delivery = new ExpressDelivery(distance, weight);
            }
            deliveries.add(delivery);
        }

        System.out.println();
        System.out.println("--- DELIVERY FEE SUMMARY ---");

        long totalFees = 0;

        for (int i = 0; i < deliveries.size(); i++) {
            long fee = deliveries.get(i).calculateFee();
            System.out.println("delivery_management.Delivery " + (i + 1) + ": " + fee + " units");
            totalFees += fee;
        }
        System.out.println("Total delivery fees: " + totalFees + " units");
        scanner.close();
    }
}
