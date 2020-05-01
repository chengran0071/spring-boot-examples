package com.wxblockchain.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString(callSuper = true)
public class CattleRaiseDetailInfo  {

    @ApiModelProperty(value = "牛只uuid",hidden = false)
    private String cattleUuid;
    @ApiModelProperty(value = "称重重量")
    private BigDecimal weight;
    @ApiModelProperty(value = "称重时间")
    private Date weightTime;
    @ApiModelProperty(value = "记录人员名称")
    private String operatorName;
    @ApiModelProperty(value = "存证id")
    private String evidenceId;

    @ApiModelProperty(value = "项圈编号")
    private String collarNo;

    @ApiModelProperty(value = "签名数据")
    private String signData;
}
