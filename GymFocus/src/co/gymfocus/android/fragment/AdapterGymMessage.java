package co.gymfocus.android.fragment;

import java.util.ArrayList;

import co.gymfocus.android.GymMessage;
import co.gymfocus.android.R;
import co.gymfocus.android.Workout;
import co.gymfocus.android.fragment.CustomAdapterWorkouts.Holder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterGymMessage extends BaseAdapter {
	private final Context mContext;
	private LayoutInflater mLayoutInflater;
	private int mDataSize = -1;
	private ArrayList<GymMessage> mGymMessageListData;

	public AdapterGymMessage(Context context, ArrayList<GymMessage> gymMessageData) {
		this.mContext = context;
		this.mLayoutInflater = LayoutInflater.from(this.mContext);
		mGymMessageListData = gymMessageData;
	}

	@Override
	public int getCount() {
		if (mDataSize < 1)
			mDataSize = mGymMessageListData.size();
		return mDataSize;
	}

	@Override
	public Object getItem(int position) {
		return mGymMessageListData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder mHolder;
		if (convertView == null) {
			convertView = mLayoutInflater.inflate(
					R.layout.adapter_gymmessage_list, null);
			mHolder = new Holder();
			mHolder.message_type = (TextView) convertView
					.findViewById(R.id.adapter_workout_name);
			mHolder.workout_value = (TextView) convertView
					.findViewById(R.id.adapter_workout_duration);
			convertView.setTag(mHolder);
		} else {
			mHolder = (Holder) convertView.getTag();
		}
		GymMessage gymMessage = mGymMessageListData.get(position);
		mHolder.message_type.setText(gymMessage.type.toString());
		mHolder.workout_value.setText(gymMessage.message);

		return convertView;
	}

	static class Holder {
		TextView message_type;
		TextView workout_value;
	}
}
