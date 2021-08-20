package net.mindzone.mindshopui.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import net.mindzone.mindshopui.BaseFragment;
import net.mindzone.mindshopui.activities.onBoarding;
import net.mindzone.mindshopui.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends BaseFragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnMainv2.setOnClickListener(this::MovingToOnboarding);
        return root;
    }

    public void MovingToOnboarding(View v) {
        Log.d("Test", "Moving to onBoarding");
        Intent intent = new Intent();
        intent.setClass(getActivity(), onBoarding.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}