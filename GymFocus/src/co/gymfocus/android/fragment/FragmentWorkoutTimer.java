package co.gymfocus.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.gymfocus.android.R;

import com.actionbarsherlock.app.SherlockFragment;

public class FragmentWorkoutTimer extends SherlockFragment {

	private Workout mWorkout;
	private View mInflatedView;

	public void setWorkout(Workout workout) {
		this.mWorkout = workout;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mInflatedView = inflater.inflate(R.layout.fragment_workout_timer, container, false);
		return mInflatedView;
	}

}
