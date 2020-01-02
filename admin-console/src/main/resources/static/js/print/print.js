var LODOP;//声明为全局变量
function prn_print(html){
    CreateOneFormPage(html);
    LODOP.PRINT();
};
function CreateOneFormPage(html){
    LODOP=getLodop();
    LODOP.SET_PRINT_STYLE("FontSize",12);//打印区域的字体大小
    LODOP.SET_PRINT_MODE("POS_BASEON_PAPER",true);
    LODOP.SET_PRINT_PAGESIZE(0,'58mm','150mm','');
    var strStyleCSS="<link href='"+_contextPath+"plugins/layui/css/layui.css' type='text/css' rel='stylesheet' media='all'>" +
        "<link href='"+_contextPath+"plugins/layui/css/admin.css' type='text/css' rel='stylesheet' media='all'>";
    var strFormHtml=strStyleCSS+"<body>"+html+"</body>";
    LODOP.ADD_PRINT_HTM(0,0,"100%","100%",strFormHtml);
};