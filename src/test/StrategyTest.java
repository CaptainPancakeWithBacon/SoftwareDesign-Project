package src.test;

import src.composite.FoodComposite;
import src.decorators.ChocolateDecorator;
import src.decorators.SyrupDecorator;
import src.products.IFood;
import src.products.Pancake;
import src.products.Waffle;
import src.strategy.*;

public class StrategyTest {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Test ===\n");

        // Test 1: Different strategies on a single item
        System.out.println("--- Test 1: Single Item with Different Strategies ---");
        IFood pancake = new Pancake("Amerikaanse", 7.0);

        Order order1 = new Order(pancake, new RegularPricingStrategy());
        order1.printOrderDetails();

        System.out.println();
        order1.setPricingStrategy(new PercentageDiscountStrategy(10));
        order1.printOrderDetails();

        System.out.println();
        order1.setPricingStrategy(new PercentageDiscountStrategy(25));
        order1.printOrderDetails();

        // Test 2: Bulk discount strategy
        System.out.println("\n--- Test 2: Bulk Discount Strategy ---");

        // Small order - no bulk discount
        IFood waffle = new Waffle("Luikse", 6.5);
        Order smallOrder = new Order(waffle, new BulkDiscountStrategy(20.0, 15));
        System.out.println("Kleine bestelling:");
        smallOrder.printOrderDetails();

        System.out.println();

        // Large order - gets bulk discount
        FoodComposite familyMeal = new FoodComposite("Familie Maaltijd");
        familyMeal.addComponent(new Pancake("Amerikaanse", 7.0));
        familyMeal.addComponent(new Pancake("Klassieke", 5.5));
        familyMeal.addComponent(new Waffle("Luikse", 6.5));
        familyMeal.addComponent(new Waffle("Brusselse", 6.0));

        Order largeOrder = new Order(familyMeal, new BulkDiscountStrategy(20.0, 15));
        System.out.println("Grote bestelling:");
        largeOrder.printOrderDetails();

        // Test 3: Happy Hour strategy
        System.out.println("\n--- Test 3: Happy Hour Strategy ---");
        IFood decoratedPancake = new ChocolateDecorator(new SyrupDecorator(new Pancake("Amerikaanse", 7.0)));

        Order happyHourOrder = new Order(decoratedPancake, new HappyHourStrategy(30, false));
        System.out.println("Buiten happy hour:");
        happyHourOrder.printOrderDetails();

        System.out.println();
        happyHourOrder.setPricingStrategy(new HappyHourStrategy(30, true));
        System.out.println("Tijdens happy hour:");
        happyHourOrder.printOrderDetails();

        // Test 4: Comparing strategies on the same order
        System.out.println("\n--- Test 4: Strategy Comparison ---");
        FoodComposite combo = new FoodComposite("Ontbijt Combo");
        combo.addComponent(new Pancake("Amerikaanse", 7.0));
        combo.addComponent(new Waffle("Brusselse", 6.0));

        System.out.println("Vergelijking van verschillende strategieën op dezelfde bestelling:\n");

        PricingStrategy[] strategies = {
            new RegularPricingStrategy(),
            new PercentageDiscountStrategy(10),
            new PercentageDiscountStrategy(20),
            new BulkDiscountStrategy(10.0, 15),
            new HappyHourStrategy(25, true)
        };

        Order comparisonOrder = new Order(combo, strategies[0]);

        for (PricingStrategy strategy : strategies) {
            comparisonOrder.setPricingStrategy(strategy);
            System.out.println(strategy.getStrategyDescription() + ": €" +
                             String.format("%.2f", comparisonOrder.calculateFinalPrice()));
        }

        // Test 5: Strategy with decorated composite
        System.out.println("\n--- Test 5: Strategy with Decorated Composite ---");

        FoodComposite megaCombo = new FoodComposite("Mega Combo");
        megaCombo.addComponent(new ChocolateDecorator(new Pancake("Klassieke", 5.5)));
        megaCombo.addComponent(new SyrupDecorator(new Waffle("Luikse", 6.5)));
        megaCombo.addComponent(new Pancake("Amerikaanse", 7.0));

        Order complexOrder = new Order(megaCombo, new RegularPricingStrategy());
        System.out.println("Zonder korting:");
        complexOrder.printOrderDetails();

        System.out.println();
        complexOrder.setPricingStrategy(new BulkDiscountStrategy(15.0, 20));
        System.out.println("Met bulk korting:");
        complexOrder.printOrderDetails();

        // Test 6: Runtime strategy switching
        System.out.println("\n--- Test 6: Runtime Strategy Switching ---");

        IFood simpleWaffle = new Waffle("Amerikaanse", 5.5);
        Order flexibleOrder = new Order(simpleWaffle, new RegularPricingStrategy());

        System.out.println("Start met normale prijs:");
        System.out.println("Prijs: €" + String.format("%.2f", flexibleOrder.calculateFinalPrice()));

        System.out.println("\nKlant heeft een 15% kortingsbon:");
        flexibleOrder.setPricingStrategy(new PercentageDiscountStrategy(15));
        System.out.println("Prijs: €" + String.format("%.2f", flexibleOrder.calculateFinalPrice()));

        System.out.println("\nHet is nu happy hour! (30% korting):");
        flexibleOrder.setPricingStrategy(new HappyHourStrategy(30, true));
        System.out.println("Prijs: €" + String.format("%.2f", flexibleOrder.calculateFinalPrice()));

        System.out.println("\n=== Strategy Pattern Test Completed! ===");
    }
}
