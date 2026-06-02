package main;

import java.util.Scanner;

import alert.*;
import incident.*;
import observer.*;
import response.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== SDA-Pro Started =====");

        // Alert Input
        System.out.print("Enter Alert ID: ");
        String alertId = input.nextLine();

        System.out.print("Enter Severity (HIGH/MEDIUM/LOW): ");
        String severity = input.nextLine();

        System.out.print("Enter Alert Source: ");
        String source = input.nextLine();

        System.out.print("Enter Alert Description: ");
        String description = input.nextLine();

        Alert alert = AlertFactory.createAlert(
                alertId,
                severity,
                source,
                "Today",
                description
        );

        System.out.println("\n===== Alert Details =====");
        alert.displayAlert();

        // Incident Input
        System.out.print("\nEnter Incident ID: ");
        String incidentId = input.nextLine();

        Incident incident = new Incident(
                incidentId,
                severity,
                "NEW"
        );

        incident.createIncident();
        incident.handleIncident();

        // Observer Pattern
        EventBus eventBus = EventBus.getInstance();

        eventBus.subscribe(new DashboardObserver());
        eventBus.subscribe(new AuditObserver());

        eventBus.publish("New Security Incident");

        // Strategy Pattern
        System.out.println("\nSelect Response Strategy");
        System.out.println("1. Aggressive");
        System.out.println("2. Conservative");
        System.out.print("Choice: ");

        int choice = input.nextInt();

        ResponseManager manager = new ResponseManager();

        if (choice == 1) {
            manager.setStrategy(new AggressiveStrategy());
        } else {
            manager.setStrategy(new ConservativeStrategy());
        }

        manager.executeResponse();

        System.out.println("\n===== SDA-Pro Completed =====");

        input.close();
    }
}