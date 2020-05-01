package com.wxblockchain.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString(callSuper = true)
public class CattleDetailInfo {

    /**牛只基本信息*/
    @ApiModelProperty(value = "合同编号")
    private  String contractNo;
    @ApiModelProperty(value = "品种")
    private  String category;
    @Pattern(regexp = "[0-1]",message = "性别数据有误")
    @ApiModelProperty(value = "性别")
    private  String gender;
    @ApiModelProperty(value = "出生年月")
    private  String birthday;
    @ApiModelProperty(value = "来源地")
    private  String sourceAddress;
    @ApiModelProperty(value = "入栏重量")
    private BigDecimal inPenWeight;
    @ApiModelProperty(value = "入栏时间")
    private  Date inPenDate;


    @ApiModelProperty(value = "出栏方式")
    private  String outPenMethod;
    @ApiModelProperty(value = "出栏时间")
    private  Date outPenDate;
    @Pattern(regexp = "[0-2]",message = "养殖状态数据有误")
    @ApiModelProperty(value = "养殖状态")
    private  String raiseStatus;
    @ApiModelProperty(value = "供应商")
    private  String supplier;
    @ApiModelProperty(value = "采购价格")
    private BigDecimal purchasePrice;
    @ApiModelProperty(value = "牧场名称")
    private  String pastureName;
    @Pattern(regexp = "[0-1]",message = "养殖方式数据有误")
    @ApiModelProperty(value = "养殖方式")
    private  String raiseMethod;
    @ApiModelProperty(value = "牛舍编号")
    private  String colonyNo;
    @ApiModelProperty(value = "图片url")
    private  String picUrl;
    @ApiModelProperty(value = "项圈编号")
    private String collarNo;
    @ApiModelProperty(value = "存证id")
    private String evidenceId;
    @ApiModelProperty(value = "签名数据")
    private String signData;

    @ApiModelProperty(value = "备注")
    private  String remark;

}
