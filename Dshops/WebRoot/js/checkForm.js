function checkfm(form){
			if (form.brandName.value==""){
				alert("品牌名称不能为空！");
				form.brandName.focus();
				return false;
			}
			var logofile = form.logoimg.value;
			if(logofile!=""){
				var ext = logofile.substring(logofile.length-3).toLowerCase();
				if (ext!="jpg" && ext!="gif" && ext!="bmp" && ext!="png"){
					alert("只允许上传gif、jpg、bmp、png！");
					return false; 
				}
			}
               
			
			return true;
		}





