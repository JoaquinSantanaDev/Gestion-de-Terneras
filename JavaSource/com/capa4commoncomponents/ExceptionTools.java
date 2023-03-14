package com.capa4commoncomponents;

import javax.validation.ConstraintViolationException;

public class ExceptionTools {

	public static Throwable getCause(Throwable e) {
		Throwable cause = null;
		Throwable result = e;

		while (null != (cause = result.getCause()) && (result != cause)) {
			result = cause;
			if (result instanceof ConstraintViolationException) {
				return result;
			}
		}
		return result;
	}

	public static String formatedMsg(Throwable ex) {
		
		return "["+ex.getClass().getSimpleName()+"] "+ex.getLocalizedMessage();
	}
}
