package com.lyx;

import cn.hutool.core.io.FileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTests
{
	@Test
	void contextLoads()
	{
		System.out.println(FileUtil.getTmpDirPath());
	}
}
