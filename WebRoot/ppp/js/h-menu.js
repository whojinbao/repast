window.onload=function(){ 
	var flag_hh=-1;
  /*
  *��Ʒ�ܼ�
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
	*������log��ʾ
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
   *�������˵�
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
			$("#menuDetails_son").append("<div><span class='menuDetails_span'>"+name1+"</span><input type='button' class='menuDetails_sub' value='-'/> <input class='menuDetails_txt' type='text'value='"+value2+"'/> <input type='button' class='menuDetails_add' value='+' /><span style='color:red'>&nbsp;&nbsp;&nbsp;��</span><span class='menuDetails_prices'>"+num3*value2+"</span><input class='menuDetails_delete' type='button' value='ɾ��'/></div>");	
		}
   }
   /*
   *�˵��������¼�
   *js����div��̬����¼�
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
   *�˵��������¼�
   *js����div��̬����¼�
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
   *�˵�ɾ���¼�
   *js����div��̬����¼�
   */
   $("#menuDetails_son").on("click",'.menuDetails_delete',function(){
	  
		   $(this).parent().remove();
		   lognum();
	  
	})
	
   /*
   * ����˵���click�¼�����
   */
   $(".putIn").click(function(){
		if(flag_hh==1){
			alert('�Ӳ��һ�û������');
			return;}
		var flog=0;
		var wh=document.body.clientHeight;								 //��ȡ��ǰ���ڸ߶�
		var ww=document.body.clientWidth;								//��ȡ��ǰ���ڿ��
		var tt= parseInt($(this).offset().top-$(window).scrollTop());	//����input����Ӵ��ڸ߶ȵľ���
		var ll=parseInt(ww-$(this).offset().left-310);                   //���㵱ǰ�����input���·�div�Ŀ�Ȳ�
		var aa=wh-tt-70;												//���㵱ǰ�����input���·�div�ĸ߶Ȳ�
		var index1=$(this).parent().parent().find(".product_ipt").val()*1; //��ȡinput valueֵ
		var Prices=$(this).parent().parent().parent().find(".name span").html()*1;  //��ȡ��Ʒ�۸�
		var  name1=$(this).parent().parent().parent().find(".name strong").html();               //��ȡ��Ʒ����
		addmenu(name1,index1,Prices);															//���ü���˵�����
		var num,index;
		function statc(){
			num = Math.floor(Math.random() * 3 + 1);					//0-1֮�������*3+1���������� numֵΪ1,2,3
			index=$('.hah').children('img').length;						//demo ���ӽڵ�img�ĸ���0��1,2,3,4,5
			$(".hah").append("<img class='img123654789'src=''>");		//demo������һ��img
			$('.hah img:eq(' + index + ')').attr('src','images/'+num+'.png') //�������һ��img
			if(ll>0){														//������img���о��Զ�λ
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
   *��Ʒ��������
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
		*��Ʒ��������
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
	*�˵�����ر�
	*/
	$("#menuDetails .menuDetails_close").click(
		function(){
			$("#menuDetails").css("display","none");
		}	
		)
		/*
		*�˵����鿪��
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
	*��չ��ﳵ
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
	*�ѵ��Ʒ����	
	*/
	$("#menuDetails_submit1_submit ").click(function(){
			var index=$("#menuDetails_son").children('div').length;	
			if (index>0)
			{
			   alert('�ύ�ɹ�');
			   $("#menuDetails").css("display","none");
			   $("#menuDetailsShow").css("display","block");
			}else{
				alert('�˵���������Ϊ��');
				return;
			}
			for (var i=0;i<index ;i++ )
			{   
				var a=$('#menuDetails_son div:eq('+i+')').find(".menuDetails_span").html();
				var b=$('#menuDetails_son div:eq('+i+')').find(".menuDetails_txt").val()*1;
				var c=$('#menuDetails_son div:eq('+i+')').find(".menuDetails_prices").html()*1;
				$("#menuDetailsShow_son").append("<div><span class='menuDetails_span'>"+a+"</span><span class='menuDetails_txt'>"+b+"</span><span style='color:red'>��</span><span class='menuDetails_prices'>"+c+"</span></div>");	
	
			}
			flag_hh=1;
			
	})
		/*
	*�ѵ�˵�����ر�
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