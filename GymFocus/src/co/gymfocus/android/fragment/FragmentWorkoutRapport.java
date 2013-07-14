package co.gymfocus.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import co.gymfocus.android.DBFakeHandler;
import co.gymfocus.android.R;
import co.gymfocus.android.Workout;

import com.actionbarsherlock.app.SherlockFragment;

public class FragmentWorkoutRapport extends SherlockFragment {

	private Workout mWorkout;
	ImageView mButtonBad;
	private ImageView mButtonGood;
	private EditText mUserComment;
	boolean mBadButtonActivated = false;
	boolean mGoodButtonActivated = false;
	Button mSendButton;
	private View mInflatedView;
	
	public void setWorkout(Workout workout) {
		this.mWorkout = workout;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mInflatedView = inflater.inflate(
				R.layout.fragment_workout_rapport, container, false);
		mUserComment = (EditText) mInflatedView
				.findViewById(R.id.rapport_commentuser);
		setVoteButtons(mInflatedView);
		setSendButton(mInflatedView);
		return mInflatedView;
	}

	private void setSendButton(View mInflatedView) {
		mSendButton = (Button) mInflatedView.findViewById(R.id.rapport_sendbutton);
		mSendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setSendDataButton();
			}

		});
	}

	private void setSendDataButton() {
		// TODO Send data, clean backstack
		setDataInDB();
		sendDataToServer();
		returnOnWorkoutList();
	}

	private void returnOnWorkoutList() {
		FragmentManager fragManager = getActivity().getSupportFragmentManager();
		fragManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		FragmentTransaction transaction = fragManager.beginTransaction();
		transaction.replace(R.id.content_frame, new FragmentWorkouts());
		
	}

	private void sendDataToServer() {
		// TODO Auto-generated method stub
		
	}

	private void setDataInDB() {
		if(mBadButtonActivated)
			mWorkout.likedIt = false;
		else if(mGoodButtonActivated)
			mWorkout.likedIt = true;
		
		if(!TextUtils.isEmpty(mUserComment.getText())){
			mWorkout.workoutComment = mUserComment.getText().toString();
		}
		
		mWorkout.isDone = true;
		
		DBFakeHandler.getInstance().modifyWorkout(mWorkout);
		
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