package com.lyx.common;

import lombok.Data;

@Data
public class ResponseData<T>
{
	private Boolean success;

	private String msg; // 要传给前端的数据

	private T data; // 要传给前端的数据

	private ResponseData()
	{
	}

	private ResponseData(Boolean success, String msg, T data)
	{
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public static <T> ResponseData<T> success()
	{
		return new ResponseData<T>(true,null,null);
	}

	public static <T> ResponseData<T> successMsg(String msg)
	{
		return new ResponseData<T>(true, msg, null);
	}

	public static <T> ResponseData<T> successData(T data)
	{
		return new ResponseData<T>(true,null,data);
	}

	public static <T> ResponseData<T> successMsgData(String msg, T data)
	{
		return new ResponseData<T>(true,msg,data);
	}

	public static <T> ResponseData<T> errorMsg(String msg)
	{
		return new ResponseData<T>(false, msg, null);
	}
}