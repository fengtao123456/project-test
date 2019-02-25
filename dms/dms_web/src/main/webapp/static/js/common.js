// v当前值
// r当前行
// i当前索引
function stateFormatter(v,r,i) {

    if(v==0){
        return "<font style='color:blue'>正常</font>"
    }
    else{
        return "<font style='color:red'>停用</font>"
    }
}


function objFormatter(v,r,i) {

    //判断null manager.username/realName parent.name
    if(v){
        //或者的短路行为
        return v.name || v.username || v.realName || v.title;
    }
}

//扩展juery插件
$.fn.serializeJson = function ()
{
    var paramArray =$(this).serializeArray();
    var paramObj = {};
    $.each(paramArray,function (index, obj) {

        var attrName = obj.name;
        var attrVal = obj.value;
        paramObj[attrName] = attrVal;
    })
    return paramObj;
}

function arrayFormatter(v,r,i) {
    var result = "";
    if(v){
        //v是一个数组
        $.each(v,function (index,obj) {

            //如果不是最后一个都要加上逗号
            if(index == v.length-1 ){
                result += objFormatter(obj)

            }else{
                result += objFormatter(obj)+","
            }

        })
    }
    return result;
}