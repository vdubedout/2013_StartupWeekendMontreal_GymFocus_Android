package co.gymfocus.android.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import co.gymfocus.android.DBFakeHandler;
import co.gymfocus.android.GymMessage;
import co.gymfocus.android.R;

import com.actionbarsherlock.app.SherlockFragment;

public class FragmentMessages extends SherlockFragment {
	private View mInflatedView;
	private ListView mListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mInflatedView = inflater.inflate(R.layout.fragment_message, container,
				false);
		mListView = (ListView) mInflatedView.findViewById(android.R.id.list);
		ArrayList<GymMessage> messages = DBFakeHandler.getInstance().getMessages();
		mListView.setAdapter(new AdapterGymMessage(getActivity(), messages));
		return mInflatedView;
	}
}
