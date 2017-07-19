package ru.belitavitex.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.belitavitex.dao.CustomerOrderDao;
import ru.belitavitex.dao.OrderItemDao;
import ru.belitavitex.dao.PersonDao;
import ru.belitavitex.dao.ProductDao;
import ru.belitavitex.entity.CustomerOrder;
import ru.belitavitex.entity.OrderItem;
import ru.belitavitex.entity.OrderStatus;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dzianis on 10.07.2017.
 */
@Repository
public class CustomerOrdersTestDataImporter {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private PersonTestDataImporter personTestDataImporter;

    @Autowired
    private ProductTestDataImporter productTestDataImporter;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderItemDao orderItemDao;

    public void importTestData() {

        personTestDataImporter.importTestData();
        productTestDataImporter.importTestData();
        createCustomerOrder(1);
        createCustomerOrder(2);
        createCustomerOrder(3);
    }



    private void createCustomerOrder(int number){
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setPerson(personDao.findAll().get(0));
        customerOrder.setDateClosing(LocalDate.of(2011, 03, 03));
        customerOrder.setDateCreated(LocalDate.of(2011, 03, 01));
        customerOrder.setOrderStatus(OrderStatus.CLOSED);
        customerOrderDao.save(customerOrder);
        for (int i = 0; i < number; i++) {
            createSetOrderItem(customerOrder, i, i*2);
        }
    }

    private void createSetOrderItem(CustomerOrder customerOrder, int number, int quantity){
        Set<OrderItem> setOrderItem = customerOrder.getOrderItems();
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(productDao.findAll().get(number));
        orderItem.setQuantity(quantity);
        orderItem.setCustomerOrder(customerOrder);
        setOrderItem.add(orderItem);
        orderItemDao.save(orderItem);
    }
}
