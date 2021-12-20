package ru.gb.rest.controller;

import ru.gb.rest.service.CartService;

public interface ShopController {
    CartService getCart();
}
