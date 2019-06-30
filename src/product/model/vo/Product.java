package product.model.vo;

public class Product implements java.io.Serializable {
	private static final long serialVersionUID = 100L;
	
	public Product() {}

	private String productNum;
	private String productName;
	private int productListNo;
	private String rProduct;
	private String country;
	private String destination;
	private String destinationInfo;
	private String touristSpot1;
	private String touristSpot1Info;
	private String touristSpot2;
	private String touristSpot2Info;
	private String touristSpot3;
	private String touristSpot3Info;
	private String oBannerImage1;
	private String rBannerImage1;
	private String oBannerImage2;
	private String rBannerImage2;
	private String oBannerImage3;
	private String rBannerImage3;
	private String oDestinationImage;
	private String rDestinationImage;
	private String oTouristImage1;
	private String rTouristImage1;
	private String oTouristImage2;
	private String rTouristImage2;
	private String oTouristImage3;
	private String rTouristImage3;
	
	public Product(String productNum, String productName, int productListNo, String rProduct, String country,
			String destination, String destinationInfo, String touristSpot1, String touristSpot1Info,
			String touristSpot2, String touristSpot2Info, String touristSpot3, String touristSpot3Info,
			String oBannerImage1, String rBannerImage1, String oBannerImage2, String rBannerImage2,
			String oBannerImage3, String rBannerImage3, String oDestinationImage, String rDestinationImage,
			String oTouristImage1, String rTouristImage1, String oTouristImage2, String rTouristImage2,
			String oTouristImage3, String rTouristImage3) {
		super();
		this.productNum = productNum;
		this.productName = productName;
		this.productListNo = productListNo;
		this.rProduct = rProduct;
		this.country = country;
		this.destination = destination;
		this.destinationInfo = destinationInfo;
		this.touristSpot1 = touristSpot1;
		this.touristSpot1Info = touristSpot1Info;
		this.touristSpot2 = touristSpot2;
		this.touristSpot2Info = touristSpot2Info;
		this.touristSpot3 = touristSpot3;
		this.touristSpot3Info = touristSpot3Info;
		this.oBannerImage1 = oBannerImage1;
		this.rBannerImage1 = rBannerImage1;
		this.oBannerImage2 = oBannerImage2;
		this.rBannerImage2 = rBannerImage2;
		this.oBannerImage3 = oBannerImage3;
		this.rBannerImage3 = rBannerImage3;
		this.oDestinationImage = oDestinationImage;
		this.rDestinationImage = rDestinationImage;
		this.oTouristImage1 = oTouristImage1;
		this.rTouristImage1 = rTouristImage1;
		this.oTouristImage2 = oTouristImage2;
		this.rTouristImage2 = rTouristImage2;
		this.oTouristImage3 = oTouristImage3;
		this.rTouristImage3 = rTouristImage3;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductListNo() {
		return productListNo;
	}

	public void setProductListNo(int productListNo) {
		this.productListNo = productListNo;
	}

	public String getrProduct() {
		return rProduct;
	}

	public void setrProduct(String rProduct) {
		this.rProduct = rProduct;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestinationInfo() {
		return destinationInfo;
	}

	public void setDestinationInfo(String destinationInfo) {
		this.destinationInfo = destinationInfo;
	}

	public String getTouristSpot1() {
		return touristSpot1;
	}

	public void setTouristSpot1(String touristSpot1) {
		this.touristSpot1 = touristSpot1;
	}

	public String getTouristSpot1Info() {
		return touristSpot1Info;
	}

	public void setTouristSpot1Info(String touristSpot1Info) {
		this.touristSpot1Info = touristSpot1Info;
	}

	public String getTouristSpot2() {
		return touristSpot2;
	}

	public void setTouristSpot2(String touristSpot2) {
		this.touristSpot2 = touristSpot2;
	}

	public String getTouristSpot2Info() {
		return touristSpot2Info;
	}

	public void setTouristSpot2Info(String touristSpot2Info) {
		this.touristSpot2Info = touristSpot2Info;
	}

	public String getTouristSpot3() {
		return touristSpot3;
	}

	public void setTouristSpot3(String touristSpot3) {
		this.touristSpot3 = touristSpot3;
	}

	public String getTouristSpot3Info() {
		return touristSpot3Info;
	}

	public void setTouristSpot3Info(String touristSpot3Info) {
		this.touristSpot3Info = touristSpot3Info;
	}

	public String getoBannerImage1() {
		return oBannerImage1;
	}

	public void setoBannerImage1(String oBannerImage1) {
		this.oBannerImage1 = oBannerImage1;
	}

	public String getrBannerImage1() {
		return rBannerImage1;
	}

	public void setrBannerImage1(String rBannerImage1) {
		this.rBannerImage1 = rBannerImage1;
	}

	public String getoBannerImage2() {
		return oBannerImage2;
	}

	public void setoBannerImage2(String oBannerImage2) {
		this.oBannerImage2 = oBannerImage2;
	}

	public String getrBannerImage2() {
		return rBannerImage2;
	}

	public void setrBannerImage2(String rBannerImage2) {
		this.rBannerImage2 = rBannerImage2;
	}

	public String getoBannerImage3() {
		return oBannerImage3;
	}

	public void setoBannerImage3(String oBannerImage3) {
		this.oBannerImage3 = oBannerImage3;
	}

	public String getrBannerImage3() {
		return rBannerImage3;
	}

	public void setrBannerImage3(String rBannerImage3) {
		this.rBannerImage3 = rBannerImage3;
	}

	public String getoDestinationImage() {
		return oDestinationImage;
	}

	public void setoDestinationImage(String oDestinationImage) {
		this.oDestinationImage = oDestinationImage;
	}

	public String getrDestinationImage() {
		return rDestinationImage;
	}

	public void setrDestinationImage(String rDestinationImage) {
		this.rDestinationImage = rDestinationImage;
	}

	public String getoTouristImage1() {
		return oTouristImage1;
	}

	public void setoTouristImage1(String oTouristImage1) {
		this.oTouristImage1 = oTouristImage1;
	}

	public String getrTouristImage1() {
		return rTouristImage1;
	}

	public void setrTouristImage1(String rTouristImage1) {
		this.rTouristImage1 = rTouristImage1;
	}

	public String getoTouristImage2() {
		return oTouristImage2;
	}

	public void setoTouristImage2(String oTouristImage2) {
		this.oTouristImage2 = oTouristImage2;
	}

	public String getrTouristImage2() {
		return rTouristImage2;
	}

	public void setrTouristImage2(String rTouristImage2) {
		this.rTouristImage2 = rTouristImage2;
	}

	public String getoTouristImage3() {
		return oTouristImage3;
	}

	public void setoTouristImage3(String oTouristImage3) {
		this.oTouristImage3 = oTouristImage3;
	}

	public String getrTouristImage3() {
		return rTouristImage3;
	}

	public void setrTouristImage3(String rTouristImage3) {
		this.rTouristImage3 = rTouristImage3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return this.productNum + ", " + this.productName + ", " + this.productListNo + ", " + this.rProduct + ", " + this.country + ", " + this.destination + ", " + this.destinationInfo
				+ ", " + this.touristSpot1 + ", " + this.touristSpot1Info + ", " + this.touristSpot2 + ", " + this.touristSpot2Info + ", " + this.touristSpot3 + ", " + this.touristSpot3Info
				+ ", " + this.oBannerImage1 + ", " + this.rBannerImage1 + ", " + this.oBannerImage2 + ", " + this.rBannerImage2 + ", " + this.oBannerImage3 + ", " + this.rBannerImage3
				 + ", " + this.oDestinationImage + ", " + this.rDestinationImage + ", " + this.oTouristImage1 + ", " + this.rTouristImage1 + ", " + this.oTouristImage2 + ", " + this.rTouristImage2 + ", " + this.oTouristImage3 + ", " + this.rTouristImage3;
	}
}
