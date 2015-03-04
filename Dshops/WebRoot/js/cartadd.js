
function getjsoninfo() {
	
        
        var valp = $("#productid").val();
        var val1s = $("#styleid").val();
        $.post("json/shopcart/cartsession.action", { productid: valp, styleid: val1s } ,function callback(json){  
 
                  alert("商品已经添加到购物车");  
 
  
 
});   
}