package com.lyx.process.service;

import com.lyx.common.ResponseData;
import com.lyx.entity.GenerateCodePara;
import org.springframework.http.ResponseEntity;

public interface MyService
{
	ResponseEntity geneCode(GenerateCodePara para);
}