package co.gymfocus.android.fragment;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import co.gymfocus.android.R;

public class CustomAdapterWorkouts extends BaseAdapter {
	private final Context mContext;
	private LayoutInflater mLayoutInflater;
	private int mDataSize = -1;
	private ArrayList<Workout> mWorkoutListData;

	public CustomAdapterWorkouts(Context context, ArrayList<Workout> workoutListData) {
		this.mContext = context;
		this.mLayoutInflater = LayoutInflater.from(this.mContext);
		mWorkoutListData = workoutListData;
	}

	@Override
	public int getCount() {
		if (mDataSize < 1)
			mDataSize = mWorkoutListData.size();
		return mDataSize;
	}

	@Override
	public Object getItem(int position) {
		return mWorkoutListData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder mHolder;
		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.adapter_workout_list, null);
			mHolder = new Holder();
			mHolder.workout_name = (TextView) convertView.findViewById(R.id.adapter_workout_name);
			mHolder.workout_duration = (TextView) convertView.findViewById(R.id.adapter_workout_duration);
			convertView.setTag(mHolder);
		} else {
			mHolder = (Holder) convertView.getTag();
		}
		mHolder.workout_duration.setText(mWorkoutListData.get(position).duration);
		mHolder.workout_name.setText(mWorkoutListData.get(position).name);
		
		return convertView;
	}

	static class Holder {
		TextView workout_duration;
		TextView workout_name;
	}
}
