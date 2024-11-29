package www.optionmenu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPage extends FragmentStateAdapter {
    public ViewPage(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new home();
            case 1:
                return new friend();
            case 3:
                return new personal();
            default:
                return new home();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
