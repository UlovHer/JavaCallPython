import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class UseJython {
	private PythonInterpreter interpreter;
	private PySystemState pySys;

	public UseJython() {
		interpreter = new PythonInterpreter();
		pySys = Py.getSystemState();
	}

	public void execCode(String[] pythonCode) {
		for (String str : pythonCode) {
			interpreter.exec(str);
		}
		interpreter.cleanup();
	}

	public void execScriptNoReturn(String scriptPath, String[] args) {
		for (String str : args) {
			pySys.argv.append(new PyString(str));
		}
		interpreter.execfile(scriptPath);
		interpreter.cleanup();
	}

	public void execScriptReturn(String scriptPath, String[] args) {
		// System.setProperty("python.home",
		// "C:\\Users\\Lovwin\\AppData\\Local\\Programs\\Python\\Python37");
		PyList argvList = new PyList();
		for (String str : args) {
			argvList.append(new PyInteger(Integer.parseInt(str)));
		}
		interpreter.execfile(scriptPath);
		PyFunction pyFunc = interpreter.get("add", PyFunction.class);
		// 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型

		// 调用Python程序中的函数
		PyObject pyObj = pyFunc.__call__(argvList);
		System.out.println("the result is: " + pyObj);
		interpreter.cleanup();
	}

	public void close() {
		interpreter.cleanup();
		interpreter.close();

	}
}
