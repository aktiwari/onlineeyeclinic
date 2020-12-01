package com.cg.onlineeyeclinc.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.onlineeyeclinc.entity.Appointment;
import com.cg.onlineeyeclinc.exeception.AppointmentIdNotFoundException;
import com.cg.onlineeyeclinc.exeception.InvalidAppointmentException;
/**The AppointmentRepositoryImpl class provides methods to persist or update or remove or view data from database
 * 
 * @author N,Nandini
 *
 */

public class AppointmentRepositoryImpl implements IAppointmentRepository {
	private EntityManager entityManager;
	/* Constructor to get the entity manager */ 
	public AppointmentRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}
    @Override
	public Appointment bookAppointment(Appointment appointment) {
		entityManager.persist(appointment);
		return appointment;
	}
    /**
   	 * This method takes appointment object and update appointment details into DB
   	 * @param appointment - Appointment entity details 
   	 */
    @Override
	public Appointment updateAppointment(Appointment appointment) throws InvalidAppointmentException {
		Appointment app = entityManager.find(Appointment.class, appointment.getAppointmentId());
		if(app==null)
		{
			throw new InvalidAppointmentException("appointment not found");
		}
		appointment = entityManager.merge(appointment);
		return appointment;
	}
    /**
   	 * This method takes appointment variable id and view remove appointment details from DB
   	 * @param appointment - Appointment entity details 
   	 */
    @Override
	public Appointment cancelAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		Appointment appointment = entityManager.find(Appointment.class, appointmentId);
		if(appointment==null)
		{
			throw new AppointmentIdNotFoundException(appointmentId);
		}
		entityManager.remove(appointment);
		appointment=null;
		return appointment;
	}
    /**
   	 * This method takes appointment variable id and view appointment details from DB
   	 * @param appointment - Appointment entity details 
   	 */
    @Override
	public Appointment viewAppointment(int appointmentId) throws AppointmentIdNotFoundException{
		Appointment appointment = entityManager.find(Appointment.class, appointmentId);
		if(appointment==null)
		{
			throw new AppointmentIdNotFoundException(appointmentId);
		}
		return appointment;
	}
    /**
   	 * This method shows all appointment details in a List from DB
   	 * @param appointment - Appointment entity details 
   	 */
    @Override
	public List<Appointment> viewAllAppointments() {
		TypedQuery<Appointment> query = entityManager.createQuery("select a from Appointment a", Appointment.class);
		List<Appointment> allapp = query.getResultList();
		return allapp;
	}
    /**
	 * This method takes appointment variable date and view appointment details from DB
	 * @param appointment - Appointment entity details 
	 */
    @Override
	public List<Appointment> viewAppointments(LocalDate date) {
		TypedQuery<Appointment> query = entityManager.createQuery("select a from Appointment a", Appointment.class);
		List<Appointment> app =  query.getResultList();
		return app;
	}
    /**
	 * This method is used to begin transaction.
	 */
    @Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}
    /**
	 * This method is used to commit transaction.
	 */
    @Override
	public void commitTransaction() {
	    entityManager.getTransaction().commit();
		
	}

}
