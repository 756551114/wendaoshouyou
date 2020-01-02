//package com.dhcc.admin.sys.config;
//
//import org.apache.activemq.artemis.api.core.client.ClientConsumer;
//import org.apache.activemq.artemis.api.core.client.ClientProducer;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//import com.dhcc.utils.artemis.ArtemisClient;
//import com.dhcc.yjy.constants.ArtemisAddressConstant;
//
//@Configuration
//public class ActivemqConfig implements InitializingBean, DisposableBean {
//
//    @Value("${activemq-tcp}")
//    private String activemqTcp;
//    private ClientProducer producer = null;
//    private ArtemisClient artemisClient =null;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        artemisClient = new ArtemisClient(activemqTcp);
//        producer = artemisClient.createProducer(ArtemisAddressConstant.MANAGER_LOG);
//    }
//    /**
//     * 发送
//     * @param bytes
//     * @throws Exception
//     */
//    public void sendLog(byte[] bytes) throws Exception{
//        artemisClient.sendMessage(producer, bytes);
//    }
//
//    /**
//     * 关闭
//     */
//    @Override
//    public void destroy() throws Exception {
//        artemisClient.shutdown();
//    }
//}
