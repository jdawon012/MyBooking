
public class PlaceDTO {
	private String placeName;
	private String placeType;
	private String placeAdd;
	private String placeTell;
	private String placeImage;
	private String placeBigImage;
	private int placeStar;
	
	PlaceDTO(){
		
	}

	@Override
	public String toString() {
		return "PlaceDTO [placeName=" + placeName + ", placeType=" + placeType + ", placeAdd=" + placeAdd
				+ ", placeTell=" + placeTell + ", placeImage=" + placeImage + ", placeBigImage=" + placeBigImage
				+ ", placeStar=" + placeStar + "]";
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getPlaceAdd() {
		return placeAdd;
	}

	public void setPlaceAdd(String placeAdd) {
		this.placeAdd = placeAdd;
	}

	public String getPlaceTell() {
		return placeTell;
	}

	public void setPlaceTell(String placeTell) {
		this.placeTell = placeTell;
	}

	public String getPlaceImage() {
		return placeImage;
	}

	public void setPlaceImage(String placeImage) {
		this.placeImage = placeImage;
	}

	public String getPlaceBigImage() {
		return placeBigImage;
	}

	public void setPlaceBigImage(String placeBigImage) {
		this.placeBigImage = placeBigImage;
	}

	public int getPlaceStar() {
		return placeStar;
	}

	public void setPlaceStar(int placeStar) {
		this.placeStar = placeStar;
	}
	
	

}
