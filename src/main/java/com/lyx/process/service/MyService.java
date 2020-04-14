package com.lyx.process.service;

import com.lyx.entity.GenerateCodePara;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MyService
{
	ResponseEntity geneCode(GenerateCodePara para, BindingResult result);
}