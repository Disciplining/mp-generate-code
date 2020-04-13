package com.lyx.process.service;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.lyx.common.ResponseData;
import com.lyx.entity.GenerateCodePara;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("myServiceImpl")
public class MyServiceImpl implements MyService
{
	@Override
	public ResponseData geneCode(GenerateCodePara para)
	{
		AutoGenerator mpg = new AutoGenerator();

		GlobalConfig gc = new GlobalConfig();
		String projectPath = FileUtil.getTmpDirPath() + "z" + UUID.randomUUID(); // 项目的路径
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor("powered by lyx"); // 作者
		gc.setSwagger2(para.getUseSwagger()); // 是否添加Swagger2注解
		mpg.setGlobalConfig(gc);


		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl(new StringBuilder("jdbc:mysql://").append(para.getDbHost()).append(':').append(para.getPort()).append('/').append(para.getDb()).append("?serverTimezone=Asia/Shanghai").toString()); // 数据库地址
		dsc.setDriverName("com.mysql.cj.jdbc.Driver"); // 连接数据库驱动
		dsc.setUsername(para.getUser()); // 用户名
		dsc.setPassword(para.getPasswd()); // 密码
		mpg.setDataSource(dsc);

		PackageConfig pc = new PackageConfig();
		pc.setModuleName(para.getModuleName());
		pc.setParent(para.getParentPackage()); // 设置 "父包名"
		mpg.setPackageInfo(pc);

		if (para.getGeXml()) // 是否生成xml文件
		{
			boolean inPackage = para.getWhereMapperXml(); // 是否在包内

			InjectionConfig cfg = new InjectionConfig()
			{
				@Override
				public void initMap()
				{
				}
			};


			String templatePath = "/templates/mapper.xml.ftl";

			List<FileOutConfig> focList = new ArrayList<>();
			focList.add
			(
				new FileOutConfig(templatePath)
				{
					@Override
					public String outputFile(TableInfo tableInfo)
					{
						if (inPackage)
						{
							return projectPath + "/src/main/java/" + pc.getParent().replace(".", "/") + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
						}
						else
						{
							return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
						}
					}
				}
			);

			cfg.setFileOutConfigList(focList);
			mpg.setCfg(cfg);
		}

		TemplateConfig templateConfig = new TemplateConfig();


		templateConfig.setXml(null);
		mpg.setTemplate(templateConfig);


		StrategyConfig strategy = new StrategyConfig();

		strategy.setNaming(para.getEntityName2TableName() ? NamingStrategy.no_change : NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(para.getFieldName2AttrName() ? NamingStrategy.no_change : NamingStrategy.underline_to_camel);  // 字段到属性
		strategy.setEntityLombokModel(para.getAddLombok()); // 是否添加 lombok 注解
		strategy.setRestControllerStyle(para.getUseRest()); // 是否为RestController
		strategy.setEntityTableFieldAnnotationEnable(para.getEntityAddTableNameAnno()); // 生成实体时是加 @TableField 注解


		strategy.setInclude(para.getTable().split(","));
		strategy.setTablePrefix(pc.getModuleName() + "_");

		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();

		File allFile = FileUtil.file(projectPath);

		return ResponseData.successMsg("成功了");
	}
}