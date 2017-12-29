
public class LocationOutOfBounds extends RuntimeException {
	String message;

	public LocationOutOfBounds(String Message) {
		super(Message);
		this.message = Message;
	}

}
