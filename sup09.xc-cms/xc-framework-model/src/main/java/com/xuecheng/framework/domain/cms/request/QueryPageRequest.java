package com.xuecheng.framework.domain.cms.request;

import com.wenbronk.framework.model.request.RequestData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 09:16
 * description:
 */
@Data
@ApiModel(value="QueryPageRequest对象",description="QueryPageRequest")
public class QueryPageRequest extends RequestData {

    @ApiModelProperty("站点id")
    private String siteId;

    @ApiModelProperty("页面ID")
    private String pageId;

    @ApiModelProperty("页面名称")
    private String pageName;

    @ApiModelProperty("页面别名")
    private String pageAliase;

    @ApiModelProperty("模版id")
    private String templateId;

}
