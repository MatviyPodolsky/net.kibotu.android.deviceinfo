package net.kibotu.android.deviceinfo.ui.menu;

import android.app.ActionBar;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import net.kibotu.android.deviceinfo.R;

import static com.common.android.utils.ContextHelper.getContext;
import static com.common.android.utils.extensions.ViewExtensions.getContentRoot;

/**
 * Created by Nyaruhodo on 20.02.2016.
 */
public class MainMenu implements IMainMenu {

    @NonNull
    @Bind(R.id.drawer_title)
    TextView leftDrawerTitle;

    @NonNull
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @NonNull
    @Bind(R.id.left_drawer)
    NavigationView leftDrawer;

    @NonNull
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private ActionBarDrawerToggle drawerToggle;

    public MainMenu() {
        ButterKnife.bind(this, getContentRoot());
    }

    @Override
    public IMainMenu prepareDrawers() {
        if (drawerToggle != null)
            return this;

        drawerToggle = new ActionBarDrawerToggle(getContext(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };

        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
                drawerToggle.setDrawerIndicatorEnabled(true);
                drawerLayout.setDrawerListener(drawerToggle);
            }
        });

        return this;
    }

    @Override
    public IMainMenu setLeftDrawerTitle(@NonNull final String title) {
        this.leftDrawerTitle.setText(title);
        return this;
    }

    @Override
    public IMainMenu setTitle(@NonNull final String title) {
        getActionBar().setTitle(title);
        return this;
    }

    private ActionBar getActionBar() {
        return getContext().getActionBar();
    }

    @Override
    public IMainMenu showActionBar(boolean isShowing) {
        if (isShowing)
            getActionBar().show();
        else
            getActionBar().hide();
        return this;
    }

    @Override
    public IMainMenu setLeftDrawerLockMode(@LockMode int lockMode) {
        drawerLayout.setDrawerLockMode(lockMode, leftDrawer);
        return this;
    }
}