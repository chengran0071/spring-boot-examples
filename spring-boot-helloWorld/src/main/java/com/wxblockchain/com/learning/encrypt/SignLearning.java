package com.wxblockchain.com.learning.encrypt;

import com.kunlun.crypto.asym.EccCrypto;
import com.wxblockchain.bean.CattleCollarStatementDetailInfo;
import com.wxblockchain.bean.CattleDetailInfo;
import com.wxblockchain.bean.CattleRaiseDetailInfo;
import com.wxblockchain.bean.ModifyCattleInfo;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 签名 与 验签
 */
public class SignLearning {
    private static final String PRIVATE_KEY = "5YO8xGYRh06jsCqFavMVWIY0JY77mt7sgqlWQH3y0Q8=";
    private static final String PUBLIC_KEY = "BOx02l8QCLFlSocDPiU89Auicut0v93qnwswksOMn6SEqqPYrU9LFr2+teJfzqgbPbbcB1XTME+HDHspZrN4dME=";

    private  static final ObjectMapper ObjectMapper = new ObjectMapper();
    private static String clearText = "";

    public static void main(String[] args) throws Exception{
        String paraJson = "{\"bindStatus\":\"1\",\"collarNo\":\"test002\",\"gpsInfo\":\"22.33,33.44\",\"penStatus\":\"0\",\"cattleStatus\":\"0\",\"powerInfo\":\"0\",\"activityInfo\":\"000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000\",\"signData\":\"MEQCIDbJ51DvaE1lZNVJLeHTtbWoWjUXNM48CbX4fYInc1WaAiAffAqRgEb2IlvZZI29luGYns2ZglfrmFiuky3PrzAuQg==\",\"evidenceId\":\"2c38f73bccf44f43a40654f64d66ca1c\"}";

        getClearText(paraJson,CattleCollarStatementDetailInfo.class);
        EccCrypto eccCrypto = new EccCrypto();
        String signData = eccCrypto.sign(clearText, PRIVATE_KEY);
        System.out.println("本地测试生成的签名数据 ：" + signData);

        String originalSignData = "";
        System.out.println("参数的验签结果为 ：" + eccCrypto.verify(clearText,PUBLIC_KEY,originalSignData));

    }

    private static <T> T getClearText(String paraJson,Class<T> clazz) throws  Exception{
        T t = ObjectMapper.readValue(paraJson, clazz);
        if(t instanceof CattleDetailInfo){
            CattleDetailInfo cattleDetailInfo =(CattleDetailInfo) t;
            clearText =cattleDetailInfo.getContractNo() + cattleDetailInfo.getGender() +
                    cattleDetailInfo.getBirthday() + cattleDetailInfo.getSourceAddress() +
                    cattleDetailInfo.getInPenDate() + cattleDetailInfo.getInPenWeight() +
                    cattleDetailInfo.getPurchasePrice() + cattleDetailInfo.getSupplier() +
                    cattleDetailInfo.getPastureName() + cattleDetailInfo.getColonyNo() +
                    cattleDetailInfo.getPicUrl() + cattleDetailInfo.getCollarNo();
        }else if (t instanceof CattleCollarStatementDetailInfo){
            CattleCollarStatementDetailInfo cattleCollar = (CattleCollarStatementDetailInfo) t;
            //项圈编号+记录人员名称+称重重量+称重时间
            clearText = cattleCollar.getCollarNo() +
                    cattleCollar.getBindStatus() + cattleCollar.getGpsInfo() +
                    cattleCollar.getActivityInfo() + cattleCollar.getDSignature() +
                    cattleCollar.getPenStatus() + cattleCollar.getCattleStatus() +
                    cattleCollar.getPowerInfo();
        }else if (t instanceof CattleRaiseDetailInfo){
            CattleRaiseDetailInfo cattleRaise = (CattleRaiseDetailInfo) t;
            //项圈编号+记录人员名称+称重重量+称重时间
            clearText =cattleRaise.getCollarNo() + cattleRaise.getOperatorName() +
                    cattleRaise.getWeight() + cattleRaise.getWeightTime();
        }else if (t instanceof ModifyCattleInfo){
            ModifyCattleInfo modifyCattleInfo = (ModifyCattleInfo) t;
            //项圈编号+牛舍编号+出栏时间+出栏方式+出栏体重+养殖方式+养殖状态+重新绑定的项圈编号+备注
            clearText = modifyCattleInfo.getCollarNo() + modifyCattleInfo.getColonyNo() +
                    modifyCattleInfo.getOutPenDate() + modifyCattleInfo.getOutPenMethod() +
                    modifyCattleInfo.getOutPenWeight() + modifyCattleInfo.getRaiseMethod() +
                    modifyCattleInfo.getRaiseStatus() + modifyCattleInfo.getNewCollarNo() +
                    modifyCattleInfo.getRemark();
        }
        return t;
    }
}
