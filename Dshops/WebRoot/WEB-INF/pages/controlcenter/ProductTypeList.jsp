<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  
         <link rel="stylesheet" href="../css/bginvalid.css" type="text/css" media="screen" />
	  
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="../css/bgreset.css" type="text/css" media="screen" />
		
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="../css/bgliststyle.css" type="text/css" media="screen" />	
        
        <!-- jQuery -->
		<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
		
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="../js/simpla.jquery.configuration.js"></script>
		
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="../js/facebox.js"></script>
		
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="../js/jquery.wysiwyg.js"></script>
		
		<!-- jQuery Datepicker Plugin -->
		<script type="text/javascript" src="../js/jquery.datePicker.js"></script>
		<script type="text/javascript" src="../js/jquery.date.js"></script>
		<!--[if IE]><script type="text/javascript" src="resources/scripts/jquery.bgiframe.js"></script><![endif]-->
        
        <script type="text/javascript">
			jQuery(document).ready(function($) {
			  $('a[rel*=facebox]').facebox() 
			})
		</script>
        
        
        
        
</head>
<body>

<!--弹出增加新父类型  --><div id="addparentdiv" style="display:none">               
				<h3>增加新父类型</h3>
			 
				<form action="#" method="post">
					
					<h4>增加新类型</h4>

					 数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
					<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加新父类型 -->


<div id="tbnav">


            
         </div>   
            
            
     <div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>产品类型列表</h3>
					
					
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
				  <div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
				    <table width="100%">
							
			  <thead>
								<tr>
								
								 
								   <th>Column 2</th>
								   <th>Column 3</th>
								   <th>Column 4</th>
								   <th>Column 5</th>
								</tr>
								
							</thead>
						 
							<tfoot>
								<tr>
									<td colspan="6">
                                       <center>
                                          <div class="pagination">
                                            <a href="#" title="First Page">&laquo; First</a><a href="#" title="Previous Page">&laquo; Previous</a>
                                            <a href="#" class="number" title="1">1</a>
                                            <a href="#" class="number" title="2">2</a>
                                            <a href="#" class="number current" title="3">3</a>
                                            <a href="#" class="number" title="4">4</a>
                                            <a href="#" title="Next Page">Next &raquo;</a><a href="#" title="Last Page">Last &raquo;</a>
                                        </div>
                                         </center> <!-- End .pagination -->
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
						 
							<tbody>
							<s:iterator value="${produtresult}" var="productlist">
								<tr>
									
									<td>${productlist.typeid }</td>
									<td><a href="#" title="title">Sit amet</a></td>
									<td>${productlist.note}</td>
									<td>Donec tortor diam</td>
									<td>
										<!-- Icons -->
										 <a href="#mydiv" title="修改"  rel="facebox" ><img src="../images/icons/pencil.png" alt="修改" /></a>
										 <a href="#deleteconfirmdiv" title="删除" rel="facebox"><img src="../images/icons/cross.png" alt="删除" /></a> 
										 <a href="#addchilderndiv" title="增加子类"  rel="facebox"><img src="../images/icons/hammer_screwdriver.png" alt="增加子类" /></a>
									</td>
								</tr>
								
             <!--弹出修改  --><div id="mydiv" style="display:none">               
				<h3>修改菜单</h3>
			 
				<form action="#" method="post">
					
					<h4>修改菜单</h4>

					 数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
					<input class="button" type="submit" value="提交" />	
                    
				</form>
				
	</div> <!-- End  弹出修改-->
    
    
       <!--弹出确认是否删除菜单  --><div id="deleteconfirmdiv" style="display:none">               
				<h3>是否删除</h3>
			 
				<form action="#" method="post">
					
					<h4>是否删除</h4>

					 数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
					<input class="button" type="submit" value="确定"/>
      			
				</form>
				
	</div> <!-- End 弹出确认是否删除菜单 -->
    
    					
             <!--弹出增加子类  --><div id="addchilderndiv" style="display:none">               
				<h3>增加子类</h3>
			 
				<form action="#" method="post">
					
					<h4>增加子类</h4>

					 父类id<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
                     数据1<input type="text"><br/>
					<input class="button" type="submit" value="提交" />		
				</form>
				
	</div> <!-- End  弹出增加子类-->
								
								
								
								
			</s:iterator>
							
							</tbody>
							
						</table>
                        
					  <p>
                      		 <a href="#addparentdiv" title="修改"  rel="facebox"><img src="../images/icons/paper_content_pencil_48.png" alt="icon" /><br/>
                             
                                   增加新类
                        </a>
       
					  </p>
                  </div> 
					<!-- End #tab1 -->
						
				</div> <!-- End .content-box-content -->
				
			</div>
            
          
</body>
</html>
