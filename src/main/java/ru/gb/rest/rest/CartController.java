package ru.gb.rest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.rest.controller.Buyer;
import ru.gb.rest.entity.Cart;
import ru.gb.rest.entity.Product;
import ru.gb.rest.service.CartService;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    //    private final CartService cartService;
    private final Buyer buyer;


    @GetMapping
    public Set<Product> getProductList(){
        return buyer.showCart();
    }

//    @GetMapping("/{productId}")
//    public ResponseEntity<?> getProduct(@PathVariable("productId") Long id){
//        Product product;
//        if(id != null){
//            product = cartService.findById(id);
//            if (product != null){
//                return new ResponseEntity<>(product, HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @PostMapping("/{productId}")
    public ResponseEntity<?> handlePost(@PathVariable("productId") Long id){
        buyer.purchase(id);
//        Cart savedProduct = cartService.add(product);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(URI.create("/api/v1/product" + savedProduct.getId()));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/{productId}")
//    public ResponseEntity<?> handlePost(@PathVariable("productId") Long id, @RequestBody Product product){
//        product.setId(id);
//        productService.save(product);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("productId") Long id){
        buyer.removeProduct(id);
    }

}
