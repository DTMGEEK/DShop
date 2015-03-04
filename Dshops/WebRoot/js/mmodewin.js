		$.setupJMPopups({
					screenLockerBackground: "#003366",
					screenLockerOpacity: "0.7"
				});

			
				function openLogoPopup() {
					$.openPopupLayer({
						name: "mySecondPopup",
						width: 300,
						url: "/buyer/list/faceboxlogin"
					});
				}