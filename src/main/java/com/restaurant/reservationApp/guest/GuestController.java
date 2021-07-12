package com.restaurant.reservationApp.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class GuestController {
    GuestService guestService;

    public GuestController() {
    }

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/guests")
    public ResponseEntity<List<Guest>> getAllGuests() {

        List<Guest> allGuests = guestService.getAllGuests();
        return new ResponseEntity<>(allGuests, HttpStatus.OK);
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable(name = "id", required = true) long id) {
        Guest guest = guestService.getGuestById(id);
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @RequestMapping(value = "/guest", method = RequestMethod.POST)
    public ResponseEntity<Guest> createGuest(Guest guest) {
        System.out.println(guest);
        Guest guest1 = guestService.createGuest(guest);
        return new ResponseEntity<>(guest1, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Guest> updatePlane(@RequestParam(name = "id") long id,
                                             @RequestParam(name = "firstName") String firstName,
                                             @RequestParam(name = "lastName") String lastName) {
        Guest guest = guestService.updateGuest(id, firstName, lastName);
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public void deleteGuest(@RequestParam(name = "id") long id) {
        guestService.deleteGuest(id);
    }
}

