package com.lyx.entity;

import lombok.Data;

/**
 * 代码生成参数
 */
@Data
public class GenerateCodePara
{
	private String parentPackage;
	private String moduleName;
	private String dbHost;
	private String port;
	private String db;
	private String table;
	private String user;
	private String passwd;
	private Boolean entityName2TableName;
	private Boolean fieldName2AttrName;
	private Boolean addLombok;
	private Boolean useRest;
	private Boolean entityAddTableNameAnno;
	private Boolean useSwagger;
	private Boolean geXml;
	private Boolean whereMapperXml;
}
