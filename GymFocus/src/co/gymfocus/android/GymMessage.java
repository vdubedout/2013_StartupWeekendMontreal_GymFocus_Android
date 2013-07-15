package co.gymfocus.android;

public class GymMessage {
	public enum Type{
		MESSAGE,
		BADGE
	}
	
	public Type type;
	public String message;
	public long timestamp;

	public GymMessage() {
	}
}
