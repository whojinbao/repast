window.onload=function(){ 
	var flag_hh=-1;
  /*
  *菜品总价
  */
  function bottomPrices(){
		var index=$("#menuDetails_son").children('div').length;	
			var sumNum=0;
			for (var i=0;i<index ;i++ )
			{
				var num=$('#menuDetails_son div:eq(' + i + ')').find(".menuDetails_prices").html()*1;
				sumNum+=num;
			}	
			$("#master_memu_bottom_prices span").html(sumNum);
			$("#menuDetails_details_price_num").html(sumNum);
			$("#menuDetails_details_price_num1").html(sumNum);
  }
		
	/*
	*总数量log显示
	*/
    function lognum(){
			var index=$("#menuDetails_son").children('div').length;	
			var logNum=0;
			for (var i=0;i<index ;i++ )
			{
				var num=$('#menuDetails_son div:eq(' + i + ')').find(".menuDetails_txt").val()*1;
				logNum+=num;
			}	
			$('#master_memu_bottom_lognum').html(logNum);
			$('#menuDetails_details_num').html(logNum);
			$('#menuDetails_details_num1').html(logNum);
			if(logNum>0){
				$('#master_memu_bottom_lognum').css("display","block");
			}else{
				$('#master_memu_bottom_lognum').css("display","none");
			}
			bottomPrices();
	}
   /*
   *点击加入菜单
   */
   function addmenu(name1,value2,num3){
		var index=$("#menuDetails_son").children('div').length;	
		var flog=0;
		for (var i=0;i<index ;i++ )
		{
				var name=$('#menuDetails_son div:eq(' + i + ')').find(".menuDetails_span").html();
				if(name1==name){
					flog=1;
					var aa=$('#menuDetails_son div:eq(' + i + ')').find(".menuDetails_txt").val()*1;
					aa += value2;
					var bb;
					bb=aa*num3;
					$('#menuDetails_son div:eq(' + i + ')').find(".menuDetails_txt").val(aa);
					$('#menuDetails_son div:eq(' + i + ')').find(".menuDetails_prices").html(bb);
					break;
				}
		}
		if(flog==0){
			$("#menuDetails_son").append("<div><span class='menuDetails_span'>"+name1+"</span><input type='button' class='menuDetails_sub' value='-'/> <input class='menuDetails_txt' type='text'value='"+value2+"'/> <input type='button' class='menuDetails_add' value='+' /><span style='color:red'>&nbsp;&nbsp;&nbsp;￥</span><span class='menuDetails_prices'>"+num3*value2+"</span><input class='menuDetails_delete' type='button' value='删除'/></div>");	
		}
   }
   /*
   *菜单减数量事件
   *js生产div动态添加事件
   */
   $("#menuDetails_son").on("click",'.menuDetails_sub',function(){
	   var num=$(this).parent().find(".menuDetails_txt").val()*1;
	   var num1=$(this).parent().find(".menuDetails_prices").html()*1;
	   if (num==1)
	   {
		   $(this).parent().remove();
	   }else{
			var  num3=num1/num;
			num--;
			num1=num3*num;
			$(this).parent().find(".menuDetails_txt").val(num);
			$(this).parent().find(".menuDetails_prices").html(num1);
	   }
	   lognum();
	})
   /*
   *菜单加数量事件
   *js生产div动态添加事件
   */
   $("#menuDetails_son").on("click",'.menuDetails_add',function(){
	   var num=$(this).parent().find(".menuDetails_txt").val()*1;
	   var num1=$(this).parent().find(".menuDetails_prices").html()*1;
		var  num3=num1/num;
		num++;
		num1=num3*num;
		$(this).parent().find(".menuDetails_txt").val(num);
		$(this).parent().find(".menuDetails_prices").html(num1);
		lognum();
	})
	 /*
   *菜单删除事件
   *js生产div动态添加事件
   */
   $("#menuDetails_son").on("click",'.menuDetails_delete',function(){
	  
		   $(this).parent().remove();
		   lognum();
	  
	})
	
   /*
   * 加入菜单总click事件函数
   */
   $(".putIn").click(function(){
		if(flag_hh==1){
			alert('加菜我还没做！！');
			return;}
		var flog=0;
		var wh=document.body.clientHeight;								 //获取当前窗口高度
		var ww=document.body.clientWidth;								//获取当前窗口宽度
		var tt= parseInt($(this).offset().top-$(window).scrollTop());	//计算input与可视窗口高度的距离
		var ll=parseInt(ww-$(this).offset().left-310);                   //计算当前点击的input与下方div的宽度差
		var aa=wh-tt-70;												//计算当前点击的input与下方div的高度差
		var index1=$(this).parent().parent().find(".product_ipt").val()*1; //获取input value值
		var Prices=$(this).parent().parent().parent().find(".name span").html()*1;  //获取菜品价格
		var  name1=$(this).parent().parent().parent().find(".name strong").html();               //获取菜品名字
		addmenu(name1,index1,Prices);															//调用加入菜单函数
		var num,index;
		function statc(){
			num = Math.floor(Math.random() * 3 + 1);					//0-1之间随机数*3+1进行下舍入 num值为1,2,3
			index=$('.hah').children('img').length;						//demo 下子节点img的个数0，1,2,3,4,5
			$(".hah").append("<img class='img123654789'src=''>");		//demo下增加一个img
			$('.hah img:eq(' + index + ')').attr('src','images/'+num+'.png') //随机创建一个img
			if(ll>0){														//创建的img进行绝对定位
				$('.hah img:eq(' + index + ')').css({'position':'absolute','bottom':aa+"px",'left':'-'+ll+'px'});
			}else{
				ll *= -1;
				flog=1;
				$('.hah img:eq(' + index + ')').css({'position':'absolute','bottom':aa+"px",'left':ll+'px'});
			}
			if (flog==1)
			{
				ll*=-1;
				flog=0;
			}
			$(".hah img").animate({
				bottom:"-30px",
				opacity:"1",
				left: "20px",
			},1800);
			index1--;
			if(index1==0){
				clearInterval(dds);
				lognum();
				bottomPrices();
				return;
			}
		}
		var dds=setInterval(statc, 30);
		
   })  
 /*
   *菜品数量增加
   */
		$(".add .product_add").click(
			function(){	
				var i=0;
				var a=$(this).parent().parent().find(".product_ipt").val()*1;
				if(a>0){
					i=a;
				}
				i++;
				$(this).parent().parent().find(".product_ipt").val(i);
			}
		)
		/*
		*菜品数量减少
		*/
		$(".add .product_sub").click(
			function(){	
				var a=$(this).parent().parent().find(".product_ipt").val()*1;
				if(a>1){
					a--;
					$(this).parent().parent().find(".product_ipt").val(a);
				}
			}
		)
	/*
	*菜单详情关闭
	*/
	$("#menuDetails .menuDetails_close").click(
		function(){
			$("#menuDetails").css("display","none");
		}	
		)
		/*
		*菜单详情开启
		*/
	$("#master_memu_bottom").click(
		function(){
		var index=$("#menuDetails_son").children('div').length;	
		var index1=$("#menuDetailsShow_son").children('div').length;	
		if(index==0){
			return;
		}
		$("#menuDetails").css("display","block");
		if(index1>0){
			$("#menuDetails").css("display","none");
			$("#menuDetailsShow").css("display","block");
		}
		
	})
	/*
	*清空购物车
	*/
	$("#menuDetails_submit1_delete").click(function(){
			var index=$("#menuDetails_son").children('div').length;	
			for (var i=0;i<index ;i++ )
			{
					 $('#menuDetails_son div:eq(0)').remove();
					 $("#menuDetails").css("display","none");
					 lognum();
					 bottomPrices();
			}
			
	})
			/*
	*已点餐品详情	
	*/
	$("#menuDetails_submit1_submit ").click(function(){
			var index=$("#menuDetails_son").children('div').length;	
			if (index>0)
			{
			   alert('提交成功');
			   $("#menuDetails").css("display","none");
			   $("#menuDetailsShow").css("display","block");
			}else{
				alert('菜单数量不能为零');
				return;
			}
			for (var i=0;i<index ;i++ )
			{   
				var a=$('#menuDetails_son div:eq('+i+')').find(".menuDetails_span").html();
				var b=$('#menuDetails_son div:eq('+i+')').find(".menuDetails_txt").val()*1;
				var c=$('#menuDetails_son div:eq('+i+')').find(".menuDetails_prices").html()*1;
				$("#menuDetailsShow_son").append("<div><span class='menuDetails_span'>"+a+"</span><span class='menuDetails_txt'>"+b+"</span><span style='color:red'>￥</span><span class='menuDetails_prices'>"+c+"</span></div>");	
	
			}
			flag_hh=1;
			
	})
		/*
	*已点菜单详情关闭
	*/
	$("#menuDetailsShow_close").click(
		function(){
			   $("#menuDetailsShow").css("display","none");
		}	
		)


	

	$(function(){
	$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
	$(".leftsidebar_box dt img").attr("src","images/select_xl01.png");
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
		$(this).css({"background-color": "#317eb4"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","images/select_xl01.png");
		$(this).parent().find('img').attr("src","images/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
})
	
	







}