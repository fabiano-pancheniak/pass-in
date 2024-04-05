package com.example.pass.in.services;

import com.example.pass.in.domain.attendee.Attendee;
import com.example.pass.in.domain.checkin.CheckIn;
import com.example.pass.in.domain.checkin.exceptions.CheckInAlreadyExistsException;
import com.example.pass.in.repositories.CheckInRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {
    private final CheckInRepository checkInRepository;

    public void registerCheckIn(Attendee attendee){
        this.verifyCheckInExists(attendee.getId());

        CheckIn newCheckin = new CheckIn();
        newCheckin.setAttendee(attendee);
        newCheckin.setCreatedAt(LocalDateTime.now());
        this.checkInRepository.save(newCheckin);
    }
    
    private void verifyCheckInExists(String attendeeId){
        Optional<CheckIn> isCheckedIn = this.getCheckIn(attendeeId);
        if(isCheckedIn.isPresent()) throw new CheckInAlreadyExistsException("Já fez check in");
    }

    public Optional<CheckIn> getCheckIn(String attendeeId){
        return this.checkInRepository.findByAttendeeId(attendeeId);
    }
}
