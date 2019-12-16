package org.linlinjava.litemall.core.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.Key;

public class DesUtil
{
    public static String byteArr2HexStr(byte[] paramArrayOfByte)
            throws Exception
    {
        int i = 0;
        int k = paramArrayOfByte.length;
        StringBuffer localStringBuffer = new StringBuffer(k * 2);
        while (i < k)
        {
            int j = paramArrayOfByte[i];
            while (j < 0) {
                j += 256;
            }
            if (j < 16) {
                localStringBuffer.append("0");
            }
            localStringBuffer.append(Integer.toString(j, 16));
            i += 1;
        }
        return localStringBuffer.toString();
    }

    public static String decrypt(String paramString1, String paramString2)
    {
        Key key = getKey(paramString2.getBytes());
        try
        {
            paramString1 = new String(decrypt(hexStr2ByteArr(paramString1), key));
            return paramString1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decrypt(byte[] paramArrayOfByte, Key paramKey)
            throws Exception
    {
        Cipher localCipher = Cipher.getInstance("DES");
        localCipher.init(2, paramKey);
        return localCipher.doFinal(paramArrayOfByte);
    }

    public static String encrypt(String paramString1, String paramString2)
    {
        Key key = getKey(paramString2.getBytes());
        try
        {
            paramString1 = byteArr2HexStr(encrypt(paramString1.getBytes(), key));
            return paramString1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] encrypt(byte[] paramArrayOfByte, Key paramKey)
            throws Exception
    {
        Cipher localCipher = Cipher.getInstance("DES");
        localCipher.init(1, paramKey);
        return localCipher.doFinal(paramArrayOfByte);
    }

    private static Key getKey(byte[] paramArrayOfByte)
    {
        byte[] arrayOfByte = new byte[8];
        int i = 0;
        while ((i < paramArrayOfByte.length) && (i < arrayOfByte.length))
        {
            arrayOfByte[i] = paramArrayOfByte[i];
            i += 1;
        }
        return new SecretKeySpec(arrayOfByte, "DES");
    }

    public static byte[] hexStr2ByteArr(String paramString)
            throws Exception
    {
        final byte[] bytes = paramString.getBytes();
        int i = 0;
        int j = bytes.length;
        byte[] arrayOfByte = new byte[j / 2];
        while (i < j)
        {
            String str = new String(bytes, i, 2);
            arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(str, 16));
            i += 2;
        }
        return arrayOfByte;
    }

    public static void main(String[] args) throws IOException {
//        ClassPathResource res = new ClassPathResource("sdkConfigold.properties");
//        final String path = res.getURL().getPath();
//        FileReader reader = new FileReader(path);
//        BufferedReader br = new BufferedReader(reader);
//        String str = br.readLine();
//        while(str!=null){
//            final String[] split = str.split("=");
//            if(split.length==1){
//                str = br.readLine();
//                continue;
//            }
//            if(split[1].length()<50){
//                str = br.readLine();
//                continue;
//            }
//            System.out.println(split[0]);
//            final String decrypt = decrypt(split[1], "548711fdc20a2129");
//            System.out.println(decrypt);
//            str = br.readLine();
//        }
        final String decrypt = decrypt("662a14bd16bef3c6d5ab3e907fafed5c41e4c4210c4071c0d071763e778c63749bb87e3d0446d9944ab5221c3ac8893642e26971ba5f4b674dee9fb0a48d704894d749b3af0f1a375f5cdb8e7ef3ebc1b06722f3922be9581ff931365e29f1dc786b86486a478d5e4dee9fb0a48d704894d749b3af0f1a375f5cdb8e7ef3ebc1b06722f3922be958c156424e7bf98bf2d5ab3e907fafed5c95cb56a21467ba27587b1a7fcf6fdf3395d053042cabc5e99c68a2d2ec4ab3e30ef9d913c6693ecf9fdc413bde812e85a107335d3c76b34b9e46e13bdce784bd04edadf2bae18369ccc5644be1107a9bca28ce2a9dc7693af0a8ca4595d315da354541baecc03b7ead46e44adc2987ec5a69f3ab16076ab10e59a4299782e084a790f9f4da879578269207148699e5a80799357c737eea71af99e02e4ad945c674cd293f62781c5dbdb597d0b7bbba900e2946f9ddef201b1044a21099fb6a70bd6480dcb6aa558b76a028304bf7b3351e06282cb6a360ab736048598940baa10147395fe2cab62ac9eef2c91aeec6d42ee3d2384abad7d33ff1b816ded4d54d43d5021d2ebdcdbf8a3d97d866b26102cd5510023a2122af74cd293f62781c5d0c4f9c354615bdcafeb485c6fa71f9df4d717460108b3718ff509f19224c96219fcf3833c0fbc86c8ae103b2883758415d41cbe484a30361ce41ceab8b526a04c8b4cc31457a94a709c9f79f367a6d98275b119e7505251539f3b2a7ab0e378e67a6c83a463d576e992e427e5018b5a9b6661f981dc80c608fcb40365ed4eddc9909c1169f544e8f1e06282cb6a360ab388118f1ee4c3063aa3c0f0d7a749439c76266b2a99a3a0b2ff5045207815659d8b4390f15656555b2663ab9006ffe10b9a9bdd5d46f9bac43d5021d2ebdcdbfa9e6594a941b427719c003682442d52b715134d2eceb445f8daa4feb4694bcd5496466c78b62bd5a24b1095544ee12876ea2b9c7596c368ec4f0034a048fe918da2ff10b3d93d0615be3328832148a02340d4c8317461c8befc344c8f8971c1dc93d327974ffd52b5b6ca6042ea19d265fec04a93302670f19c003682442d52be7ebcf03e4dac20a9fe53a5f51df8f461bf5578c06533a4459e11c63d4daa7578130709e646330fc931aee8e9fc5cdd223e53c080692e6b2b799eefe55b96e9baf749b8671678052c3b13d847c85c0958e532cfdc402776786c233bd42ac8e3b354e8b481ef5952eabbc19859cd8b4d599ddb27bd42ddf1b29ee93f7a15ae36c7e99b32ece8ca29ca25d185bb0bfac4e4cbfdb3c64704f80cfebfa2f51ecda8e770c4e7b7d7413ca9a3e8297905ab6700799357c737eea7108d9449d2a9fe9bd19c003682442d52b9224e6ef471c96f52f010ab24e2184449a93f787c7924dbf14cb78557c72254603d70f7636b26b49fa845ebb9fce4d658d768b9a1eff4e3522810a007cc979d25be3a5af9de4b96e2819ee15e84370431e5d1834986d243f10933974e2193f5ab3b49b64946bfb936d996c01cfa6bcd77105749d1bf54be8a4a911467c4ad0a06b48e824d67fc53057be42c1ad289fd0ffd07c8af8ce38dac651f4e647070796136800d1e7c36d9b2b8046d221b82130a3c57ba0499314c8cb8d96679a2a024e42db173a5427a574f1683da2d949d66716c8bd5a3c08d401ef543174f52e79637077b3d0a71704177f11ccce86cb36da43d5021d2ebdcdbf7db410424c5ef758ffb9c23c41f2db8180a863ca7fa063f974ad64d3b11fa9b370300c951c2b780e3128c0d588e29fb26b9640fd5a2107fe78b6a4beb775700455aef4cc6d5ce69eae05be16ab5fca380577b86825f30027d65c8698d29e84ef3be207967d62b228b588121c2470a4522afea7428aff6abf13e0e5dcc321a2a79406c3cb07f9c08f516d545680c862bc260e1c50b77c15250d4f14d4309f0137", "548711fdc20a2129");
        System.out.println(decrypt);
        final String encrypt = encrypt("{\"loginUrl\":\"http://http://s.fiuwbjadshf.com:81/vip4\",\"payUrl\":\"http://http://s.fiuwbjadshf.com:81/vip4\",\"accountUrl\":\"http://http://s.fiuwbjadshf.com:81/vip4\",\"bbsUrl\":\"http://bbs.leiting.com\",\"helpUrl\":\"http://helper.leiting.com\",\"kernelUrl\":\"http://www.leiting.com\",\"logUrl\":\"http://tplog.leiting.com\",\"urlApis\":[{\"name\":\"login\",\"value\":\"/login/login.php\"},{\"name\":\"checkLogin\",\"value\":\"/login/mobile!mobileCheckLoginV3.php\"},{\"name\":\"fastRegister\",\"value\":\"/login/mobile!fastRegisterV2.action\"},{\"name\":\"payOrder\",\"value\":\"/terrace/phone_charge!createLeitingNo.action\"},{\"name\":\"getAdultInfo\",\"value\":\"/terrace/game_api/getIdCardBindInfo.htm\"}],\"channels\":[{\"name\":\"leiting\",\"value\":\"{\\\"guestLogin\\\":\\\"0\\\",\\\"payLevel\\\":\\\"1\\\",\\\"gmPhoneNum\\\":\\\"0592-3011618\\\"}\"}],\"plugs\":[{\"name\":\"qiyukf\",\"value\":\"{\\\"appKey\\\":\\\"b8c33a8308b536dc4fde7be133fc9835\\\",\\\"groupId\\\":\\\"354781\\\",\\\"robotId\\\":\\\"83373\\\"}\"},{\"name\":\"toutiao\",\"value\":\"{\\\"appId\\\":\\\"151304\\\",\\\"appName\\\":\\\"wendao\\\"}\"},{\"name\":\"wechath5\",\"value\":\"{\\\"payResult\\\":\\\"/terrace/phone_charge!searchResultByLeitingNo.action\\\",\\\"payResultChannel\\\":\\\"/terrace/notify_back!searchResultByLeitingNo.action\\\",\\\"payLoginResult\\\":\\\"/terrace/drm_charge!queryWechatPayResult.action\\\"}\"}],\"resValues\":[{\"name\":\"lt_realname_auth_toast_msg1\",\"value\":\"根据国家法规要求，您的账号信息尚未完善，请尽快完成实名认证以保障账号安全。\"}]}", "548711fdc20a2129");
        System.out.println(encrypt);
//        final String encrypt = encrypt("{\"loginUrl\":\"https://loginwd.leiting.com\",\"payUrl\":\"https://paywd.leiting.com\",\"accountUrl\":\"https://member.leiting.com\",\"bbsUrl\":\"http://bbs.leiting.com\",\"helpUrl\":\"http://helper.leiting.com\",\"kernelUrl\":\"http://www.leiting.com\",\"logUrl\":\"http://tplog.leiting.com\",\"urlApis\":[{\"name\":\"login\",\"value\":\"/login/mobile!sdkLogin.action\"},{\"name\":\"checkLogin\",\"value\":\"/login/mobile!sdkCheckLogin.action\"},{\"name\":\"fastRegister\",\"value\":\"/login/mobile!guestRegister.action\"},{\"name\":\"payOrder\",\"value\":\"/terrace/phone_charge!createLeitingNo.action\"},{\"name\":\"getAdultInfo\",\"value\":\"/terrace/game_api/getIdCardBindInfo.htm\"}],\"channels\":[{\"name\":\"leiting\",\"value\":\"{\\\"guestLogin\\\":\\\"1\\\",\\\"payLevel\\\":\\\"1\\\",\\\"gmPhoneNum\\\":\\\"0592-3011618\\\"}\"}],\"plugs\":[{\"name\":\"qiyukf\",\"value\":\"{\\\"appKey\\\":\\\"b8c33a8308b536dc4fde7be133fc9835\\\",\\\"groupId\\\":\\\"354781\\\",\\\"robotId\\\":\\\"83373\\\"}\"},{\"name\":\"toutiao\",\"value\":\"{\\\"appId\\\":\\\"151304\\\",\\\"appName\\\":\\\"wendao\\\"}\"},{\"name\":\"wechath5\",\"value\":\"{\\\"payResult\\\":\\\"/terrace/phone_charge!searchResultByLeitingNo.action\\\",\\\"payResultChannel\\\":\\\"/terrace/notify_back!searchResultByLeitingNo.action\\\",\\\"payLoginResult\\\":\\\"/terrace/drm_charge!queryWechatPayResult.action\\\"}\"}],\"resValues\":[{\"name\":\"lt_realname_auth_toast_msg1\",\"value\":\"根据国家法规要求，您的账号信息尚未完善，请尽快完成实名认证以保障账号安全。\"}]}\n", "548711fdc20a2129");
//        System.out.println(encrypt);
    }
}
