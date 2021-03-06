package com.trms.data;

import com.trms.data.Impl.DeptDAOImpl;
import com.trms.data.Impl.EmplDAOImpl;
import com.trms.data.Impl.EventDAOImpl;
import com.trms.data.Impl.ReimbursamentDAOImpl;
import com.trms.data.Impl.StatusDAOImpl;
import com.trms.models.Event;

public class DaoFactory {

	    private static DeptDAO deptDAO = null;
	    private static EventDAO eventDAO = null;
	    private static StatusDAO statusDAO = null;
	    private static ReimbursementDAO reimbursementDAO = null;
	    private static  EmplDAO emplDAO = null ;
	    private static Event event = null;
	    private static long eventId = 0;
	    private DaoFactory() {

	    }

	    public static DeptDAO getDeptDao() {
	        if (deptDAO == null) {
	        	deptDAO = new DeptDAOImpl();
	        }
	        return deptDAO;
	    }
	    
	    public static long getEventId() {
	        
	        return eventId;
	    }
	    
	    public static Event getEvent() {
	    	if(event==null) {
	    		event = new Event();
	    	}
	    	return event;
	    }
	    public static EventDAO getEventDAO() {
	    	if (eventDAO == null) {
	    		eventDAO = new EventDAOImpl();
	        }
	        return eventDAO;
	    	
	    }
	    public static StatusDAO getStatusDAO() {
	    	if (statusDAO == null) {
	    		statusDAO = new StatusDAOImpl();
	        }
	        return statusDAO;
	    	
	    }
	    public static ReimbursementDAO getReimbursementDAO() {
	    	if (reimbursementDAO == null) {
	    		reimbursementDAO = new ReimbursamentDAOImpl();
	        }
	        return reimbursementDAO;
	    	
	    }
	    public static EmplDAO geEmplDAO() {
	    	if (emplDAO == null) {
	    		emplDAO = new EmplDAOImpl();
	        }
	        return emplDAO;
	    	
	    }
	}

