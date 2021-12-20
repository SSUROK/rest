package ru.gb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.rest.entity.Product;
import ru.gb.rest.service.ShopServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Set;

@RequiredArgsConstructor
@Component
@Scope("prototype")
public class Buyer {

    private final ShopServiceImpl shopService;

    @PostConstruct
    public void init() {
        shopService.enterToShop();
    }

    public void purchase(Long id) {
        shopService.addProductFromCartById(id);
    }

    public void purchase(Product product) {
        shopService.addProductFromCartById(product);
    }

    public Set<Product> showCart() {
        return shopService.showProductsInCart();
    }

    public void removeProduct(Long id) {
        shopService.deleteProductFromCartById(id);
    }

}