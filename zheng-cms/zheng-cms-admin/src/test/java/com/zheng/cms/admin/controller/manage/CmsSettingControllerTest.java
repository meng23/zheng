package com.zheng.cms.admin.controller.manage;

import com.zheng.cms.common.constant.CmsResult;
import com.zheng.cms.common.constant.CmsResultConstant;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CmsSettingControllerTest {

    @Test
    public void indexReturnsErrorWhenNameContainsInvalidCharacters() {
        CmsSettingController controller = new CmsSettingController();

        ModelAndView result = controller.index("abc-123");

        assertNull(result.getViewName());
        assertTrue(result.getModel().get("result") instanceof CmsResult);
        CmsResult cmsResult = (CmsResult) result.getModel().get("result");
        assertEquals(CmsResultConstant.INVALID_PARAMETER.getCode(), cmsResult.getCode());
        assertEquals("您输入的参数有误，请正确输入", cmsResult.getData());
    }

    @Test
    public void indexAllowsLettersNumbersAndUnderscoreName() {
        CmsSettingController controller = new CmsSettingController();

        ModelAndView result = controller.index("abc_123");

        assertEquals("/manage/setting/index.jsp", result.getViewName());
    }

    @Test
    public void indexAllowsBlankName() {
        CmsSettingController controller = new CmsSettingController();

        ModelAndView result = controller.index(null);

        assertEquals("/manage/setting/index.jsp", result.getViewName());
    }

}
