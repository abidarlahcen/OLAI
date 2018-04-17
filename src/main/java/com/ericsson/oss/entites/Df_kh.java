package com.ericsson.oss.entites;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity 
@Table(name = "Df_kh")
public class Df_kh implements Serializable { 
	
/**
	 * 
	 */
	
	Dfid Dfid;
    private String filesysteme ;
	private Float memory_size ;
	private Float memory_used ;
	private Float memory_avail ;
	private Float capacity ;
@Id	
	public Dfid getDfid() {
	return Dfid;
}


public void setDfid(Dfid dfid) {
	Dfid = dfid;
}

	public Df_kh () {
	
	}
	
	
	public String getFilesysteme() {
		return filesysteme;
	}


	public void setFilesysteme(String filesysteme) {
		this.filesysteme = filesysteme;
	}


	public Float getMemory_size() {
		return memory_size;
	}

	public void setMemory_size(Float memory_size) {
		this.memory_size = memory_size;
	}

	public Float getMemory_used() {
		return memory_used;
	}

	public void setMemory_used(Float memory_used) {
		this.memory_used = memory_used;
	}

	public Float getMemory_avail() {
		return memory_avail;
	}

	public void setMemory_avail(Float memory_avail) {
		this.memory_avail = memory_avail;
	}

	public Float getCapacity() {
		return capacity;
	}

	public void setCapacity(Float capacity) {
		this.capacity = capacity;
	}

	
	
	
	
	
	
	
	

}
