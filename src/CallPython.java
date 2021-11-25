import java.text.SimpleDateFormat;
import java.util.Date;

public class CallPython {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("****************************************************");
		System.out.println("*****use Jython to exec python script*****");
		UseJython useJython = new UseJython();
		String[] code = { "test = 'Java call Python'", "print(test)" };
		System.out.println("*****exec python code*****");
		useJython.execCode(code);

		System.out.println("*****exec python file*****");
		String scriptPath = "./python_scripts/call_python_script.py";
		Date dateData = new Date();
		String[] argsStrings1 = { "2021", "01", "07" };
		useJython.execScriptNoReturn(scriptPath, argsStrings1);

		System.out.println("*****exec python function*****");
		scriptPath = "./python_scripts/call_python_func.py";
		String[] argsStrings2 = { "10", "15" };
		useJython.execScriptReturn(scriptPath, argsStrings2);
		System.out.println("****************************************************");
		System.out.println("*****use java runtime to exec python script*****");
		System.out.println("*****run python script*****");

		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String nowTime = formatDate.format(dateData);
		String cmdString = String.format("python ./python_scripts/%s %s %s", "plot_clock.py", "subprocess call python",
				nowTime);
		System.out.println(cmdString);
		UseRuntime.runScript(cmdString);

		useJython.close();
	}

}
