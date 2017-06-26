
	 $.ajax({
			type:"post",
			url:"who_order_getAddress.action",
			success:function(data){
			     
			}
			
		});

		var makers = [];
		var map, geolocation;
		//���ص�ͼ�������������λ����
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
				enableHighAccuracy : true,//�Ƿ�ʹ�ø߾��ȶ�λ��Ĭ��:true
				timeout : 10000, //����10���ֹͣ��λ��Ĭ�ϣ������
				buttonOffset : new AMap.Pixel(10, 20),//��λ��ť�����õ�ͣ��λ�õ�ƫ������Ĭ�ϣ�Pixel(10, 20)
				zoomToAccuracy : true, //��λ�ɹ��������ͼ��Ұ��Χʹ��λλ�ü����ȷ�Χ��Ұ�ڿɼ���Ĭ�ϣ�false
				buttonPosition : 'RB'
			});
			map.addControl(geolocation);
			geolocation.getCurrentPosition();
			AMap.event.addListener(geolocation, 'complete', onComplete);//���ض�λ��Ϣ
			AMap.event.addListener(geolocation, 'error', onError); //���ض�λ������Ϣ
		});

		//��λ����

		var placeSearch;
		AMap.service([ "AMap.PlaceSearch" ], function() {
			placeSearch = new AMap.PlaceSearch({ //����ص��ѯ��
				pageSize : 5,
				pageIndex : 1,
				city : "֣��", //����
				map : map
			//,
			//panel: "panel"
			});
		});
		//�ؼ��ֲ�ѯ
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

		//����� ����

		AMap.plugin([ 'AMap.Autocomplete', 'AMap.PlaceSearch' ], function() {
			var autoOptions = {
				city : "֣��", //���У�Ĭ��ȫ��
				input : "input"//ʹ�����������input��id
			};
			autocomplete = new AMap.Autocomplete(autoOptions);
			AMap.event.addListener(autocomplete, "select", function(e) {
				placeSearch.search(e.poi.name);

			});
		});

		//��λ���
		function onComplete(data) {
			var a = data.position.getLng();
			var b = data.position.getLat();
			var lnglatXY = [ a, b ];

			AMap.plugin('AMap.Geocoder', function() {
					var geocoder = new AMap.Geocoder({
						city : "֣��"//���У�Ĭ�ϣ���ȫ����                                                                                            
					});

					map.remove(makers); //ɾ��makers������marker
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
						map.remove(makers); //ɾ��makers������marker
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
								message.innerHTML = '�޷���ȡλ��';
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
