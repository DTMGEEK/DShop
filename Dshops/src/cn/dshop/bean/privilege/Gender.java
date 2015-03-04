package cn.dshop.bean.privilege;

public enum Gender {
	
	MAN
 {
		@Override
		public String getName() {

			return "男";
		}
	},
	WOMAN {
		@Override
		public String getName() {

			return "女";
		}
	};
	
	public abstract String getName();

}
