package cn.dshop.bean.book;


/**
 * 送货方式
 * @author Administrator
 *
 */
public enum DeliverWay {
	/*平邮*/
	GENERALPOST {
		@Override
		public String getName() {
		
			return "平邮";
		}
	},
	
	/*快递送货上门*/
	EXPRESSDELIVERY {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "快递送货上门";
		}
	},
	
	/*加急快递送货上门*/
	EXIGENCEEXPRESSDELIVERY {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "加急快递送货上门";
		}
	},
	
	/*国内快递EMS*/
	EMS {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "国内快递EMS";
		}
	};
	
	public abstract String getName();
	
	
	

}
