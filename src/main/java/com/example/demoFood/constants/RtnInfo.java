package com.example.demoFood.constants;

public enum RtnInfo {
	SUCCESSFUL("200", "成功"),
	PARAMETER_REQUIRED("400","必要參數缺失,請在嘗試"),
	FAILED("500", "  Failure");
	
	
	private String code;
	
	private String message;

	private RtnInfo(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
