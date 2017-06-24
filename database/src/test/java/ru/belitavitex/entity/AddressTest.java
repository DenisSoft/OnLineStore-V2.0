package ru.belitavitex.entity;

/**
 * Created by Dzianis on 18.06.2017.
 */
public class AddressTest extends BaseTest<Address> {

    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }

    @Override
    protected Address getModel() {
        Address address = new Address();
        address.setApartment(5);
        address.setHouse(4);
        address.setBuilding(1);
        address.setStreet("Main");
        address.setCountry("USA");
        address.setCity("New York");
        address.setPerson(new Person());
        address.setZip("22005");
        return address;
    }
}
