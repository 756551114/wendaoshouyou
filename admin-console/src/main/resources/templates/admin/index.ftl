<#include "../layout.ftl" >
<@head title="GM管理平台" />
<#if !(Session.loginUser)??>
    <script>
        location.href = '${application.getContextPath()}/login';
    </script>
</#if>
<body class="layui-layout-body">
  
  <div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left">
          <li class="layui-nav-item layadmin-flexible" lay-unselect>
            <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
              <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
            </a>
          </li>
          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;" layadmin-event="refresh" title="刷新">
              <i class="layui-icon layui-icon-refresh-3"></i>
            </a>
          </li>
        </ul>
        <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
          
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="note">
              <i class="layui-icon layui-icon-note"></i>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="fullscreen">
              <i class="layui-icon layui-icon-screen-full"></i>
            </a>
          </li>
          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;">
              <cite>${(Session.loginUser.loginName)!}</cite>
            </a>
            <dl class="layui-nav-child">
              <dd><a lay-href="${application.getContextPath()}/admin/userInfo">基本资料</a></dd>
              <dd><a lay-href="${application.getContextPath()}/admin/updatePwd">修改密码</a></dd>
              <hr>
              <dd style="text-align: center;"><a href="${application.getContextPath()}/logout">退出</a></dd>
            </dl>
          </li>
          
          <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
            <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
          </li>
        </ul>
      </div>
      
      <!-- 侧边菜单 -->
      <div class="layui-side layui-side-menu">
        <div class="layui-side-scroll">
          <div class="layui-logo" tppabs="http://www.layui.com/admin/std/dist/views/home/console.html">
            <span>GM管理平台</span>
          </div>
          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
          <#assign outter_index = 0>
          <#assign inner_index = 0>
          	<#if (Session.loginUser.resList)?? && Session.loginUser.resList?size &gt; 0>
          		<#list Session.loginUser.resList as sysRes>
          			<#if !(sysRes.pId??)>
			            <li class="layui-nav-item <!--<#if outter_index == 0>layui-nav-itemed</#if>-->">
			              <a href="javascript:;" lay-tips="${sysRes.resName}" lay-direction="2">
			                <i class="layui-icon ${sysRes.resIcon!}"></i>
			                <cite>${sysRes.resName}</cite>
			              </a>
			              <dl class="layui-nav-child">
			              	<#list Session.loginUser.resList as childSysRes>
			              		<#if childSysRes.pId?? && childSysRes.pId == sysRes.resId>
					                <dd class="<!--<#if outter_index == 0 && inner_index == 0>layui-this</#if>-->">
					                  <a lay-href="${application.getContextPath()}${childSysRes.resUrl!}">${childSysRes.resName!}</a>
					                </dd>
					                <#assign inner_index = inner_index + 1>
				                </#if>
			                </#list>
			              </dl>
			            </li>
			            <#assign outter_index = outter_index + 1>
		            </#if>
	            </#list>
            </#if>
          </ul>
        </div>
      </div>

      <!-- 页面标签 -->
      <div class="layadmin-pagetabs" id="LAY_app_tabs">
      	<div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
      	<div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-down">
          <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
            <li class="layui-nav-item" lay-unselect>
              <a href="javascript:;"></a>
              <dl class="layui-nav-child layui-anim-fadein">
                <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
              </dl>
            </li>
          </ul>
        </div>
        <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
          <ul class="layui-tab-title" id="LAY_app_tabsheader">
            <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
          </ul>
        </div>
      </div>
      
      
      <!-- 主体内容 -->
      <div class="layui-body" id="LAY_app_body">
        <div class="layadmin-tabsbody-item layui-show">
          <iframe src="${application.getContextPath()}/admin/console" tppabs="http://www.layui.com/admin/std/dist/views/home/console.html" frameborder="0" class="layadmin-iframe"></iframe>
        </div>
      </div>
      
      <!-- 辅助元素，一般用于移动设备下遮罩 -->
      <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
  </div>

<@scripts>
  <script src="${application.getContextPath()}/js/admin/index.js"></script>
  <script>
  layui.config({
    base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use('index',callback);
  </script>
</@scripts>
</body>
</html>


