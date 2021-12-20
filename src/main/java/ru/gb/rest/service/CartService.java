package ru.gb.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.rest.dao.CartDao;
import ru.gb.rest.entity.Cart;
import ru.gb.rest.entity.Product;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CartService implements Consumer<Product> {
    //    private final HashMap<Product, Integer> cart = new HashMap<>();
    private final CartDao cartDao;
    private final Cart cart;


    public Cart add(Product product) {
        if (cart.getId() == null){
            createCart();
        }
        Optional<Cart> cartOptional = cartDao.findById(cart.getId());
        if (cartOptional.isPresent()){
            Cart cartFromDB = cartOptional.get();
            cartFromDB.addProduct(product);
            return cartDao.save(cartFromDB);
        }
        return null;
    }

    public void deleteByProductId(Product product) {
        Optional<Cart> cartOptional = cartDao.findById(cart.getId());
        if (cartOptional.isPresent()) {
            Cart cartFromDB = cartOptional.get();
            cartFromDB.deleteProduct(product);
            cartDao.save(cartFromDB);
        }
    }

    public Set<Product> findAll() {
        if (cart.getId() == null){
            createCart();
        }
        Optional<Cart> cartOptional = cartDao.findById(cart.getId());
        Cart cartFromDB = cartOptional.get();
        return cartFromDB.getProducts();
    }

    private void createCart(){
        cartDao.save(cart);
    }


    @Override
    public void accept(Product product) {
        add(product);
    }
}
