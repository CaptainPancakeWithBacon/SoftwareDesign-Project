package src.test;

import src.composite.FoodComposite;
import src.decorators.BerriesDecorator;
import src.decorators.ChocolateDecorator;
import src.decorators.SyrupDecorator;
import src.products.IFood;
import src.products.Pancake;
import src.products.Waffle;

public class CompositeTest {
    public static void main(String[] args) {
        System.out.println("=== Composite Pattern Test ===\n");

        // Create individual food items (Leaf nodes)
        System.out.println("--- Creating Individual Items ---");
        IFood pancake1 = new Pancake("Amerikaanse", 7.0);
        IFood pancake2 = new Pancake("Klassieke", 5.5);
        IFood waffle1 = new Waffle("Luikse", 6.5);
        IFood waffle2 = new Waffle("Brusselse", 6.0);

        System.out.println("Created: " + pancake1.getDescription());
        System.out.println("Created: " + pancake2.getDescription());
        System.out.println("Created: " + waffle1.getDescription());
        System.out.println("Created: " + waffle2.getDescription());

        // Create a simple breakfast combo (Composite node)
        System.out.println("\n--- Creating Breakfast Combo ---");
        FoodComposite breakfastCombo = new FoodComposite("Ontbijt Combo");
        breakfastCombo.addComponent(pancake1);
        breakfastCombo.addComponent(waffle1);

        System.out.println(breakfastCombo.getDescription());
        System.out.println("Totale prijs: €" + String.format("%.2f", breakfastCombo.getPrice()));

        // Create a family meal (Composite with more items)
        System.out.println("\n--- Creating Family Meal ---");
        FoodComposite familyMeal = new FoodComposite("Familie Maaltijd");
        familyMeal.addComponent(pancake1);
        familyMeal.addComponent(pancake2);
        familyMeal.addComponent(waffle1);
        familyMeal.addComponent(waffle2);

        System.out.println(familyMeal.getDescription());
        System.out.println("Totale prijs: €" + String.format("%.2f", familyMeal.getPrice()));

        // Create nested composite (Composite containing composites)
        System.out.println("\n--- Creating Nested Composite ---");
        FoodComposite combo1 = new FoodComposite("Combo 1");
        combo1.addComponent(new Pancake("Zuid Afrikaanse", 6.0));
        combo1.addComponent(new Waffle("Amerikaanse", 5.5));

        FoodComposite combo2 = new FoodComposite("Combo 2");
        combo2.addComponent(new Pancake("Amerikaanse", 7.0));
        combo2.addComponent(new Waffle("Luikse", 6.5));

        FoodComposite megaCombo = new FoodComposite("Mega Party Combo");
        megaCombo.addComponent(combo1);
        megaCombo.addComponent(combo2);

        System.out.println(megaCombo.getDescription());
        System.out.println("Totale prijs: €" + String.format("%.2f", megaCombo.getPrice()));

        // Demonstrate unified interface (treating leaf and composite the same)
        System.out.println("\n--- Demonstrating Unified Interface ---");
        System.out.println("Treating all items the same through IFood interface:\n");

        IFood[] items = {pancake1, breakfastCombo, familyMeal};
        for (IFood item : items) {
            System.out.println("Item: " + item.getDescription().split("\n")[0]);
            System.out.println("Prijs: €" + String.format("%.2f", item.getPrice()));
            System.out.println();
        }

        // Demonstrate preparation of composite
        System.out.println("--- Preparing Breakfast Combo ---");
        breakfastCombo.prepare();

        // Demonstrate adding/removing components
        System.out.println("\n--- Modifying Composite ---");
        FoodComposite customCombo = new FoodComposite("Custom Combo");
        customCombo.addComponent(new Pancake("Klassieke", 5.5));
        System.out.println("After adding pancake:");
        System.out.println("Prijs: €" + String.format("%.2f", customCombo.getPrice()));

        IFood tempWaffle = new Waffle("Brusselse", 6.0);
        customCombo.addComponent(tempWaffle);
        System.out.println("\nAfter adding waffle:");
        System.out.println("Prijs: €" + String.format("%.2f", customCombo.getPrice()));

        customCombo.removeComponent(tempWaffle);
        System.out.println("\nAfter removing waffle:");
        System.out.println("Prijs: €" + String.format("%.2f", customCombo.getPrice()));

        // INTEGRATION: Composite + Decorator patterns
        System.out.println("\n--- Composite + Decorator Integration ---");
        System.out.println("Demonstrating how both patterns work together:\n");

        // Scenario 1: Decorated items in a composite
        FoodComposite decoratedCombo = new FoodComposite("Deluxe Combo");
        decoratedCombo.addComponent(new ChocolateDecorator(new Pancake("Amerikaanse", 7.0)));
        decoratedCombo.addComponent(new BerriesDecorator(new Waffle("Luikse", 6.5)));

        System.out.println(decoratedCombo.getDescription());
        System.out.println("Totale prijs: €" + String.format("%.2f", decoratedCombo.getPrice()));

        // Scenario 2: Decorating an entire composite
        System.out.println("\n--- Decorating Entire Composite ---");
        FoodComposite plainCombo = new FoodComposite("Basis Combo");
        plainCombo.addComponent(new Pancake("Klassieke", 5.5));
        plainCombo.addComponent(new Waffle("Brusselse", 6.0));

        IFood chocolateCombo = new ChocolateDecorator(plainCombo);
        System.out.println(chocolateCombo.getDescription());
        System.out.println("Totale prijs: €" + String.format("%.2f", chocolateCombo.getPrice()));

        System.out.println("\n=== All Composite Pattern tests completed! ===");
        System.out.println("(Including Composite + Decorator integration)");
    }
}
