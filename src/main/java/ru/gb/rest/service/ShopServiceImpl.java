package ru.gb.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.gb.rest.controller.ShopController;
import ru.gb.rest.dao.CartDao;
import ru.gb.rest.dao.ProductDao;
import ru.gb.rest.entity.Product;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ShopServiceImpl implements ShopController {
    private final ProductDao productDao;
    private final CartDao cartDao;
    private CartService cart;

    @Lookup
    @Override
    public CartService getCart() {
        return null;
    }

    public void showAssortment() {
        System.out.println(productDao.findAll());
    }

    public void addProductFromCartById(Long id) {
        productDao.findById(id).ifPresent(cart);
    }

    public void addProductFromCartById(Product product) {
        productDao.findById(product.getId()).ifPresent(cart);
    }

    public void deleteProductFromCartById(Long id) {
        System.out.println(productDao.getById(id));
        cart.deleteByProductId(productDao.getById(id));
    }

    public Set<Product> showProductsInCart() {
        return cart.findAll();
    }

    public void enterToShop() {
        this.cart = getCart();
    }
}