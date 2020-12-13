package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

abstract class FSElement {

	protected String name;
	protected int size;
	protected LocalDateTime creationTime;
	protected Directory parent; 
	
	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}	

	public Directory getParent() {
		return this.parent;
	}
	
	public int getSize() {
		return this.size;
	}

	public String getName() {
		return this.name;
	}
	public String getCreationTime() {
		return this.creationTime.toString();
	}
	public String getParentToString() {
		return this.parent.getName();
	}
	public void setParent(Directory parent) {
		this.parent = parent;
	}
	
	//left this empty, and its child will complete implementation later
	public abstract boolean isDirectory();
	
}
