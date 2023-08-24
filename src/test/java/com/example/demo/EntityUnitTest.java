package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.example.demo.entities.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestInstance(Lifecycle.PER_CLASS)
class EntityUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    private Doctor d1;
    private Patient p1;
    private Room r1;
    private Appointment a1;
    private Appointment a2;
    private Appointment a3;

    @BeforeAll
    void setup() {
        // Initialize entities here
        d1 = new Doctor(/* Set doctor properties */);
        p1 = new Patient(/* Set patient properties */);
        r1 = new Room(/* Set room properties */);
        a1 = new Appointment(/* Set appointment properties */);
        a2 = new Appointment(/* Set appointment properties */);
        a3 = new Appointment(/* Set appointment properties */);
    }

    @Test
    void testDoctorEntity() {
        Doctor savedDoctor = entityManager.persistAndFlush(d1);
        Doctor retrievedDoctor = entityManager.find(Doctor.class, savedDoctor.getId());

        assertThat(retrievedDoctor).isEqualTo(savedDoctor);
    }

    @Test
    void testPatientEntity() {
        Patient savedPatient = entityManager.persistAndFlush(p1);
        Patient retrievedPatient = entityManager.find(Patient.class, savedPatient.getId());

        assertThat(retrievedPatient).isEqualTo(savedPatient);
    }

    @Test
    void testRoomEntity() {
        Room savedRoom = entityManager.persistAndFlush(r1);
        Room retrievedRoom = entityManager.find(Room.class, savedRoom.getId());

        assertThat(retrievedRoom).isEqualTo(savedRoom);
    }

    @Test
    void testAppointmentEntity() {
        Appointment savedAppointment = entityManager.persistAndFlush(a1);
        Appointment retrievedAppointment = entityManager.find(Appointment.class, savedAppointment.getId());

        assertThat(retrievedAppointment).isEqualTo(savedAppointment);
    }

}
