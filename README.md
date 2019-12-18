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

