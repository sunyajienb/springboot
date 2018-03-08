package restful.bean;

public class Result {

	/**
	 * 结果码
	 */
	private String code;
	/**
	 * 结果描述
	 */
	private String result;
	/**
	 * 成功/失败原因
	 */
	private String reason;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", result=" + result + ", reason=" + reason + "]";
	}
	
}
