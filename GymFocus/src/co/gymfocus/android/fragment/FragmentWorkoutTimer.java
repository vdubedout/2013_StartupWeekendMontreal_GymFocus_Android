package co.gymfocus.android.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
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
		Button mButton = (Button) mInflatedView.findViewById(R.id.timer_start_stop);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
		});
		
		return mInflatedView;
	}
	
	void startButtonClicked(){
		FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
		FragmentWorkoutRapport fragRapport = new FragmentWorkoutRapport();
		fragRapport.setWorkout(mWorkout);
		transaction.replace(R.id.content_frame, fragRapport);
		transaction.addToBackStack(null);
		transaction.commit();
	}

}
