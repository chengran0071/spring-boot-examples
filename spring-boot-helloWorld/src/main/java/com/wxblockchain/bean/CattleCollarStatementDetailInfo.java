package com.wxblockchain.bean;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;

@Data
@ToString(callSuper = true)
public class CattleCollarStatementDetailInfo {

    @ApiModelProperty(value = "项圈编号")
    private String collarNo;

    @Pattern(regexp = "[0-1]",message = "绑定状态数据有误")
    @ApiModelProperty(value = "绑定状态：0-未佩戴；1-已佩戴")
    private String bindStatus;

    @Pattern(regexp = "[0-1]",message = "围栏状态数据有误")
    @ApiModelProperty(value = "围栏状态：正常、超出范围")
    private String penStatus;

    @ApiModelProperty(value = "24h位置信息")
    private String gpsInfo;

    @ApiModelProperty(value = "48h活动量")
    private String activityInfo;

    @ApiModelProperty(value = "魔联签名")
    private String dSignature;

    @ApiModelProperty(value = "操作人")
    private String processorName;

    @ApiModelProperty(value = "存证id")
    private String evidenceId;

    @Pattern(regexp = "[0-1]",message = "体征数据有误")
    @ApiModelProperty(value = "体征状态")
    private String cattleStatus;

    @Pattern(regexp = "[0-1]",message = "电量数据有误")
    @ApiModelProperty(value = "电量状态")
    private String powerInfo;

    @ApiModelProperty(value = "签名数据")
    private String signData;
}
