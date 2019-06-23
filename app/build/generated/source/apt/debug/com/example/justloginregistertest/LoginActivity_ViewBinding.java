// Generated code from Butter Knife. Do not modify!
package com.example.justloginregistertest;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131165361;

  private View view2131165222;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_loginactivity_register, "field 'mTvLoginactivityRegister' and method 'onClick'");
    target.mTvLoginactivityRegister = Utils.castView(view, R.id.tv_loginactivity_register, "field 'mTvLoginactivityRegister'", TextView.class);
    view2131165361 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mRlLoginactivityTop = Utils.findRequiredViewAsType(source, R.id.rl_loginactivity_top, "field 'mRlLoginactivityTop'", RelativeLayout.class);
    target.mEtLoginactivityUsername = Utils.findRequiredViewAsType(source, R.id.et_loginactivity_username, "field 'mEtLoginactivityUsername'", EditText.class);
    target.mEtLoginactivityPassword = Utils.findRequiredViewAsType(source, R.id.et_loginactivity_password, "field 'mEtLoginactivityPassword'", EditText.class);
    target.mLlLoginactivityTwo = Utils.findRequiredViewAsType(source, R.id.ll_loginactivity_two, "field 'mLlLoginactivityTwo'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.bt_loginactivity_login, "method 'onClick'");
    view2131165222 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvLoginactivityRegister = null;
    target.mRlLoginactivityTop = null;
    target.mEtLoginactivityUsername = null;
    target.mEtLoginactivityPassword = null;
    target.mLlLoginactivityTwo = null;

    view2131165361.setOnClickListener(null);
    view2131165361 = null;
    view2131165222.setOnClickListener(null);
    view2131165222 = null;
  }
}
