package co.gymfocus.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.gymfocus.android.R;

import com.actionbarsherlock.app.SherlockFragment;

public class FragmentWorkoutRapport extends SherlockFragment{

	private Workout mWorkout;

	public void setWorkout(Workout workout) {
		this.mWorkout = workout;
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View mInflatedView = inflater.inflate(R.id.content_frame, container, false);
		return mInflatedView;
	}
}