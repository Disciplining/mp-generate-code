package com.lyx.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 代码生成参数
 */
@Data
public class GenerateCodePara
{
	@NotEmpty(message = "父包名不能为空")
	private String parentPackage;

	@NotEmpty(message = "模块名不能为空")
	private String moduleName;

	@NotEmpty(message = "主机名不能为空")
	private String dbHost;

	private Integer port;

	@NotEmpty(message = "数据库不能为空")
	private String db;

	@NotEmpty(message = "表名不能为空")
	private String table;

	@NotEmpty(message = "用户名不能为空")
	private String user;

	@NotEmpty(message = "密码不能为空")
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
