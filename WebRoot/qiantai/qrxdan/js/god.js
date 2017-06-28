
	 $.ajax({
			type:"post",
			url:"who_order_getAddress.action",
			success:function(data){
			     
			}
			
		});

		var makers = [];
		var map, geolocation;
		//加载地图，调用浏览器定位服务
		var map = new AMap.Map('container',{
});
AMap.plugin(['AMap.Scale','AMap.OverView'],
    function(){
        map.addControl(new AMap.ToolBar());

        map.addControl(new AMap.Scale());

        map.addControl(new AMap.OverView({isOpen:true}));
});

		map.plugin('AMap.Geolocation', function() {
			geolocation = new AMap.Geolocation({
				enableHighAccuracy : true,//是否使用高精度定位，默认:true
				timeout : 10000, //超过10秒后停止定位，默认：无穷大
				buttonOffset : new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
				zoomToAccuracy : true, //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
				buttonPosition : 'RB'
			});
			map.addControl(geolocation);
			geolocation.getCurrentPosition();
			AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
			AMap.event.addListener(geolocation, 'error', onError); //返回定位出错信息
		});

		//定位结束

		var placeSearch;
		AMap.service([ "AMap.PlaceSearch" ], function() {
			placeSearch = new AMap.PlaceSearch({ //构造地点查询类
				pageSize : 5,
				pageIndex : 1,
				city : "郑州", //城市
				map : map
			//,
			//panel: "panel"
			});
		});
		//关键字查询
		function hah() {
			var vaule = document.getElementById('input').value;
			placeSearch.search(vaule, function(status, result) {
			});
		}
		function showMsg() {
			var keycode = event.keyCode;
			if (keycode == 13) {
				hah();
			}
		}

		//输入框 联想

		AMap.plugin([ 'AMap.Autocomplete', 'AMap.PlaceSearch' ], function() {
			var autoOptions = {
				city : "郑州", //城市，默认全国
				input : "input"//使用联想输入的input的id
			};
			autocomplete = new AMap.Autocomplete(autoOptions);
			AMap.event.addListener(autocomplete, "select", function(e) {
				placeSearch.search(e.poi.name);

			});
		});

		//定位输出
		function onComplete(data) {
			var a = data.position.getLng();
			var b = data.position.getLat();
			var lnglatXY = [ a, b ];

			AMap.plugin('AMap.Geocoder', function() {
					var geocoder = new AMap.Geocoder({
						city : "郑州"//城市，默认：“全国”                                                                                            
					});

					map.remove(makers); //删除makers中所有marker
					makers = [];

					var marker1 = new AMap.Marker({
						map : map,
						bubble : true,
						position : lnglatXY
					});

					makers.push(marker1);

					geocoder.getAddress(lnglatXY, function(status, result) {
						$("#message").val(result.regeocode.formattedAddress);
					});

					var input = document.getElementById('input');
					var message = document.getElementById('message');

					map.on('click', function(e) {
						map.remove(makers); //删除makers中所有marker
						makers = [];

						var marker2 = new AMap.Marker({
							map : map,
							bubble : true
						});

						marker2.setPosition(e.lnglat);
						makers.push(marker2);

						geocoder.getAddress(e.lnglat, function(status, result) {
							message.value = result.regeocode.formattedAddress;
							message.innerHTML = '';
						});

					});

					input.onchange = function(e) {
						var address = input.value;
						geocoder.getLocation(address, function(status, result) {
							if (status == 'complete' && result.geocodes.length) {
								marker.setPosition(result.geocodes[0].location);
								map.setCenter(marker.getPosition());
								message.innerHTML = '';
							} else {
								message.innerHTML = '无法获取位置';
							}
						});
					};

					AMap.event.addListener(placeSearch, "markerClick", function(e) {
							var LngLat = [ e.data.location.lng, e.data.location.lat ];
							map.remove(makers);
							makers = [];
							var marker = new AMap.Marker({
								map : map,
								bubble : true
							});

							marker.setPosition(LngLat);
							makers.push(marker);
							geocoder.getAddress(LngLat, function(status, result) {
								$("#message").val(result.regeocode.formattedAddress);
							});

					});

			
		});

	}

		$("#btn").click(function() {
			var marker = makers[0];
			var LngLat = marker.getPosition();
			var Lng = LngLat.getLng();
			var Lat = LngLat.getLat();
			$.ajax({
 	 			type:"post",
 	 			url:"who_order_saveAddress.action",
 	 			data:{ads:$("#message").val()},
 	 			datatype:"json",
 	 			success:function(data){
 	 			            window.location.href = 'http://localhost:8080/repast/qiantai/qrxdan/xiadan.jsp';
 	 			}
 	 			
 	 		});
			
		});
