import java.sql.SQLOutput;
import java.util.*;


public class Main {

    public static void displayMenu(){
        System.out.println("Welcome to Law's Car Dealer!\n");
        System.out.println("Choose one of the following:");
        System.out.println("1. Browse inventory\n2. Purchase vehicle\n3. Sell used vehicle\n4. Show budget\n5. Exit");
    }

    public static void displayList(HashMap<Integer, Car> inventory){
        System.out.println("---------------------------------");
        System.out.println("\t\tSelect a car");
        System.out.println("---------------------------------");
        for (int i : inventory.keySet()){
            System.out.print(i + " - ");
            inventory.get(i).getName();
        }
        System.out.println("0 - Exit");
        return;
    }

    public static void showInventory(HashMap<Integer, Car> inventory) {
        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            displayList(inventory);
            choice = input.nextInt();
            if(choice == 0){
                break;
            }
            System.out.println(inventory.get(choice));
        }
        return;
    }

    public static double purchaseCar(double budget, HashMap<Integer, Car> inventory){
        // Select which car to buy
        // If budget > carPrice : return budget - carPrice & inventory.remove(key)
        // Else sout("Choose again or exit");
        Scanner input = new Scanner(System.in);
        int choice = -1;

        while(choice != 0){
            displayList(inventory);
            System.out.println("Which vehicle would you like to purchase?");
            choice = input.nextInt();

            if(budget >= inventory.get(choice).getPrice() && inventory.get(choice).getStock() > 0) {
                budget -= inventory.get(choice).getPrice();
                inventory.get(choice).setStock(1);
                System.out.println("Enjoy your new whip: ");
                System.out.println(inventory.get(choice).toString());
                break;
            }
            else {
                System.out.println("Well..this is awkward. Would you like to buy some crypto?");
            }
        }
        return budget;
    }

    public static void sellCar(HashMap<Integer, Car> inventory, double budget){
        String type, origin, brand, model;
        int year, hp, quantity;
        double price;

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your vehicle's details:");
        System.out.print("1. Type: ");
        type = input.nextLine();
        System.out.print("2. Origin: ");
        origin = input.nextLine();
        System.out.print("3. Brand: ");
        brand = input.nextLine();
        System.out.print("4. Model: ");
        model = input.nextLine();
        System.out.print("5. Year: ");
        year = input.nextInt();
        System.out.print("6. HP: ");
        hp = input.nextInt();
        System.out.print("7. Asking Price: ");
        price = input.nextDouble();
        System.out.print("8. Quantity: ");
        quantity = input.nextInt();

        Car soldCar = new Car(type, origin, brand, model, year, hp, price, quantity);
        int soldCarKey = inventory.size()+1;
        inventory.put(soldCarKey, soldCar);
        System.out.println("Thank you for your vehicle! Here are the specifications you gave us.");
        budget += price;
        System.out.println(inventory.get(soldCarKey).toString());
        return;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create cars and store into array (for the purpose of this program)
        Car car1 = new Car("Car", "USA", "Ford", "Mustang GT", 2022, 470, 27_205, 3);
        Car car2 = new Car("Car", "Japan", "Nissan", "GT-R", 2021, 565, 113_540, 1);
        Car car3 = new Car("SUV", "Japan", "Lexus", "RZ 450e", 2023, 355, 125_490, 1);
        Car car4 = new Car("Car", "German", "Mercedes Benz", "EQS", 2022, 470, 27_205, 3);
        Car car5 = new Car("Truck", "USA", "Tesla", "Cybertruck", 2022, 800, 39_000, 2);

        // HashMap to hold cars:
        HashMap<Integer, Car> inventory = new HashMap<>();
        inventory.put(1, car1);
        inventory.put(2, car2);
        inventory.put(3, car3);
        inventory.put(4, car4);
        inventory.put(5, car5);

        double budget = 100_000.00;

        int choice = 0;
        while (choice != 5) {
            displayMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    showInventory(inventory);
                    choice = 0;
                    break;
                case 2:
                    budget = purchaseCar(budget, inventory); // Show inventory again (no stats) but will have get and remove car from list, and remove price from budget;
                    choice = 0;
                    break;
                case 3:
                    sellCar(inventory, budget); // Prompt user for details of their car to then add to HashMap
                    choice = 0;
                    break;
                case 4:
                    System.out.println("Budget: $" + budget);
                    choice = 0;
                    break;
                case 5:
                    System.out.println("Thank you for visiting and come back soon!");
                    break;
                default:
                    System.out.println("Not a valid choice");
                    choice = 0;
            }
        }
    }
}
