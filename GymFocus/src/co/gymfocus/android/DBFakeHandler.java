package co.gymfocus.android;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import co.gymfocus.android.GymMessage.Type;

public class DBFakeHandler {

	private static DBFakeHandler mInstance;
	ArrayList<Workout> mWorkouts;
	private ArrayList<GymMessage> mGymMessageList;

	private DBFakeHandler() {
	}

	public static DBFakeHandler getInstance() {
		if (mInstance == null)
			mInstance = new DBFakeHandler();
		return mInstance;
	}

	public ArrayList<Workout> getWorkouts(boolean forceGeneration) {
		if (mWorkouts == null || forceGeneration) {
			mWorkouts = createWorkouts();
		}

		return mWorkouts;
	}

	public void modifyWorkout(Workout workout) {
		int indexOf = mWorkouts.indexOf(workout);
		mWorkouts.set(indexOf, workout);
	}

	private ArrayList<Workout> createWorkouts() {
		ArrayList<Workout> workouts = new ArrayList<Workout>();

		// Workouts 0
		Workout workout = new Workout();
		workout.id = 0;
		workout.name = "Cardio";
		workout.description = " - Walk for 5 minutes \n\n - Run at 8km/h for 20 minutes \n\n - Stretch for 5 minutes \n\n ";
		workout.durationEstimated = "10 min.";
		workouts.add(workout);

		// Workouts 1
		workout = new Workout();
		workout.id = 1;
		workout.name = "Core";
		workout.description = " - Do 2 sets of  Sit Ups \n\n - do 3 sets of the plank static hold";
		workout.durationEstimated = "7 min.";
		workouts.add(workout);

		// Workouts 2
		workout = new Workout();
		workout.id = 2;
		workout.name = "Lower Body";
		workout.description = " - 3 sets of squats \n\n - 3 sets of leg press";
		workout.durationEstimated = "15 min.";
		workouts.add(workout);

		// Workouts 3
		workout = new Workout();
		workout.id = 3;
		workout.name = "Chest";
		workout.description = " - 3 sets of barbench press \n\n - 3 sets of pushups \n\n - 3 sets of cable flies";
		workout.durationEstimated = "22 min.";
		workouts.add(workout);

		// Workouts 4
		workout = new Workout();
		workout.id = 4;
		workout.name = "Shoulders";
		workout.description = " - 3 sets of barbell shoulder press \n\n - 3 sets of arnold shoulder press \n\n - 3 sets of alternating cable shoulder press";
		workout.durationEstimated = "3 min.";
		workouts.add(workout);

		// Workouts 5
		workout = new Workout();
		workout.id = 5;
		workout.name = "Back";
		workout.description = " - 3 sets of Lat Pull Downs \n\n - 3 sets of either dumbbell rows or pullups ";
		workout.durationEstimated = "52 min.";
		workouts.add(workout);

		// Workouts 6
		workout = new Workout();
		workout.id = 6;
		workout.name = "Arms";
		workout.description = " - 3 sets of dumbbell curlls \n\n - 3 sets of skullcrushers";
		workout.durationEstimated = "5 min.";
		workouts.add(workout);

		// Workouts 7
		workout = new Workout();
		workout.id = 7;
		workout.name = "Stretches";
		workout.description = "- stretch your shoulders \n\n - stretch your hamstrings \n\n - stretch your calves \n\n - stretch your quadriceps";
		workout.durationEstimated = "13 min.";
		workouts.add(workout);

		return workouts;
	}
	
	public ArrayList<GymMessage> getMessages(){
		if(mGymMessageList == null)
			mGymMessageList = createGymMessages();
		
		return mGymMessageList;
	}

	private ArrayList<GymMessage> createGymMessages() {
		ArrayList<GymMessage> messageList = new ArrayList<GymMessage>();
		GymMessage message = new GymMessage();
		message.type = Type.MESSAGE;
		message.message = "Hey Nicolas, where were you the last 10 days. We miss you.";
		message.timestamp = 10;
		messageList.add(message);
		
		message = new GymMessage();
		message.type = Type.MESSAGE;
		message.message = "Hey Nicolas, You have done a nice record this week. Congratz.";
		message.timestamp = 6;
		messageList.add(message);
		
		message = new GymMessage();
		message.type = Type.BADGE;
		message.message = "You just won the Human Rocket Badge with your 65km/h sprint";
		message.timestamp = 3;
		messageList.add(message);
		
		return messageList;
	}
}
