package edu.umb.cs680.hw07;

import java.util.LinkedList;
import java.util.Objects;

public class FileSystem {

	private LinkedList<Directory> rootDirs = new LinkedList<>();
	
	private static FileSystem instance = null;
	
	//default constructor
	private FileSystem() {
	}
	//Singleton 
	public static FileSystem getFileSystem() {
		try {
			return Objects.requireNonNull(instance);
		} catch(NullPointerException ex) {
			instance = new FileSystem();
			return instance;
		}
	}
	public LinkedList<Directory> getRootDirs(){
		return this.rootDirs;
	}
	
	public void appendRoot(Directory root) {
		this.rootDirs.add(root);
	}
}
