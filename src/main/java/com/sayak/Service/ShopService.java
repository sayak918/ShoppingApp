package com.sayak.Service;

import com.sayak.Entity.*;
import com.sayak.ErrorHandling.InvalidCouponException;
import com.sayak.ErrorHandling.InvalidQuantityException;
import com.sayak.ErrorHandling.OrderNotFoundException;
import com.sayak.ErrorHandling.PaymentResponse;
import com.sayak.WebOrder;
import com.sayak.WebOrderHistory;
import com.sayak.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service

public class ShopService {
   private UserDao userDao;
    private ProductDao productDao;
    private CouponDao couponDao;
    private OrderDao orderDao;
    private PaymentStatusDao paymentStatusDao;

    @Autowired
    public ShopService(ProductDao productDao, CouponDao couponDao, OrderDao orderDao,UserDao userDao,PaymentStatusDao paymentStatusDao) {
        this.productDao = productDao;
        this.couponDao = couponDao;
        this.orderDao = orderDao;
        this.userDao=userDao;
        this.paymentStatusDao=paymentStatusDao;
    }

    public Order placeOrder(int userId, int qty, String coupon) {
        User u=userDao.findById(userId).get();
        Coupon temp=couponDao.findById(coupon).get();
        Product  product=productDao.findById(1).get();

        int amt=product.getPrice();

        String coup=u.getCouponId();
        int discount=temp.getOffer();
        int c=u.getNoOfCoupon();
        if (qty< 1 || qty > product.getAvailable()) {
            throw new InvalidQuantityException("Invalid quantity");
        }
        if(c>0 && coup.equals(coupon)){

            c--;
            amt=amt-((amt*discount)/100);
            u.setNoOfCoupon(c);
            userDao.save(u);

            System.out.println(amt);
        }else{
            throw new InvalidCouponException("Invalid Coupon ");
        }




        Order order=new Order();

        //order.setOrderId(101);
        order.setUserId(userId);
        order.setAmount(amt);
        order.setQuantity(qty);
        order.setCouponId(coupon);

         return orderDao.save(order);
    }
    public ResponseEntity<Object>payment(int userId,int orderId,int amt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        Order order1=orderDao.findByOrderId(orderId);
        int UserId_order=order1.getUserId();
        int amt1=order1.getAmount();
        String coupon=order1.getCouponId();
        String transactionId = generateRandomTransactionId();
        if(UserId_order ==userId && amt1==amt){

            PaymentStatus p=new PaymentStatus();
            p.setUserId(userId);
            p.setOrderId(orderId);
            p.setAmt(amt);
            p.setCoupon(coupon);
            p.setDate(LocalDate.now().format(formatter));
            p.setTransactionId(transactionId);
            p.setStatus("successful");
            paymentStatusDao.save(p);

            return ResponseEntity.status(HttpStatus.OK).body(new PaymentResponse(userId, orderId, transactionId, "successful"));
        } else if (amt!=amt1) {

            PaymentStatus p=new PaymentStatus();
            p.setUserId(userId);
            p.setOrderId(orderId);
            p.setAmt(amt);
            p.setCoupon(coupon);
            p.setDate(LocalDate.now().format(formatter));
            p.setTransactionId(transactionId);
            p.setStatus("failed");
            paymentStatusDao.save(p);
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PaymentResponse(userId, orderId, transactionId, "failed", "Payment Failed as amount is invalid"));
        }else{
            Random random = new Random();
            int statusCode = random.nextInt(6) + 1;
            PaymentStatus p=new PaymentStatus();
            switch (statusCode) {
                case 1:

                    p.setUserId(userId);
                    p.setOrderId(orderId);
                    p.setAmt(amt);
                    p.setCoupon(coupon);
                    p.setDate(LocalDate.now().format(formatter));
                    p.setTransactionId(transactionId);
                    p.setStatus("failed");
                    paymentStatusDao.save(p);
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PaymentResponse(userId, orderId, "tran010100003", "failed", "Payment Failed from bank"));
                case 2:

                    p.setUserId(userId);
                    p.setOrderId(orderId);
                    p.setAmt(amt);
                    p.setCoupon(coupon);
                    p.setDate(LocalDate.now().format(formatter));
                    p.setTransactionId(transactionId);
                    p.setStatus("failed");
                    paymentStatusDao.save(p);
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PaymentResponse(userId, orderId, "tran010100004", "failed", "Payment Failed due to invalid order id"));
                case 3:
                    p.setUserId(userId);
                    p.setOrderId(orderId);
                    p.setAmt(amt);
                    p.setCoupon(coupon);
                    p.setDate(LocalDate.now().format(formatter));
                    p.setTransactionId(transactionId);
                    p.setStatus("failed");
                    paymentStatusDao.save(p);
                    return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new PaymentResponse(userId, orderId, "tran010100005", "failed", "No response from payment server"));
                case 4:
                    p.setUserId(userId);
                    p.setOrderId(orderId);
                    p.setAmt(amt);
                    p.setCoupon(coupon);
                    p.setDate(LocalDate.now().format(formatter));
                    p.setTransactionId(transactionId);
                    p.setStatus("failed");
                    paymentStatusDao.save(p);
                    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new PaymentResponse(userId, orderId, "tran010100006", "failed", "Order is already paid for"));
                default:
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

    }
   public String generateRandomTransactionId() {
        // Logic to generate a random transaction ID (for demonstration, you can adjust this according to your requirements)
        Random random = new Random();
        int randomNumber = random.nextInt(1000000);
        return "tran" + Integer.toString(randomNumber);
    }


    public ResponseEntity<List<WebOrder>> findOrders(int userId) {

        List<WebOrder>result=new ArrayList<>();
        List<Order>p=orderDao.findAllByUserId(userId);
        for(int i=0;i<p.size();i++){
            Order o=p.get(i);
            WebOrder w=new WebOrder(o.getOrderId(),o.getAmount(),o.getCouponId());
            result.add(w);
        }
        return ResponseEntity.ok(result);

    }

    public ResponseEntity<Object> findOrderByTransactionId(int userId, int orderId) {
        boolean flag=false;
        List<WebOrderHistory>result=new ArrayList<>();
        List<PaymentStatus>a=paymentStatusDao.findAllByUserId(userId);
        for(int i=0;i<a.size();i++){
            PaymentStatus p=a.get(i);
            if(p.getOrderId()==orderId){
                flag=true;
                WebOrderHistory w=new WebOrderHistory(orderId,p.getAmt(),p.getDate(),p.getCoupon(),p.getTransactionId(),p.getStatus());
                result.add(w);
            }
        }
        if(flag==false){

          return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(new OrderNotFoundException(orderId, "Order not found"));
        }
        return ResponseEntity.ok(result);
    }
}
