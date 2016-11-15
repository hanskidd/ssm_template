package com.kidd.core.domain;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * json结果封装类
 * @author kidd
 */
public class JsonResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code = 200;// 结果状态码
	private String message;// 结果描述
	private Object data;// 实际数据

	public JsonResult() {
	}

	public JsonResult(ResultEnum result) {
		this.code = result.getCode();
		this.message = result.getMessage();
	}

	public JsonResult(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public JsonResult(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setError(ResultEnum err) {
		this.code = err.getCode();
		this.message = err.getMessage();
	}

	public void setResult(int code, String msg) {
		this.code = code;
		this.message = msg;
	}

	/**
	 * 结果是否成功,即等于ErrorEnum.SUCCESS
	 * 
	 * @return
	 */
	public boolean success() {
		return code == ResultEnum.SUCCESS.getCode();
	}

	/**
	 * 内置错误枚举 200--执行成功 400--提交的数据有误 401--身份验证失败，未登录 403--无权限操作 500--系统内部错误
	 */
	public enum ResultEnum {
		SUCCESS(200), PARAM_ERROR(400), NO_AUTH(401), FORBIDDEN(403), SERVER_ERROR(500);

		private final static String[] errmsgs = { "执行成功", "提交的数据有误", "身份验证失败", "无权限操作", "系统内部错误" };
		private final int code;

		private ResultEnum(int code) {
			this.code = code;
		}

		public int getCode() {
			return this.code;
		}

		public String getMessage() {
			switch (code) {
			case 200:
				return errmsgs[0];
			case 400:
				return errmsgs[1];
			case 401:
				return errmsgs[2];
			case 403:
				return errmsgs[3];
			case 500:
				return errmsgs[4];

			default:
				break;
			}
			return null;
		}
	}

	@Override
	public String toString() {
		return MessageFormat.format("code={0},message={1},data={2}", code, message,
				(data == null ? "" : data.toString()));
	}
}
