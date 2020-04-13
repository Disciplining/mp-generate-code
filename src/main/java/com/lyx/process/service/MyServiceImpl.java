package com.lyx.process.service;

import com.lyx.common.ResponseData;
import com.lyx.entity.GenerateCodePara;
import org.springframework.stereotype.Service;

@Service("myServiceImpl")
public class MyServiceImpl implements MyService
{
	@Override
	public ResponseData geneCode(GenerateCodePara para)
	{
		System.out.println("我是業務方法");
		return ResponseData.successMsg("执行成功");
	}
}