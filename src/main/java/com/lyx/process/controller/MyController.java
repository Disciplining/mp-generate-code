package com.lyx.process.controller;

import com.lyx.common.ResponseData;
import com.lyx.entity.GenerateCodePara;
import com.lyx.process.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController
{
	@Autowired
	@Qualifier("myServiceImpl")
	private MyService myService;

	@PostMapping("/geneCode")
	public ResponseData geneCode(GenerateCodePara para)
	{
		return myService.geneCode(para);
	}
}