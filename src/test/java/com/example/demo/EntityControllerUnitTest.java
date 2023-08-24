
package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.DoctorController;
import com.example.demo.controllers.PatientController;
import com.example.demo.controllers.RoomController;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Room;
import com.example.demo.repositories.DoctorRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.repositories.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest({DoctorController.class, PatientController.class, RoomController.class})
class EntityControllerUnitTest {

    @MockBean
    private DoctorRepository doctorRepository;

    @MockBean
    private PatientRepository patientRepository;

    @MockBean
    private RoomRepository roomRepository;

    @Autowired 
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllDoctors() throws Exception {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(/* Set doctor properties */));
        when(doctorRepository.findAll()).thenReturn(doctors);

        mockMvc.perform(get("/doctors"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(doctors.size()));
    }


    @Test
    void testGetAllPatients() throws Exception {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(/* Set patient properties */));
        when(patientRepository.findAll()).thenReturn(patients);

        mockMvc.perform(get("/patients"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(patients.size()));
    }


    @Test
    void testGetAllRooms() throws Exception {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(/* Set room properties */));
        when(roomRepository.findAll()).thenReturn(rooms);

        mockMvc.perform(get("/rooms"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(rooms.size()));
    }

}

