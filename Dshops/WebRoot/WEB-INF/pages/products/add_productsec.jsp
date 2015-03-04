<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加新产品</title>
<link rel="stylesheet" href="/css/sheet.css" type="text/css">
<script src="jquery-1.5.2.js"></script>
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>

<script type="text/javascript" src="/js/jscripts/tiny_mce/tiny_mce.js"></script>
<script language="javascript" type="text/javascript">
tinyMCE.init({
	language : "zh_cn",
	mode : "textareas",
	theme : "advanced",
	plugins : "table,advhr,advimage,advlink,emotions,iespell,insertdatetime,preview,zoom,flash,searchreplace,print,contextmenu",	
	theme_advanced_buttons1_add : "fontsizeselect",
	theme_advanced_buttons2_add : "separator,insertdate,inserttime,preview,zoom,separator,forecolor",
	theme_advanced_buttons3_add : "emotions,iespell,flash,advhr,separator,print",
	theme_advanced_toolbar_location : "top",
	theme_advanced_toolbar_align : "left",
	theme_advanced_path_location : "bottom",
	plugin_insertdate_dateFormat : "%Y-%m-%d",
	plugin_insertdate_timeFormat : "%H:%M:%S",
	extended_valid_elements : "a[name|href|target|title|onclick],img[class|src|border=0|alt|title|hspace|vspace|width|height|align|onmouseover|onmouseout|name],hr[class|width|size|noshade],font[face|size|color|style],span[class|align|style]",
	external_link_list_url : "example_data/example_link_list.js",
	external_image_list_url : "example_data/example_image_list.js",
	flash_external_list_url : "example_data/example_flash_list.js"
});

function Formfield(name, label){
	this.name=name;
	this.label=label;
}
function verifyForm(objForm){
	tinyMCE.triggerSave();//手动把iframe的值赋给textarea表单元素
	var list  = new Array(new Formfield(document.forms.elements["productinfobean.name"].value, "产品名称"),new Formfield("typeid", "产品类型"),
	new Formfield("productinfobean.baseprice", "产品底价"),new Formfield("productinfobean.marketprice", "产品市场价")
	,new Formfield("productinfobean.sellprice", "产品销售价"),new Formfield("productinfobean.buyeexplain", "产品描述"),
	new Formfield("productinfobean.stylename", "产品图片的样式"),new Formfield("productimg", "产品图片"));
	for(var i=0;i<list.length;i++){
		var objfield = list[i];
		if(objfield==""){
			alert(list[i].label+ "不能为空");
			if(objfield.type!="hidden" && objfield.focus()) objfield.focus();
			return false;
		}
	}
	var imagefile = objForm.imagefile.value;
	var ext = imagefile.substring(imagefile.length-3).toLowerCase();
	if (ext!="jpg" && ext!="gif" && ext!="bmp" && ext!="png"){
		alert("只允许上传gif、jpg、bmp、png！");
		return false; 
	}
    return true;
}
function SureSubmit(objForm){
	if (verifyForm(objForm)) objForm.submit();
} 
</script>    


<script>

$(function(){
		   $("div").click(function(){
		   $(this).addClass("select");		
    });
})
</script>


</head>

<body>




<div class="exlist">
    <div class="exlist_title"><img src="/images/paper-clip.png" /></div>
       <div id="title"><h1>新产品信息</h1></div> 
       <form name="forms" method="post" action="${pageContext.request.contextPath}/control/product/dealproduct_addProduct" enctype="multipart/form-data">
              <input id="typeid" type="hidden" name="typeid" >
              <input type="hidden" name="page" value=""/>
           <fieldset>
           <legend>基本信息</legend>
                   <div class="row">
                   <label>1. 产品名称:</label>
                   <input style="width:100px" class="txt" type="text"  maxlength="40" name="productinfobean.name"  />
                   <label>2. 产品类别 :</label><input class="txt" type="text"  name="v_type_name"  disabled="true"/> <input   type="button" name="select" value="选择..." onClick="javaScript:winOpen('<s:url action="selecttypere" namespace="/control/product"/>','列表',600,400)">
                   
                   </div>
                   <div class="row">
                   <label>3. 货号 :</label><input class="txt" type="text"  maxlength="30" name="productinfobean.code" />
                   </div>
                   <div class="row">
                   <label>4. 型号   :</label><input class="txt" style="width:400px"  maxlength="30"  type="text" name="productinfobean.model" />
                   </div>
           </fieldset>
           <fieldset>
           <legend>详细信息</legend>
                   <div class="row">
                   <label>1. 底价:</label>
                   <input style="width:100px" class="txt" type="text"  maxlength="10" onkeypress="javascript:InputLongNumberCheck()" name="productinfobean.baseprice" />
                   <label>2. 销售价:</label>
                     <input style="width:100px" class="txt" type="text"  maxlength="10" onkeypress="javascript:InputLongNumberCheck()" name="productinfobean.sellprice"   />
                   </div>
                   <div class="row">
                   <label>3. 市场价:</label>
                     <input style="width:100px" class="txt" type="text"  maxlength="10" onkeypress="javascript:InputLongNumberCheck()"  name="productinfobean.marketprice"  />
                   </div>
                  
                   <div class="row">
                   <label>4. 产品重量 (单位:克):</label><input class="txt" type="text"  maxlength="10" onkeypress="javascript:InputIntNumberCheck()" name="productinfobean.weight" />
                   </div>
                   <div class="row">
                   <label>5. 产品样式名称:</label><input class="txt" style="width:400px"  type="text" name="productinfobean.stylename"  />
                   </div>
           </fieldset>
           <fieldset>
           <legend>产品描述</legend>
                   <div class="row">
                  <label>1. 产品图片:</label><input class="txt" style="width:400px"  type="file" name="productimg"/><br/>
                 
                   </div>
                   <div class="row">
                         <label>2.品牌 </label>
                             <select name="productinfobean.brandid" >
									               <c:forEach items="${brands}" var="brandvalue"></tr>
									                   <option value="${brandvalue.code}" label="${brandvalue.name}">${brandvalue.name}</option>
									           	    </c:forEach>					           	          
					                 </select>  
                   </div>
                   <div class="row">
                   <label>3. 购买说明:</label>
                      <input class="txt" style="width:400px"  type="text"  maxlength="30" name="productinfobean.buyeexplain"  />
                                               
                   </div>
             <div class="row">
               <label>4. 产品简介:</label>
                   <center>
                     <textarea  cols="70" rows="20" name="productinfobean.description"></textarea>
                   </center>
               </div>
           </fieldset>
            <center>
             <input type="submit" name="Add" value=" 确 认 "  >
             <input type="button" name="Button" value=" 返 回 " class="frm_btn" onclick="javascript:history.back()">
          </center>
        </form>
        
</div>
</body>
</html>
