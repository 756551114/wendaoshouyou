# 这是什么项目自己研究
# 加作者Q 756551114
<h3>12.17</h3>
项目结构优化，启动方式改变。集成dubbo，打完root包后，依次启动必须先启动game-data，再启动另外两个项目
<h3>12.18</h3>
1.修改打包启动方式
启动命令更新为<br>
java -server -Xms64m -Xmx128m -XX:NewRatio=4 -XX:SurvivorRatio=4 -XX:PermSize=64M -XX:MaxPermSize=64m -Dloader.path="lib/" -jar xxxxxxxx.jar
<br>
jvm参数根据自己需求配置<br>
2.配置文件移除jar包，修改配置文件在jar包同级目录下config下面修改
<h3>12.19</h3>
添加Vip等级，vip等级会随着提高给人物提高属性加成<br>
配置表为 vip_add add字段表示加成倍率
<h5>氪金使人变强</h5>
<h3>12.20</h3>
移除多余依赖，json 序列化改为马云的fastjson，打包和启动数据大幅度提升