import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UseRuntime {
	public static void runScript(String scriptpath) {
		try {
			Process subProcess = Runtime.getRuntime().exec(scriptpath);
			// ProcessHandle Java 9可用,打印PID
			ProcessHandle pHandle = subProcess.toHandle();
			System.out.println("SubProcess id is " + pHandle.pid());
			// 新启一个子进程
			InputStream inputStream = subProcess.getInputStream();
			BufferedReader subInput = new BufferedReader(new InputStreamReader(inputStream));
			// 子进程向主进程输出信息
			String lineString = null;
			while ((lineString = subInput.readLine()) != null) {
				System.out.println(lineString);
			}
			subInput.close();
			subProcess.waitFor();
			// waitFor()函数是让当前主进程等待该子进程执行完毕，正常退出则返回0
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
