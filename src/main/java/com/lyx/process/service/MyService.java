package com.lyx.process.service;

import com.lyx.common.ResponseData;
import com.lyx.entity.GenerateCodePara;

public interface MyService
{
	ResponseData geneCode(GenerateCodePara para);
}