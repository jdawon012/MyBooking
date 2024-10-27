
public class MainPlaceDTO {
	private String placeName; // 숙소 이름
	private String placeAdd; // 숙소 주소
	private String placeImage; // 호텔 이미지
	private double placeStar; // 평점?

	public MainPlaceDTO() {

	}

	
	public MainPlaceDTO(String placeName, String placeAdd, String placeImage, double placeStar) {
		super();
		this.placeName = placeName;
		this.placeAdd = placeAdd;
		this.placeImage = placeImage;
		this.placeStar = placeStar;
	}

	
	
	@Override
	public String toString() {
		return "MainPlace_DTO [placeName=" + placeName + ", placeAdd=" + placeAdd + ", placeImage=" + placeImage
				+ ", placeStar=" + placeStar + "]";
	}

	
	
	public String toPlace() {
		String str ="\n "+
					placeName + 
					"\n\n " + 
					placeAdd + 
					"\n  평점 :" + placeStar;
		return str ;
	}
	
	public String toImage() {
		String str= "img/" + placeImage;
		
		return str;
		
		
	}
	
	public String toName() {
		String str= placeName;
		return str;
		
		
	}
	
	
	
	
	
	
	// getter & setter
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceAdd() {
		return placeAdd;
	}

	public void setPlaceAdd(String placeAdd) {
		this.placeAdd = placeAdd;
	}

	public String getPlaceImage() {
		return placeImage;
	}

	public void setPlaceImage(String placeImage) {
		this.placeImage = placeImage;
	}

	public double getPlaceStar() {
		return placeStar;
	}

	public void setPlaceStar(double placeStar) {
		this.placeStar = placeStar;
	}
}
