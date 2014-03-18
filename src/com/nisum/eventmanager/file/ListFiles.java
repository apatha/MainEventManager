package com.nisum.eventmanager.file;

import java.io.File;

public class ListFiles {

	public String[] getFiles(String path) {

path=path+"\\";

		String files[] = null;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		files = new String[listOfFiles.length];
		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files[i] = listOfFiles[i].getName();
			}
		}
		return files;
	}
}