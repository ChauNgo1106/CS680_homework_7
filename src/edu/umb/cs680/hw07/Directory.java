package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

import java.util.LinkedList;

public class Directory extends FSElement {
	private LinkedList<FSElement> children = new LinkedList<>();

	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
	}

	// this is directory class
	public boolean isDirectory() {
		return true;
	}

	public LinkedList<FSElement> getChildren() {
		return this.children;
	}

	public void appendChild(FSElement child) {
		children.add(child);
		child.setParent(this);
	}

	public int countChildren() {
		return this.children.size();
	}

	public LinkedList<File> getFiles() {
		LinkedList<File> files = new LinkedList<>();
		for(FSElement child : children) {
			if(!child.isDirectory()) {
				files.add((File)child);
			}
		}
		return files;
	}

	public int getTotalSize() {
		int total = 0;
		for(FSElement child : children ) {
			if(!child.isDirectory()) {
				total += child.getSize();
			}
			else if(child.isDirectory()) {
				Directory convert = (Directory)child;
				total += convert.getTotalSize();
			}
		}
		return total;
	}
	
	public LinkedList<Directory> getSubDirectories(){
		LinkedList<Directory> sub = new LinkedList<>();
		for(FSElement child : children) {
			if(child.isDirectory()) {
				sub.add((Directory)child);
			}
		}
		return sub;
	}
	
	
	public void printChildName(LinkedList<FSElement> children) {
		for(FSElement child : children) {
			System.out.println(child.getName());
		}
	}

}
