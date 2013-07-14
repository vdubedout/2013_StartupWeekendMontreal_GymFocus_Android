package co.gymfocus.android;

import java.util.ArrayList;

public class DBFakeHandler {

	private static DBFakeHandler mInstance;
	ArrayList<Workout> mWorkouts;

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
		workout.durationEstimated = "5 min.";
		workouts.add(workout);

		// Workouts 1
		workout = new Workout();
		workout.id = 1;
		workout.name = "Core";
		workout.description = " - Do 20 Sit ups";
		workout.durationEstimated = "10 min.";
		workouts.add(workout);

		// Workouts 2
		workout = new Workout();
		workout.id = 2;
		workout.name = "Lower Body";
		workout.description = "You have to do a squat like this blalalalalalalalala";
		workout.durationEstimated = "5 min.";
		workouts.add(workout);

		// Workouts 3
		workout = new Workout();
		workout.id = 3;
		workout.name = "Chest";
		workout.description = "You have to do a squat like this blalalalalalalalala";
		workout.durationEstimated = "5 min.";
		workouts.add(workout);

		// Workouts 4
		workout = new Workout();
		workout.id = 4;
		workout.name = "Shoulders";
		workout.description = "You have to do a squat like this blalalalalalalalala";
		workout.durationEstimated = "5 min";
		workouts.add(workout);

		// Workouts 5
		workout = new Workout();
		workout.id = 5;
		workout.name = "Back";
		workout.description = "You have to do a squat like this blalalalalalalalala";
		workout.durationEstimated = "5 min.";
		workouts.add(workout);

		// Workouts 6
		workout = new Workout();
		workout.id = 6;
		workout.name = "Arms";
		workout.description = "You have to do a squat like this blalalalalalalalala";
		workout.durationEstimated = "5 min.";
		workouts.add(workout);

		// Workouts 7
		workout = new Workout();
		workout.id = 7;
		workout.name = "Stretches";
		workout.description = "You have to do a squat like this blalalalalalalalala";
		workout.durationEstimated = "5 min.";
		workouts.add(workout);

		return workouts;
	}
}
