package ru.belitavitex.entity;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

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
        return createAddress();
    }

    private Address createAddress() {
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

    @Test
    public void testGetAddress(){
        Address address = createAddress();
        assertNotNull(address.getApartment());
        assertNotNull(address.getHouse());
        assertNotNull(address.getBuilding());
        assertNotNull(address.getStreet());
        assertNotNull(address.getCountry());
        assertNotNull(address.getCity());
        assertNotNull(address.getPerson());
        assertNotNull(address.getZip());
    }
}
