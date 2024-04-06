package com.sayak.Controller;

import com.sayak.Entity.Coupon;
import com.sayak.Entity.Order;
import com.sayak.Entity.Product;
import com.sayak.Service.CouponService;
import com.sayak.Service.ProductService;
import com.sayak.Service.ShopService;
import com.sayak.WebOrder;
import com.sayak.WebOrderHistory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url")
public class ShoppingAppController {
    ProductService productService;
    CouponService couponService;
    ShopService shopService;

    public ShoppingAppController(ProductService productService,CouponService couponService,ShopService shopService) {
        this.productService = productService;
        this.couponService=couponService;
        this.shopService=shopService;
    }
    @GetMapping("/inventory")
    Product showInventory(){

        return productService.getInventory();
    }
    @GetMapping("/fetchCoupons")
    List<Coupon> allOffers(){
        return couponService.findAll();
    }

    @GetMapping("/coupon")
    Coupon get(@RequestParam String coupon){
        return couponService.findCoupon(coupon);
    }
    @PostMapping("/{userId}/order")
    public ResponseEntity<Order>placeOrder(@PathVariable int userId, @RequestParam int qty, @RequestParam String coupon){


        Order order=shopService.placeOrder(userId,qty,coupon);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/{userId}/{orderId}/pay")
    public ResponseEntity<Object> payment(@PathVariable int userId, @PathVariable int orderId, @RequestParam int amount){

        return shopService.payment(userId,orderId,amount);

    }
    @GetMapping("/{userId}/orders")
    ResponseEntity<List<WebOrder>>orders(@PathVariable int userId){
        return shopService.findOrders(userId);
    }
    @GetMapping("/{userId}/orders/{orderId}")
    ResponseEntity<Object>OrdersById(@PathVariable int userId,@PathVariable int orderId){
        return shopService.findOrderByTransactionId(userId,orderId);
    }


}
