package com.zheng.cms.admin.controller.manage;

import com.zheng.cms.common.constant.CmsResult;
import com.zheng.cms.common.constant.CmsResultConstant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CmsSettingControllerTest {

	@Test
	public void indexReturnsInvalidParameterWhenIdGreaterThan20000() {
		CmsSettingController controller = new CmsSettingController();

		Object result = controller.checkIndexId(20001);

		assertTrue(result instanceof CmsResult);
		CmsResult cmsResult = (CmsResult) result;
		assertEquals(CmsResultConstant.INVALID_PARAMETER.getCode(), cmsResult.getCode());
		assertEquals(CmsResultConstant.INVALID_PARAMETER.getMessage(), cmsResult.getMessage());
		assertEquals("参数不正确", cmsResult.getData());
	}

}
