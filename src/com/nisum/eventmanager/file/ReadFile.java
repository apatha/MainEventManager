package com.nisum.eventmanager.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

public class ReadFile {
	@SuppressWarnings("null")
	public String findFile(final String fileName,String path) {
		File dir = new File(path+"\\");
		String files;
		String fileContent = null;
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith(fileName);
			}
		};

		String[] children = dir.list(filter);
		if (children == null) {
			System.out
					.println("Either dir does not exist or is not a directory");
		} else {
			for (int i = 0; i < children.length; i++) {
				files = children[i];
				BufferedReader br = null;
				try {
					String sCurrentLine;
					br = new BufferedReader(new FileReader(path+"\\"+ files));
					while ((sCurrentLine = br.readLine()) != null) {
						sCurrentLine = sCurrentLine.replaceAll("\"+", "~");
						fileContent += sCurrentLine;
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null)
							br.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		fileContent = fileContent.replace("null", "");
		return fileContent;
	}
}