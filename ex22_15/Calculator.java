import java.util.Stack;
import java.util.StringTokenizer;


public class Calculator {
	public static double eval(String str) throws Exception {
		Stack<Double> stack = new Stack<Double>();
		StringTokenizer st = new StringTokenizer(str, " ");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			try {
				Double number = Double.parseDouble(token);
				stack.push(number);
				continue;
			} catch (Exception e) {}
			operation(token, stack);
		}
		double ret = stack.pop();
		if (stack.isEmpty()) return ret;
		throw new Exception();
	}
	
	private static void operation(String token, Stack<Double> stack) {
		if (token.equals("+")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(a + b);
		} else if (token.equals("-")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(a - b);
		} else if (token.equals("*")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(a * b);
		} else if (token.equals("/")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(a / b);
		} else if (token.equals("%")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(a % b);
		} else if (token.equals("sin")) {
			double a = stack.pop();
			stack.push(Math.sin(a));
		} else if (token.equals("cos")) {
			double a = stack.pop();
			stack.push(Math.cos(a));
		} else if (token.equals("tan")) {
			double a = stack.pop();
			stack.push(Math.tan(a));
		} else if (token.equals("asin")) {
			double a = stack.pop();
			stack.push(Math.asin(a));
		} else if (token.equals("acos")) {
			double a = stack.pop();
			stack.push(Math.acos(a));
		} else if (token.equals("atan")) {
			double a = stack.pop();
			stack.push(Math.atan(a));
		} else if (token.equals("atan2")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(Math.atan2(a, b));
		} else if (token.equals("toRadians")) {
			double a = stack.pop();
			stack.push(Math.toRadians(a));
		} else if (token.equals("toDegrees")) {
			double a = stack.pop();
			stack.push(Math.toDegrees(a));
		} else if (token.equals("exp")) {
			double a = stack.pop();
			stack.push(Math.exp(a));
		} else if (token.equals("sinh")) {
			double a = stack.pop();
			stack.push(Math.sinh(a));
		} else if (token.equals("cosh")) {
			double a = stack.pop();
			stack.push(Math.cosh(a));
		} else if (token.equals("tanh")) {
			double a = stack.pop();
			stack.push(Math.tanh(a));
		} else if (token.equals("pow")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(Math.pow(a, b));
		} else if (token.equals("log")) {
			double a = stack.pop();
			stack.push(Math.log(a));
		} else if (token.equals("log10")) {
			double a = stack.pop();
			stack.push(Math.log10(a));
		} else if (token.equals("sqrt")) {
			double a = stack.pop();
			stack.push(Math.sqrt(a));
		} else if (token.equals("cbrt")) {
			double a = stack.pop();
			stack.push(Math.cbrt(a));
		} else if (token.equals("signum")) {
			double a = stack.pop();
			stack.push(Math.signum(a));
		} else if (token.equals("ceil")) {
			double a = stack.pop();
			stack.push(Math.ceil(a));
		} else if (token.equals("floor")) {
			double a = stack.pop();
			stack.push(Math.floor(a));
		} else if (token.equals("rint")) {
			double a = stack.pop();
			stack.push(Math.rint(a));
		} else if (token.equals("round")) {
			double a = stack.pop();
			stack.push((double) Math.round(a));
		} else if (token.equals("abs")) {
			double a = stack.pop();
			stack.push(Math.abs(a));
		} else if (token.equals("max")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(Math.max(a, b));
		} else if (token.equals("min")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(Math.min(a, b));
		} else if (token.equals("hypot")) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(Math.hypot(a, b));
		}
	}
}
