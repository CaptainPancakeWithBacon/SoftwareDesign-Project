package src.composite;

import src.products.IFood;
import src.state.FoodState;
import src.state.RawState;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite pattern implementation for grouping multiple food items into a meal combo.
 * This class implements IFood and can contain multiple IFood components (both individual items and other composites).
 */
public class FoodComposite implements IFood {
    private String name;
    private List<IFood> components;
    private FoodState state;

    public FoodComposite(String name) {
        this.name = name;
        this.components = new ArrayList<>();
        this.state = new RawState();
    }

    @Override
    public void setState(FoodState state) {
        this.state = state;
    }

    @Override
    public FoodState getState() {
        return this.state;
    }

    /**
     * Add a food component to this composite
     */
    public void addComponent(IFood food) {
        components.add(food);
    }

    /**
     * Remove a food component from this composite
     */
    public void removeComponent(IFood food) {
        components.remove(food);
    }

    /**
     * Get all components in this composite
     */
    public List<IFood> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public String getDescription() {
        if (components.isEmpty()) {
            return name + " (leeg) - Status: " + state.getStateName();
        }

        StringBuilder description = new StringBuilder(name + " bevat (Status: " + state.getStateName() + ") + :\n");
        for (IFood component : components) {
            // Indent nested descriptions
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
        System.out.println("=== " + name
                + " wordt bereid (Huidige status: "
                + state.getStateName() + ") ===");
        state.prepare(this);
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
