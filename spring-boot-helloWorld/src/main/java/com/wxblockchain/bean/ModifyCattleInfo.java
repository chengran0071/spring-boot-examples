package com.wxblockchain.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString(callSuper = true)
public class ModifyCattleInfo {
    /**牛只基本信息*/

    @Pattern(regexp = "[0-3]",message = "出栏方式数据有误")
    @ApiModelProperty(value = "出栏方式")
    private  String outPenMethod;

    @ApiModelProperty(value = "出栏时间")
    private Date outPenDate;

    @ApiModelProperty(value = "出栏体重")
    private BigDecimal outPenWeight;

    @Pattern(regexp = "[0-2]",message = "养殖状态数据有误")
    @ApiModelProperty(value = "养殖状态")
    private  String raiseStatus;

    @Pattern(regexp = "[0-1]",message = "养殖方式数据有误")
    @ApiModelProperty(value = "养殖方式")
    private  String raiseMethod;

    @ApiModelProperty(value = "牛舍编号")
    private  String colonyNo;

    @ApiModelProperty(value = "重新绑定项圈")
    private String newCollarNo;

    @ApiModelProperty(value = "项圈编号")
    private  String collarNo;

    @ApiModelProperty(value = "存证id")
    private String evidenceId;

    @ApiModelProperty(value = "备注")
    private  String remark;

    @ApiModelProperty(value = "签名数据")
    private String signData;

}
