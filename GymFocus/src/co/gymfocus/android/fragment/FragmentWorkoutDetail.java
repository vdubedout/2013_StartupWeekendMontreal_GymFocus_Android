package co.gymfocus.android.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import co.gymfocus.android.R;
import co.gymfocus.android.Workout;

import com.actionbarsherlock.app.SherlockFragment;
import com.googlecode.androidannotations.annotations.EFragment;
import com.googlecode.androidannotations.annotations.ViewById;

@EFragment
public class FragmentWorkoutDetail extends SherlockFragment implements IFragmentWorkout {
	private View mInflatedView;
	private Workout mWorkout;

	@ViewById(R.id.workout_detail_startbutton)
	Button mStartButton;
	
	
	public void setWorkout(Workout workout){
		this.mWorkout = workout;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mInflatedView = inflater.inflate(R.layout.fragment_workout_detail, container, false);
		mStartButton = (Button) mInflatedView.findViewById(R.id.workout_detail_startbutton);
		mStartButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startButtonClicked();
			}
		});
		
		setDataWorkout();
		return mInflatedView;
	}

	private void setDataWorkout() {
		TextView tvExercice = (TextView) mInflatedView.findViewById(R.id.workout_detail_exercicevalue);
		tvExercice.setText(mWorkout.name);
		TextView tvTime = (TextView) mInflatedView.findViewById(R.id.workout_detail_estimatedtimevalue);
		tvTime.setText(mWorkout.durationEstimated);
		TextView tvDescription = (TextView) mInflatedView.findViewById(R.id.workout_detail_description);
		tvDescription.setText(mWorkout.description);
	}

	void startButtonClicked(){
		FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
		FragmentWorkoutTimer fragTimer = new FragmentWorkoutTimer();
		fragTimer.setWorkout(mWorkout);
		transaction.replace(R.id.content_frame, fragTimer);
		transaction.addToBackStack(null);
		transaction.commit();
	}
}
