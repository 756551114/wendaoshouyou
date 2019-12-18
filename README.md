# 这是什么项目自己研究
# 加作者Q 756551114
<h3>12.18</h3>
修改打包启动方式
启动命令更新为<br>
java -server -Xms64m -Xmx128m -XX:NewRatio=4 -XX:SurvivorRatio=4 -XX:PermSize=64M -XX:MaxPermSize=64m -Dloader.path="lib/" -jar xxxxxxxx.jar
<br>
jvm参数根据自己需求配置

