//5) ���������� ���������, ������� � �������������� 1 ���, ����� ��������� ��������� ��������� ��������.
//���� � ���� �������� �������� ����� ���� ��� �������� ������������, �� ��������� ��������� �� ���� �������.
//��������� ������ �������� � ������������ ������ ����������.

package com.yandex.kbelyako;

import java.io.File;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		File folder=new File(".");
		Thread th= new Thread(new FileWatcher(folder));
		th.start();				
	}

}
