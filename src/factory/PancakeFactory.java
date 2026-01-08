package src.factory;

import src.products.IFood;
import src.products.Pancake;

public class PancakeFactory extends BakeryFactory {
    public IFood createProduct(String type) {
        switch (type.toLowerCase()) {
            case "zuidafrikaanse" -> {
                return new Pancake("Zuid Afrikaanse", (double)6.0F);
            }
            case "amerikaans" -> {
                return new Pancake("Amerikaanse", (double)7.0F);
            }
            default -> {
                return new Pancake("Klassieke", (double)5.5F);
            }
        }
    }
}
