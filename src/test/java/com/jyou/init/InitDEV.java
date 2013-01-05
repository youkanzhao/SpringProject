package com.jyou.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InitDEV {
	private static String HOST = "127.0.0.1  www.june.com";
//	private static String URL = "http://www.june.com:8080/SpringProject/index.jsp";
	private static String URL = "http://www.june.com:8080/SpringProject/home.html";

	private static void setHost() {
		String fileName = "C:\\Windows\\System32\\drivers\\etc\\hosts";
		if (!isHostExist(fileName)) {
			addHost(fileName);
		}
	}

	private static void addHost(String fileName) {
		try {
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);
			randomFile.writeBytes("\n" + HOST);
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isHostExist(String fileName) {
		boolean result = false;
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if (tempString.startsWith(HOST)) {
					result = true;
					break;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e1) {
				}
			}
		}
		return result;
	}

	private static void openBrowser() {
		// TODO Auto-generated method stub
		try {
			Runtime.getRuntime().exec(
					"rundll32 url.dll,FileProtocolHandler " + URL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void setSelenium() {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\explorerDriver";
		String targetPath = "C:\\SeleniumWorkSpace";
		File file = new File(path);
		File targetFile = new File(targetPath);
		if (targetFile.isDirectory()) {
			targetFile.delete();
		}
		targetFile.mkdir();

		File[] allFiles = file.listFiles();
		try {
			for (int i = 0; i < allFiles.length; i++) {
				if (allFiles[i].isFile()) {
					FileInputStream input = new FileInputStream(allFiles[i]);
					FileOutputStream output = new FileOutputStream(targetPath
							+ "/" + allFiles[i].getName());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setSelenium();
		setHost();
		openBrowser();
	}
}
