package com.food.order.ports.output;


import com.food.order.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Customer save(Customer customer);
    Optional<Customer> findCustomer(UUID customerId);
}
