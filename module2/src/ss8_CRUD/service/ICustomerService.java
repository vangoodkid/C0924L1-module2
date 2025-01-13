package ss8_CRUD.service;

import ss8_CRUD.modern.Customer;

public interface ICustomerService {
    Customer[] findAll();
    void addCustomer();
    void deleteCustomer();
    void updateCustomer();
}
