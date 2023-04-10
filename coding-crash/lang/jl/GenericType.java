package lang.jl;

import java.util.List;

public class GenericType {
}

class Product<T>{
    private T product;

    public T getProduct(T product){
        this.product = product;

        return product;
    }
}

class GenericArray<E> {
    List<E> geneArray;
}
