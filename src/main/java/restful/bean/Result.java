package restful.bean;

public class Result {

	/**
	 * �����
	 */
	private String code;
	/**
	 * �������
	 */
	private String result;
	/**
	 * �ɹ�/ʧ��ԭ��
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
