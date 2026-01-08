package src.factory;

import src.products.IFood;

public abstract class BakeryFactory {
    public abstract IFood createProduct(String var1);

    public IFood orderProduct(String type) {
        IFood product = this.createProduct(type);
        product.prepare();
        return product;
    }
}
