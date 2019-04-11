package com.zl.lambda;

import java.util.Optional;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class FormulaTest {

	public static void main(String[] args) throws ScriptException {
		Formula formula = new FormulaTest()::cast;
		System.out.println(formula.calculate(3));
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName( "JavaScript" );
		System.out.println( engine.getClass().getName() );
		System.out.println( "Result:" + engine.eval( "function f() {console.log(1); }; f();" ) );
	}
	private double cast(int i){
		return (double) i;
	}
	public static String getName(User u) {
	    return Optional.ofNullable(u)
	                    .map(user->user.getName())
	                    .orElse("Unknown");

	}

}
