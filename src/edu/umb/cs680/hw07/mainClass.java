package edu.umb.cs680.hw07;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directory root = new Directory(null, "root", 0,
				LocalDateTime.of(LocalDate.of(2019, 8, 15), LocalTime.of(12, 00, 00)));
		Directory applications = new Directory(root, "applications", 0,
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 00, 40)));
		Directory home = new Directory(root, "home", 0,
				LocalDateTime.of(LocalDate.of(2019, 10, 15), LocalTime.of(20, 30, 00)));
		Directory code = new Directory(home, "code", 0,
				LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 31, 00)));

		File a = new File(applications, "a", 2048,
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 01, 00)));
		File b = new File(applications, "b", 1024,
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 10, 00)));

		File c = new File(home, "c", 2048, LocalDateTime.of(LocalDate.of(2019, 10, 15), LocalTime.of(21, 32, 45)));
		File d = new File(home, "d", 4096, LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(21, 45, 18)));

		File e = new File(code, "e", 1024, LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 40, 59)));
		File f = new File(code, "f", 2048, LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 45, 51)));

		// adding root directory, as same as C drive or D drive in Window Explorer file
		// system
		// we must add application and home directory to rootDirs.
		FileSystem.getFileSystem().appendRoot(root);
		// FileSystem.getFileSystem().appendRoot(home);

		applications.appendChild(a);
		applications.appendChild(b);

		root.appendChild(applications);
		root.appendChild(home);

		home.appendChild(code);
		home.appendChild(c);
		home.appendChild(d);

		code.appendChild(e);
		code.appendChild(f);

		System.out.println(root.countChildren());
		System.out.println(applications.countChildren());
		System.out.println(home.countChildren());

		root.printChildName(root.getChildren());
		applications.printChildName(applications.getChildren());
		home.printChildName(home.getChildren());
		code.printChildName(code.getChildren());

		System.out.println(applications.getTotalSize());
		System.out.println(home.getTotalSize());
		System.out.println(root.getTotalSize());

		System.out.println(root.getSubDirectories());
		System.out.println(home.getSubDirectories());
		System.out.println(home.getFiles());
		System.out.println(root.getFiles());
		System.out.println(applications.getFiles());

		System.out.println(a.getCreationTime().toString());

	}

}
