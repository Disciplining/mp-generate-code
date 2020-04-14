package com.lyx.process.controller;

import com.lyx.entity.GenerateCodePara;
import com.lyx.process.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MyController
{
	@Autowired
	@Qualifier("myServiceImpl")
	private MyService myService;

	@PostMapping("/geneCode")
	public ResponseEntity geneCode(@Valid GenerateCodePara para, BindingResult result)
	{
		return myService.geneCode(para, result);
	}
}