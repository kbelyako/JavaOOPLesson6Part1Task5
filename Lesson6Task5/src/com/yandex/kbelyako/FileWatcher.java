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

	private File[] getContent() {

		File[] fileArray = this.folder.listFiles();

		return fileArray;
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		SimpleDateFormat sdf = new SimpleDateFormat("HH.mm.ss");
		for (; !thr.isInterrupted();) {

			File[] contentOne = getContent();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			File[] contentTwo = getContent();

			int diff = contentOne.length - contentTwo.length;

			if (diff > 0) {

				for (int i = 0; i < contentOne.length; i++) {
					boolean flag = true;
					for (int j = 0; j < contentTwo.length; j++) {
						if (contentOne[i].getName().equals(
								contentTwo[j].getName())) {
							flag = false;
						}
					}

					if (flag == true) {

						// System.out.println(contentOne[i].getName()+" has been deleted");
						System.out.println("'" + contentOne[i].getName() + "'");
					}
				}
				System.out.println("has been deleted from "
						+ this.folder.getAbsolutePath());
				// System.out.println("Some files has been deleted");
			}
			if (diff < 0) {

				for (int i = 0; i < contentTwo.length; i++) {
					boolean flag = true;
					for (int j = 0; j < contentOne.length; j++) {
						if (contentTwo[i].getName().equals(
								contentOne[j].getName())) {
							flag = false;
						}

					}
					if (flag == true) {

						// System.out.println("'"+contentTwo[i].getName()+"'"+" has been added");
						System.out.println("'" + contentTwo[i].getName() + "'");
					}
				}

				// System.out.println("Some files has been added");
				System.out.println("has been added to "
						+ this.folder.getAbsolutePath());
			}

		}

	}

}
