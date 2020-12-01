package com.cg.onlineeyeclinc.dao;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.exeception.AppointmentIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.InvalidAppointmentException;

import junit.framework.TestCase;

public class AppointmentRepositoryImplTest extends TestCase{
    IAppointmentRepository repository;
	@BeforeEach
	protected void setUp() throws Exception {
		repository = new AppointmentRepositoryImpl();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		repository = null;
	}

	@Test
	public void testAppointmentRepositoryImpl() {
		AppointmentRepositoryImpl appointmentRepository = new AppointmentRepositoryImpl();
		assertTrue(appointmentRepository instanceof AppointmentRepositoryImpl);
	}

	@Test
	public void testBookAppointment() {
		Appointment appointment = new Appointment(LocalDate.of(2020, 11, 16), LocalTime.of(05,00), 5000.00);
		repository.beginTransaction();
		appointment = repository.bookAppointment(appointment);
		repository.commitTransaction();
		assertEquals(appointment.getDateOfAppointment(),LocalDate.of(2020, 11, 16));
	}

	@Test
	public void testUpdateAppointment() throws InvalidAppointmentException {
		Appointment appointment = new Appointment(LocalDate.of(2020, 10, 11), LocalTime.of(05,00), 6000.00);
		repository.beginTransaction();
		appointment = repository.bookAppointment(appointment);
		repository.commitTransaction();
		double consultationFee = 3000.00;
		appointment.setConsultationFee(consultationFee);
		repository.beginTransaction();
		appointment = repository.updateAppointment(appointment);
		repository.commitTransaction();
		assertEquals(appointment.getConsultationFee(),3000.00);
	}

	@Test
	public void testCancelAppointment() throws AppointmentIdNotFoundException {
		Appointment appointment = new Appointment(LocalDate.of(2020, 11, 11), LocalTime.of(05,00), 10000.00);
		repository.beginTransaction();
		appointment = repository.bookAppointment(appointment);
		appointment = repository.cancelAppointment(appointment.getAppointmentId());
		repository.commitTransaction();
		assertNull(appointment);
		
	}

	@Test
	public void testViewAppointment() throws AppointmentIdNotFoundException {
	    Appointment appointment = new Appointment(LocalDate.of(2019, 10, 11), LocalTime.of(05,00), 1000.00);
	    appointment = repository.bookAppointment(appointment);
	    Appointment appointment1 =repository.viewAppointment(appointment.getAppointmentId());
	    assertNotNull(appointment1);
	}

	@Test
	public void testViewAllAppointments() {
		List<Appointment> appointmentList = repository.viewAllAppointments();
		assertNotNull(appointmentList);
	}

	@Test
	    public void testViewAppointments() {
		
		/*Appointment appointment = new Appointment(LocalDate.of(2021, 5, 15), LocalTime.of(05,00), 10000.00);
		appointment = repository.bookAppointment(appointment);*/
		List<Appointment> appointmentlist = repository.viewAppointments(LocalDate.of(2019, 10, 11));
		assertNotNull(appointmentlist);
		/*List<Appointment> appointmentlist = repository.viewAppointments(LocalDate.of(2019, 10, 11));
		assertNotNull(appointmentlist);
		LocalDate date1 =LocalDate.of(2021, 5, 15);*/
	}

}
