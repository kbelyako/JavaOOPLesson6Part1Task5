//5) Реализуйте программу, которая с периодичностью 1 сек, будет проверять состояние заданного каталога.
//Если в этом каталоге появится новый файл или исчезнет существующий, то выведется сообщение об этом событии.
//Программа должна работать в параллельном потоке выполнения.

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
