package src.factory;

import src.products.Waffle;
import src.products.IFood;

public class WaffleFactory extends BakeryFactory {
    public src.products.IFood createProduct(String type) {
        switch (type.toLowerCase()) {
            case "luikse" -> {
                return new Waffle("Luikse", (double)6.5F);
            }
            case "stroopwafel" -> {
                return new Waffle("Stroopwafel", (double)5.5F);
            }
            default -> {
                return new Waffle("Brusselse", (double)6.0F);
            }
        }
    }
}