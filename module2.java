import java.util.HashMap;

import java.util.Scanner;

public class InventoryManager {

    // Custom class to represent an item in the inventory
    public static class Item {

        String name;

        int quantity;

        public Item(String name, int quantity) {

            this.name = name;

            this.quantity = quantity;
        }

        // Function to display item details
        public void display() {

            System.out.println(name + " - Quantity: " + quantity);

        }
    }

    // HashMap to store items using their name as the key
    private HashMap<String, Item> inventory;

    public InventoryManager() {

        inventory = new HashMap<>();

    }

    // Function to add an item to the inventory
    public void addItem(String name, int quantity) {

        if (inventory.containsKey(name)) {

            inventory.get(name).quantity += quantity;

        } else {

            inventory.put(name, new Item(name, quantity));
        }
    }

    // Function to display the inventory
    public void displayInventory() {

        System.out.println("Inventory:");

        for (Item item : inventory.values()) {

            item.display();

        }
    }

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        Scanner scanner = new Scanner(System.in);

        // Simple user interface
        while (true) {

            System.out.println("1. Add Item\n2. Display Inventory\n3. Exit");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            scanner.nextLine(); // Consume newline

            switch (choice) {

                case 1:

                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    manager.addItem(name, quantity);
                    break;

                case 2:

                    manager.displayInventory();
                    break;

                case 3:

                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
