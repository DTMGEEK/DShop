package cn.dshop.bean.book;

public enum OrderState {
	
	/*取消订单*/
	CANCEL {
		@Override
		public String getName() {
			
			return "已取消订单";
		}
	}, 
	/*待审核订单*/
	WAICONFIRM {
		@Override
		public String getName() {
			
			return "待审核";
		}
	},
	
	/*等待付款*/
	WAITPAYMENT {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "等待付款";
		}
	},
	/*正在配货*/
	ADMEASUREPRODUCT {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "正在配货";
		}
	},
	/*等待发货*/
	WAITDELIVER {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "等待发货";
		}
	},
	/*已经发货*/
	DELIVER {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "已经发货";
		}
	},
	/*已经收货*/
	RECEIVED {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "已经收货";
		}
	};
	
	
	
	public abstract String getName();
	
	

}
