$(function () {
    $("#submitPhone").bind('click',function(){
        var phone=$("#phoneNumber").val();
        // console.debug(phone)
        // $.ajaxSettings.async = false;
        $.post("cxf/phone",{phoneNumber:phone},function(data){
            // console.debug(data);
            // var $data = $.parseJSON(data);
            // console.debug(data+"z")
            if(data.success){
                $.messager.alert('提示',data.msg,'info');
            }else{
                $.messager.alert('错误提示',data.msg,'error');
            }
        },"json");
    })
})