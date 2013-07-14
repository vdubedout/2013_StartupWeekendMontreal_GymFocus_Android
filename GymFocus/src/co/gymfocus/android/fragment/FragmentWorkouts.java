package co.gymfocus.android.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import co.gymfocus.android.DBFakeHandler;
import co.gymfocus.android.R;
import co.gymfocus.android.Workout;

import com.actionbarsherlock.app.SherlockFragment;
import com.googlecode.androidannotations.annotations.EFragment;
import com.googlecode.androidannotations.annotations.ViewById;

@EFragment
public class FragmentWorkouts extends SherlockFragment {

	@ViewById(android.R.id.list)
	ListView mList;
	private View mInflatedView;
	private ArrayList<Workout> mWorkouts;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mInflatedView = inflater.inflate(R.layout.fragment_workouts_list,
				container, false);
		mList = (ListView) mInflatedView.findViewById(android.R.id.list);

		mWorkouts = DBFakeHandler.getInstance().getWorkouts(false);
		mList.setAdapter(new CustomAdapterWorkouts(getActivity(), mWorkouts));
		mList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				FragmentTransaction transaction = getActivity()
						.getSupportFragmentManager().beginTransaction();

				IFragmentWorkout fragment;
				if (mWorkouts.get(position).isDone) {
					fragment = new FragmentWorkoutRapport();
				} else {
					fragment = new FragmentWorkoutDetail();
				}
				fragment.setWorkout(mWorkouts.get(position));
				transaction.replace(R.id.content_frame, (Fragment) fragment);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		return mInflatedView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

	}
}
