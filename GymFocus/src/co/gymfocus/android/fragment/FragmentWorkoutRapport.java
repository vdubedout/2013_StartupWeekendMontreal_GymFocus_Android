package co.gymfocus.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import co.gymfocus.android.R;

import com.actionbarsherlock.app.SherlockFragment;

public class FragmentWorkoutRapport extends SherlockFragment {

	private Workout mWorkout;
	ImageView mButtonBad;
	private ImageView mButtonGood;
	private EditText mUserComment;
	boolean mBadButtonActivated = false;
	boolean mGoodButtonActivated = false;
	
	public void setWorkout(Workout workout) {
		this.mWorkout = workout;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View mInflatedView = inflater.inflate(
				R.layout.fragment_workout_rapport, container, false);
		setVoteButtons(mInflatedView);
		return mInflatedView;
	}

	private void setVoteButtons(View mInflatedView) {
		mButtonBad = (ImageView) mInflatedView.findViewById(R.id.rapport_bad);
		mButtonGood = (ImageView) mInflatedView.findViewById(R.id.rapport_good);

		mButtonBad.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mBadButtonActivated) {
					mButtonBad.setImageResource(R.drawable.results_bad_normal);
					mBadButtonActivated = false;
				} else {
					mBadButtonActivated = true;
					mGoodButtonActivated = false;
					mButtonBad.setImageResource(R.drawable.results_bad_presse);
					mButtonGood.setImageResource(R.drawable.results_good_normal);
				}
			}
		});

		mButtonGood.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mGoodButtonActivated){
					mButtonGood.setImageResource(R.drawable.results_good_normal);
					mGoodButtonActivated = false;
				} else {
					mGoodButtonActivated = true;
					mBadButtonActivated = false;
					mButtonGood.setImageResource(R.drawable.results_good_presse);
					mButtonBad.setImageResource(R.drawable.results_bad_normal);
				}
			}
		});
	}
}