package kr.pe.tippingpoint.vo;

public class TpProjectCategory {
	private String tppCategory;
	private String tppCategoryName;
	public TpProjectCategory() {
		super();
	}
	public TpProjectCategory(String tppCategory, String tppCategoryName) {
		super();
		this.tppCategory = tppCategory;
		this.tppCategoryName = tppCategoryName;
	}
	public String getTppCategory() {
		return tppCategory;
	}
	public void setTppCategory(String tppCategory) {
		this.tppCategory = tppCategory;
	}
	public String getTppCategoryName() {
		return tppCategoryName;
	}
	public void setTppCategoryName(String tppCategoryName) {
		this.tppCategoryName = tppCategoryName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tppCategory == null) ? 0 : tppCategory.hashCode());
		result = prime * result + ((tppCategoryName == null) ? 0 : tppCategoryName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TpProjectCategory other = (TpProjectCategory) obj;
		if (tppCategory == null) {
			if (other.tppCategory != null)
				return false;
		} else if (!tppCategory.equals(other.tppCategory))
			return false;
		if (tppCategoryName == null) {
			if (other.tppCategoryName != null)
				return false;
		} else if (!tppCategoryName.equals(other.tppCategoryName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "tpProjectCategory [tppCategory=" + tppCategory + ", tppCategoryName=" + tppCategoryName + "]";
	}
	
	
}
