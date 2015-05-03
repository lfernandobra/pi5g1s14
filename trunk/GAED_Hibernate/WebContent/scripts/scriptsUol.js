(
function(){
    var widgetDate = new Date();
    var widgetScript = document.getElementsByTagName('script')[document.getElementsByTagName('script').length-1];
    var widgetParent = widgetScript.parentNode;
    var counter = 0;
    try {
        eval("var getParam=[];\n"+unescape((widgetScript.src+"&").replace(/.*?\?/,"&").match(/\&*[^\&]*?\=.*?\&/g,"").join(";").replace(/;&/g,";").replace(/^&/g,"getParam['").replace(/&$/,"\";").replace(/=/g,"']=\"").replace(/&;/g,"\";\ngetParam['")));
        var estacao = getParam['estacao'].toUpperCase();
        var skin    = getParam['skin'].toLowerCase();
        var tema    = getParam['tema'].toLowerCase();
    }
    catch (e) {
        if(estacao && skin) {
            var tema = "noticias";
        }
        else {
            var estacao = "ESPORTE";
            var skin    = "1";
        }
    }
    
    if(widgetParent.className=="UOLWidgetsStyle") widgetParent.id = "UOLWidgetsStyle"+estacao+tema+skin;

    var widgetContainer = document.createElement("div");
    widgetParent.insertBefore(widgetContainer, widgetScript);
    
    widgetSite = location.href;
    
    document.write('<script src="http://widgets.uol.com.br/UolWidgetsConfig'+estacao+'.js?ts='+widgetDate.getTime()+'" type="text/javascript"></script>');

    var isLoad = setInterval(function(){
        try {
            counter += 1;
            widgetContainer.innerHTML = eval('UolWidgetsConfig'+estacao+'[tema][skin]');
            clearInterval(isLoad);
        }
        catch (e) {
            if(counter>5) { // 3 seconds timeout
                widgetContainer.innerHTML = '<iframe src="http://noticias.uol.com.br/ultnot/primeirapagina-noticias.jhtm?first=noticias" width="160" height="376" frameborder="0" border="0" scrolling="no"></iframe>';
                clearInterval(isLoad);
            }
            else {
                return;
            }
         }
    },500);
}
)();

