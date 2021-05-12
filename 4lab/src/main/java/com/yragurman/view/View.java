package com.yragurman.view;

import com.yragurman.controller.*;
import com.yragurman.model.entity.address;
import com.yragurman.model.entity.coupon;
import com.yragurman.model.entity.customer;
import com.yragurman.model.entity.parking;
import com.yragurman.model.entity.parkingPrice;
import com.yragurman.model.entity.parkingSlot;
import com.yragurman.model.entity.parkingSlotReservation;
import com.yragurman.model.entity.regularCustomer;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final addressController addressController = new addressController();
    private final couponController couponController = new couponController();
    private final customerController customerController = new customerController();
    private final parkingController parkingController = new parkingController();
    private final parkingPriceController parkingPriceController = new parkingPriceController();
    private final parkingSlotController parkingSlotController = new parkingSlotController();
    private final parkingSlotReservationController parkingSlotReservationController = new parkingSlotReservationController();
    private final regularCustomerController regularCustomerController = new regularCustomerController();



    private final Map<String, Printable> menu;
    private static final Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    public final void show() throws SQLException {
        String keyMenu = "";
        while (!keyMenu.equals("Q")) {
            displayMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                menu.get(keyMenu).print();
            } catch (Exception ignored) {

            }
        }
    }

    private void displayMenu() {
        System.out.println(" ---------------------------------------------------- ");
        System.out.println("|                               |                    |");
        System.out.println("|             TABLES            |       METHODS      |");
        System.out.println("|                               |                    |");
        System.out.println(" ---------------------------------------------------- ");
        System.out.println("|  1 - address                  |  1 - get all       |");
        System.out.println("|  2 - coupon                   |  2 - get by id     |");
        System.out.println("|  3 - customer                 |  3 - create        |");
        System.out.println("|  4 - parking                  |  4 - update        |");
        System.out.println("|  5 - parking_price            |  5 - delete        |");
        System.out.println("|  6 - parking_slot             |                    |");
        System.out.println("|  7 - parking_slot_reservation |                    |");
        System.out.println("|  8 - regular_customer         |                    |");
        System.out.println(" ---------------------------------------------------- ");
        System.out.println("|                          Q - exit                  |");
        System.out.println(" ---------------------------------------------------- ");
    }

    public View() {
        menu = new LinkedHashMap<>();

        // address
        menu.put("11", this::findAllAddresses);
        menu.put("12", this::findAddress);
        menu.put("13", this::createAddress);
        menu.put("14", this::updateAddress);
        menu.put("15", this::deleteAddress);

        //coupon

        menu.put("21", this::findAllCoupons);
        menu.put("22", this::findCoupon);
        menu.put("23", this::createCoupon);
        menu.put("24", this::updateCoupon);
        menu.put("25", this::deleteCoupon);

        //customer

        menu.put("31", this::findAllCustomers);
        menu.put("32", this::findCustomer);
        menu.put("33", this::createCustomer);
        menu.put("34", this::updateCustomer);
        menu.put("35", this::deleteCustomer);

        //parking

        menu.put("41", this::findAllParkings);
        menu.put("42", this::findParking);
        menu.put("43", this::createParking);
        menu.put("44", this::updateParking);
        menu.put("45", this::deleteParking);

        //parking price

        menu.put("51", this::findAllParkingPrices);
        menu.put("52", this::findParkingPrice);
        menu.put("53", this::createParkingPrice);
        menu.put("54", this::updateParkingPrice);
        menu.put("55", this::deleteParkingPrice);

        //parking slot

        menu.put("61", this::findAllParkingSlots);
        menu.put("62", this::findParkingSlot);
        menu.put("63", this::createParkingSlot);
        menu.put("64", this::updateParkingSlot);
        menu.put("65", this::deleteParkingSlot);

        //parking slot reservation

        menu.put("71", this::findAllParkingSlotReservations);
        menu.put("72", this::findParkingSlotReservation);
        menu.put("73", this::createParkingSlotReservation);
        menu.put("74", this::updateParkingSlotReservation);
        menu.put("75", this::deleteParkingSlotReservation);

        //regular customer

        menu.put("81", this::findAllRegularCustomers);
        menu.put("82", this::findRegularCustomer);
        menu.put("83", this::createRegularCustomer);
        menu.put("84", this::updateRegularCustomer);
        menu.put("85", this::deleteRegularCustomer);

    }
    /*  ----- address -----  */

    private address getAddressDataByInputs() {
        System.out.println("Enter address id: ");
        Integer id = input.nextInt();
        System.out.println("Enter country: ");
        String country = input.next();
        System.out.println("Enter city: ");
        String city = input.next();
        System.out.println("Enter address name: ");
        String addressName = input.next();
        System.out.println("Enter post index: ");
        Integer postIndex = input.nextInt();
        return new address(id, country, city, addressName, postIndex);
    }

    private void findAllAddresses() throws SQLException {
        System.out.println("\nAddresses:");
        System.out.println(addressController.findAll());
    }

    private void findAddress() throws SQLException {
        System.out.println("\nEnter the ID for a address to find");
        Integer id = input.nextInt();
        System.out.println(addressController.find(id));
    }

    private void createAddress() throws SQLException {
        System.out.println("[Creating a new address] \n");
        address addressData = getAddressDataByInputs();
        addressController.create(addressData);
        System.out.println("A new address was been inserted into the database!");
    }

    private void updateAddress() throws SQLException {
        System.out.println("[Updating a address] \n");
        address newAddressData = getAddressDataByInputs();
        addressController.update(newAddressData.getId(), newAddressData);
        System.out.println("The address with id " + newAddressData.getId() + " was been updated!");
    }

    private void deleteAddress() throws SQLException {
        System.out.println("[Deleting the address] \n");
        Integer id = input.nextInt();
        addressController.delete(id);
        System.out.println("Address with id " + id + " was been deleted!");
    }

    /*  ----- coupon -----  */

    private coupon getCouponDataByInputs() {
        System.out.println("Enter coupon id: ");
        Integer id = input.nextInt();
        System.out.println("Enter customer id: ");
        Integer customerId = input.nextInt();
        System.out.println("Enter entry date: ");
        String entryDate = input.next();
        System.out.println("Enter exit date: ");
        String exitDate = input.next();
        System.out.println("Enter parking slot id: ");
        Integer parkingSlotId = input.nextInt();
        return new coupon(id, customerId, entryDate, exitDate, parkingSlotId);
    }

    private void findAllCoupons() throws SQLException {
        System.out.println("\nCoupons:");
        System.out.println(couponController.findAll());
    }

    private void findCoupon() throws SQLException {
        System.out.println("\nEnter the ID for a coupon to find");
        Integer id = input.nextInt();
        System.out.println(couponController.find(id));
    }

    private void createCoupon() throws SQLException {
        System.out.println("[Creating a new coupon] \n");
        coupon couponData = getCouponDataByInputs();
        couponController.create(couponData);
        System.out.println("A new coupon was been inserted into the database!");
    }

    private void updateCoupon() throws SQLException {
        System.out.println("[Updating a coupon] \n");
        coupon newCouponData = getCouponDataByInputs();
        couponController.update(newCouponData.getId(), newCouponData);
        System.out.println("The coupon with id " + newCouponData.getId() + " was been updated!");
    }

    private void deleteCoupon() throws SQLException {
        System.out.println("[Deleting the coupon] \n");
        Integer id = input.nextInt();
        couponController.delete(id);
        System.out.println("Coupon with id " + id + " was been deleted!");
    }

    /*  ----- customer -----  */

    private customer getCustomerDataByInputs() {
        System.out.println("Enter customer id: ");
        Integer id = input.nextInt();
        System.out.println("Enter vehicle number: ");
        String vehicleNumber = input.next();
        System.out.println("Enter is regular customer?: ");
        String isRegularCustomer = input.next();
        System.out.println("Enter contact number: ");
        String contactNumber = input.next();
        return new customer(id, vehicleNumber, isRegularCustomer, contactNumber);
    }

    private void findAllCustomers() throws SQLException {
        System.out.println("\nCustomers:");
        System.out.println(customerController.findAll());
    }

    private void findCustomer() throws SQLException {
        System.out.println("\nEnter the ID for a customer to find");
        Integer id = input.nextInt();
        System.out.println(customerController.find(id));
    }

    private void createCustomer() throws SQLException {
        System.out.println("[Creating a new customer] \n");
        customer customerData = getCustomerDataByInputs();
        customerController.create(customerData);
        System.out.println("A new customer was been inserted into the database!");
    }

    private void updateCustomer() throws SQLException {
        System.out.println("[Updating a customer] \n");
        customer newCustomerData = getCustomerDataByInputs();
        customerController.update(newCustomerData.getId(), newCustomerData);
        System.out.println("The customer with id " + newCustomerData.getId() + " was been updated!");
    }

    private void deleteCustomer() throws SQLException {
        System.out.println("[Deleting the customer] \n");
        Integer id = input.nextInt();
        customerController.delete(id);
        System.out.println("Customer with id " + id + " was been deleted!");
    }

    /*  ----- parking -----  */

    private parking getParkingDataByInputs() {
        System.out.println("Enter parking id: ");
        Integer id = input.nextInt();
        System.out.println("Enter trade network: ");
        String tradeNetwork = input.next();
        System.out.println("Enter address id: ");
        Integer addressId = input.nextInt();
        System.out.println("Enter customer id: ");
        Integer customerId = input.nextInt();
        System.out.println("Enter parking slot id: ");
        Integer parkingSlotId = input.nextInt();
        return new parking(id, tradeNetwork, addressId, customerId, parkingSlotId);
    }

    private void findAllParkings() throws SQLException {
        System.out.println("\nParkings:");
        System.out.println(parkingController.findAll());
    }

    private void findParking() throws SQLException {
        System.out.println("\nEnter the ID for a parking to find");
        Integer id = input.nextInt();
        System.out.println(parkingController.find(id));
    }

    private void createParking() throws SQLException {
        System.out.println("[Creating a new parking] \n");
        parking parkingData = getParkingDataByInputs();
        parkingController.create(parkingData);
        System.out.println("A new parking was been inserted into the database!");
    }

    private void updateParking() throws SQLException {
        System.out.println("[Updating a parking] \n");
        parking newParkingData = getParkingDataByInputs();
        parkingController.update(newParkingData.getId(), newParkingData);
        System.out.println("The parking with id " + newParkingData.getId() + " was been updated!");
    }

    private void deleteParking() throws SQLException {
        System.out.println("[Deleting the parking] \n");
        Integer id = input.nextInt();
        parkingController.delete(id);
        System.out.println("parking with id " + id + " was been deleted!");
    }

    /*  ----- parking price-----  */

    private parkingPrice getParkingPriceDataByInputs() {
        System.out.println("Enter parking price id: ");
        Integer id = input.nextInt();
        System.out.println("Enter morning price: ");
        BigDecimal morningPrice = input.nextBigDecimal();
        System.out.println("Enter midday price: ");
        BigDecimal middayPrice = input.nextBigDecimal();
        System.out.println("Enter evening price: ");
        BigDecimal eveningPrice = input.nextBigDecimal();
        System.out.println("Enter all day price: ");
        BigDecimal allDayPrice = input.nextBigDecimal();
        return new parkingPrice(id, morningPrice, middayPrice, eveningPrice, allDayPrice);
    }

    private void findAllParkingPrices() throws SQLException {
        System.out.println("\nParking prices:");
        System.out.println(parkingPriceController.findAll());
    }

    private void findParkingPrice() throws SQLException {
        System.out.println("\nEnter the ID for a parking price to find");
        Integer id = input.nextInt();
        System.out.println(parkingPriceController.find(id));
    }

    private void createParkingPrice() throws SQLException {
        System.out.println("[Creating a new parking price] \n");
        parkingPrice parkingPriceData = getParkingPriceDataByInputs();
        parkingPriceController.create(parkingPriceData);
        System.out.println("A new parking price was been inserted into the database!");
    }

    private void updateParkingPrice() throws SQLException {
        System.out.println("[Updating a parking price] \n");
        parkingPrice newParkingPriceData = getParkingPriceDataByInputs();
        parkingPriceController.update(newParkingPriceData.getId(), newParkingPriceData);
        System.out.println("The parking price with id " + newParkingPriceData.getId() + " was been updated!");
    }

    private void deleteParkingPrice() throws SQLException {
        System.out.println("[Deleting the parking price] \n");
        Integer id = input.nextInt();
        parkingPriceController.delete(id);
        System.out.println("parking price with id " + id + " was been deleted!");
    }

    /*  ----- parking slot-----  */

    private parkingSlot getParkingSlotDataByInputs() {
        System.out.println("Enter parking slot id: ");
        Integer id = input.nextInt();
        System.out.println("Enter slot number: ");
        Integer slotNumber = input.nextInt();
        System.out.println("Enter is invalid place: ");
        String isInvalidPlace = input.next();
        System.out.println("Enter parking price id: ");
        Integer parkingPriceId = input.nextInt();
        System.out.println("Enter is reserved?: ");
        String isReserved = input.next();
        System.out.println("Enter time count in minutes: ");
        Integer timeCountInMinutes = input.nextInt();
        return new parkingSlot(id, slotNumber, isInvalidPlace, parkingPriceId, isReserved, timeCountInMinutes);
    }

    private void findAllParkingSlots() throws SQLException {
        System.out.println("\nParking slots:");
        System.out.println(parkingSlotController.findAll());
    }

    private void findParkingSlot() throws SQLException {
        System.out.println("\nEnter the ID for a parking slot to find");
        Integer id = input.nextInt();
        System.out.println(parkingSlotController.find(id));
    }

    private void createParkingSlot() throws SQLException {
        System.out.println("[Creating a new parking slot] \n");
        parkingSlot parkingSlotData = getParkingSlotDataByInputs();
        parkingSlotController.create(parkingSlotData);
        System.out.println("A new parking slot was been inserted into the database!");
    }

    private void updateParkingSlot() throws SQLException {
        System.out.println("[Updating a parking slot] \n");
        parkingSlot newParkingSlotData = getParkingSlotDataByInputs();
        parkingSlotController.update(newParkingSlotData.getId(), newParkingSlotData);
        System.out.println("The parking slot with id " + newParkingSlotData.getId() + " was been updated!");
    }

    private void deleteParkingSlot() throws SQLException {
        System.out.println("[Deleting the parking price] \n");
        Integer id = input.nextInt();
        parkingSlotController.delete(id);
        System.out.println("parking slot with id " + id + " was been deleted!");
    }

    /*  ----- parking slot reservation-----  */

    private parkingSlotReservation getParkingSlotReservationDataByInputs() {
        System.out.println("Enter parking slot reservation id: ");
        Integer id = input.nextInt();
        System.out.println("Enter booking date: ");
        String bookingDate = input.next();
        System.out.println("Enter customer id: ");
        Integer customerId = input.nextInt();
        System.out.println("Enter parking slot id: ");
        Integer parkingSlotId = input.nextInt();
        System.out.println("Enter is paid?: ");
        String isPaid = input.next();
        System.out.println("Enter entry date: ");
        String entryDate = input.next();
        System.out.println("Enter exit date: ");
        String exitDate = input.next();
        return new parkingSlotReservation(id, bookingDate, customerId, parkingSlotId, isPaid, entryDate, exitDate);
    }

    private void findAllParkingSlotReservations() throws SQLException {
        System.out.println("\nParking slot reservations:");
        System.out.println(parkingSlotReservationController.findAll());
    }

    private void findParkingSlotReservation() throws SQLException {
        System.out.println("\nEnter the ID for a parking slot reservation to find");
        Integer id = input.nextInt();
        System.out.println(parkingSlotReservationController.find(id));
    }

    private void createParkingSlotReservation() throws SQLException {
        System.out.println("[Creating a new parking slot reservation] \n");
        parkingSlotReservation parkingSlotReservationData = getParkingSlotReservationDataByInputs();
        parkingSlotReservationController.create(parkingSlotReservationData);
        System.out.println("A new parking slot reservation was been inserted into the database!");
    }

    private void updateParkingSlotReservation() throws SQLException {
        System.out.println("[Updating a parking slot reservation] \n");
        parkingSlotReservation newParkingSlotReservationData = getParkingSlotReservationDataByInputs();
        parkingSlotReservationController.update(newParkingSlotReservationData.getId(), newParkingSlotReservationData);
        System.out.println("The parking slot reservation with id " + newParkingSlotReservationData.getId() + " was been updated!");
    }

    private void deleteParkingSlotReservation() throws SQLException {
        System.out.println("[Deleting the parking price] \n");
        Integer id = input.nextInt();
        parkingSlotReservationController.delete(id);
        System.out.println("parking slot reservation with id " + id + " was been deleted!");
    }

    /*  ----- regular customer-----  */

    private regularCustomer getRegularCustomerDataByInputs() {
        System.out.println("Enter regular customer id: ");
        Integer id = input.nextInt();
        System.out.println("Enter customer id: ");
        Integer customerId = input.nextInt();
        System.out.println("Enter purchase date: ");
        String purchaseDate = input.next();
        System.out.println("Enter start date: ");
        String startDate = input.next();
        System.out.println("Enter duration in day: ");
        Integer durationInDay = input.nextInt();
        System.out.println("Enter cost: ");
        Integer cost = input.nextInt();
        return new regularCustomer(id, customerId, purchaseDate, startDate, durationInDay, cost);
    }

    private void findAllRegularCustomers() throws SQLException {
        System.out.println("\nRegular customers:");
        System.out.println(regularCustomerController.findAll());
    }

    private void findRegularCustomer() throws SQLException {
        System.out.println("\nEnter the ID for a regular customer to find");
        Integer id = input.nextInt();
        System.out.println(regularCustomerController.find(id));
    }

    private void createRegularCustomer() throws SQLException {
        System.out.println("[Creating a new regular customer] \n");
        regularCustomer regularCustomerData = getRegularCustomerDataByInputs();
        regularCustomerController.create(regularCustomerData);
        System.out.println("A new regular customer was been inserted into the database!");
    }

    private void updateRegularCustomer() throws SQLException {
        System.out.println("[Updating a regular customer] \n");
        regularCustomer newRegularCustomerData = getRegularCustomerDataByInputs();
        regularCustomerController.update(newRegularCustomerData.getId(), newRegularCustomerData);
        System.out.println("The regular customer with id " + newRegularCustomerData.getId() + " was been updated!");
    }

    private void deleteRegularCustomer() throws SQLException {
        System.out.println("[Deleting the regular customer] \n");
        Integer id = input.nextInt();
        customerController.delete(id);
        System.out.println("Regular customer with id " + id + " was been deleted!");
    }
}
