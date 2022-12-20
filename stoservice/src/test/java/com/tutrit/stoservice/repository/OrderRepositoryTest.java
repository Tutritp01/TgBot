package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.bean.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderRepositoryTest {
    OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();

        IntStream.range(0, 3)
                .boxed()
                .map(index -> makeOrder(index))
                .forEach(order -> orderRepository.save(order));
    }

    private Order makeOrder(Integer index) {
        Order order = new Order();
        Engineer engineer = new Engineer(index.toString(), "firstName" + index, "lastName" + index, "function" + index, "category" + index, "edycation" + index, 10 + Integer.valueOf(index), Integer.valueOf(index));
        Car car = new Car(index.toString(), "owner1" + index, "vin1" + index, "plateNumber1" + index, "brand1" + index, "model1" + index, "1g" + index, "mod1" + index, "engine1" + index, 2000 + Integer.valueOf(index));
        Customer customer = new Customer(index.toString(), "customer1" + index, "city1" + index, "phoneNumber1" + index, "email1" + index);
        order.setId(index.toString());
        order.setOrderStatus("new");
        order.setCar(car);
        order.setCustomer(customer);
        order.setEngineers(List.of(engineer));
        return order;
    }

    @Test
    void save() {
        var order4 = makeOrder(4);
        orderRepository.save(order4);
        int expected = orderRepository.count();
        assertEquals(expected, orderRepository.orders.size());
        var order5 = makeOrder(5);
        orderRepository.save(order5);
        assertEquals(5, orderRepository.orders.size());
    }

    @Test
    void saveAll() {
        var order6 = makeOrder(6);
        var order7 = makeOrder(7);
        var order8 = makeOrder(8);
        var order9 = makeOrder(9);
        List<Order> ordersList = new ArrayList<>();
        ordersList.add(order6);
        ordersList.add(order7);
        ordersList.add(order8);
        ordersList.add(order9);
        orderRepository.saveAll(ordersList);
        assertEquals(7, orderRepository.orders.size());
    }

    @Test
    void find() {
        var order10 = makeOrder(10);
        orderRepository.save(order10);
        var expected = order10;
        Order actual = orderRepository.find(order10);
        assertEquals(expected, actual);
    }

//    @Test
//    void findAll() {
//        Map<String, Order> orderMap = Map.of(
//                "1", new Order("1", "Vasil", "lada", "to do"),
//                "2", new Order("2", "Dima", "volga", "in progress"),
//                "3", new Order("3", "Petya", "patriot", "closed")
//        );
//
//        final Map<String, Order> actualResult = StreamSupport
//                .stream(orderRepository.findAll().spliterator(), false)
//                .collect(Collectors.toMap(Order::getId, el -> el));
//
//        assertEquals(orderMap, actualResult);
//    }
//
//    @Test
//    void findById() {
//        Order actual1 = orderRepository.findById(order1.getId());
//        Order actual2 = orderRepository.findById(order2.getId());
//        Order actual3 = orderRepository.findById("3");
//        assertEquals(order1, actual1);
//        assertEquals(order2, actual2);
//        assertEquals(order3, actual3);
//    }
//

//    @Test
//    void deleteById() {
//        Order order4 = new Order("", "sas", "sss", "OrderStatus.CLOSED");
//        Assertions.assertFalse(orderRepository.deleteById("4"));
//        Assertions.assertTrue(orderRepository.deleteById("2"));
//        orderRepository.save(order4);
//        Assertions.assertTrue(orderRepository.deleteById("4"));
//    }
//
//    @Test
//    void update() {
//        var order4 = new Order("2", "sas", "sss", "OrderStatus.CLOSED");
//        var order5 = new Order("2", "sas", "sss", "OrderStatus.CLOSED");
//        orderRepository.update(order4);
//        var actual = orderRepository.findById("2");
//        assertEquals(order5, actual);
//    }

    @Test
    void count() {
        assertEquals(3, orderRepository.counted);
        orderRepository.count();
        assertEquals(4, orderRepository.counted);
    }
}
