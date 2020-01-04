<#include "../../layout.ftl" >
<@head title="添加" />
<style>

</style>
<body>
<div class="layui-fluid" style="margin-top: 0px;">
    <div class="layui-card">
        <div class="layui-card-body layui-form">
            <input type="hidden" name="id" id="id" value="${(pet.id)!}">

            <div class="layui-form-item">
                <label class="layui-form-label">图鉴:</label>
                <div class="layui-input-block">
                    <input type="number" name="index" id="index" class="layui-input" min="1" max="999999"
                            placeholder="请输入图鉴" autocomplete="off"  value="${(pet.index)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">相行:</label>
                <div class="layui-input-block">
                    <select name="polar" id="polar">
                        <option <#if (pet.polar)?? && pet.polar == "无">selected</#if> value="无">无</option>
                        <option <#if (pet.polar)?? && pet.polar == "金">selected</#if> value="金">金</option>
                        <option <#if (pet.polar)?? && pet.polar == "木">selected</#if> value="木">木</option>
                        <option <#if (pet.polar)?? && pet.polar == "水">selected</#if> value="水">水</option>
                        <option <#if (pet.polar)?? && pet.polar == "火">selected</#if> value="火">火</option>
                        <option <#if (pet.polar)?? && pet.polar == "土">selected</#if> value="土">土</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>名称:</label>
                <div class="layui-input-block">
                    <input type="text" name="name" id="name" class="layui-input"
                           required lay-verify="required" placeholder="请输入名称" autocomplete="off"  value="${(pet.name)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>图标:</label>
                <div class="layui-input-block">
                    <input type="number" name="icon" id="icon" class="layui-input"
                           required lay-verify="required" placeholder="请输入图标" autocomplete="off"  value="${(pet.icon)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>携带等级:</label>
                <div class="layui-input-block">
                    <input type="number" name="levelReq" id="levelReq" class="layui-input"
                           required lay-verify="required" placeholder="请输入携带等级" autocomplete="off"  value="${(pet.levelReq)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>血气成长:</label>
                <div class="layui-input-block">
                    <input type="number" name="life" id="life" class="layui-input"
                           required lay-verify="required" placeholder="请输入血气成长" autocomplete="off"  value="${(pet.life)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>法力成长:</label>
                <div class="layui-input-block">
                    <input type="number" name="mana" id="mana" class="layui-input"
                           required lay-verify="required" placeholder="请输入法力成长" autocomplete="off"  value="${(pet.mana)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>速度成长:</label>
                <div class="layui-input-block">
                    <input type="number" name="speed" id="speed" class="layui-input"
                           required lay-verify="required" placeholder="请输入速度成长" autocomplete="off"  value="${(pet.speed)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>物攻成长:</label>
                <div class="layui-input-block">
                    <input type="number" name="phyAttack" id="phyAttack" class="layui-input"
                           required lay-verify="required" placeholder="请输入物攻成长" autocomplete="off"  value="${(pet.phyAttack)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>法功成长:</label>
                <div class="layui-input-block">
                    <input type="number" name="magAttack" id="magAttack" class="layui-input"
                           required lay-verify="required" placeholder="请输入法功成长" autocomplete="off"  value="${(pet.magAttack)!}">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>天生技能:</label>
                <div class="layui-input-block">
                    <input type="text" name="skiils" id="skiils" class="layui-input"
                           required lay-verify="required" placeholder="请输入天生技能" autocomplete="off"  value="${(pet.skiils)!}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>所在地图:</label>
                <div class="layui-input-block">
                    <input type="text" name="zoon" id="zoon" class="layui-input"
                           required lay-verify="required" placeholder="请输入所在地图" autocomplete="off"  value="${(pet.zoon)!}">
                </div>
            </div>
            <div class="layui-form-item" style="display: none">
                <button class="layui-btn layui-hide" lay-submit lay-filter="submit" id="submit">提交
                </button>
            </div>
        </div>
    </div>

    <@scripts>
        <script>

        </script>
        <script src="${application.getContextPath()}/js/business/pet/pet_add.js"></script>
        <script>
            layui.config({
                base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
            }).extend({
                index: 'lib/index' //主入口模块
            }).use(['util', 'index', 'table', 'upload'], callback);
        </script>
    </@scripts>
</body>
</html>

