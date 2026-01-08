package src;

import src.builder.FoodBuilder;
import src.builder.PancakeBuilder;
import src.builder.WaffleBuilder;
import src.composite.FoodComposite;
import src.decorators.BerriesDecorator;
import src.decorators.ChocolateDecorator;
import src.decorators.SyrupDecorator;
import src.factory.BakeryFactory;
import src.factory.PancakeFactory;
import src.factory.WaffleFactory;
import src.products.IFood;
import src.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ConsoleReader reader = new ConsoleReader();
    private static BakeryFactory pancakeFactory = new PancakeFactory();
    private static BakeryFactory waffleFactory = new WaffleFactory();
    private static List<IFood> cart = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║   🥞 WELKOM BIJ BAKKERIJ DE PANNENKOEKEN 🥞          ║");
        System.out.println("║   Waar design patterns samenwerken als beslag en boter ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println();

        boolean keepOrdering = true;

        while (keepOrdering) {
            showMainMenu();
            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    orderPancake();
                    break;
                case "2":
                    orderWaffle();
                    break;
                case "3":
                    useBuilder();
                    break;
                case "4":
                    createCombo();
                    break;
                case "5":
                    viewCart();
                    break;
                case "6":
                    checkout();
                    keepOrdering = false;
                    break;
                case "7":
                    System.out.println("\nTot ziens! Kom snel weer terug! 🥞");
                    return;
                default:
                    System.out.println("\n❌ Ongeldige keuze. Probeer opnieuw.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n╔════════════════ HOOFDMENU ════════════════╗");
        System.out.println("║ Wat wilt u bestellen?                     ║");
        System.out.println("║                                           ║");
        System.out.println("║ 1. 🥞 Pannenkoek (Factory Pattern)        ║");
        System.out.println("║ 2. 🧇 Wafel (Factory Pattern)             ║");
        System.out.println("║ 3. 🧑‍🍳 Custom maken (Builder Pattern)    ║");
        System.out.println("║ 4. 🧺 Combo maken (Composite Pattern)     ║");
        System.out.println("║ 5. 🛒 Bekijk winkelwagen                  ║");
        System.out.println("║ 6. 💰 Afrekenen                           ║");
        System.out.println("║ 7. 🚪 Verlaten                            ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        System.out.print("\nUw keuze: ");
    }

    private static void orderPancake() {
        System.out.println("\n[🏭 Factory Pattern: Pannenkoek maken]");
        System.out.println("\nWelk type pannenkoek wilt u?");
        System.out.println("1. Klassieke (€5.50)");
        System.out.println("2. Amerikaanse (€7.00)");
        System.out.println("3. Zuid-Afrikaanse (€6.00)");
        System.out.print("Uw keuze: ");

        String choice = reader.readLine();
        IFood pancake;

        switch (choice) {
            case "1":
                pancake = pancakeFactory.createProduct("klassieke");
                break;
            case "2":
                pancake = pancakeFactory.createProduct("amerikaans");
                break;
            case "3":
                pancake = pancakeFactory.createProduct("zuidafrikaanse");
                break;
            default:
                System.out.println("Ongeldige keuze, klassieke gekozen.");
                pancake = pancakeFactory.createProduct("klassieke");
        }

        pancake = addToppings(pancake);
        pancake.prepare();
        cart.add(pancake);

        System.out.println("\n✅ Toegevoegd aan winkelwagen: " + pancake.getDescription());
        System.out.println("Prijs: €" + String.format("%.2f", pancake.getPrice()));
    }

    private static void orderWaffle() {
        System.out.println("\n[🏭 Factory Pattern: Wafel maken]");
        System.out.println("\nWelk type wafel wilt u?");
        System.out.println("1. Brusselse (€6.00)");
        System.out.println("2. Luikse (€6.50)");
        System.out.println("3. Amerikaanse (€5.50)");
        System.out.print("Uw keuze: ");

        String choice = reader.readLine();
        IFood waffle;

        switch (choice) {
            case "1":
                waffle = waffleFactory.createProduct("brusselse");
                break;
            case "2":
                waffle = waffleFactory.createProduct("luikse");
                break;
            case "3":
                waffle = waffleFactory.createProduct("amerikaanse");
                break;
            default:
                System.out.println("Ongeldige keuze, Brusselse gekozen.");
                waffle = waffleFactory.createProduct("brusselse");
        }

        waffle = addToppings(waffle);
        waffle.prepare();
        cart.add(waffle);

        System.out.println("\n✅ Toegevoegd aan winkelwagen: " + waffle.getDescription());
        System.out.println("Prijs: €" + String.format("%.2f", waffle.getPrice()));
    }

    private static IFood addToppings(IFood food) {
        System.out.println("\n[🍫 Decorator Pattern: Toppings toevoegen]");
        System.out.println("\nWilt u toppings toevoegen? (j/n)");
        System.out.print("Uw keuze: ");

        if (!reader.readLine().equalsIgnoreCase("j")) {
            return food;
        }

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("\nBeschikbare toppings:");
            System.out.println("1. Chocolade (+€0.75)");
            System.out.println("2. Siroop (+€0.50)");
            System.out.println("3. Bessen (+€0.80)");
            System.out.println("4. Klaar met toppings");
            System.out.print("Uw keuze: ");

            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    food = new ChocolateDecorator(food);
                    System.out.println("✅ Chocolade toegevoegd!");
                    break;
                case "2":
                    food = new SyrupDecorator(food);
                    System.out.println("✅ Siroop toegevoegd!");
                    break;
                case "3":
                    food = new BerriesDecorator(food);
                    System.out.println("✅ Bessen toegevoegd!");
                    break;
                case "4":
                    addingToppings = false;
                    break;
                default:
                    System.out.println("❌ Ongeldige keuze.");
            }
        }

        return food;
    }

    private static void useBuilder() {
        System.out.println("\n[🧑‍🍳 Builder Pattern: Custom bereiding]");
        System.out.println("\nWat wilt u custom maken?");
        System.out.println("1. Pannenkoek");
        System.out.println("2. Wafel");
        System.out.print("Uw keuze: ");

        String choice = reader.readLine();
        FoodBuilder builder;

        if (choice.equals("2")) {
            builder = new WaffleBuilder();
            System.out.println("\n🧇 Wafel aan het maken...");
        } else {
            builder = new PancakeBuilder();
            System.out.println("\n🥞 Pannenkoek aan het maken...");
        }

        builder.prepareBatter();

        System.out.println("\nBoter toevoegen? (j/n): ");
        if (reader.readLine().equalsIgnoreCase("j")) {
            builder.addButter();
        }

        System.out.println("Siroop toevoegen? (j/n): ");
        if (reader.readLine().equalsIgnoreCase("j")) {
            builder.addSyrup();
        }

        System.out.println("Bessen toevoegen? (j/n): ");
        if (reader.readLine().equalsIgnoreCase("j")) {
            builder.addBerries();
        }

        IFood customFood = builder.build();
        customFood.prepare();
        cart.add(customFood);

        System.out.println("\n✅ Custom item toegevoegd aan winkelwagen!");
        System.out.println(customFood.getDescription());
    }

    private static void createCombo() {
        System.out.println("\n[🧺 Composite Pattern: Combo maken]");
        System.out.print("\nGeef uw combo een naam: ");
        String comboName = reader.readLine();

        FoodComposite combo = new FoodComposite(comboName);

        System.out.println("\nHoeveel items wilt u in de combo? ");
        System.out.print("Aantal: ");
        String countStr = reader.readLine();
        int count;

        try {
            count = Integer.parseInt(countStr);
        } catch (NumberFormatException e) {
            count = 2;
            System.out.println("Ongeldige invoer, 2 items gekozen.");
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Item " + (i + 1) + " van " + count + " ---");
            System.out.println("1. Pannenkoek");
            System.out.println("2. Wafel");
            System.out.print("Keuze: ");

            String itemChoice = reader.readLine();
            IFood item;

            if (itemChoice.equals("2")) {
                System.out.println("Type wafel (1=Brusselse, 2=Luikse, 3=Amerikaanse): ");
                String type = reader.readLine();
                String waffleType = type.equals("2") ? "luikse" : type.equals("3") ? "amerikaanse" : "brusselse";
                item = waffleFactory.createProduct(waffleType);
            } else {
                System.out.println("Type pannenkoek (1=Klassieke, 2=Amerikaanse, 3=Zuid-Afrikaanse): ");
                String type = reader.readLine();
                String pancakeType = type.equals("2") ? "amerikaans" : type.equals("3") ? "zuidafrikaanse" : "klassieke";
                item = pancakeFactory.createProduct(pancakeType);
            }

            System.out.println("Toppings toevoegen? (j/n): ");
            if (reader.readLine().equalsIgnoreCase("j")) {
                item = addToppings(item);
            }

            combo.addComponent(item);
        }

        combo.prepare();
        cart.add(combo);

        System.out.println("\n✅ Combo toegevoegd aan winkelwagen!");
        System.out.println(combo.getDescription());
        System.out.println("Totaalprijs: €" + String.format("%.2f", combo.getPrice()));
    }

    private static void viewCart() {
        System.out.println("\n╔════════════════ WINKELWAGEN ══════════════════╗");

        if (cart.isEmpty()) {
            System.out.println("║ Uw winkelwagen is leeg.                      ║");
        } else {
            double total = 0;
            for (int i = 0; i < cart.size(); i++) {
                IFood item = cart.get(i);
                System.out.println("║ " + (i + 1) + ". " + item.getDescription().split("\n")[0]);
                System.out.println("║    Prijs: €" + String.format("%.2f", item.getPrice()));
                total += item.getPrice();
            }
            System.out.println("║                                               ║");
            System.out.println("║ Totaal: €" + String.format("%.2f", total) + "                           ║");
        }

        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    private static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("\n❌ Uw winkelwagen is leeg!");
            return;
        }

        System.out.println("\n╔════════════════ AFREKENEN ════════════════╗");

        FoodComposite order = new FoodComposite("Uw bestelling");
        for (IFood item : cart) {
            order.addComponent(item);
        }

        System.out.println("\n" + order.getDescription());
        System.out.println("\nBasisprijs: €" + String.format("%.2f", order.getPrice()));

        System.out.println("\n[💰 Strategy Pattern: Prijsstrategie kiezen]");
        System.out.println("\nHeeft u korting?");
        System.out.println("1. Geen korting (normale prijs)");
        System.out.println("2. Happy Hour (25% korting)");
        System.out.println("3. Kortingsbon (voer percentage in)");
        System.out.println("4. Bulkkorting (bij grote bestellingen)");
        System.out.print("Uw keuze: ");

        String choice = reader.readLine();
        PricingStrategy strategy;

        switch (choice) {
            case "2":
                strategy = new HappyHourStrategy(25, true);
                break;
            case "3":
                System.out.print("Percentage korting: ");
                int percentage = 10;
                try {
                    percentage = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ongeldige invoer, 10% gekozen.");
                }
                strategy = new PercentageDiscountStrategy(percentage);
                break;
            case "4":
                strategy = new BulkDiscountStrategy(10, 50);
                break;
            default:
                strategy = new RegularPricingStrategy();
        }

        Order finalOrder = new Order(order, strategy);
        System.out.println();
        finalOrder.printOrderDetails();

        System.out.println("\n🎉 Bedankt voor uw bestelling!");
        System.out.println("Uw bestelling wordt bereid...\n");

        order.prepare();

        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║  ✅ Bestelling compleet!                                ║");
        System.out.println("║                                                        ║");
        System.out.println("║  📊 Gebruikte Design Patterns:                         ║");
        System.out.println("║     ✓ Factory Pattern    - Producten maken             ║");
        System.out.println("║     ✓ Builder Pattern    - Custom bereiding            ║");
        System.out.println("║     ✓ Decorator Pattern  - Toppings toevoegen          ║");
        System.out.println("║     ✓ Composite Pattern  - Orders samenstellen         ║");
        System.out.println("║     ✓ Strategy Pattern   - Flexibele prijzen           ║");
        System.out.println("║     ✓ State Pattern      - Bereidingsstatus            ║");
        System.out.println("║                                                        ║");
        System.out.println("║  Eet smakelijk! 🥞                                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
