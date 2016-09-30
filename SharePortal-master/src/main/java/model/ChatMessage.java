package model;


import java.util.Date;

import javax.persistence.Entity;

public class ChatMessage extends Message {

	    private Date time;
	    
	    public ChatMessage(Message original, Date time) 
	    {
	        super(original.getId(), original.getMessage());
	        this.time = time;
	    }
	    
	    public Date getTime() {
	        return time;
	    }
	    
	    public void setTime(Date time) {
	        this.time = time;
	    }
	}


