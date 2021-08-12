//package com.restaurant.reservationApp.guest;
//
//import com.restaurant.reservationApp.employee.Employee;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class GuestRepositoryImpl implements GuestRepository {
//    List<Guest> list = new ArrayList<>(Arrays.asList(
//            new Guest(1, "Mila", "Bom", 061234567, 234),
//            new Guest(2, "Alex", "De Souza", 061234567, 345),
//            new Guest(3, "Yolant", "Verbulen", 061234567, 456),
//            new Guest(4, "Johan", "Cruyff", 061234567, 567),
//            new Guest(5, "Pogba", "Henry", 061234567, 678),
//            new Guest(6, "Sedat", "Peker", 061234567, 789)
//    ));
//
//    public GuestRepositoryImpl() {
//    }
//
//    @Override
//    public List<Guest> getAllGuests() {
//        return list;
//    }
//
//    @Override
//    public Guest getGuestById(long id) {
//        Optional<Guest> guest1 = list.stream().filter(guest -> guest.getId() == id).findFirst();
//        return guest1.get();
//    }
//
//    @Override
//    public Guest createGuest(Guest guest) {
//        guest.setId(list.size() + 1);
//        list.add(guest);
//        return guest;
//    }
////    public Employee updateEmployee(Employee employee) {
////        final Optional<Employee> willUpdateEmployee = list.stream().filter(employee1 -> employee1.getId() == employee.getId()).findFirst();
////        if (willUpdateEmployee.isPresent()) {
////            willUpdateEmployee.get().setFirstName(employee.getFirstName());
////            willUpdateEmployee.get().setLastName(employee.getLastName());
////            willUpdateEmployee.get().setUsername(employee.getUsername());
////            willUpdateEmployee.get().setPassword(employee.getPassword());
////            return willUpdateEmployee.get();
////        }
////
////        return null;
////    }
//
//    @Override
//    public Guest updateGuest(Guest guest) {
//
//        final Optional<Guest> willUpdateGuest = list.stream().filter(guest1 -> guest1.getId() == guest.getId()).findFirst();
//        if (willUpdateGuest.isPresent()){
//            willUpdateGuest.get().setFirstName(guest.getFirstName());
//            willUpdateGuest.get().setLastName(guest.getLastName());
//            willUpdateGuest.get().setPhoneNumber(guest.getPhoneNumber());
//            willUpdateGuest.get().setRoomNumber(guest.getRoomNumber());
//            return willUpdateGuest.get();
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteGuest(long id) {
//        for(Guest guest:list){
//            if (guest.getId()==id){
//                list.remove(guest);
//                break;
//            }
//
//        }
//
//    }
//}
