package co.gymfocus.android;

public class GymMessage {
	enum Type{
		MESSAGE,
		BADGE
	}
	
	Type type;
	String message;

	public GymMessage() {
	}
}
