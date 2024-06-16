package com.hospital.hms.service;
import java.util.List;


import org.springframework.stereotype.Service;

import com.hospital.hms.model.Appointment;

@Service
public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(int id);
    Appointment createAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(int id);
}
