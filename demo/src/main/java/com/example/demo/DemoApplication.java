package com.example.demo;

import com.example.demo.dto.CartDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
@Transactional
public class DemoApplication implements CommandLineRunner {
    @Autowired
    ApplicationContext context;
    @Autowired
    CartService cartService;
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @Autowired
    ItemService itemService;
    @Autowired
    AddressService addressService;

    @Transactional
    public static void main(String[] args) {
       SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    // @Transactional
    public void run(String... args) throws Exception {
       // addCart1();
       // addCart2();
        //addCart3();
        // updateCart();
        // deleteCart();
        // fetchCart();
             add2Customer();
        //   customerService.findCustomerByFirstName("Richa");  // testing @query
//        fetchCustomer();
//        updateCustomer();
         deleteCustomer();
        //   add2Orders();
        //  orderService.getOrdersOfCustomer(3L);
        //itemService.findByItemPricePerUnitLessThan(100);
        //addressService.findByCountryStartingWith("Ca");

//        fetchOrder();
//        deleteOrder();
    }

    public void add2Orders() {

        Orders order1 = Orders.builder().order_id(1L)
                .customer(customerService.getById(1L).get())
                .order_creation__date(LocalDateTime.now())
                .cart(CartDTO.getEntity(cartService.getById(1).get())).build();

        Orders order2 = Orders.builder().order_id(2L)
                .customer(customerService.getById(1L).get())
                .order_creation__date(LocalDateTime.now())
                .cart(CartDTO.getEntity(cartService.getById(2).get())).build();

        Orders order3 = Orders.builder().order_id(3L)
                .customer(customerService.getById(3L).get())
                .order_creation__date(LocalDateTime.now())
                .cart(CartDTO.getEntity(cartService.getById(3).get())).build();

        orderService.save(order1);
        orderService.save(order2);
        orderService.save(order3);


    }

    public void fetchOrder() {
        orderService.getById(1l);
    }

    public void deleteOrder() {
        orderService.deleteById(1l);
        System.out.println("order deleted successfully");
    }


    public void updateCart() {
        ArrayList<ItemDTO> list = new ArrayList<>();
        ItemDTO item3 = ItemDTO.builder().item_name("Levis Jeans 32 ").item_price_per_unit(100).itemBarCode("FHKS287489Y").item_count(1).build();

        list.add(item3);

        Optional<CartDTO> addingMoreItems = cartService.updateAddMoreItem(1, list);
        System.out.println("cart updated successfully: " + addingMoreItems);


    }

    public void fetchCart() {
        Optional<CartDTO> byId2 = cartService.getById(1l);
        System.out.println(byId2.get());
    }

    public void deleteCart() {
        cartService.deleteById(1l);

        System.out.println("Cart deleted successfully");
    }

    public void addCart1() {
        ItemDTO item1 = ItemDTO.builder().item_id(1L).item_name("Nike shoes").item_price_per_unit(200).itemBarCode("DL46987489Y").item_count(1).build();
        ItemDTO item2 = ItemDTO.builder().item_id(2L).item_name("Floral red top ").item_price_per_unit(40).itemBarCode("123287489Y").item_count(1).build();
        ArrayList<ItemDTO> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCart_id(1L);
        cartDTO.setCart_last_updated_on(LocalDateTime.now());
        cartDTO.setItems(items);
        CartDTO savedCartDto = cartService.save(
                cartDTO);
        System.out.println("Cart saved successfully :" + savedCartDto);
    }

    public void addCart2() {
        ItemDTO item1 = ItemDTO.builder().item_id(3L).item_name("Kitchen mat").item_price_per_unit(20).itemBarCode("7877777").item_count(1).build();
        ArrayList<ItemDTO> items = new ArrayList<>();
        items.add(item1);
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCart_id(2L);
        cartDTO.setCart_last_updated_on(LocalDateTime.now());
        cartDTO.setItems(items);
        CartDTO savedCartDto = cartService.save(
                cartDTO);
        System.out.println("Cart saved successfully :" + savedCartDto);
    }

    public void addCart3() {
        ItemDTO item1 = ItemDTO.builder().item_id(4L).item_name("Honey").item_price_per_unit(25).itemBarCode("111111221").item_count(1).build();
        ArrayList<ItemDTO> items = new ArrayList<>();
        items.add(item1);
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCart_id(3L);
        cartDTO.setCart_last_updated_on(LocalDateTime.now());
        cartDTO.setItems(items);
        CartDTO savedCartDto = cartService.save(
                cartDTO);
        System.out.println("Cart saved successfully :" + savedCartDto);
    }

    public void add2Customer() {

        CustAdr custAdr1 = CustAdr.builder().address_id(1L).city("Brampton").country("Canada").hous_no(12).street(2).pincode("RY34NJK").build();
        Customer customer1 = Customer.builder().customerId(1L)
                .custAdr(custAdr1)
                .email("abc@gmail.com")
                .firstName("Richa")
                .lastName("Luthra")
                .password("12345634").phone("+16576156757").user_name("richa002").build();

        CustAdr custAdr2 = CustAdr.builder().address_id(2L).city("Brampton").country("Canada").hous_no(100).street(12).pincode("LLJKKA56").build();
        Customer customer2 = Customer.builder().customerId(2L)
                .custAdr(custAdr2)
                .email("XYZ@gmail.com")
                .firstName("Richa")
                .lastName("Tanwar")
                .password("789896").phone("+789269789479").user_name("richaKT").build();

        CustAdr custAdr3 = CustAdr.builder().address_id(3L).city("Delhi").country("India").hous_no(122).street(10).pincode("110032").build();
        Customer customer3 = Customer.builder().customerId(3L)
                .custAdr(custAdr3)
                .email("hkj@gmail.com")
                .firstName("Neha")
                .lastName("km")
                .password("23121").phone("6874897497").user_name("neha002").build();


        customerService.save(customer1);
        customerService.save(customer2);
        customerService.save(customer3);

    }

    public void updateCustomer() {
        CustAdr custAdr = CustAdr.builder().city("Brampton").country("Canada").hous_no(12).street(2).pincode("RY34NJK").build();

        Customer customer = Customer.builder().customerId(1l)
                .custAdr(custAdr)
                .email("abcd@gmail.com")
                .firstName("Richa")
                .lastName("Luthra")
                .password("123456345").phone("+19876156757").user_name("richa002").build();

        customerService.updateProfile(1, customer);

    }

    public void fetchCustomer() {
        customerService.getById(1l);
    }

    public void deleteCustomer() {
        customerService.deleteById(1l);
        System.out.println("Customer deleted successfully");
    }
}
