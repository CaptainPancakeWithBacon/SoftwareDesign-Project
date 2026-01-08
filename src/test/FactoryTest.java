package src.test;

import src.factory.BakeryFactory;
import src.factory.PancakeFactory;
import src.factory.WaffleFactory;
import src.products.IFood;

public class FactoryTest {
    public static void main(String[] args) {
        System.out.println("=== Bakery Factory Pattern Test ===\n");

        // Create factory instances
        BakeryFactory pancakeFactory = new PancakeFactory();
        BakeryFactory waffleFactory = new WaffleFactory();

        // Test PancakeFactory with different types
        System.out.println("--- Testing PancakeFactory ---");
        testProduct(pancakeFactory, "zuidafrikaanse");
        testProduct(pancakeFactory, "amerikaans");
        testProduct(pancakeFactory, "klassiek");

        System.out.println("\n--- Testing WaffleFactory ---");
        testProduct(waffleFactory, "luikse");
        testProduct(waffleFactory, "amerikaanse");
        testProduct(waffleFactory, "brusselse");

        System.out.println("\n=== All tests completed! ===");
    }

    private static void testProduct(BakeryFactory factory, String type) {
        System.out.println("\n>> Bestelling: " + type);
        IFood product = factory.orderProduct(type);
        System.out.println("Product: " + product.getDescription());
        System.out.println("Prijs: €" + String.format("%.2f", product.getPrice()));
        System.out.println("---");
    }
}
