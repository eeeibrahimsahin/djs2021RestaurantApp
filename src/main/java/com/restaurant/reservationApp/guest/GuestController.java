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
    private Guest willUpdateGuest;
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

    @PostMapping("/newguest")
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        System.out.println(guest.getFirstName());
        Guest guest1 = guestService.createGuest(guest);
        return new ResponseEntity<>(guest1, HttpStatus.OK);
    }

    @PutMapping( "/guest")
    public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest){
        Guest guest1 = guestService.updateGuest(guest);
        return new ResponseEntity<>(guest1, HttpStatus.OK);
    }

    @PutMapping(value = "/willupdateguest")
    public void willUpdateGuest(@RequestBody Guest guest) {
        willUpdateGuest =guest;
    }

    @GetMapping("/updateguest")
    public ResponseEntity<Guest> getWillUpdateGuest() {
        return new ResponseEntity<>(willUpdateGuest, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteGuest(@PathVariable(name = "id") long id) {
        guestService.deleteGuest(id);
    }
}



