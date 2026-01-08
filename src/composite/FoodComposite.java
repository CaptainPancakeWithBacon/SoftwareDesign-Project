package src.composite;

import src.products.IFood;

import java.util.ArrayList;
import java.util.List;

public class FoodComposite implements IFood {
    private String name;
    private List<IFood> components;

    public FoodComposite(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(IFood food) {
        components.add(food);
    }

    public void removeComponent(IFood food) {
        components.remove(food);
    }

    public List<IFood> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public String getDescription() {
        if (components.isEmpty()) {
            return name + " (leeg)";
        }

        StringBuilder description = new StringBuilder(name + " bevat:\n");
        for (IFood component : components) {
            String componentDesc = component.getDescription();
            String[] lines = componentDesc.split("\n");
            for (String line : lines) {
                description.append("  - ").append(line).append("\n");
            }
        }
        return description.toString().trim();
    }

    @Override
    public double getPrice() {
        double totalPrice = 0.0;
        for (IFood component : components) {
            totalPrice += component.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void prepare() {
        System.out.println("=== Bereiden van " + name + " ===");
        if (components.isEmpty()) {
            System.out.println("Geen items om te bereiden!");
        } else {
            for (IFood component : components) {
                component.prepare();
            }
            System.out.println("=== " + name + " is klaar! ===");
        }
    }
}
