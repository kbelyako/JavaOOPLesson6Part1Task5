package com.yandex.kbelyako;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class FileWatcher implements Runnable {
	private File folder;
	
	
	public FileWatcher(File folder) {
		super();
		this.folder = folder;
	}

	public File getFolder() {
		return folder;
	}
	
	private File [] getContent() {
		
		File [] fileArray = this.folder.listFiles();
		
		return fileArray;
	}
	

	@Override
	public void run() {
		Thread thr=Thread.currentThread();
		SimpleDateFormat sdf = new SimpleDateFormat("HH.mm.ss");
		for(;!thr.isInterrupted();) {

			File [] contentOne=getContent();
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File [] contentTwo=getContent();
			int diff=contentOne.length-contentTwo.length;
			
			if(diff>0) { 
				System.out.println("Some files has been deleted");
			}
			if(diff<0) { 
				System.out.println("Some files has been added");
			}
			
		}
		
	}
	
	

}
