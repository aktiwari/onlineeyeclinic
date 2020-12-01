package com.cg.onlineeyeclinc.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineeyeclinc.entity.Appointment;

import junit.framework.TestCase;

public class AppointmentServiceImplTest extends TestCase {
	IAppointmentService service;

	@BeforeEach
	protected void setUp() throws Exception {
		service = new AppointmentServiceImpl();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		service =null;
	}
		               

	@Test
	public void testAppointmentServiceImpl() {
		assertTrue(service instanceof AppointmentServiceImpl);
		
	}

	@Test
	public void testBookAppointment() {
		Appointment appointment = new Appointment(LocalDate.of(2020, 11, 16), LocalTime.of(11, 30, 30) , 5000.00);
		appointment = service.bookAppointment(appointment);
		assertEquals(appointment.getDateOfAppointment(),LocalDate.of(2020, 11, 16));
	}	
	

	@Test
	public void testUpdateAppointment() {
		Appointment appointment = new Appointment(LocalDate.of(2020, 10, 11), LocalTime.of(05,00), 6000.00);
		appointment = service.bookAppointment(appointment);
		double consultationFee = 3000.00;
		appointment.setConsultationFee(consultationFee);
		appointment = service.updateAppointment(appointment);
		assertEquals(appointment.getConsultationFee(),3000.00);
	}

	@Test
	public void testCancelAppointment() {
		Appointment appointment = new Appointment(LocalDate.of(2020, 11, 11), LocalTime.of(05,00), 10000.00);
		appointment = service.bookAppointment(appointment);
		appointment = service.cancelAppointment(appointment.getAppointmentId());
		assertNull(appointment);
	}

	@Test
	public void testViewAppointment() {
		Appointment appointment = new Appointment(LocalDate.of(2019, 10, 11), LocalTime.of(05,00), 1000.00);
	    appointment = service.bookAppointment(appointment);
	    Appointment appointment1 =service.viewAppointment(appointment.getAppointmentId());
	    assertNotNull(appointment1);
	}

	@Test
	public void testViewAllAppointments() {
		List<Appointment> appointmentList = service.viewAllAppointments();
		assertNotNull(appointmentList);
	}
	@Test
	public void testViewAppointments() {
		/*Appointment appointment = new Appointment(LocalDate.of(2021, 5, 15), LocalTime.of(05,00), 10000.00);
		appointment = service.bookAppointment(appointment);*/
		List<Appointment> appointmentlist = service.viewAppointments( LocalDate.of(2021, 5, 15));
		assertNotNull(appointmentlist);
	}

}