package com.s1025.kuroko.result;

public class ResultBase {
	private String resultType;

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public ResultBase(String resultType) {
		super();
		this.resultType = resultType;
	}

	public ResultBase() {
		super();
	}

	@Override
	public String toString() {
		return "ResultBase [resultType=" + resultType + "]";
	}
}
